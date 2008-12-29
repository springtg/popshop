package com.poprlz.user.dao;

import java.util.List;

import com.poprlz.dao.IGenericDao;
import com.poprlz.user.entity.SystemEntity;

public interface ISystemDao extends IGenericDao<SystemEntity,Integer>{
	
	public SystemEntity loadSystemEntityBySystemCode(String systemCode);

	public List<SystemEntity> loadAllSystemInfo();

}
