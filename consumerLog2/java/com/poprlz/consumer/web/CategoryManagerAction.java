package com.poprlz.consumer.web;

 

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import com.poprlz.common.CommonConstant;
import com.poprlz.consumer.entity.CategoryEntity;
import com.poprlz.consumer.logic.ICategoryLogic;

public class CategoryManagerAction extends ActionSupport {
	 
	private Integer categoryId;
	
	 
	private String name;
 
	private String information;

	 
	private String status; 
 
	private Integer parentId;
	
	private CategoryEntity categoryEntity;
	
	private ICategoryLogic categoryLogic;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public CategoryEntity getCategoryEntity() {
		return categoryEntity;
	}

	public void setCategoryEntity(CategoryEntity categoryEntity) {
		this.categoryEntity = categoryEntity;
	}

	public ICategoryLogic getCategoryLogic() {
		return categoryLogic;
	}

	@Autowired
	public void setCategoryLogic(ICategoryLogic categoryLogic) {
		this.categoryLogic = categoryLogic;
	}
	
	
	public String createCategorySetup() throws Exception {
		
		
		return SUCCESS;
		 
	}
	
	
	@Validations(requiredStrings = {
			@RequiredStringValidator(fieldName="name",message = "Pelease Input Category name.", key = "categoryManager.name.nullError", shortCircuit = true, trim = true),
			@RequiredStringValidator(fieldName="information",message = "Pelease Input information.", key = "categoryManager.information.nullError", shortCircuit = true, trim = true)
		}
	)
	public String createCategory() throws Exception {
		
		boolean isCategoryExited=categoryLogic.checkCategoryNameExited(name);
		
		if(isCategoryExited){
			this.addActionError(this.getText("categoryManager.name.exited", "THIS Category Name HAS EXITED!"));
			return INPUT;
		}
		
		CategoryEntity category=new CategoryEntity();
		
		category.setName(name);
		category.setInformation(information);
		CategoryEntity parent=new CategoryEntity();
		parent.setCategoryId(parentId);
		category.setParent(parent);
		category.setStatus(CommonConstant.STATUS_ACTIVE);
		
		categoryEntity=categoryLogic.createCategory(category);
		
		return SUCCESS;
		 
	}
	
	@Validations(requiredStrings = {
			@RequiredStringValidator(fieldName="name",message = "Pelease Input Category name.", key = "categoryManager.name.nullError", shortCircuit = true, trim = true),
			@RequiredStringValidator(fieldName="information",message = "Pelease Input information.", key = "categoryManager.information.nullError", shortCircuit = true, trim = true)
		},
		intRangeFields =
        { @IntRangeFieldValidator(type = ValidatorType.SIMPLE, fieldName = "categoryId", min = "1",key = "categoryManager.categoryId.nullError",   message = "categoryId must be between ${min} and ${max}, current value is ${categoryId}.")}
	
	)
	public String modifyCategory() throws Exception {
		CategoryEntity category=new CategoryEntity();
		
		category.setCategoryId(categoryId);
		category.setName(name);
		category.setInformation(information);
		category.setStatus(status);
		categoryEntity=categoryLogic.modifyCategory(category);
		return SUCCESS;
		 
	}
	
	
	@Validations(
		intRangeFields =
        { @IntRangeFieldValidator(type = ValidatorType.SIMPLE, fieldName = "categoryId", min = "1",key = "categoryManager.categoryId.nullError",   message = "categoryId must be between ${min} and ${max}, current value is ${categoryId}.")}
	
	)
	public String removeCategory() throws Exception {
		
		boolean result=categoryLogic.removeCategoryEntityByKey(categoryId);
		return SUCCESS;
		 
	}
	
	@Validations(
			intRangeFields =
	        { @IntRangeFieldValidator(type = ValidatorType.SIMPLE, fieldName = "categoryId", min = "1",key = "categoryManager.categoryId.nullError",   message = "categoryId must be between ${min} and ${max}, current value is ${categoryId}.")}
		
	)
	public String loadCategory() throws Exception {
		
		categoryEntity=categoryLogic.loadCategoryEntityByKey(categoryId);
		return SUCCESS;
		 
	}

}
