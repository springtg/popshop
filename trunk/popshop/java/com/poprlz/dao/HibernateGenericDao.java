package com.poprlz.dao;

import java.util.List;

import org.hibernate.Session;

import com.google.inject.Inject;

public abstract  class HibernateGenericDao<T> implements IGenericDao<T>{
	
	@Inject
	protected SessionProvider<Session> sessionProvider;
	
	
 

	public T modifyEntity(T entity) {
		sessionProvider.get().saveOrUpdate(entity);
		return entity;
	}

	public abstract List<T> queryEntity();

	 
	public boolean removeEntity(T entity) {
		sessionProvider.get().delete(entity);
		return true;
	}

	 
	public T saveAndLoadEntity(T entity) {
		sessionProvider.get().saveOrUpdate(entity);
		return entity;
	}

	 

	 
 

}
