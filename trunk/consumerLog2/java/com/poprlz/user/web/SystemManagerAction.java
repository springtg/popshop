package com.poprlz.user.web;

 
import java.util.List;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import com.poprlz.common.CommonConstant;
import com.poprlz.user.entity.SystemEntity;
import com.poprlz.user.logic.ISystemLogic;

public class SystemManagerAction extends ActionSupport {
	
	
	private ISystemLogic systemLogic;
	
	

	private Integer systemId;
	
 
	private String systemCode;
	
 
	private String description;
 
	private String status;
	
	private SystemEntity systemEntity;
	
	private List<SystemEntity> systemList;

	public Integer getSystemId() {
		return systemId;
	}

	public void setSystemId(Integer systemId) {
		this.systemId = systemId;
	}

	public String getSystemCode() {
		return systemCode;
	}

	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	@Validations(requiredStrings = {
			@RequiredStringValidator(fieldName="systemCode",message = "Pelease Input systemCode.", key = "systemManager.systemCode.nullError", shortCircuit = true, trim = true),
			@RequiredStringValidator(fieldName="description",message = "Pelease Input description.", key = "systemManager.description.nullError", shortCircuit = true, trim = true)
		}
	)
	public String create() throws Exception {
		
		boolean isSystemCodeExited=systemLogic.checkSystemCodeExited(systemCode);
		
		if(isSystemCodeExited){
			this.addActionError(this.getText("systemManager.systemCode.exited", "THIS SYSTEM CODE HAS EXITED!"));
			return INPUT;
		}
		
		SystemEntity system=new SystemEntity();
		
		system.setSystemCode(systemCode);
		system.setDescription(description);
		system.setStatus(CommonConstant.STATUS_ACTIVE);
		
		
		systemEntity=systemLogic.createSystem(system);
	 

		return SUCCESS;
		 
	}
	
	public ISystemLogic getSystemLogic() {
		return systemLogic;
	}
	@Autowired
	public void setSystemLogic(ISystemLogic systemLogic) {
		this.systemLogic = systemLogic;
	}

	public SystemEntity getSystemEntity() {
		return systemEntity;
	}

	@Validations(requiredStrings = {
			@RequiredStringValidator(fieldName="systemCode",message = "Pelease Input systemCode.", key = "systemManager.systemCode.nullError", shortCircuit = true, trim = true),
			@RequiredStringValidator(fieldName="description",message = "Pelease Input description.", key = "systemManager.description.nullError", shortCircuit = true, trim = true)
		},
		intRangeFields =
        { @IntRangeFieldValidator(type = ValidatorType.SIMPLE, fieldName = "systemId", min = "1",key = "systemManager.systemId.nullError",   message = "bar must be between ${min} and ${max}, current value is ${bar}.")}

	)
	public String modify() throws Exception {
		
		SystemEntity system=new SystemEntity();
		system.setSystemId(systemId);
		system.setSystemCode(systemCode);
		system.setDescription(description);
		system.setStatus(status);
		
		systemEntity=systemLogic.modifySystem(system);

		return SUCCESS;
		 
	}
	
	@Validations(
		intRangeFields =
        { @IntRangeFieldValidator(type = ValidatorType.SIMPLE, fieldName = "systemId", min = "1",key = "systemManager.systemId.nullError",   message = "bar must be between ${min} and ${max}, current value is ${bar}.")}

	)
	@SkipValidation
	public String remove() throws Exception {
		
		SystemEntity system=new SystemEntity();
		system.setSystemId(systemId);
	 
		
		systemLogic.removeSystem(system);

		return SUCCESS;
		 
	}
	
	public List<SystemEntity> getSystemList() {
		return systemList;
	}

		@Validations(
			intRangeFields =
	        { @IntRangeFieldValidator(type = ValidatorType.SIMPLE, fieldName = "systemId", min = "1",key = "systemManager.systemId.nullError",   message = "bar must be between ${min} and ${max}, current value is ${bar}.")}

		)
		@SkipValidation
		public String load() throws Exception {
			
			 
			
		systemEntity=systemLogic.loadSystemInfoByKey(systemId);

			return SUCCESS;
			 
		}
	
	@SkipValidation
	public String listAllSystem()throws Exception {
		
		systemList=systemLogic.loadAllSystemInfo();

		return SUCCESS;
		 
	}

}
