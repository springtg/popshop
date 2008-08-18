package com.poprlz.product.dao;

import java.io.Serializable;
import java.util.List;

import com.poprlz.dao.HibernateGenericDao;

public class OrderProductItemDaoImple<OrderProductItem> extends HibernateGenericDao<OrderProductItem> implements
		IOrderProductItemDao<OrderProductItem> {

	@Override
	public List<OrderProductItem> queryEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderProductItem loadEntity(Serializable key) {
		// TODO Auto-generated method stub
		return null;
	}
 

}
