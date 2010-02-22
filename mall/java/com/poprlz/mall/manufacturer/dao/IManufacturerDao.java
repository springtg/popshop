package com.poprlz.mall.manufacturer.dao;

import com.poprlz.dao.IGenericDAO;
import com.poprlz.mall.entity.Manufacturer;
import com.poprlz.web.Page;

public interface IManufacturerDao extends IGenericDAO<Manufacturer, Integer> {

	Page<Manufacturer> listManufacturerPage(int pageIndex,int pageSize);

}
