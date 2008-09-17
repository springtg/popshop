package com.poprlz.product.dao;

import java.util.List;

import com.google.inject.ImplementedBy;
import com.poprlz.product.web.bean.ShopCart;

@ImplementedBy(ShopCartDaoImple.class)
public interface IShopCartDao {

	public ShopCart loadEntity(String sessionId);

	public ShopCart modifyEntity(ShopCart entity);

	public List<ShopCart> queryEntity(String querySql);

	public boolean removeEntity(ShopCart entity);

	public ShopCart saveAndLoadEntity(ShopCart entity);

}
