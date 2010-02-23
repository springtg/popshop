package com.poprlz.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

 
 

import com.poprlz.web.Page;

public interface IGenericDAO<T, ID extends Serializable> {

	public T loadEntityById(final ID id);

	public T saveEntity(final T entity);

	public T updateEntity(final T entity);

	public void removeEntity(final T entity);

	public List<T> findAllEntitys();

	public Page<?> findPage(String hqlCmd, int firstResultIndex,
			int maxResults, Object... parameters);
	
	public List<?> excuteQuery(String hqlCmd, Object... parameters);

	public <X> X findUniqueData(final String hqlCmd, final Object... parameters);

	public <X> List<X> find(final String hqlCmd, final Object... values);

	public long countHqlResult(final String hqlCmd, final Object... parameters);

 
	
	 
 

	

}
