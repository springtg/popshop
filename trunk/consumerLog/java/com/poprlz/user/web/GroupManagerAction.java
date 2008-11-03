package com.poprlz.user.web;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.google.inject.Inject;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
 
import com.poprlz.user.entity.Group;
import com.poprlz.user.logic.IGroupLogicService;
import com.poprlz.util.PaginationSupport;

public class GroupManagerAction extends ActionSupport {
	@Inject
	private IGroupLogicService groupLogicService;

	// 部门的唯一主键
	private int groupId;

	// 部门名称
	private String groupName;

	// 部门简介
	private String mark;

	// 上一级部门;
	private int parentId;
 

	// 部门级别,值越小,级别就越高
	private int level;

	private Group group;

	PaginationSupport<Group> paginationSupport = null;
	private int page = 0;
	
	@SkipValidation 
	@Validations(requiredStrings = {@RequiredStringValidator(message = "Please input groupName!", key = "groupName.error.required", fieldName = "groupName", type = ValidatorType.SIMPLE, trim = true) }, intRangeFields = { @IntRangeFieldValidator(type = ValidatorType.SIMPLE, fieldName = "groupId", min = "0", max = "1000", message = "Value must be between ${min} and ${max}.", key = "groupId.error.required") })
	public String modifyGroup() throws Exception {

		group = new Group();
		group.setGroupId(groupId);
		group.setGroupName(groupName);
		group.setLevel(level);
		group.setMark(mark);
		Group parent = new Group();
		parent.setGroupId(parentId);
		group.setParent(parent);

		group = groupLogicService.saveGroup(group);

		return SUCCESS;
	}
 
	@SkipValidation
	@Validations(requiredStrings = {@RequiredStringValidator(message = "Please input groupName!", key = "groupName.error.required", fieldName = "groupName", type = ValidatorType.SIMPLE, trim = true) }, intRangeFields = { @IntRangeFieldValidator(type = ValidatorType.SIMPLE, fieldName = "groupId", min = "0", max = "1000", message = "Value must be between ${min} and ${max}.", key = "groupId.error.required") })
	public String createGroup() throws Exception {
	
		group = new Group();
		 
		group.setGroupName(groupName);
		group.setLevel(level);
		group.setMark(mark);
		Group parent = new Group();
		parent.setGroupId(parentId);
		group.setParent(parent);
		group.setStutas(Group.STUTAS_Y);
		group = groupLogicService.createGroup(group);
		return SUCCESS;
	}
 
	@SkipValidation 
	@Validations(intRangeFields = { @IntRangeFieldValidator(type = ValidatorType.SIMPLE, fieldName = "groupId", min = "0", max = "1000", message = "Value must be between ${min} and ${max}.", key = "groupId.error.required") })
	public String removeGroup() throws Exception {
		groupLogicService.logicRemoveGroup(groupId);
		return SUCCESS;
	}

	@SkipValidation 
	@Validations(intRangeFields = { @IntRangeFieldValidator(type = ValidatorType.SIMPLE, fieldName = "groupId", min = "0", max = "1000", message = "Value must be between ${min} and ${max}.", key = "groupId.error.required") })
	public String loadUserInfo() throws Exception {
		group = groupLogicService.loadGroup(groupId);
		return SUCCESS;
	}

	@SkipValidation 
	@Validations(requiredStrings = { @RequiredStringValidator(message = "Please input userName!", key = "userName.error.required", fieldName = "userName", type = ValidatorType.SIMPLE, trim = true) })
	public String checkGroupName() throws Exception {
		boolean result =false;
		 result = groupLogicService.isHasGroupName(groupName);

		if (result)
			return SUCCESS;
		else
			return ERROR;
	}

	public String queryGroup() throws Exception {
		paginationSupport = groupLogicService.queryGroup(page);

		return SUCCESS;

	}
 
	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public PaginationSupport<Group> getPaginationSupport() {
		return paginationSupport;
	}

	public void setPaginationSupport(PaginationSupport<Group> paginationSupport) {
		this.paginationSupport = paginationSupport;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getGroupId() {
		return groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public String getMark() {
		return mark;
	}

	public int getLevel() {
		return level;
	}

	 
}
