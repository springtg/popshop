package com.poprlz.user.web;

import com.google.inject.Inject;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.poprlz.user.logic.IUserLogicService;

public class LoginAction extends ActionSupport {

	// 用户电子邮箱
	private String userEmail;

	private String userPassword;
	private String greeting;

	@Inject
	private IUserLogicService userLogicService;

	@Override
	@Validations(requiredStrings = {

	@RequiredStringValidator(message = "Please input userPassword!", key = "password.error.required", fieldName = "userPassword", type = ValidatorType.SIMPLE, trim = true) }, emails = { @EmailValidator(message = "Please input userEmail!", key = "userEmail.error.required", fieldName = "userEmail", type = ValidatorType.SIMPLE) })
	public String execute() throws Exception {

		userLogicService.authenticationUserInfo(userEmail, userPassword);
		this.greeting = "Welcome to Here!";
		return SUCCESS;
	}

	public String getGreeting() {
		return greeting;
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

}
