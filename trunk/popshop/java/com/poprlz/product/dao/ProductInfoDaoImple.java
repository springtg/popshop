package com.poprlz.product.dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.google.inject.Inject;
import com.poprlz.dao.HibernateGenericDao;
import com.poprlz.product.web.ProductInfoView;

public class ProductInfoDaoImple<ProductInfo> extends
		HibernateGenericDao<ProductInfo> implements
		IProductInfoDao<ProductInfo> {
	
	@Inject
	private QueryRunner dbOperator;

	 
	public List<ProductInfo> queryEntity() {
		Query query = this.sessionProvider.get().createQuery(
				" from ProductInfo as productInfo ");

		return query.list();
	}

	public ProductInfo loadEntity(Serializable productId) {
		Query query = this.sessionProvider
				.get()
				.createQuery(
						"from  ProductInfo as productInfo  where productInfo.productId =:productId");
		query.setParameter("productId", productId);
		List ProductInfoList = query.list();
		if (ProductInfoList == null || ProductInfoList.size() < 1)
			return null;
		ProductInfo productInfo = (ProductInfo) ProductInfoList.get(0);
		return productInfo;
	}

	public List<ProductInfo> getNewProducts() {
		Query query = this.sessionProvider
				.get()
				.createQuery(
						"from  ProductInfo as productInfo where productInfo.stutas=0 and productInfo.dateAvailable<Now() and quantity>0 order by lastModified ");

		//query.setDate("currentDate", new Date());

		query.setFirstResult(0);
		query.setMaxResults(5);

		List productInfoList = query.list();
		if (productInfoList == null || productInfoList.size() < 1)
			return null;

		return productInfoList;
	}

	public List<ProductInfo> getTopSellProducts() {
		Query query = this.sessionProvider
				.get()
				.createQuery(
						"from  ProductInfo as productInfo where productInfo.stutas=0 and productInfo.dateAvailable<Now() and quantity>0 order by ordered ");

 

		query.setFirstResult(0);
		query.setMaxResults(5);

		List productInfoList = query.list();
		if (productInfoList == null || productInfoList.size() < 1)
			return null;

		return productInfoList;
	}

	public List<ProductInfo> getTopViewProducts() {
		Query query = this.sessionProvider
				.get()
				.createQuery(
						"from  ProductInfo as productInfo where productInfo.stutas=0 and productInfo.dateAvailable<Now() and quantity>0 order by viewed ");

		 

		query.setFirstResult(0);
		query.setMaxResults(5);

		List productInfoList = query.list();
		if (productInfoList == null || productInfoList.size() < 1)
			return null;

		return productInfoList;
	}

	public int queryTotalCount(String querySql) {
		try {
			Integer data=(Integer)dbOperator.query(sessionProvider.get().connection(), querySql, null, new ResultSetHandler(){

				public Object handle(ResultSet rs) throws SQLException {
					Integer result=null;
					 if(rs.next())
						 result=new Integer(rs.getInt(1));
						 
					return result;
				}
				
			});
			
			return data.intValue();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public List<ProductInfoView> queryProductViewList(String querySql) {
		try {
			List<ProductInfoView> productInfoViewList=(List<ProductInfoView>)dbOperator.query(sessionProvider.get().connection(), querySql, null, new ProductInfoViewResultSetHandler());
			
			return productInfoViewList;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * SELECT * FROM productinfo prd LEFT JOIN ( SELECT * FROM productImage WHERE imageId IN (
SELECT DISTINCT MIN( imageId ) FROM productImage GROUP BY productId

)) prdImg ON (prd.productId=prdImg.productId)

WHERE prd.stutas=0 AND prd.dateAvailable<NOW() AND prd.quantity>0 AND prd.price BETWEEN ? AND ? AND prd.manufacturerId=?
AND prd.productId IN (SELECT productId FROM cat_product WHERE categorield=?) LIMIT ?,?
	 */
	
	

}
