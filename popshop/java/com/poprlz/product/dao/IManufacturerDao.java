package com.poprlz.product.dao;

import java.util.List;

import com.google.inject.ImplementedBy;
import com.poprlz.dao.IGenericDao;
import com.poprlz.product.entity.Manufacturer;
@ImplementedBy(ManufacturerDaoImple.class)
public interface IManufacturerDao<Manufacturer> extends
		IGenericDao<Manufacturer> {

	public List<Manufacturer> getEffectiveManufacturerList();

}
