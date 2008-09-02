package com.poprlz.product.dao.test;

import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.poprlz.product.dao.ICategorieDao;
import com.poprlz.product.entity.Categorie;

public class CategorieDaoImpleTest {
	
	Injector in=Guice.createInjector();
	
	ICategorieDao<Categorie> dao=in.getInstance(ICategorieDao.class);

	@Test
	public void testQueryEntity() {
	
		
		List<Categorie> catList=dao.queryEntity();
		
		for(Iterator<Categorie> catIterator=catList.iterator();catIterator.hasNext();){
			System.out.println(catIterator.next().getCategorieId());
			//Assert.assertTrue(true);
			
		}
		 
		 
	}
	
	@Test
	public void testQueryEffectiveCategorie(){
		List<Categorie> catList=dao.queryEffectiveCategorie();
		
		for(Iterator<Categorie> catIterator=catList.iterator();catIterator.hasNext();){
			System.out.println(catIterator.next().getCategorieId());
			//Assert.assertTrue(true);
			
		}
	}
	

	@Test
	public void testLoadEntity() {
		Categorie cat=dao.loadEntity(0);
		Assert.assertNull(cat);
	}

	@Test
	public void testModifyEntity() {
		Categorie cat=dao.loadEntity(1);
		cat.setInformation("modify test cat Infomation!");
		
		cat=dao.saveAndLoadEntity(cat);
		
		Assert.assertEquals("modify test cat Infomation!",cat.getInformation());
	}

 

	@Test
	public void testRemoveEntity() {
		dao.removeEntity(dao.loadEntity(2));
	}

	@Test
	public void testSaveAndLoadEntity() {
		Categorie parent=new Categorie();
		parent.setCategorieId(0);
		Categorie cat=new Categorie();
		cat.setCatName("testCatName");
		cat.setImage("testCatImage");
		cat.setInformation("testCatInfomation");
		cat.setParentCat(parent);
		cat.setSortOrder(0);
		cat.setStutas(0);
		cat=dao.saveAndLoadEntity(cat);
		
		//Assert.assertEquals(1,cat.getCategorieId());
		
		System.out.println(cat.getCategorieId());
	}

}
