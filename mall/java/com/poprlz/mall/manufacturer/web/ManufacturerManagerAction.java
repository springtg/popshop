package com.poprlz.mall.manufacturer.web;

import java.util.Calendar;

import javax.annotation.Resource;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import com.poprlz.mall.entity.Manufacturer;
import com.poprlz.mall.manufacturer.logic.IManufacturerLogicService;
import com.poprlz.web.CURDManagerAction;
import com.poprlz.web.Page;

public class ManufacturerManagerAction extends
		CURDManagerAction<Manufacturer, Integer> {

	private Manufacturer manufacturer;

	private Integer id;
	
	private int pageIndex;

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	private Page<Manufacturer> manufacturerPage;

	@Resource(name = "manufacturerLogicService")
	private IManufacturerLogicService manufacturerLogicService;

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setManufacturerLogicService(
			IManufacturerLogicService manufacturerLogicService) {
		this.manufacturerLogicService = manufacturerLogicService;
	}

	@Override
	public String delete() throws Exception {
		manufacturerLogicService.removeEntity(manufacturer);
		 
		return SUCCESS;
	}
	
 
	
	
	

 

	@Override
	protected void prepareModel() throws Exception {

		if (id != null && id > 0) {
			manufacturer = this.manufacturerLogicService.loadEntityById(id);
		}

		Calendar cal = Calendar.getInstance();
		if (manufacturer == null) {

			manufacturer = new Manufacturer();
			manufacturer.setDateAdded(cal.getTime());
			manufacturer.setDateLastClick(cal.getTime());

		}
		manufacturer.setLastModified(cal.getTime());
	}

	@Override
	@Validations(requiredStrings = { @RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "manufacturer.manufacturersName", message = "The Name Can not by empty!") })
	public String save() throws Exception {

		if (manufacturer.getManufacturersId() <=0) {
			manufacturerLogicService.saveEntity(manufacturer);
		} else {
			manufacturerLogicService.updateEntity(manufacturer);
		}
 		return SUCCESS;
	}

	@Override
	public Manufacturer getModel() {
		// TODO Auto-generated method stub
		return manufacturer;
	}

	@Override
	public void prepare() throws Exception {
		prepareModel();

	}

	@Override
	public String input() throws Exception {
		prepareModel();
		return SUCCESS;
	}

	public Page<Manufacturer> getManufacturerPage() {
		return manufacturerPage;
	}

}
