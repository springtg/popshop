package com.poprlz.user.logic;

import com.poprlz.user.entity.UserEntity;

public interface IUserLogic {
	
	public boolean authenticationUser(String email,String password);

	public boolean checkUserEmailExited(String email);

	public UserEntity registerUser(UserEntity user);

}
