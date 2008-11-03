package com.poprlz.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

import com.poprlz.dao.HsqlDBTool;
import com.poprlz.util.HibernateUtil;

public class HibernateSessionFilter implements Filter {

	private static Logger log=Logger.getLogger(HibernateSessionFilter.class);
	 
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse rsp,
			FilterChain chain) throws IOException, ServletException {
		try{
			log.info("Hibernate Session is created!");	 
		HibernateUtil.currentSession();
		HsqlDBTool.getConnection();
		chain.doFilter(req, rsp);
		}catch(Exception e){
			
		}finally{
			HibernateUtil.closeSession();
			HsqlDBTool.closeConnection();
			log.info("Hibernate Session is closed!");	 
		}
		 

	}

	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

}
