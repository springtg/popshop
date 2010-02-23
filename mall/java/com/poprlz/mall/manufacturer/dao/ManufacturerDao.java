package com.poprlz.mall.manufacturer.dao;

import org.springframework.stereotype.Repository;

import com.poprlz.dao.GenericJAPDAO;
import com.poprlz.mall.entity.Manufacturer;
import com.poprlz.web.Page;

@Repository("manufacturerDao")
public class ManufacturerDao extends GenericJAPDAO<Manufacturer, Integer>
		implements IManufacturerDao {

	@Override
	public Page<Manufacturer> listManufacturerPage(int pageIndex, int pageSize) {

		int firstResultIndex=Page.convertFirstResultIndex(pageIndex, pageSize);
		Page<Manufacturer> page = this.findPage(
				"SELECT m FROM Manufacturer m ", firstResultIndex, pageSize);
		return page;
	}

}
