package com.poprlz.mall.manufacturer.dao;

 

import org.springframework.stereotype.Repository;

import com.poprlz.dao.GenericJAPDAO;
import com.poprlz.mall.entity.Manufacturer;

@Repository("manufacturerDao")
public class ManufacturerDao extends GenericJAPDAO<Manufacturer, Integer>
		implements IManufacturerDao {

	 

}
