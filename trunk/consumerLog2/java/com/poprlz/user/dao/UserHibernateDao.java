package com.poprlz.user.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.poprlz.dao.HibernateGenericDao;
import com.poprlz.user.entity.UserEntity;



@Repository("userDao")
public class UserHibernateDao extends HibernateGenericDao<UserEntity,Integer> implements IUserDao {

	@Override
	public UserEntity loadUserEntityByEmail(String email) {
		Query query=sessionFactory.getCurrentSession().createQuery(" from UserEntity user where user.email=?");
		query.setString(0, email);
		
		List result=query.list();
		
		if(result==null || result.size()<=0)
			return null;
		
		
		return (UserEntity)result.get(0);
	}

}
