package com.poprlz.product.logic;

import java.util.List;

import com.google.inject.Inject;
import com.poprlz.product.dao.ICategorieDao;
import com.poprlz.product.entity.Categorie;



public class CategorieServiceLogic implements ICategorieServiceLogic {

	@Inject
	private ICategorieDao categorieDao;
	public List<Categorie> getProductEffectiveCatList() throws ServiceException {
		List<Categorie> catList=categorieDao.queryEffectiveCategorie();
		
		if(catList==null || catList.size()<1)
			throw new ServiceException("These is no Categorie Infomation");
		return catList;
	}

}
