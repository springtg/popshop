package com.poprlz.product.logic;

import java.util.List;

import com.google.inject.Inject;
import com.poprlz.product.dao.IManufacturerDao;
import com.poprlz.product.entity.Manufacturer;

public class ManufacturerServiceLogic implements IManufacturerServiceLogic{
	
	@Inject
	private IManufacturerDao  manufacturerDao;
	public List<Manufacturer> getEffectiveManufacturerList()
			throws ServiceException {
		List<Manufacturer> manufacturerList=manufacturerDao.getEffectiveManufacturerList();
		
		if(manufacturerList==null || manufacturerList.size()<1)
			throw new ServiceException("These is no Manufacturer Infomation");
		return manufacturerList;
	}

}
