package org.light.portal.core.action;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.light.portal.core.StartupAction;
import org.light.portal.core.service.ServiceContext;
import org.light.portal.logger.Logger;
import org.light.portal.logger.LoggerFactory;
import org.light.portal.util.LocaleUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

public class GlobalShutdownAction implements StartupAction{
	private Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	public void execute(ServletContext servletContext) throws Exception{
		logger.info("shutdown event is begining");
		
		logger.info("shutdown event is ending");
	}
}
