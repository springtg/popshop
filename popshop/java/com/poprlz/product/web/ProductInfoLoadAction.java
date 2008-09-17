package com.poprlz.product.web;

import com.google.inject.Inject;
import com.opensymphony.xwork2.ActionSupport;
import com.poprlz.product.entity.ProductInfo;
import com.poprlz.product.logic.IProductServiceLogic;

public class ProductInfoLoadAction extends ActionSupport {
	@Inject
	private IProductServiceLogic productServiceLogic;
	
	private ProductInfo productInfo;
	private Integer productId;
	
	public String execute() throws Exception {
		
		productInfo=productServiceLogic.loadProductInfoLogic(productId);
		return SUCCESS;
	}

	public ProductInfo getProductInfo() {
		return productInfo;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	
}
