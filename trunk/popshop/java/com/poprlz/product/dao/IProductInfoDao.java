package com.poprlz.product.dao;

import java.util.List;

import com.google.inject.ImplementedBy;
import com.poprlz.dao.IGenericDao;
import com.poprlz.product.entity.ProductInfo;

@ImplementedBy(ProductInfoDaoImple.class)
public interface IProductInfoDao<ProductInfo> extends IGenericDao<ProductInfo> {

	public List<ProductInfo> getNewProducts();

	public List<ProductInfo> getTopSellProducts();

	public List<ProductInfo> getTopViewProducts();
	
	public int queryTotalCount(String querySql);

}
