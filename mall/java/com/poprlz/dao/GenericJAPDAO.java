package com.poprlz.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class GenericJAPDAO<T, ID extends Serializable> implements
		IGenericDAO<T, ID> {

	@PersistenceContext
	protected EntityManager entityManager;

	private Class<T> persistentClass;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	protected EntityManager getEntityManager() {
		return this.entityManager;
	}

	public GenericJAPDAO() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public List<T> findAllEntitys() {
		String sqlCmd = "SELECT o FROM " + this.getPersistentClass() + " o ";

		return (List<T>) this.excuteQuery(sqlCmd);
	}

	@Override
	public T loadEntityById(ID id) {
		// TODO Auto-generated method stub
		return getEntityManager().find(getPersistentClass(), id);
	}

	@Override
	public void removeEntity(T entity) {
		getEntityManager().remove(entity);

	}

	@Override
	public T saveEntity(T entity) {
		// TODO Auto-generated method stub

		getEntityManager().persist(entity);

		System.out.println("Dao Save the Entity!");
		return entity;
	}

	public T updateEntity(T entity) {
		// TODO Auto-generated method stub

		getEntityManager().merge(entity);

		System.out.println("Dao Save the Entity!");
		return entity;
	}

	public List<? extends Object> excuteQuery(String sqlCmd,
			int firstResultIndex, int maxResults, Object... parameters) {
		Query query = this.getEntityManager().createQuery(sqlCmd);
		query.setFirstResult(firstResultIndex);
		query.setMaxResults(maxResults);
		int index = 1;
		for (Object parameter : parameters) {
			query.setParameter(index, parameter);
			index++;
		}

		return query.getResultList();
	}

	public List<? extends Object> excuteQuery(String sqlCmd,
			Object... parameters) {
		Query query = this.getEntityManager().createQuery(sqlCmd);

		int index = 1;
		for (Object parameter : parameters) {
			query.setParameter(index, parameter);
			index++;
		}
		return query.getResultList();
	}

	public Object excuteQueryData(String sqlCmd, Object... parameters) {
		Query query = this.getEntityManager().createQuery(sqlCmd);

		int index = 1;
		for (Object parameter : parameters) {
			query.setParameter(index, parameter);
			index++;
		}
		
		Object result =query.getSingleResult();
		
		return result;
		 
	}
	
	public Integer excuteQueryIntegerData(String sqlCmd, Object... parameters) {
		 
		
		Integer result =(Integer)excuteQueryData(sqlCmd,parameters);
		
		return result;
		 
	}

}
