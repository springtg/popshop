package com.poprlz.product.web;

import java.util.List;

import com.google.inject.Inject;
import com.opensymphony.xwork2.ActionSupport;
import com.poprlz.product.dao.ProductQueryCondition;
import com.poprlz.product.logic.IProductServiceLogic;
import com.poprlz.util.PaginationSupport;

public class ProductListAction extends ActionSupport {

	@Inject
	private IProductServiceLogic productServiceLogic;
	private List<ProductInfoView> productList;

	public List<ProductInfoView> getProductList() {
		return productList;
	}

	public String getNewProducts() throws Exception {

		ProductQueryCondition queryConditon = new ProductQueryCondition();

		queryConditon.setOrderType(ProductQueryCondition.OrderType_Day);

		PaginationSupport<ProductInfoView> productInfoViewList = productServiceLogic
				.searchProductAction(queryConditon);

		productList = productInfoViewList.getItems();

		return SUCCESS;
	}

	public String getTopSellProducts() throws Exception {

		ProductQueryCondition queryConditon = new ProductQueryCondition();

		queryConditon.setOrderType(ProductQueryCondition.OrderType_Ordered);

		PaginationSupport<ProductInfoView> productInfoViewList = productServiceLogic
				.searchProductAction(queryConditon);

		productList = productInfoViewList.getItems();

		return SUCCESS;
	}

	public String getTopViewProducts() throws Exception {

		ProductQueryCondition queryConditon = new ProductQueryCondition();

		queryConditon.setOrderType(ProductQueryCondition.OrderType_Viewed);

		PaginationSupport<ProductInfoView> productInfoViewList = productServiceLogic
				.searchProductAction(queryConditon);

		productList = productInfoViewList.getItems();
		return SUCCESS;
	}
}
