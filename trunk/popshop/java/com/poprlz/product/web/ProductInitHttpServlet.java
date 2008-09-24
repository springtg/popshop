package com.poprlz.product.web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.hibernate.Session;

import com.poprlz.product.util.HSQLInitUtil;
import com.poprlz.util.HibernateUtil;

public class ProductInitHttpServlet extends HttpServlet {
	
	private HSQLInitUtil hsqlInitUtil=new HSQLInitUtil(); 

	@Override
	public void destroy() {
		 
		
		hsqlInitUtil.shutDownHsqlDB();
		super.destroy();
		
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		 
		
		hsqlInitUtil.initDBSQL();
		Session session=HibernateUtil.currentSession();
		
		session.createSQLQuery(" SELECT NOW() ");
		HibernateUtil.closeSession();
		//DataSources.destroy(pooledDataSource);
		
		super.init(config);
	}
	
	

}
