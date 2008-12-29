package com.poprlz.product.logic;

import java.util.List;

import com.google.inject.ImplementedBy;
import com.poprlz.product.entity.Manufacturer;

@ImplementedBy(ManufacturerServiceLogic.class)
public interface IManufacturerServiceLogic {

	List<Manufacturer> getEffectiveManufacturerList()  throws ServiceException;

}
