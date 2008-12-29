package com.poprlz.consumer.dao;

import com.poprlz.consumer.entity.CategoryEntity;
import com.poprlz.dao.IGenericDao;
 

public interface ICategoryDao extends IGenericDao<CategoryEntity,Integer>{

	CategoryEntity loadCategoryEntityByCategoryName(String name);

}
