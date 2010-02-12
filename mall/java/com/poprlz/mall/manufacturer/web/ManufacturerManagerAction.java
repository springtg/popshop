package com.poprlz.mall.manufacturer.web;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import com.poprlz.mall.entity.Manufacturer;
import com.poprlz.mall.manufacturer.logic.IManufacturerLogicService;
import com.poprlz.web.CURDManagerAction;
import com.poprlz.web.Page;

public class ManufacturerManagerAction extends
		CURDManagerAction<Manufacturer, Integer> {

	private Manufacturer manufacturer;

	private Integer id;

	private Page<Manufacturer> manufacturerList;

	@Resource(name="manufacturerLogicService")
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

	public Page<Manufacturer> getManufacturerList() {
		return manufacturerList;
	}

	public void setManufacturerLogicService(
			IManufacturerLogicService manufacturerLogicService) {
		this.manufacturerLogicService = manufacturerLogicService;
	}

	@Override
	public String delete() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void prepareModel() throws Exception {
		if (manufacturer == null) {
			Calendar cal = Calendar.getInstance();
			manufacturer = new Manufacturer();
			manufacturer.setDateAdded(cal.getTime());
			manufacturer.setDateLastClick(cal.getTime());
			manufacturer.setLastModified(cal.getTime());
		}
	}

	@Override
	@Validations(requiredStrings = { @RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "manufacturer.manufacturersName", message = "The Name Can not by empty!") })
	public String save() throws Exception {
	
		manufacturerList=new Page<Manufacturer>(10);
		manufacturerLogicService.saveEntity(manufacturer);
		List<Manufacturer> result=new ArrayList<Manufacturer>();
		result.add(this.manufacturer);
		manufacturerList.setResult(result);
		 
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

}
