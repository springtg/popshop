package com.poprlz.product.dao;

import com.google.inject.ImplementedBy;
import com.poprlz.dao.IGenericDao;

@ImplementedBy(ProductAttributeDaoImple.class)
public interface IProductAttributeDao<ProductAttribute> extends
		IGenericDao<ProductAttribute> {

}
