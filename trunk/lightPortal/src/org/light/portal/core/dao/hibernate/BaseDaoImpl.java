package org.light.portal.core.dao.hibernate;

import org.light.portal.core.dao.BaseDao;
import org.light.portal.model.Entity;
import org.light.portal.search.Indexer;
import org.light.portal.user.dao.UserDao;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDaoImpl extends HibernateDaoSupport implements BaseDao {
    private UserDao userDao;
    private Indexer indexer;
    
    public BaseDaoImpl(){
		this.setSessionFactory(HibernateUtil.getInstance().getSessionFactory());
    }
    public Entity create(Entity entity){    	
    	return entity;
	}
    
    public void save(Entity entity){
		this.getHibernateTemplate().saveOrUpdate(entity);
		indexer.updateIndex(entity);
	}
	
	public void delete(Entity entity){
		this.getHibernateTemplate().delete(entity);
		indexer.deleteIndex(entity);
	}

	public UserDao getUserDao() {
		return userDao;
	}
	

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public Indexer getIndexer() {
		return indexer;
	}

	public void setIndexer(Indexer indexer) {
		this.indexer = indexer;
	}
	
}
