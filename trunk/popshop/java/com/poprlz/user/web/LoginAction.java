package com.poprlz.user.web;

import com.google.inject.Inject;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.poprlz.user.logic.IUserLogicService;

public class LoginAction extends ActionSupport {
	
	 
	private String userName;
	private String userPassword;
	private String greeting;
	
	@Inject
	private IUserLogicService userLogicService;

	@Override
	@Validations(requiredStrings={
			@RequiredStringValidator(message="Please input userName!",key="userName.error.required",fieldName="userName",type=ValidatorType.SIMPLE,trim=true),
			@RequiredStringValidator(message="Please input userPassword!",key="password.error.required",fieldName="userPassword",type=ValidatorType.SIMPLE,trim=true)})
	public String execute() throws Exception {

		userLogicService.authenticationUserInfo(userName, userPassword);
		this.greeting="Welcome to Here!";
		return SUCCESS;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	 
	
	

}
