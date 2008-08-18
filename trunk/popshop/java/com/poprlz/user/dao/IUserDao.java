package com.poprlz.user.dao;
import java.util.List;

import com.google.inject.ImplementedBy;
import com.poprlz.dao.IGenericDao;
import com.poprlz.user.entity.UserInfo;
 
@ImplementedBy(UserDaoImple.class)
public interface IUserDao<UserInfo> extends IGenericDao<UserInfo>{
	public UserInfo loadUserInfo(String userName);

	public int getUserInfoCount();

	public List<UserInfo> queryUserInfo(int page);
}
