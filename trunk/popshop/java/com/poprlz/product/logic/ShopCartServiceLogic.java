package com.poprlz.product.logic;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import com.google.inject.Inject;
import com.poprlz.product.dao.IShopCartDao;
import com.poprlz.product.dao.IShopCartProductItemDao;
import com.poprlz.product.web.bean.ShopCart;
import com.poprlz.product.web.bean.ShopCartProductItem;

public class ShopCartServiceLogic implements IShopCartServiceLogic {
	@Inject
	private IShopCartDao shopCartDao;
	@Inject
	IShopCartProductItemDao shopCartProductItemDao;

	public ShopCart loadShopCartInfo(String sessionId) {

		ShopCart shopCart = shopCartDao.loadEntity(sessionId);

		if (shopCart == null)
			return null;

		shopCart.setProductItemInfoList(shopCartProductItemDao
				.queryEntityBySessionId(sessionId));

		return shopCart;
	}

	public ShopCart saveProductItem(ShopCart shopCart,
			ShopCartProductItem shopCartProductItem) {

		List<ShopCartProductItem> productItemList = shopCartProductItemDao
				.queryEntityBySessionId(shopCart.getSessionId());

		if (productItemList == null || productItemList.size() < 1) {
			if (shopCartProductItem.getOrderQuantity() > 0)
				shopCartProductItemDao.saveAndLoadEntity(shopCartProductItem);
		} else {

			ShopCartProductItem item = null;
			for (int i = 0; i < productItemList.size(); i++) {

				if (productItemList.get(i).getProductId().equals(
						shopCartProductItem.getProductId())) {

					item = productItemList.get(i);
					break;
				}

			}

			if (item == null) {// 数据库不存在这个产品的数据

				if (shopCartProductItem.getOrderQuantity() > 0)
					shopCartProductItemDao
							.saveAndLoadEntity(shopCartProductItem);

			} else {

				if (item.getOrderQuantity()
						+ shopCartProductItem.getOrderQuantity() > 0) {
					item.setOrderQuantity(item.getOrderQuantity()
							+ shopCartProductItem.getOrderQuantity());
					shopCartProductItemDao.modifyEntity(item);
				} else {
					shopCartProductItemDao.removeEntity(item);
				}

			}

		}

		 
		return saveShopCartInfo(shopCart);
	}

	public ShopCart saveShopCartInfo(ShopCart shopCart) {

		List<ShopCartProductItem> productItemList = shopCartProductItemDao
				.queryEntityBySessionId(shopCart.getSessionId());
		BigDecimal totalPrice = new BigDecimal(0);
		if (productItemList != null) {
			ShopCartProductItem item = null;
			for (Iterator<ShopCartProductItem> iterator = productItemList
					.iterator(); iterator.hasNext();) {
				item = iterator.next();
				totalPrice.add(item.getPrice().multiply(
						new BigDecimal(item.getOrderQuantity())));

			}
		}

		shopCart.setTotalPrice(totalPrice);
		
		if(null==shopCartDao.loadEntity(shopCart.getSessionId()))
			shopCart=shopCartDao.saveAndLoadEntity(shopCart);
		else
			shopCart=shopCartDao.modifyEntity(shopCart);
		
		shopCart.setProductItemInfoList(productItemList);
		
		return shopCart;
		 
	}

}
