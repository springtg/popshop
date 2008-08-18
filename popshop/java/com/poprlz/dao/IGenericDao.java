package com.poprlz.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao<T> {
	
	 
	
	public T loadEntity(Serializable key); 
	
	public T saveAndLoadEntity(T entity);
	
	public T modifyEntity(T entity);
	
	public boolean removeEntity(T entity);
	
	public List<T> queryEntity();
	
	

}
