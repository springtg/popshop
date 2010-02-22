package com.poprlz.mall.manufacturer.logic;

 

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.poprlz.dao.IGenericDAO;
import com.poprlz.logic.GenericLogicService;
import com.poprlz.mall.entity.Manufacturer;
import com.poprlz.mall.manufacturer.dao.IManufacturerDao;
import com.poprlz.web.Page;
 
 

@Service("manufacturerLogicService")
public class ManufacturerLogicService extends
		GenericLogicService<Manufacturer, Integer> implements
		IManufacturerLogicService {

	@Resource(name="manufacturerDao")
	private IManufacturerDao manufacturerDao;
	@Override
	protected IGenericDAO<Manufacturer, Integer> getIGenericDAO() {
		 
		return manufacturerDao;
	}
	@Override
	public Page<Manufacturer> listManufacturerPage(int pageIndex,int pageSize) {
		// TODO Auto-generated method stub
		return manufacturerDao.listManufacturerPage(pageIndex,pageSize);
	}

}
