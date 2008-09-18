package com.poprlz.product.logic;

import com.google.inject.ImplementedBy;
import com.poprlz.product.web.bean.ShopCart;
import com.poprlz.product.web.bean.ShopCartProductItem;
@ImplementedBy(ShopCartServiceLogic.class)
public interface IShopCartServiceLogic {

	public ShopCart saveProductItem(ShopCart shopCart,
			ShopCartProductItem shopCartProductItem);

	public ShopCart loadShopCartInfo(String sessionId);

	public ShopCart saveShopCartInfo(ShopCart shopCart);

}
