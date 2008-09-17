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
	
	private String productName;
	
	private int manufacturerId;
	
	private int[] categorieIds;
	
	private int orderType;
	
	private BigDecimal minDecimal;
	
	private BigDecimal maxDecimal;
	
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
