package com.poprlz.user.logic;

import com.google.inject.ImplementedBy;
import com.poprlz.user.entity.UserInfo;
import com.poprlz.util.PaginationSupport;


@ImplementedBy(UserLogicService.class)
public interface IUserLogicService {
	
	public boolean authenticationUserInfo(String userName,String password);

	public boolean isHasUserName(String userName);

	public void logicRemoveUserInfo(int userInfoId);

	public UserInfo createUserInfo(UserInfo userInfo);

	public UserInfo saveUserInfo(UserInfo userInfo);

	public UserInfo loadUserInfo(int userInfoId);

	public PaginationSupport<UserInfo> queryUserInfo(int page);

}
