package com.poprlz.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class HibernateGenericDao<T, KEY extends Serializable> implements
		IGenericDao<T, KEY> {

	private Class<T> persistentClass;

	protected SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public HibernateGenericDao() {

		Class clazz = getClass();
		while (!(clazz.getGenericSuperclass() instanceof ParameterizedType)) {
			clazz = clazz.getSuperclass();
		}

		persistentClass = (Class<T>) ((ParameterizedType) clazz
				.getGenericSuperclass()).getActualTypeArguments()[0];

	}

	public HibernateGenericDao(Class<T> persistentClass) {

		this.persistentClass = persistentClass;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;

	}

 

	@Override
	public T loadByKey(KEY keyId) {

		return (T) sessionFactory.getCurrentSession().load(
				getPersistentClass(), keyId);
	}

	@Override
	public T modifyEntity(T entity) {

		sessionFactory.getCurrentSession().saveOrUpdate(entity);

		return entity;
	}

	@Override
	public List<T> queryEntity(String queryCmd) {
		Query query=sessionFactory.getCurrentSession().createQuery(queryCmd);
		return (List<T>)query.list();
	}

	@Override
	public boolean remove(T entity) {
		sessionFactory.getCurrentSession().delete(entity);
		return true;
	}

	@Override
	public T saveEntity(T entity) {

		sessionFactory.getCurrentSession().saveOrUpdate(entity);

		return entity;
	}

}
