package com.poprlz.product.web;
	
import java.util.List;

import com.google.inject.Inject;
import com.opensymphony.xwork2.ActionSupport;
import com.poprlz.product.entity.ProductInfo;
import com.poprlz.product.logic.IProductServiceLogic;
import com.poprlz.util.PaginationSupport;

public class ProductListAction  extends ActionSupport {
	
	@Inject
	private IProductServiceLogic productServiceLogic;
	private List<ProductInfo> productList; 
	

	public List<ProductInfo> getProductList() {
		return productList;
	}

	public String getNewProducts() throws Exception {

		productList=productServiceLogic.getNewProducts();
		 
		return SUCCESS;
	}
	
	public String getTopSellProducts() throws Exception {
		productList=productServiceLogic.getTopSellProducts();
		 
		return SUCCESS;
	}
	
	public String getTopViewProducts() throws Exception {

		productList=productServiceLogic.getTopViewProducts();
		return SUCCESS;
	}
}
