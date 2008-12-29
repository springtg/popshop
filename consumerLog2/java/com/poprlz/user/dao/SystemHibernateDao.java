package com.poprlz.user.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.poprlz.dao.HibernateGenericDao;
import com.poprlz.user.entity.SystemEntity;


@Repository("systemDao")
public class SystemHibernateDao extends HibernateGenericDao<SystemEntity,Integer>    implements ISystemDao {

	@Override
	public SystemEntity loadSystemEntityBySystemCode(String systemCode) {
		Query query=sessionFactory.getCurrentSession().createQuery(" from SystemEntity system where system.systemCode=?");
		query.setString(0, systemCode);
		
		List result=query.list();
		
		if(result==null || result.size()<=0)
			return null;
		
		return (SystemEntity)result.get(0);
	}

	@Override
	public List<SystemEntity> loadAllSystemInfo() {
		 
		return queryEntity(" from SystemEntity system ");
	}

	 

}
