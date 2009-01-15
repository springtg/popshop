package org.light.portal.core.action;

import javax.servlet.ServletContext;

import org.light.portal.core.StartupAction;
import org.light.portal.core.service.ServiceContext;
import org.light.portal.logger.Logger;
import org.light.portal.logger.LoggerFactory;
import org.light.portal.util.LocaleUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

public class GlobalStartupAction implements StartupAction{
	private Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	public void execute(ServletContext servletContext) throws Exception{
		logger.info("startup event is beginning.");
		//set Application level references data
		servletContext.setAttribute("languages",LocaleUtil.getSupportedLanguages());
		
		//set spring application context for getting beans conveniently
		ApplicationContext ctx = (ApplicationContext) servletContext		
									.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);		
		ServiceContext.getInstance().setContext(ctx);
		logger.info("startup event is ending.");
	}
}
