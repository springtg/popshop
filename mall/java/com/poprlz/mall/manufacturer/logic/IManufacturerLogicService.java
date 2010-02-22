package com.poprlz.mall.manufacturer.logic;

import com.poprlz.logic.ILogicService;
import com.poprlz.mall.entity.Manufacturer;
import com.poprlz.web.Page;

public interface IManufacturerLogicService extends ILogicService<Manufacturer, Integer> {

	Page<Manufacturer> listManufacturerPage(int pageIndex,int pageSize);

}
