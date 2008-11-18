package com.poprlz.product.web;

import java.util.List;

import com.google.inject.Inject;
import com.opensymphony.xwork2.ActionSupport;
import com.poprlz.product.entity.Categorie;
import com.poprlz.product.entity.Manufacturer;
import com.poprlz.product.logic.ICategorieServiceLogic;
import com.poprlz.product.logic.IManufacturerServiceLogic;

public class ManufacturerListAction extends ActionSupport {
	@Inject
	private IManufacturerServiceLogic manufacturerServiceLogic;
	private List<Manufacturer> manufacturerList;

 
	
	public List<Manufacturer> getManufacturerList() {
		return manufacturerList;
	}



	public String execute() throws Exception {

		manufacturerList=manufacturerServiceLogic.getEffectiveManufacturerList();
		return SUCCESS;
	}

	
	
}
