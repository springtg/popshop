package com.poprlz.dao;

import com.google.inject.Provider;
import com.poprlz.util.HibernateUtil;

public class SessionProvider<Session> implements Provider<Session> {

	@SuppressWarnings("unchecked")
	public Session get() {
		// TODO Auto-generated method stub
		return (Session) HibernateUtil.currentSession();
	}

}
