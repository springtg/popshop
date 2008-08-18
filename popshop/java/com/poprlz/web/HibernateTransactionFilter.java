package com.poprlz.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

import com.poprlz.util.HibernateUtil;

public class HibernateTransactionFilter implements Filter {
	private static Logger log=Logger.getLogger(HibernateTransactionFilter.class);
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse rsp,
			FilterChain chain) throws IOException, ServletException {
		try {
			log.info("Transaction is Begining!");
			HibernateUtil.beginTransaction();
			chain.doFilter(req, rsp);
			HibernateUtil.commitTransaction();
			log.info("Transaction is commited!");
		} catch (Exception e) {
			HibernateUtil.rollbackTransaction();
			log.info("Transaction is rollbacked!");

		}

	}

	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

}
