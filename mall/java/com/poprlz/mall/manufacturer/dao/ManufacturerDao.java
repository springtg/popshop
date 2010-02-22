package com.poprlz.mall.manufacturer.dao;

 

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.poprlz.dao.GenericJAPDAO;
import com.poprlz.mall.entity.Manufacturer;
import com.poprlz.web.Page;

@Repository("manufacturerDao")
public class ManufacturerDao extends GenericJAPDAO<Manufacturer, Integer>
		implements IManufacturerDao {

	@Override
	public Page<Manufacturer> listManufacturerPage(int pageIndex,int pageSize) {
		
		Page<Manufacturer> page=new Page<Manufacturer>(pageSize);
		
		 int totalCount=this.excuteQueryIntegerData("SELECT COUNT(1) FROM "+this.getPersistentClass());
		 
		 page.setTotalCount(totalCount);
		 List<Manufacturer> result=(List<Manufacturer>)this.excuteQuery("SELECT o FROM "+this.getPersistentClass()+" o ", pageIndex*pageSize, pageSize);
		 page.setResult(result);
		// TODO Auto-generated method stub
		return page;
	}

	 

}
