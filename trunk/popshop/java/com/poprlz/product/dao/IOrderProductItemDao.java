package com.poprlz.product.dao;

import com.google.inject.ImplementedBy;
import com.poprlz.dao.IGenericDao;

@ImplementedBy(OrderProductItemDaoImple.class)
public interface IOrderProductItemDao<OrderProductItem> extends IGenericDao<OrderProductItem> {

}
