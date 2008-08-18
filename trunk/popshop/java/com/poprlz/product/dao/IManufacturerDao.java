package com.poprlz.product.dao;

import com.google.inject.ImplementedBy;
import com.poprlz.dao.IGenericDao;
@ImplementedBy(ManufacturerDaoImple.class)
public interface IManufacturerDao<Manufacturer> extends
		IGenericDao<Manufacturer> {

}
