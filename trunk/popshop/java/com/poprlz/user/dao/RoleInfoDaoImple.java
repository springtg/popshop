package com.poprlz.user.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;

import com.poprlz.dao.HibernateGenericDao;

public class RoleInfoDaoImple<RoleInfo> extends HibernateGenericDao<RoleInfo>
		implements IRoleInfoDao<RoleInfo> {

	@Override
	public List<RoleInfo> queryEntity() {
		Query query = this.sessionProvider.get().createQuery(
				" from RoleInfo as role ");

		return query.list();
	}

	public RoleInfo loadEntity(Serializable key) {
		Query query = this.sessionProvider.get().createQuery(
				"from RoleInfo as role where role.roleId =:roleId");
		query.setParameter("roleId", key);
		List roleList = query.list();
		if (roleList == null || roleList.size() < 1)
			return null;
		RoleInfo role = (RoleInfo) roleList.get(0);
		return role;
	}

}
