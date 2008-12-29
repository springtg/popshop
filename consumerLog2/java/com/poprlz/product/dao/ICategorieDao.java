package com.poprlz.product.dao;

import java.util.List;

import com.google.inject.ImplementedBy;
import com.poprlz.dao.IGenericDao;
import com.poprlz.product.entity.Categorie;
@ImplementedBy(CategorieDaoImple.class)
public interface ICategorieDao extends IGenericDao {

	public List<Categorie> queryEffectiveCategorie();

}
