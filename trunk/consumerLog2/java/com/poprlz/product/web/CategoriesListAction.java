package com.poprlz.product.web;

import java.util.List;

import com.google.inject.Inject;
import com.opensymphony.xwork2.ActionSupport;
import com.poprlz.product.entity.Categorie;
import com.poprlz.product.logic.ICategorieServiceLogic;

public class CategoriesListAction extends ActionSupport {
	@Inject
	private ICategorieServiceLogic categorieServiceLogic;
	private List<Categorie> catList;

	public List<Categorie> getCatList() {
		return catList;
	}
	
	public String execute() throws Exception {

		catList=categorieServiceLogic.getProductEffectiveCatList();
		return SUCCESS;
	}

	
	
}
