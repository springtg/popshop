package org.light.portal.tags;

import static org.light.portal.util.Constants._USER;
import static org.light.portal.util.Constants._VISITED_USER;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.light.portal.core.service.PortalService;
import org.light.portal.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

public class AuthenticateVisitorTag extends TagSupport {

	   
	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.Tag#doStartTag()
	 */
	//private String user;
	
	public int doStartTag() throws JspException {
		User user = getUser((HttpServletRequest)pageContext.getRequest());
		User visitedProfile = (User)pageContext.getSession().getAttribute(_VISITED_USER);
		if(user != null && visitedProfile != null && !user.getUserId().equals(visitedProfile.getUserId()))
	       return EVAL_BODY_INCLUDE;
		else
		   return SKIP_BODY;
	}
	
	private PortalService getPortalService(ServletContext context) {			
		return (PortalService)getService(context, "portalService");
	}
	
	private Object getService(ServletContext context, String serviceName) {
		ApplicationContext ctx = (ApplicationContext) context		
  							.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);		
		return ctx.getBean(serviceName);
	}
	
	protected User getUser(HttpServletRequest request){
		return (User)request.getSession().getAttribute(_USER);
	}

	
}
