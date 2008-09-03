package com.poprlz.product.dao.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.poprlz.product.dao.IManufacturerDao;
import com.poprlz.product.entity.Categorie;
import com.poprlz.product.entity.Manufacturer;

public class ManufacturerDaoImpleTest {
	Injector in=Guice.createInjector();
	IManufacturerDao<Manufacturer> dao=in.getInstance(IManufacturerDao.class);
	@Test
	public void testQueryEntity() {
	List<Manufacturer> manuList=dao.queryEntity();
		
		for(Iterator<Manufacturer> manuIterator=manuList.iterator();manuIterator.hasNext();){
			System.out.println(manuIterator.next().getManufacturerName());
			//Assert.assertTrue(true);
			
		}
	}

	@Test
	public void testLoadEntity() {
		Manufacturer manufacturer=dao.loadEntity(1);
		System.out.println(manufacturer.getManufacturerId()+manufacturer.getManufacturerName());
	}

	@Test
	public void testModifyEntity() {
		Manufacturer manufacturer=dao.loadEntity(1);
		manufacturer.setInformation("modify manufacturer Infomation");
		manufacturer=dao.saveAndLoadEntity(manufacturer);
		
		Assert.assertEquals("modify manufacturer Infomation", manufacturer.getInformation());
		
	}

	@Test
	public void testRemoveEntity() {
		dao.removeEntity(dao.loadEntity(1));
	}

	@Test
	public void testSaveAndLoadEntity() {
		Manufacturer manufacturer=new Manufacturer();
		manufacturer.setDateLastClick(new Date());
		manufacturer.setInformation("test manufacturer information");
		manufacturer.setManufacturerImage("test imager");
		manufacturer.setManufacturerName("test manufacturer name");
		manufacturer.setManufacturerURL("test manufacturer URL");
		manufacturer.setUrlClicked(1);
		dao.saveAndLoadEntity(manufacturer);
	}
	
	@Test
	public void testGetEffectiveManufacturerList(){
		
		List<Manufacturer> manuList=dao.getEffectiveManufacturerList();
		
		for(Iterator<Manufacturer> manuIterator=manuList.iterator();manuIterator.hasNext();){
			System.out.println(manuIterator.next().getManufacturerName());
			//Assert.assertTrue(true);
			
		}
		
	}

}
