package com.poprlz.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;

import com.poprlz.web.Page;

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
	public long countHqlResult(final String hqlcmd, Object... parameters) {
		String fromHql = hqlcmd;
		// select子句与order by子句会影响count查询,进行简单的排除.
		fromHql = "FROM " + StringUtils.substringAfter(fromHql, "FROM");
		fromHql = StringUtils.substringBefore(fromHql, "ORDER BY");

		String countHqlcmd = "select count(*) " + fromHql;

		try {
			Long count = this.findUniqueData(countHqlcmd, parameters);
			return count;
		} catch (Exception e) {
			throw new RuntimeException("hqlcmd can't be auto count, hql is:"
					+ countHqlcmd, e);
		}
	}

	@Override
	public Page findPage(final String hqlCmd, int firstResultIndex,
			int maxResults, Object... parameters) {
		long totalCount = this.countHqlResult(hqlCmd, parameters);
		Page page = new Page(maxResults);
		
		int pageNo=Page.convertPageNo(firstResultIndex, maxResults);
		page.setTotalCount(totalCount);
		page.setPageNo(pageNo);

		Query query = createQuery(hqlCmd, parameters);
		query.setFirstResult(firstResultIndex);
		query.setMaxResults(page.getPageSize());
		List result = query.getResultList();
		page.setResult(result);

		return page;
	}

	@Override
	public <X> List<X> find(String hqlCmd, Object... parameters) {
		Query query = createQuery(hqlCmd, parameters);

		return (List<X>) query.getResultList();
	}

	@Override
	public List<T> findAllEntitys() {
		String sqlCmd = "SELECT o FROM " + this.getPersistentClass() + " o ";

		return (List<T>) this.find(sqlCmd);
	}

 

	@Override
	public <X> X findUniqueData(String hqlCmd, Object... parameters) {
		Query query = createQuery(hqlCmd, parameters);

		return (X) query.getSingleResult();
	}

	@Override
	public T loadEntityById(ID id) {
		return getEntityManager().find(getPersistentClass(), id);
	}

	@Override
	public void removeEntity(T entity) {
		entity = getEntityManager().merge(entity);
		getEntityManager().remove(entity);

	}

	@Override
	public T saveEntity(T entity) {
		getEntityManager().persist(entity);

		return entity;
	}

	@Override
	public T updateEntity(T entity) {
		getEntityManager().merge(entity);

		return entity;
	}

	@Override
	public List<?> excuteQuery(String hqlCmd, Object... parameters) {
		Query query = createQuery(hqlCmd, parameters);

		return (List<?>) query.getResultList();

	}

	public Query createQuery(String hqlCmd, Object... parameters) {
		Query query = this.getEntityManager().createQuery(hqlCmd);
		int index=1;
		
		for(Object parameter:parameters){
			query.setParameter(index, parameter);
			index++;
		}
		return query;
	}

}
