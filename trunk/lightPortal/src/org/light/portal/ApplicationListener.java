package org.light.portal;

import static org.light.portal.util.Constants._GLOBAL_SHUTDOWN_EVENTS;
import static org.light.portal.util.Constants._GLOBAL_STARTUP_EVENTS;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.light.portal.core.StartupAction;
import org.light.portal.logger.Logger;
import org.light.portal.logger.LoggerFactory;
import org.light.portal.portlet.factory.PortletContainerFactory;

public class ApplicationListener implements ServletContextListener{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	/* Application Startup Event */
	public void	contextInitialized(ServletContextEvent ce) {	
		try{
			String[] actions = _GLOBAL_STARTUP_EVENTS.split(",");
			for(String action : actions){
				Object actionObject = Class.forName(action).newInstance();;
				if(actionObject instanceof StartupAction){
					StartupAction startupAction = (StartupAction)actionObject;
					startupAction.execute(ce.getServletContext());
				}
			}
		}catch(Exception e){
			logger.error(e.getMessage());
		}
	}

	/* Application Shutdown	Event */
	public void	contextDestroyed(ServletContextEvent ce) {
		try{
			String[] actions = _GLOBAL_SHUTDOWN_EVENTS.split(",");
			for(String action : actions){
				Object actionObject = Class.forName(action).newInstance();;
				if(actionObject instanceof StartupAction){
					StartupAction startupAction = (StartupAction)actionObject;
					startupAction.execute(ce.getServletContext());
				}
			}
		}catch(Exception e){
			logger.error(e.getMessage());
		}
	}

}
