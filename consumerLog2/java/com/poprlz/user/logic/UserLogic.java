package com.poprlz.user.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poprlz.user.dao.IUserDao;
import com.poprlz.user.entity.UserEntity;

@Service("userLogic")
@Transactional(readOnly = true)
public class UserLogic implements IUserLogic {
	
	private IUserDao userDao;
	
	

	public IUserDao getUserDao() {
		return userDao;
	}


	@Autowired
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}



	@Override
	public boolean authenticationUser(String email, String password) {
		
		
		UserEntity userEntity=userDao.loadUserEntityByEmail(email);
		
		if(userEntity==null){
			return false;
		}
		
		if(password.equals(userEntity.getPassword())){
			return true;
		}
		return false;
	}


	@Override
	public boolean checkUserEmailExited(String email) {
		UserEntity userEntity=userDao.loadUserEntityByEmail(email);
		
		if(userEntity==null){
			return false;
		}
		
		return true;
	}


	@Override
	public UserEntity registerUser(UserEntity user) {
		// TODO Auto-generated method stub
		return null;
	}

}
