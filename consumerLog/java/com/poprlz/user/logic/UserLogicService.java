package com.poprlz.user.logic;

import java.util.List;

import com.google.inject.Inject;
import com.poprlz.user.dao.IUserDao;
import com.poprlz.user.entity.UserInfo;
import com.poprlz.util.PaginationSupport;



public class UserLogicService implements IUserLogicService {
	
	@Inject
	private IUserDao userDao;
	 
	public boolean authenticationUserInfo(String userEmail, String password) {
		UserInfo userInfo=userDao.loadUserInfoByUserEmail(userEmail);
		if(userInfo==null || !password.equals(userInfo.getUserPassword()))
			return false;
		System.out.println("成功验证用户阿！");
		return true;
	}
 
	public UserInfo createUserInfo(UserInfo userInfo) {
		return (UserInfo)userDao.saveAndLoadEntity(userInfo);
		 
	}
	 
	public boolean isHasUserName(String userEmail) {
		UserInfo userInfo=userDao.loadUserInfoByUserEmail(userEmail);
		if(userInfo==null)
			return true;
		return false;
	}
	 
	 
	public void logicRemoveUserInfo(int userInfoId) {
		UserInfo userInfo=(UserInfo)userDao.loadEntity(userInfoId);
		userInfo.setStutas(UserInfo.STUTAS_N);
		userDao.modifyEntity(userInfo);
		// TODO Auto-generated method stub
		
	}
	public UserInfo saveUserInfo(UserInfo userInfo) {
		return (UserInfo)userDao.saveAndLoadEntity(userInfo);
	}

	public UserInfo loadUserInfo(int userInfoId) {
		 
		return  (UserInfo)userDao.loadEntity(userInfoId);
	}

	public PaginationSupport<UserInfo> queryUserInfo(int page) {
		int totalCount=userDao.getUserInfoCount();
		List<UserInfo> userInfList=userDao.queryUserInfo(page);
		
		PaginationSupport<UserInfo> pagination=new PaginationSupport<UserInfo>(userInfList,totalCount);
		return pagination;
	}
	
	

}
