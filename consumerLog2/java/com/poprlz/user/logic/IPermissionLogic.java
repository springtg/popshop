package com.poprlz.user.logic;

import java.util.List;

import com.poprlz.user.entity.PermissionEntity;

public interface IPermissionLogic {

	public boolean checkPermissionCodeExited(String permissionCode);

	public PermissionEntity createPermission(PermissionEntity permission);

	public PermissionEntity modifyPermission(PermissionEntity permission);

	public boolean removePermission(PermissionEntity permission);

	public PermissionEntity loadPermissionInfoByKey(Integer permissionId);

	public List<PermissionEntity> loadAllPermissionInfoBySystemId(Integer systemId);

}
