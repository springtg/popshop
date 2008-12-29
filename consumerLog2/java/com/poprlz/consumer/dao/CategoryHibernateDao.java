package com.poprlz.consumer.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.poprlz.consumer.entity.CategoryEntity;
import com.poprlz.dao.HibernateGenericDao;
import com.poprlz.user.entity.SystemEntity;


@Repository("categoryDao")
public class CategoryHibernateDao extends HibernateGenericDao<CategoryEntity,Integer>    implements ICategoryDao {

	@Override
	public CategoryEntity loadCategoryEntityByCategoryName(String name) {
		Query query=sessionFactory.getCurrentSession().createQuery(" from CategoryEntity cat where cat.name=?");
		query.setString(0, name);
		
		List result=query.list();
		
		if(result==null || result.size()<=0)
			return null;
		
		return (CategoryEntity)result.get(0);
	}

	 

}
