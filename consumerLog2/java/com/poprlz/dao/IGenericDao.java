package com.poprlz.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao<T,KEY extends Serializable>{

	
	 public T loadByKey(KEY keyId); 
	 
	 public boolean remove(T entity);
	 
	 public T saveEntity(T entity);
	 
	 public T modifyEntity(T entity);
	 
 
	 
	 public List<T> queryEntity(String queryCmd);
}
