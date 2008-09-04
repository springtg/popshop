package com.poprlz.product.web;
	
import com.google.inject.Inject;
import com.opensymphony.xwork2.ActionSupport;
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
	
	private int categorieId;
	
	private int orderType;
	
	public String execute() throws Exception {

		productInfoViewList=productServiceLogic.searchProductAction(currentPage,productName,manufacturerId,categorieId,orderType);
		 
		return SUCCESS;
	}

	
	
	
}
