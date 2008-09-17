package com.poprlz.product.dao.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.poprlz.product.dao.IShopCartDao;
import com.poprlz.product.dao.ShopCartDaoImple;
import com.poprlz.product.web.bean.ShopCart;

public class ShopCartDaoImpleTest {
	Injector in = Guice.createInjector();
	IShopCartDao shopCartDao=in.getInstance(ShopCartDaoImple.class);
	@Test
	public void testLoadEntity() {
		ShopCart shopCart = shopCartDao.loadEntity("0000168988.06592821199");
		
		Assert.assertEquals(shopCart.getSessionId(), "0000168988.06592821199");
	}

	@Test
	public void testModifyEntity() {
		ShopCart shopCart = shopCartDao.loadEntity("0000168988.06592821199");
		
		shopCart.setClientIP("192.168.1.2");
		shopCartDao.modifyEntity(shopCart);
		shopCart = shopCartDao.loadEntity("0000168988.06592821199");
		Assert.assertEquals(shopCart.getClientIP(), "192.168.1.2");
	}

	@Test
	public void testQueryEntity() {
		
		String query= "SELECT sessionId,userInfoId,userName,createDate,lastAcessDate,clientIP,totalPrice FROM shopCart ";
		List<ShopCart> shopCartList=shopCartDao.queryEntity(query);
		
		ShopCart shopCart=null;
		for(Iterator<ShopCart> iterator=shopCartList.iterator();iterator.hasNext();){
			shopCart=iterator.next();
			System.out.println(shopCart.getSessionId());
			System.out.println(shopCart.getUserName());
			System.out.println(shopCart.getCreateDate());
			System.out.println(shopCart.getLastAcessDate());
			System.out.println(shopCart.getTotalPrice());
		
			
		}
		
		
	}

	@Test
	public void testRemoveEntity() {
		String seesionId="00001"+(int)100000*Math.random();
		ShopCart shopCart=new ShopCart();
		
		shopCart.setClientIP("127.0.0.1");
		shopCart.setSessionId(seesionId);
		shopCartDao.removeEntity(shopCart);
	}

	@Test
	public void testSaveAndLoadEntity() {
		String seesionId="00001";//+(int)100000*Math.random();
		ShopCart shopCart=new ShopCart();
		
		shopCart.setClientIP("127.0.0.1");
		shopCart.setSessionId(seesionId);
		shopCart.setTotalPrice(new BigDecimal(10));
		shopCart.setUserInfoId(1);
		shopCart.setUserName("Teset User Name");
		
		shopCart=shopCartDao.saveAndLoadEntity(shopCart);
		
		Assert.assertEquals(shopCart.getSessionId(), seesionId);
		 
		
	}

}
