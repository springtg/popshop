package com.poprlz.user.dao;
import java.util.List;

import com.google.inject.ImplementedBy;
import com.poprlz.dao.IGenericDao;
import com.poprlz.user.entity.UserInfo;
 
@ImplementedBy(UserDaoImple.class)
public interface IUserDao extends IGenericDao{
	public UserInfo loadUserInfoByUserEmail(String userEmail);

	public int getUserInfoCount();

	public List<UserInfo> queryUserInfo(int page);
}
