package com.poprlz.product.logic;

import java.util.List;

import com.google.inject.ImplementedBy;
import com.poprlz.product.dao.ProductQueryCondition;
import com.poprlz.product.entity.ProductInfo;
import com.poprlz.product.web.ProductInfoView;
import com.poprlz.util.PaginationSupport;
 

@ImplementedBy(ProductServiceLogic.class)
public interface IProductServiceLogic {

	public List<ProductInfo> getNewProducts()  throws ServiceException;

	public List<ProductInfo> getTopSellProducts()  throws ServiceException;

	public List<ProductInfo> getTopViewProducts()  throws ServiceException;

 
	public PaginationSupport<ProductInfoView> searchProductAction(
			ProductQueryCondition queryConditon);

	public ProductInfo loadProductInfoLogic(Integer productId);

}
