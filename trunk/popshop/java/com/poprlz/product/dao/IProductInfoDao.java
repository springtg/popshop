package com.poprlz.product.dao;

import com.google.inject.ImplementedBy;
import com.poprlz.dao.IGenericDao;

@ImplementedBy(ProductInfoDaoImple.class)
public interface IProductInfoDao<ProductInfo> extends IGenericDao<ProductInfo> {

}
