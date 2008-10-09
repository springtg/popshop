package com.poprlz.product.web;
	
import java.math.BigDecimal;

import com.google.inject.Inject;
import com.opensymphony.xwork2.ActionSupport;
import com.poprlz.product.dao.ProductQueryCondition;
import com.poprlz.product.entity.ProductInfo;
import com.poprlz.product.logic.IProductServiceLogic;
import com.poprlz.util.PaginationSupport;



public class ProductSearchAction  extends ActionSupport {
	@Inject
	private IProductServiceLogic productServiceLogic;
	
	private PaginationSupport<ProductInfoView> productInfoViewList;
	
	private int currentPage;
	
	public IProductServiceLogic getProductServiceLogic() {
		return productServiceLogic;
	}



	public PaginationSupport<ProductInfoView> getProductInfoViewList() {
		return productInfoViewList;
	}



	public int getCurrentPage() {
		return currentPage;
	}



	public String getProductName() {
		return productName;
	}



	public int getManufacturerId() {
		return manufacturerId;
	}



	public int[] getCategorieIds() {
		return categorieIds;
	}



	public int getOrderType() {
		return orderType;
	}



	public BigDecimal getMinDecimal() {
		return minDecimal;
	}



	public BigDecimal getMaxDecimal() {
		return maxDecimal;
	}



	private String productName;
	
	private int manufacturerId;
	
	private int[] categorieIds;
	
	private int orderType;
	
	private BigDecimal minDecimal;
	
	private BigDecimal maxDecimal;
	
	
	
	public void setProductServiceLogic(IProductServiceLogic productServiceLogic) {
		this.productServiceLogic = productServiceLogic;
	}



	public void setProductInfoViewList(
			PaginationSupport<ProductInfoView> productInfoViewList) {
		this.productInfoViewList = productInfoViewList;
	}



	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
	}



	public void setCategorieIds(int[] categorieIds) {
		this.categorieIds = categorieIds;
	}



	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}



	public void setMinDecimal(BigDecimal minDecimal) {
		this.minDecimal = minDecimal;
	}



	public void setMaxDecimal(BigDecimal maxDecimal) {
		this.maxDecimal = maxDecimal;
	}



	public String execute() throws Exception {
		ProductQueryCondition queryConditon=new ProductQueryCondition();
		queryConditon.setCategorieIds(categorieIds);
		queryConditon.setCurrentPage(currentPage);
		queryConditon.setManufacturerId(manufacturerId);
		queryConditon.setMaxDecimal(maxDecimal);
		queryConditon.setMinDecimal(minDecimal);
		queryConditon.setOrderType(orderType);
		queryConditon.setProductName(productName);
		
		

		productInfoViewList=productServiceLogic.searchProductAction(queryConditon);
		 
		return SUCCESS;
	}

	
	
	
}
