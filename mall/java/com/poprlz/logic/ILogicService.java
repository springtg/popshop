package com.poprlz.logic;

import java.io.Serializable;
import java.util.List;

//public interface IGenericDAO 〈T, ID extends Serializable〉
public interface ILogicService<T,ID extends Serializable> {
	
	public T loadEntityById(ID id);
	
	public T saveEntity(T entity);
	
	public T updateEntity(T entity);
	
	public void removeEntity(T entity);
	
	public List<T> findAllEntitys();
	
	

}
