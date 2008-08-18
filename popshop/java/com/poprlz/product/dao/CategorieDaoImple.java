package com.poprlz.product.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;

import com.poprlz.dao.HibernateGenericDao;

public class CategorieDaoImple<Categorie> extends
		HibernateGenericDao<Categorie> implements ICategorieDao<Categorie> {

	@Override
	public List<Categorie> queryEntity() {
		Query query = this.sessionProvider.get().createQuery(
				" from Categorie as categorie ");

		return query.list();
	}

	public Categorie loadEntity(Serializable categorieId) {
		Query query = this.sessionProvider
				.get()
				.createQuery(
						"from Categorie as categorie where categorie.categorieId =:categorieId");
		query.setParameter("categorieId", categorieId);
		List categorieList = query.list();
		if (categorieList == null || categorieList.size() < 1)
			return null;
		Categorie cat = (Categorie) categorieList.get(0);
		return cat;
	}

}
