package com.poprlz.product.dao.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.poprlz.product.dao.IProductInfoDao;
import com.poprlz.product.dao.ProductInfoDaoImple;
import com.poprlz.product.entity.ProductInfo;

public class ProductInfoDaoImpleTest {

	Injector in = Guice.createInjector();
	private IProductInfoDao<ProductInfo> productInfoDao = in
			.getInstance(ProductInfoDaoImple.class);

	@Test
	public void testQueryEntity() {
		List<ProductInfo> prdList = productInfoDao.queryEntity();

		for (Iterator<ProductInfo> iterator = prdList.iterator(); iterator
				.hasNext();) {
			ProductInfo prd = iterator.next();
			Assert.assertNotNull(prd);
			System.out.println(prd.getProductId() + "|" + prd.getProductName());

		}
	}

	@Test
	public void testLoadEntity() {
		ProductInfo prd =productInfoDao.loadEntity(1);
		
		Assert.assertNotNull(prd);
		Assert.assertEquals(1, prd.getProductId().intValue());
		
	}

	@Test
	public void testGetNewProducts() {
		List<ProductInfo> prdList = productInfoDao.getNewProducts();

		for (Iterator<ProductInfo> iterator = prdList.iterator(); iterator
				.hasNext();) {
			ProductInfo prd = iterator.next();
			Assert.assertNotNull(prd);
			System.out.println(prd.getProductId() + "|" + prd.getProductName());

		}
	}

	@Test
	public void testGetTopSellProducts() {
		List<ProductInfo> prdList = productInfoDao.getTopSellProducts();

		for (Iterator<ProductInfo> iterator = prdList.iterator(); iterator
				.hasNext();) {
			ProductInfo prd = iterator.next();
			Assert.assertNotNull(prd);
			System.out.println(prd.getProductId() + "|" + prd.getProductName());

		}
	}

	@Test
	public void testGetTopViewProducts() {
		List<ProductInfo> prdList = productInfoDao.getTopViewProducts();

		for (Iterator<ProductInfo> iterator = prdList.iterator(); iterator
				.hasNext();) {
			ProductInfo prd = iterator.next();
			Assert.assertNotNull(prd);
			System.out.println(prd.getProductId() + "|" + prd.getProductName());

		}
	}

	@Test
	public void testModifyEntity() {
		ProductInfo prd =productInfoDao.loadEntity(1);
		prd.setModel("Modify Model");
		
		productInfoDao.modifyEntity(prd);
		
		prd =productInfoDao.loadEntity(1);
		
		Assert.assertEquals("Modify Model", prd.getModel());
	}

	@Test
	public void testRemoveEntity() {
		productInfoDao.removeEntity(productInfoDao.loadEntity(2));
	}

	@Test
	public void testSaveAndLoadEntity() {

		ProductInfo prd = new ProductInfo();
		Date currentDate = new Date();
		prd.setDateAdded(currentDate);
		prd.setDateAvailable(currentDate);
		prd.setDescription("product Test Data,测试数据!");
		prd.setLastModified(currentDate);
		prd.setModel("Product Test Model");
		prd.setOrdered(10);
		prd.setPrice(new BigDecimal(10.5));
		prd.setProductName("Product Test Name Data");
		prd.setQuantity(20);
		prd.setStutas(0);
		prd.setURL("http://www.poprlz.cn");
		prd.setViewed(20);
		prd.setWeight(new BigDecimal(1.5));
		productInfoDao.saveAndLoadEntity(prd);

		Assert.assertEquals(4, prd.getProductId().intValue());

		System.out.println(prd.getProductId());
	}

}
