package com.poprlz.product.web;
	
import com.opensymphony.xwork2.ActionSupport;
import com.poprlz.product.entity.ProductInfo;
import com.poprlz.util.PaginationSupport;

public class ProductSearchAction  extends ActionSupport {
	private PaginationSupport<ProductInfo> productList; 
}
