package com.poprlz.user.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 

import com.poprlz.common.CommonConstant;
import com.poprlz.user.dao.ISystemDao;
import com.poprlz.user.entity.SystemEntity;


@Service("systemLogic")
@Transactional(readOnly = true)
public class SystemLogic implements ISystemLogic {
	
	private ISystemDao systemDao;

	public ISystemDao getSystemDao() {
		return systemDao;
	}

	@Autowired
	public void setSystemDao(ISystemDao systemDao) {
		this.systemDao = systemDao;
	}

	@Override
	public boolean checkSystemCodeExited(String systemCode) {
		SystemEntity systemEntity=systemDao.loadSystemEntityBySystemCode(systemCode);
		
		if(systemEntity==null){
			return false;
		}else{
			return true;
		}
	}



	@Override
	public List<SystemEntity> loadAllSystemInfo() {
		
		return systemDao.loadAllSystemInfo();
	}

	@Override
	public SystemEntity loadSystemInfoByKey(Integer systemId) {
	 
		return systemDao.loadByKey(systemId);
	}
	
	@Transactional(readOnly = false)
	public SystemEntity createSystem(SystemEntity system) {
		 
		return systemDao.saveEntity(system);
	}

	@Transactional(readOnly = false)
	public SystemEntity modifySystem(SystemEntity system) {
		SystemEntity systemEntity=systemDao.loadByKey(system.getSystemId());
		systemEntity.setDescription(system.getDescription());
		systemEntity.setStatus(system.getStatus());
		return  systemDao.modifyEntity(systemEntity);
	}

	@Transactional(readOnly = false)
	public boolean removeSystem(SystemEntity system) {
		SystemEntity systemEntity=systemDao.loadByKey(system.getSystemId());
		 
		systemEntity.setStatus(CommonConstant.STATUS_SUSPEND);
		return true;
	}

}
