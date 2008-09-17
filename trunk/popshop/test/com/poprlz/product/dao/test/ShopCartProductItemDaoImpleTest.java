package com.poprlz.product.dao.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.poprlz.product.dao.IProductInfoDao;
import com.poprlz.product.dao.IShopCartDao;
import com.poprlz.product.dao.IShopCartProductItemDao;
import com.poprlz.product.dao.ProductInfoDaoImple;
import com.poprlz.product.dao.ShopCartDaoImple;
import com.poprlz.product.dao.ShopCartProductItemDaoImple;
import com.poprlz.product.entity.ProductInfo;
import com.poprlz.product.web.bean.ShopCartProductItem;

public class ShopCartProductItemDaoImpleTest {
	
	Injector in = Guice.createInjector();
	IShopCartDao shopCartDao=in.getInstance(ShopCartDaoImple.class);
	IShopCartProductItemDao shopCartProductItemDao=in.getInstance(ShopCartProductItemDaoImple.class);
	private IProductInfoDao<ProductInfo> productInfoDao = in
	.getInstance(ProductInfoDaoImple.class);

	@Test
	public void testLoadEntity() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifyEntity() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryEntity() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryEntityBySessionId() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveEntity() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveEntityBySsssionId() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveAndLoadEntity() {
		ShopCartProductItem item=new ShopCartProductItem();
		ProductInfo prod=productInfoDao.loadEntity(1);
		
		item.setDescription(prod.getDescription());
		item.setImageId(1);
		item.setImgPath("prod Test");
		item.setOrderQuantity(prod.getQuantity()-1);
		item.setPrice(prod.getPrice());
		item.setProductId(prod.getProductId());
		item.setProductName(prod.getProductName());
		item.setSessionId("122334");
		item.setURL(prod.getURL());
		item.setWeight(prod.getWeight());
		
		shopCartProductItemDao.saveAndLoadEntity(item);
	}

}
