package org.light.portal;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CacheFilter implements Filter {

	public void init(FilterConfig arg0) throws ServletException {
		
	}

	public void doFilter(ServletRequest srequest, ServletResponse sresponse,
			FilterChain chain) throws IOException, ServletException {
		if(sresponse instanceof HttpServletResponse){
			Calendar current = Calendar.getInstance();
			current.add(Calendar.YEAR,10);			
			HttpServletResponse response = (HttpServletResponse)sresponse;
			response.setDateHeader("Expires",current.getTime().getTime());
			//response.setHeader("Content-Encoding", "gzip");
		}
		chain.doFilter(srequest,sresponse);
	}

	public void destroy() {
		

	}

}
