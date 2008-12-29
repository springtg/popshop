package com.poprlz.user.dao;

 

import java.util.List;

import com.poprlz.dao.IGenericDao;
import com.poprlz.user.entity.PermissionEntity;
 

public interface IPermissionDao extends IGenericDao<PermissionEntity,Integer>{

	PermissionEntity loadPermissionEntityByEermissionCode(String permissionCode);

	List<PermissionEntity> loadAllPermissionInfoBySystemId(Integer systemId);
	
	 

	 

}
