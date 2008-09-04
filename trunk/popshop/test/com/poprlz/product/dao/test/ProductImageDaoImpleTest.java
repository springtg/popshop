package com.poprlz.product.dao.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.poprlz.product.dao.IProductImageDao;
import com.poprlz.product.dao.IProductInfoDao;
import com.poprlz.product.dao.ProductImageDaoImple;
import com.poprlz.product.dao.ProductInfoDaoImple;
import com.poprlz.product.entity.ProductImage;
import com.poprlz.product.entity.ProductInfo;

public class ProductImageDaoImpleTest {
	
	Injector in=Guice.createInjector();
	
	private IProductImageDao<ProductImage> productImageDao=in.getInstance(ProductImageDaoImple.class);
	private IProductInfoDao<ProductInfo> productInfoDao = in.getInstance(ProductInfoDaoImple.class);
	@Test
	public void testLoadEntity() {
		ProductImage img=productImageDao.loadEntity(1);
		
		Assert.assertNotNull(img);
		
		Assert.assertEquals(1, img.getImageId().intValue());
		
	}

	@Test
	public void testQueryEntity() {
		List<ProductImage> imgList=productImageDao.queryEntity();
		
		for(Iterator<ProductImage> iterator=imgList.iterator();iterator.hasNext();){
			ProductImage image=iterator.next();
			System.out.println(image.getImageId());
			System.out.println(image.getContent());
		}
		
		
		
	}

	@Test
	public void testModifyEntity() {
		ProductImage img=productImageDao.loadEntity(1);
		
		img.setContent("Modify Image Info Content Test");
		
		productImageDao.modifyEntity(img);
		
		img=productImageDao.loadEntity(1);
		Assert.assertEquals("Modify Image Info Content Test", img.getContent());
		
	}

	@Test
	public void testRemoveEntity() {
		productImageDao.removeEntity(productImageDao.loadEntity(2));
	}

	@Test
	public void testSaveAndLoadEntity() {
		ProductImage image=new ProductImage();
		image.setAlt("Image ALT Info Test");
		image.setContent("Image Info Content Test");
		image.setMark("Image Test Mark ");
		image.setPath("/image/test.jpg");
		image.setProductInfo(productInfoDao.loadEntity(1));
		
		 
		
		productImageDao.saveAndLoadEntity(image);
		
		Assert.assertEquals(4, image.getImageId().intValue());

		System.out.println(image.getImageId());
		
	}

}
