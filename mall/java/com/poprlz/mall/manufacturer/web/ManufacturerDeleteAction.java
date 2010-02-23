package com.poprlz.mall.manufacturer.web;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.poprlz.mall.entity.Manufacturer;
import com.poprlz.mall.manufacturer.logic.IManufacturerLogicService;

public class ManufacturerDeleteAction extends ActionSupport {
	
	 

	private Integer id;
	
	public void setId(Integer id) {
		this.id = id;
	}



	@Resource(name = "manufacturerLogicService")
	private IManufacturerLogicService manufacturerLogicService;

	
	
	/**
	 * Action函数,默认action函数
	 */
	@Override
	public String execute() throws Exception {
		Manufacturer manufacturer = this.manufacturerLogicService.loadEntityById(id);
		manufacturerLogicService.removeEntity(manufacturer);
		 
		return SUCCESS;
	}

}
