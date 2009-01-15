package org.light.portal.core.service.spring;

import org.light.portal.core.dao.BaseDao;
import org.light.portal.model.Entity;

public class BaseServiceImpl {
	
	private BaseDao baseDao;
	
	public Entity create(Entity entity){
		return baseDao.create(entity);
	}
	
	public void save(Entity entity){
		baseDao.save(entity);
	}
	
	public void delete(Entity entity){
		baseDao.delete(entity);
	}

	public BaseDao getBaseDao() {
		return baseDao;
	}
	

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
}
