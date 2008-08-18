package com.poprlz.user.web;

 

import com.google.inject.Inject;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.poprlz.user.entity.UserInfo;
import com.poprlz.user.logic.IUserLogicService;

public class UserInfoManagerAction extends ActionSupport {
	@Inject
	private IUserLogicService userLogicService;

	// 用户唯一标识
	private int userInfoId;

	// 用户登陆名
	private String userName;

	// 用户登陆密码
	private String userPassword;

	// 用户电子邮箱
	private String userEmail;

	private UserInfo userInfo;

	public int getUserInfoId() {
		return userInfoId;
	}

	public void setUserInfoId(int userInfoId) {
		this.userInfoId = userInfoId;
	}

	public String getUserName() {
		return userName;
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

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}
	
	 
	@Validations(requiredStrings = {
			@RequiredStringValidator(message = "Please input userName!", key = "userName.error.required", fieldName = "userName", type = ValidatorType.SIMPLE, trim = true),
			@RequiredStringValidator(message = "Please input userPassword!", key = "password.error.required", fieldName = "userPassword", type = ValidatorType.SIMPLE, trim = true) }, emails = { @EmailValidator(message = "Please input userEmail!", key = "userEmail.error.required", fieldName = "userEmail", type = ValidatorType.SIMPLE) }, intRangeFields = { @IntRangeFieldValidator(type = ValidatorType.SIMPLE, fieldName = "userInfoId", min = "0", max = "1000", message = "Value must be between ${min} and ${max}.", key = "userInfoId.error.required") })
	public String modifyUserInfo() throws Exception {
		
		userInfo=new UserInfo();
		userInfo.setUserInfoId(userInfoId);
		userInfo.setUserEmail(userEmail);
		userInfo.setUserName(userName);
		userInfo.setUserPassword(userPassword);
		userInfo.setStutas(UserInfo.STUTAS_Y);
		userInfo=userLogicService.saveUserInfo(userInfo);
		 

		return SUCCESS;
	}

	@Validations(requiredStrings = {
			@RequiredStringValidator(message = "Please input userName!", key = "userName.error.required", fieldName = "userName", type = ValidatorType.SIMPLE, trim = true),
			@RequiredStringValidator(message = "Please input userPassword!", key = "password.error.required", fieldName = "userPassword", type = ValidatorType.SIMPLE, trim = true) }, emails = { @EmailValidator(message = "Please input userEmail!", key = "userEmail.error.required", fieldName = "userEmail", type = ValidatorType.SIMPLE) })

	public String registUserInfo() throws Exception {
		userInfo=new UserInfo();
		userInfo.setUserEmail(userEmail);
		userInfo.setUserName(userName);
		userInfo.setUserPassword(userPassword);
		userInfo.setStutas(UserInfo.STUTAS_Y);
		userInfo=userLogicService.createUserInfo(userInfo);
		return SUCCESS;
	}

	@Validations(intRangeFields = { @IntRangeFieldValidator(type = ValidatorType.SIMPLE, fieldName = "userInfoId", min = "0", max = "1000", message = "Value must be between ${min} and ${max}.", key = "userInfoId.error.required") })
	public String removeUserInfo() throws Exception {
		userLogicService.logicRemoveUserInfo(userInfoId);
		return SUCCESS;
	}
	
	@Validations(intRangeFields = { @IntRangeFieldValidator(type = ValidatorType.SIMPLE, fieldName = "userInfoId", min = "0", max = "1000", message = "Value must be between ${min} and ${max}.", key = "userInfoId.error.required") })
	public String loadUserInfo() throws Exception {
		userInfo=userLogicService.loadUserInfo(userInfoId);
		return SUCCESS;
	}

	@Validations(requiredStrings = { @RequiredStringValidator(message = "Please input userName!", key = "userName.error.required", fieldName = "userName", type = ValidatorType.SIMPLE, trim = true) })
	public String checkUserName() throws Exception {

		boolean result = userLogicService.isHasUserName(userName);

		if (result)
			return SUCCESS;
		else
			return ERROR;
	}

}
