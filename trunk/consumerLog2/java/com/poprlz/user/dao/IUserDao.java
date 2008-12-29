package com.poprlz.user.dao;

import com.poprlz.dao.IGenericDao;
import com.poprlz.user.entity.UserEntity;

public interface IUserDao extends IGenericDao<UserEntity,Integer>{
	
	public UserEntity loadUserEntityByEmail(String email);

}
