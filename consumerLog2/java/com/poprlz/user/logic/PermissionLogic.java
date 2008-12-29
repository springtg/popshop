package com.poprlz.user.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poprlz.common.CommonConstant;
import com.poprlz.user.dao.IPermissionDao;
import com.poprlz.user.entity.PermissionEntity;


@Service("permissionLogic")
@Transactional(readOnly = true)
public class PermissionLogic implements IPermissionLogic {

	private IPermissionDao permissionDao;
	
	public IPermissionDao getPermissionDao() {
		return permissionDao;
	}

	@Autowired
	public void setPermissionDao(IPermissionDao permissionDao) {
		this.permissionDao = permissionDao;
	}

	@Override
	public boolean checkPermissionCodeExited(String permissionCode) {
		PermissionEntity permission=permissionDao.loadPermissionEntityByEermissionCode(permissionCode);
		
		if(permission==null){
			return false;
		}
		return true;
	}

	@Override
	public PermissionEntity createPermission(PermissionEntity permission) {
		PermissionEntity entity=permissionDao.saveEntity(permission);
		return entity;
	}

	@Override
	public List<PermissionEntity> loadAllPermissionInfoBySystemId(
			Integer systemId) {
		 
		List<PermissionEntity> result=permissionDao.loadAllPermissionInfoBySystemId(systemId);
		
		return result;
	}

	@Override
	public PermissionEntity loadPermissionInfoByKey(Integer permissionId) {
	 
		return permissionDao.loadByKey(permissionId);
	}

	@Override
	public PermissionEntity modifyPermission(PermissionEntity permission) {
		PermissionEntity entity=permissionDao.modifyEntity(permission);
		return entity;
	}

	@Override
	public boolean removePermission(PermissionEntity permission) {
		PermissionEntity entity=permissionDao.loadByKey(permission.getPermissionId());
		entity.setStatus(CommonConstant.STATUS_SUSPEND);
		permissionDao.modifyEntity(entity);
		return true;
	}

}
