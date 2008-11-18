package com.poprlz.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import com.google.inject.Inject;

public abstract  class HibernateGenericDao implements IGenericDao{
	
	@Inject
	protected SessionProvider<Session> sessionProvider;
	
	
 

	public Object modifyEntity(Object entity) {
		sessionProvider.get().saveOrUpdate(entity);
		return entity;
	}

 

	 
	public boolean removeEntity(Object entity) {
		sessionProvider.get().delete(entity);
		return true;
	}

	 
	public Object saveAndLoadEntity(Object entity) {
		sessionProvider.get().saveOrUpdate(entity);
		return entity;
	}



 
	 

	 
 

}
