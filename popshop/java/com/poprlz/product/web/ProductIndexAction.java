package com.poprlz.product.web;
	
import java.util.List;

import com.google.inject.Inject;
import com.opensymphony.xwork2.ActionSupport;
import com.poprlz.product.dao.ProductQueryCondition;
import com.poprlz.product.entity.Categorie;
import com.poprlz.product.entity.Manufacturer;
import com.poprlz.product.logic.ICategorieServiceLogic;
import com.poprlz.product.logic.IManufacturerServiceLogic;
import com.poprlz.product.logic.IProductServiceLogic;
import com.poprlz.util.PaginationSupport;



public class ProductIndexAction  extends ActionSupport {
	@Inject
	private IProductServiceLogic productServiceLogic;
	
	@Inject
	private ICategorieServiceLogic categorieServiceLogic;
	
	@Inject
	private IManufacturerServiceLogic manufacturerServiceLogic;
	
	
	public List<Manufacturer> getManufacturerList() {
		return manufacturerList;
	}


	public List<Categorie> getCatList() {
		return catList;
	}


	public PaginationSupport<ProductInfoView> getProductInfoViewList() {
		return productInfoViewList;
	}


	public PaginationSupport<ProductInfoView> getTopViewProductInfoViewList() {
		return topViewProductInfoViewList;
	}


	public PaginationSupport<ProductInfoView> getTopSaleProductInfoViewList() {
		return topSaleProductInfoViewList;
	}


	public PaginationSupport<ProductInfoView> getLastedProductInfoViewList() {
		return lastedProductInfoViewList;
	}


	private List<Manufacturer> manufacturerList;

	
	private List<Categorie> catList;

	
	private PaginationSupport<ProductInfoView> productInfoViewList;
	
	private PaginationSupport<ProductInfoView> topViewProductInfoViewList;
	
	private PaginationSupport<ProductInfoView> topSaleProductInfoViewList;
	
	private PaginationSupport<ProductInfoView> lastedProductInfoViewList;
	 
	
	public String execute() throws Exception {
		
		//取得商品类别
		catList=categorieServiceLogic.getProductEffectiveCatList();
		
		//取得商品品牌
		manufacturerList=manufacturerServiceLogic.getEffectiveManufacturerList();
		//获得一般的排列商品
		ProductQueryCondition queryConditon=new ProductQueryCondition();
		queryConditon.setPageSize(8);
		productInfoViewList=productServiceLogic.searchProductAction(queryConditon);
		//获得最新发布的商品
		queryConditon.setOrderType(ProductQueryCondition.OrderType_Day);
		lastedProductInfoViewList=productServiceLogic.searchProductAction(queryConditon);
		//获得最多人睇的商品
		queryConditon.setPageSize(5);
		queryConditon.setOrderType(ProductQueryCondition.OrderType_Viewed);
		topViewProductInfoViewList=productServiceLogic.searchProductAction(queryConditon);
		//获得最好卖的商品
		queryConditon.setOrderType(ProductQueryCondition.OrderType_Ordered);
		topSaleProductInfoViewList=productServiceLogic.searchProductAction(queryConditon);
		 
		return SUCCESS;
	}

	
	
	
}
