package com.poprlz.product.logic;

import java.util.List;

import com.google.inject.ImplementedBy;
import com.poprlz.product.entity.ProductInfo;
 

@ImplementedBy(ProductServiceLogic.class)
public interface IProductServiceLogic {

	public List<ProductInfo> getNewProducts()  throws ServiceException;

	public List<ProductInfo> getTopSellProducts()  throws ServiceException;

	public List<ProductInfo> getTopViewProducts()  throws ServiceException;

}
