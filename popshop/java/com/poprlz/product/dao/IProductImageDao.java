package com.poprlz.product.dao;

import com.google.inject.ImplementedBy;
import com.poprlz.dao.IGenericDao;
 

@ImplementedBy(ProductImageDaoImple.class)
public interface IProductImageDao<ProductImage> extends  IGenericDao<ProductImage> {

 
}
