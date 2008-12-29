package com.poprlz.consumer.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poprlz.common.CommonConstant;
import com.poprlz.consumer.dao.ICategoryDao;
import com.poprlz.consumer.entity.CategoryEntity;


@Service("categoryLogic")
@Transactional(readOnly = true)
public class CategoryLogic implements ICategoryLogic {
	
	private ICategoryDao categoryDao;

	public ICategoryDao getCategoryDao() {
		return categoryDao;
	}

	@Autowired
	public void setCategoryDao(ICategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public boolean checkCategoryNameExited(String name) {
		CategoryEntity category=categoryDao.loadCategoryEntityByCategoryName(name);
		
		if(category==null){
			return false;
		}
		return true;
	}

	@Override
	public CategoryEntity createCategory(CategoryEntity category) {
		CategoryEntity parent=category.getParent();
		
		Integer parentId=parent.getCategoryId();
		
		parent=categoryDao.loadByKey(parentId);
		
		if(parent!=null){
			category.setParent(parent);
		}
		
		
		 
		return categoryDao.saveEntity(category);
	}

	@Override
	public CategoryEntity loadCategoryEntityByKey(Integer categoryId) {
		 
		return categoryDao.loadByKey(categoryId);
	}

	@Override
	public CategoryEntity modifyCategory(CategoryEntity category) {
		CategoryEntity categoryEntity=categoryDao.loadByKey(category.getCategoryId());
		
		categoryEntity.setCategoryId(category.getCategoryId());
		categoryEntity.setInformation(category.getInformation());
		categoryEntity.setStatus(category.getStatus());
		
		return categoryDao.modifyEntity(categoryEntity);
	}

	@Override
	public boolean removeCategoryEntityByKey(Integer categoryId) {
		CategoryEntity categoryEntity=categoryDao.loadByKey(categoryId);
		
		if(categoryEntity==null){
			return false;
		}
		
		categoryEntity.setStatus(CommonConstant.STATUS_SUSPEND);
		
		categoryDao.modifyEntity(categoryEntity);
		return true;
	}

}
