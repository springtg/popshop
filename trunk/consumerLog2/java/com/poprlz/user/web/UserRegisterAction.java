package com.poprlz.user.web;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.poprlz.common.CommonConstant;
import com.poprlz.user.entity.UserEntity;
import com.poprlz.user.logic.IUserLogic;
 

public class UserRegisterAction extends ActionSupport {
	
	
	private IUserLogic userLogic;
	 
	
	
	 
	public IUserLogic getUserLogic() {
		return userLogic;
	}


	@Autowired
	public void setUserLogic(IUserLogic userLogic) {
		this.userLogic = userLogic;
	}

	private String email;
	
	
	 
	private String password;
	
	private String conPassword;
	
	private UserEntity userEntity;
	
	
	
	

	public UserEntity getUserEntity() {
		return userEntity;
	}


	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}


	public String getConPassword() {
		return conPassword;
	}


	public void setConPassword(String conPassword) {
		this.conPassword = conPassword;
	}


	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
	@Validations(requiredStrings = {
	@RequiredStringValidator(fieldName="password",message = "Default message", key = "userRegister.password.error", shortCircuit = true, trim = true),
	@RequiredStringValidator(fieldName="conPassword",message = "Default message", key = "userRegister.conPassword.error", shortCircuit = true, trim = true)
	}
	
	)
	@EmailValidator(fieldName="email",message = "Please input validate Email", key = "userRegister.email.errorFormat", shortCircuit = true)
	@Override
	public String execute() throws Exception {
		
		 
		
		if(!password.equals(conPassword)){
			this.addActionError(this.getText("userRegister.password.notEqual", "THIS password not equal conPassword !"));
			return INPUT;
			
		} 
		
		boolean isEmailExited=userLogic.checkUserEmailExited(email);
		
		if(isEmailExited){
			this.addActionError(this.getText("userRegister.email.exited", "THIS email has been exited !"));
			return INPUT;
			
		}
		
		UserEntity user =new UserEntity();
		user.setEmail(email);
		user.setPassword(password);
		user.setStatus(CommonConstant.STATUS_ACTIVE);
		
		userEntity=userLogic.registerUser(user);

		return SUCCESS;
		 
	}
	

	
}
