package com.poprlz.product.dao;

import com.google.inject.ImplementedBy;
import com.poprlz.dao.IGenericDao;
@ImplementedBy(CategorieDaoImple.class)
public interface ICategorieDao<Categorie> extends IGenericDao<Categorie> {

}
