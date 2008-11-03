package com.poprlz.user.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;

import com.poprlz.dao.HibernateGenericDao;

public class PermissionDaoImple<Permision> extends HibernateGenericDao<Permision>
		implements IPermissionDao<Permision> {

 
	public List<Permision> queryEntity() {
		Query query = this.sessionProvider.get().createQuery(
		" from Permision as permision ");

return query.list();
	}

	public Permision loadEntity(Serializable key) {
		Query query = this.sessionProvider.get().createQuery(
		"from Permision as permision where permission.permisionId =:permisionId");
query.setParameter("permisionId", key);
List permisionList = query.list();
if (permisionList == null || permisionList.size() < 1)
	return null;
Permision permission = (Permision) permisionList.get(0);
return permission;
	}

}
