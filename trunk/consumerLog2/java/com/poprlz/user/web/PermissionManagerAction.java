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
import com.poprlz.user.entity.PermissionEntity;
import com.poprlz.user.entity.SystemEntity;
import com.poprlz.user.logic.IPermissionLogic;
import com.poprlz.user.logic.ISystemLogic;

public class PermissionManagerAction extends ActionSupport {

	private IPermissionLogic permissionLogic;

	private ISystemLogic systemLogic;

	private Integer permissionId;

	private String permissionCode;

	private String description;

	private String status;

	private Integer systemId;

	private PermissionEntity permissionEntity;

	private List<PermissionEntity> permissionList;
	
	
	private List<SystemEntity> systemList;
	
	public List<SystemEntity> getSystemList() {
		return systemList;
	}

	public void setSystemList(List<SystemEntity> systemList) {
		this.systemList = systemList;
	}

	public String createSetup() throws Exception {

		systemList=systemLogic.loadAllSystemInfo();

		return SUCCESS;

	}

	@Validations(
			requiredStrings = {
			@RequiredStringValidator(fieldName = "permissionCode", message = "Pelease Input PermissionCode.", key = "permissionManager.permissionCode.nullError", shortCircuit = true, trim = true),
			@RequiredStringValidator(fieldName = "description", message = "Pelease Input description.", key = "permissionManager.description.nullError", shortCircuit = true, trim = true) },
			intRangeFields = { @IntRangeFieldValidator(type = ValidatorType.SIMPLE, fieldName = "systemId", min = "1", key = "permissionManager.systemId.nullError", message = "bar must be between ${min} and ${max}, current value is ${bar}.") 
				}
			)
	public String create() throws Exception {

		boolean isPermissionCodeExited = permissionLogic
				.checkPermissionCodeExited(permissionCode);

		if (isPermissionCodeExited) {
			this.addActionError(this.getText(
					"permissionManager.permissionCode.exited",
					"THIS Permission CODE HAS EXITED!"));
			return INPUT;
		}

		SystemEntity system = systemLogic.loadSystemInfoByKey(systemId);

		if (system == null) {
			this.addActionError(this.getText(
					"permissionManager.system.notExited",
					"THIS System CODE is NOT EXITED!"));
			return INPUT;
		}

		PermissionEntity permission = new PermissionEntity();

		permission.setPermissionCode(permissionCode);
		permission.setDescription(description);
		permission.setStatus(CommonConstant.STATUS_ACTIVE);

		permission.setSystemEntiry(system);

		permissionEntity = permissionLogic.createPermission(permission);

		return SUCCESS;

	}

 
	@Validations(intRangeFields = { @IntRangeFieldValidator(type = ValidatorType.SIMPLE, fieldName = "permissionId", min = "1", key = "permissionManager.permissionId.nullError", message = "bar must be between ${min} and ${max}, current value is ${bar}.") }

	)
	@SkipValidation
	public String modifySetup() throws Exception {

		permissionEntity = permissionLogic
				.loadPermissionInfoByKey(permissionId);
		
		systemList=systemLogic.loadAllSystemInfo();


		return SUCCESS;

	}
	
	
	@Validations(
			requiredStrings = {
			@RequiredStringValidator(fieldName = "PermissionCode", message = "Pelease Input PermissionCode.", key = "permissionManager.permissionCode.nullError", shortCircuit = true, trim = true),
			@RequiredStringValidator(fieldName = "description", message = "Pelease Input description.", key = "permissionManager.description.nullError", shortCircuit = true, trim = true) }, 
			intRangeFields = {
			@IntRangeFieldValidator(type = ValidatorType.SIMPLE, fieldName = "PermissionId", min = "1", key = "permissionManager.permissionId.nullError", message = "bar must be between ${min} and ${max}, current value is ${bar}."),
			@IntRangeFieldValidator(type = ValidatorType.SIMPLE, fieldName = "systemId", min = "1", key = "permissionManager.systemId.nullError", message = "bar must be between ${min} and ${max}, current value is ${bar}.") 
			}

	)
	public String modify() throws Exception {

		SystemEntity system = systemLogic.loadSystemInfoByKey(systemId);

		if (system == null) {
			this.addActionError(this.getText(
					"permissionManager.system.notExited",
					"THIS System CODE is NOT EXITED!"));
			return INPUT;
		}

		PermissionEntity Permission = new PermissionEntity();
		Permission.setPermissionId(permissionId);
		Permission.setPermissionCode(permissionCode);
		Permission.setDescription(description);
		Permission.setStatus(status);

		permissionEntity = permissionLogic.modifyPermission(Permission);

		return SUCCESS;

	}

	public IPermissionLogic getPermissionLogic() {
		return permissionLogic;
	}


	@Autowired
	public void setPermissionLogic(IPermissionLogic permissionLogic) {
		this.permissionLogic = permissionLogic;
	}



	public ISystemLogic getSystemLogic() {
		return systemLogic;
	}


	@Autowired
	public void setSystemLogic(ISystemLogic systemLogic) {
		this.systemLogic = systemLogic;
	}



	public Integer getPermissionId() {
		return permissionId;
	}



	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}



	public String getPermissionCode() {
		return permissionCode;
	}



	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
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



	public Integer getSystemId() {
		return systemId;
	}



	public void setSystemId(Integer systemId) {
		this.systemId = systemId;
	}



	public PermissionEntity getPermissionEntity() {
		return permissionEntity;
	}



	public void setPermissionEntity(PermissionEntity permissionEntity) {
		this.permissionEntity = permissionEntity;
	}



	public List<PermissionEntity> getPermissionList() {
		return permissionList;
	}



	public void setPermissionList(List<PermissionEntity> permissionList) {
		this.permissionList = permissionList;
	}



	@Validations(intRangeFields = { @IntRangeFieldValidator(type = ValidatorType.SIMPLE, fieldName = "permissionId", min = "1", key = "permissionManager.permissionId.nullError", message = "bar must be between ${min} and ${max}, current value is ${bar}.") }

	)
	@SkipValidation
	public String remove() throws Exception {

		PermissionEntity permission = new PermissionEntity();
		permission.setPermissionId(permissionId);

		permissionLogic.removePermission(permission);

		return SUCCESS;

	}

	
	
 

	@Validations(intRangeFields = { @IntRangeFieldValidator(type = ValidatorType.SIMPLE, fieldName = "permissionId", min = "1", key = "permissionManager.permissionId.nullError", message = "bar must be between ${min} and ${max}, current value is ${bar}.") }

	)
	@SkipValidation
	public String load() throws Exception {

		permissionEntity = permissionLogic
				.loadPermissionInfoByKey(permissionId);

		return SUCCESS;

	}
	@Validations(intRangeFields = { @IntRangeFieldValidator(type = ValidatorType.SIMPLE, fieldName = "systemId", min = "1", key = "permissionManager.systemId.nullError", message = "bar must be between ${min} and ${max}, current value is ${bar}.") }

	)
	@SkipValidation
	public String listAllPermissionBySystem() throws Exception {

		permissionList = permissionLogic.loadAllPermissionInfoBySystemId(systemId);

		return SUCCESS;

	}

}
