package com.poprlz.product.dao;

import java.math.BigDecimal;

import com.poprlz.util.PaginationSupport;

public class ProductQueryCondition {

	public final static int OrderType_Day = 1;
	public final static int OrderType_Ordered = 2;
	public final static int OrderType_Viewed = 3;

	private int currentPage;
	
	private int pageSize=PaginationSupport.PAGESIZE;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	private String productName;

	private int manufacturerId;

	private int[] categorieIds;

	public int[] getCategorieIds() {
		return categorieIds;
	}

	public void setCategorieIds(int[] categorieIds) {
		this.categorieIds = categorieIds;
	}

	private int orderType;

	private BigDecimal minDecimal;

	private BigDecimal maxDecimal;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		if (null != productName)
			productName = productName.trim();
		if (null == productName || productName.equalsIgnoreCase("null")
				|| productName.equalsIgnoreCase("") || productName.length() < 1)
			this.productName = null;
		this.productName = productName;
	}

	public int getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public int getOrderType() {
		return orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	public BigDecimal getMinDecimal() {
		return minDecimal;
	}

	public void setMinDecimal(BigDecimal minDecimal) {
		this.minDecimal = minDecimal;
	}

	public BigDecimal getMaxDecimal() {
		return maxDecimal;
	}

	public void setMaxDecimal(BigDecimal maxDecimal) {
		this.maxDecimal = maxDecimal;
	}

	private static final String GetTotalCountSql = "SELECT count(prd.productId) FROM  productinfo prd WHERE  prd.stutas=0 AND prd.dateAvailable<NOW() AND prd.quantity>0 ";

	public String buildGetTotalCountSql() {
		/**
		 * SELECT * FROM productinfo prd LEFT JOIN ( SELECT * FROM productImage
		 * WHERE imageId IN ( SELECT DISTINCT MIN( imageId ) FROM productImage
		 * GROUP BY productId
		 * 
		 * )) prdImg ON (prd.productId=prdImg.productId)
		 * 
		 * WHERE prd.stutas=0 AND prd.dateAvailable<NOW() AND prd.quantity>0 AND
		 * prd.price BETWEEN ? AND ? AND prd.manufacturerId=? AND prd.productId
		 * IN (SELECT productId FROM cat_product WHERE categorield=?) LIMIT ?,?
		 */

		StringBuffer buffer = new StringBuffer(GetTotalCountSql);

		if (categorieIds != null && categorieIds.length > 0) {
			buffer
					.append(" AND prd.productId IN (SELECT productId FROM cat_product WHERE categorield IN (");
			for (int i = 0; i < categorieIds.length; i++) {
				buffer.append(categorieIds[i] + ",");
			}
			buffer.deleteCharAt(buffer.lastIndexOf(","));
			buffer.append(" ) ");

		}

		if (null != productName)
			buffer
					.append("  AND prd.productName LIKE '%" + productName
							+ "%' ");

		if (minDecimal != null)
			buffer.append(" AND prd.price>=" + minDecimal.toString() + " ");

		if (maxDecimal != null)
			buffer.append(" AND prd.price<=" + maxDecimal.toString() + " ");

		if (manufacturerId > 0)
			buffer.append(" AND prd.manufacturerId=" + manufacturerId + " ");
		return buffer.toString();
	}

	private static final String GetQuerySql = "SELECT prd.productId,prd.quantity,prd.model, prd.productName,prd.price,prd.dateAdded,prd.lastModified, 	prd.dateAvailable, prd.description,	 prd.weight, prd.URL, prd.stutas, prd.taxId, prd.manufacturerId, prd.viewed, prd.ordered ,"
			+" prdImg.imageId,prdImg.path,prdImg.alt,prdImg.content,prdImg.mark "
			+" FROM productinfo prd LEFT JOIN ( SELECT * FROM productImage WHERE imageId IN ( "
			+ " SELECT DISTINCT MIN( imageId ) FROM productImage GROUP BY productId "
			+ " )) prdImg ON (prd.productId=prdImg.productId) "
			+ " WHERE prd.stutas=0 AND prd.dateAvailable<NOW() AND prd.quantity>0 ";

	public String buildQuerySql() {
		/**
		 * SELECT * FROM productinfo prd LEFT JOIN ( SELECT * FROM productImage
		 * WHERE imageId IN ( SELECT DISTINCT MIN( imageId ) FROM productImage
		 * GROUP BY productId
		 * 
		 * )) prdImg ON (prd.productId=prdImg.productId)
		 * 
		 * WHERE prd.stutas=0 AND prd.dateAvailable<NOW() AND prd.quantity>0 AND
		 * prd.price BETWEEN ? AND ? AND prd.manufacturerId=? AND prd.productId
		 * IN (SELECT productId FROM cat_product WHERE categorield=?) LIMIT ?,?
		 */

		StringBuffer buffer = new StringBuffer(GetQuerySql);

		if (categorieIds != null && categorieIds.length > 0) {
			buffer
					.append(" AND prd.productId IN (SELECT productId FROM cat_product WHERE categorield IN (");
			for (int i = 0; i < categorieIds.length; i++) {
				buffer.append(categorieIds[i] + ",");
			}
			buffer.deleteCharAt(buffer.lastIndexOf(","));
			buffer.append(" ) ");

		}

		if (null != productName)
			buffer
					.append("  AND prd.productName LIKE '%" + productName
							+ "%' ");

		if (minDecimal != null)
			buffer.append(" AND prd.price>=" + minDecimal.toString() + " ");

		if (maxDecimal != null)
			buffer.append(" AND prd.price<=" + maxDecimal.toString() + " ");

		if (manufacturerId > 0)
			buffer.append(" AND prd.manufacturerId=" + manufacturerId + " ");

		switch (orderType) {

		case OrderType_Day:
			buffer.append(" ORDER BY lastModified DESC");
			break;
		case OrderType_Ordered:
			buffer.append(" ORDER BY ordered  DESC");
			break;
		case OrderType_Viewed:
			buffer.append(" ORDER BY viewed  DESC");
			break;

		}

		if (currentPage > 0) {
			buffer.append(" LIMIT "
					+ ((currentPage - 1) * pageSize) + ","
					+ pageSize);
		} else {
			buffer.append(" LIMIT 0," + pageSize);
		}

		return buffer.toString();

	}

}
