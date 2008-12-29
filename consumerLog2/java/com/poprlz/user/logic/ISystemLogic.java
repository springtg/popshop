package com.poprlz.user.logic;

import java.util.List;

import com.poprlz.user.entity.SystemEntity;

public interface ISystemLogic {

	public boolean checkSystemCodeExited(String systemCode);

	public SystemEntity createSystem(SystemEntity system);

	public SystemEntity modifySystem(SystemEntity system);

	public boolean removeSystem(SystemEntity system);

	public List<SystemEntity> loadAllSystemInfo();

	public SystemEntity loadSystemInfoByKey(Integer systemId);

}
