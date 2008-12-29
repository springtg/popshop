package com.poprlz.product.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;

import com.poprlz.dao.HibernateGenericDao;
import com.poprlz.product.entity.Categorie;

public class CategorieDaoImple extends
		HibernateGenericDao implements ICategorieDao {

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

	public List<Categorie> queryEffectiveCategorie() {
		//stutas 设置为0 为有效 
		Query query = this.sessionProvider.get().createQuery(
		" from Categorie as categorie where categorie.stutas=0 ");

		return query.list();
	}

}
