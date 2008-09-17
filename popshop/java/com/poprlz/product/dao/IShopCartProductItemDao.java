package com.poprlz.product.dao;

import java.util.List;

import com.google.inject.ImplementedBy;
import com.poprlz.product.web.bean.ShopCartProductItem;;

@ImplementedBy(ShopCartProductItemDaoImple.class)
public interface IShopCartProductItemDao {

	public ShopCartProductItem loadEntity(Integer productId);

	public ShopCartProductItem modifyEntity(ShopCartProductItem entity);

	public List<ShopCartProductItem> queryEntity(String querySql);
	
	public List<ShopCartProductItem> queryEntityBySessionId(String sessionId);

	public boolean removeEntity(ShopCartProductItem entity);

	public int saveAndLoadEntity(ShopCartProductItem entity);
	
	public boolean removeEntityBySsssionId(ShopCartProductItem entity);
}
