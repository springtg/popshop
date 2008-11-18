package com.poprlz.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao {
	
	 
	
	public Object loadEntity(Serializable key); 
	
	public Object saveAndLoadEntity(Object entity);
	
	public Object modifyEntity(Object entity);
	
	public boolean removeEntity(Object entity);
	
	public List<?> queryEntity();
	
	

}
