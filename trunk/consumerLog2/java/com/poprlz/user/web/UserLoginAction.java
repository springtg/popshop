package com.poprlz.user.web;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.poprlz.user.logic.IUserLogic;
 

public class UserLoginAction extends ActionSupport {
	
	
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

	@RequiredStringValidator(fieldName="password",message = "Default message", key = "userLogin.password.error", shortCircuit = true, trim = true)
	@EmailValidator(fieldName="email",message = "Please input validate Email", key = "userLogin.email.errorFormat", shortCircuit = true)
	@Override
	public String execute() throws Exception {
		
		System.out.println(email);
		System.out.println(password);
		
		if(userLogic.authenticationUser(email, password)){
			
			return INPUT;
			
		}else{

			return SUCCESS;
		}
	}
	

	
}
