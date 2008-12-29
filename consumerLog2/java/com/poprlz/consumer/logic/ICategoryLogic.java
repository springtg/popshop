package com.poprlz.consumer.logic;

 
import com.poprlz.consumer.entity.CategoryEntity;

 

public interface ICategoryLogic {
 
	public boolean checkCategoryNameExited(String name);

 
	public CategoryEntity createCategory(CategoryEntity category);

	public CategoryEntity loadCategoryEntityByKey(Integer categoryId) ;

	public CategoryEntity modifyCategory(CategoryEntity category);
 
	public boolean removeCategoryEntityByKey(Integer categoryId) ;
 
}
