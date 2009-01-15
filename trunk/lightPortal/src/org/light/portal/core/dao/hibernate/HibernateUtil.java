package org.light.portal.core.dao.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	
	public static HibernateUtil getInstance(){
		return instance;
	}
	
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	private HibernateUtil(){
		Configuration config = new Configuration();
		this.sessionFactory=config.configure().buildSessionFactory();
	}
	private static HibernateUtil instance = new HibernateUtil();
	private SessionFactory sessionFactory;
}
