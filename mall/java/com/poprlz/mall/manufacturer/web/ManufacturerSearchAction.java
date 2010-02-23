package com.poprlz.mall.manufacturer.web;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.poprlz.mall.entity.Manufacturer;
import com.poprlz.mall.manufacturer.logic.IManufacturerLogicService;
import com.poprlz.web.Page;

public class ManufacturerSearchAction extends ActionSupport {
	
	private int pageIndex;

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageIndex() {
		return pageIndex;
	}



	public Page<Manufacturer> getManufacturerPage() {
		return manufacturerPage;
	}

	private Page<Manufacturer> manufacturerPage;

	@Resource(name = "manufacturerLogicService")
	private IManufacturerLogicService manufacturerLogicService;

	
	
	/**
	 * Action函数,默认action函数
	 */
	@Override
	public String execute() throws Exception {
		
		manufacturerPage=manufacturerLogicService.listManufacturerPage(pageIndex, 5);
		return SUCCESS;
	}

}
