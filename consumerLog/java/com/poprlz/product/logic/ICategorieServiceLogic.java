package com.poprlz.product.logic;

import java.util.List;

import com.google.inject.ImplementedBy;
import com.poprlz.product.entity.Categorie;

@ImplementedBy(CategorieServiceLogic.class)
public interface ICategorieServiceLogic {

	List<Categorie> getProductEffectiveCatList() throws ServiceException;

}
