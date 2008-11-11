package com.poprlz.dao;

import java.util.List;

public interface IGenericDao {
	
	 
	
	public Object loadEntity(Object key); 
	
	public Object saveAndLoadEntity(Object entity);
	
	public Object modifyEntity(Object entity);
	
	public boolean removeEntity(Object entity);
	
	public List<?> queryEntity();
	
	

}
