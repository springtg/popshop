package com.poprlz.product.logic.test;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.poprlz.product.dao.ProductQueryCondition;
import com.poprlz.product.logic.IProductServiceLogic;
import com.poprlz.product.logic.ProductServiceLogic;
import com.poprlz.product.web.ProductInfoView;
import com.poprlz.util.PaginationSupport;

public class ProductServiceLogicTest {

	Injector in=Guice.createInjector();
	private IProductServiceLogic logic=in.getInstance(ProductServiceLogic.class);
	@Test
	public void testSearchProductAction() {
		ProductQueryCondition queryConditon=new ProductQueryCondition();
		PaginationSupport<ProductInfoView> list=logic.searchProductAction(queryConditon);
		
		ProductInfoView prd=null;
		for(Iterator<ProductInfoView> iterator=list.getItems().iterator();iterator.hasNext();){
			prd=iterator.next();
			System.out.println(prd.getProductId()+" ==>"+prd.getProductName()+"==>"+prd.getProductImage().getImageId());
		}
		 
	}

}
