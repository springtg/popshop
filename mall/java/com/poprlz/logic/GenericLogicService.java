package com.poprlz.logic;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.poprlz.dao.IGenericDAO;

public abstract class GenericLogicService<T, ID extends Serializable>
		implements ILogicService<T, ID> {

	protected abstract IGenericDAO<T, ID> getIGenericDAO();

	@Override
	@Transactional(readOnly=true)
	public List<T> findAllEntitys() {
		// TODO Auto-generated method stub
		return getIGenericDAO().findAllEntitys();
	}

	@Override
	@Transactional(readOnly=true)
	public T loadEntityById(ID id) {
		// TODO Auto-generated method stub
		return getIGenericDAO().loadEntityById(id);
	}

	@Override
	@Transactional
	public void removeEntity(T entity) {
		getIGenericDAO().removeEntity(entity);

	}

	@Override
	@Transactional
	public T saveEntity(T entity) {
		System.out.println("saveEntity is Working ");
		return getIGenericDAO().saveEntity(entity);
	}

}
