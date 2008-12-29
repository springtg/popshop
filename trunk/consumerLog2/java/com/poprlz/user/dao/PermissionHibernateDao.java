package com.poprlz.user.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.poprlz.dao.HibernateGenericDao;
import com.poprlz.user.entity.PermissionEntity;

@Repository("permissionDao")
public class PermissionHibernateDao extends
		HibernateGenericDao<PermissionEntity, Integer> implements
		IPermissionDao {

	@Override
	public List<PermissionEntity> loadAllPermissionInfoBySystemId(
			Integer systemId) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				" from  PermissionEntity permission  where permission.systemId=?");
		query.setInteger(0, systemId);

		List result = query.list();

		 

		return (List<PermissionEntity>)(result);
	}

	@Override
	public PermissionEntity loadPermissionEntityByEermissionCode(
			String permissionCode) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						" from PermissionEntity permission  where permission.permissionCode=?");
		query.setString(0, permissionCode);

		List result = query.list();

		if (result == null || result.size() <= 0)
			return null;

		return (PermissionEntity) result.get(0);
	}

}
