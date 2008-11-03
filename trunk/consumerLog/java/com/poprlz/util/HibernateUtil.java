package com.poprlz.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
 

public class HibernateUtil {
	private static final SessionFactory sessionFactory;

	public static final ThreadLocal<Session> threadSession = new ThreadLocal<Session>();

	public static final ThreadLocal<Transaction> threadTransaction = new ThreadLocal<Transaction>();

	static {
		try {
			
			// Create the SessionFactory
			//sessionFactory = new Configuration().configure()
			//		.buildSessionFactory();
			 sessionFactory = new AnnotationConfiguration().configure()
			 		.buildSessionFactory();
			
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session currentSession() throws HibernateException {
		Session s = threadSession.get();
		// Open a new Session, if this Thread has none yet
		if (s == null) {
			s = sessionFactory.openSession();
			threadSession.set(s);
		}
		return s;
	}

	public static void closeSession() throws HibernateException {
		Session s = threadSession.get();
		threadSession.set(null);
		if (s != null)
			s.close();
	}

	public static Transaction beginTransaction() {
		Transaction tx = threadTransaction.get();
		if (tx == null) {
			tx = currentSession().beginTransaction();
			threadTransaction.set(tx);
		}
		
		return tx;
	}

	public static void commitTransaction()  throws HibernateException {
		Transaction tx = threadTransaction.get();
		try {
			if (tx != null && !tx.wasCommitted() && !tx.wasRolledBack())
				tx.commit();
			threadTransaction.set(null);
		} catch (HibernateException ex) {
			rollbackTransaction();
			throw ex;
		}
	}

	public static void rollbackTransaction() {
		Transaction tx = threadTransaction.get();
		threadTransaction.set(null);
		try {
			if (tx != null && !tx.wasCommitted() && !tx.wasRolledBack()) {
				tx.rollback();
			}
		} finally {
			closeSession();
		}

	}
}
