/*
 * Copyright (c) 2006 Jianmin Liu.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.light.portal.tags;

import static org.light.portal.util.Constants._USER;
import static org.light.portal.util.Constants._VISITED_USER;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.light.portal.core.service.PortalService;
import org.light.portal.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
/**
 * 
 * @author Jianmin Liu
 * @version 1.0.0
 * Creation date: Sep 24, 2006
 **/
public class AuthenticateOwnerTag extends TagSupport {

	   
	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.Tag#doStartTag()
	 */
	//private String user;
	
	public int doStartTag() throws JspException {
		User user = getUser((HttpServletRequest)pageContext.getRequest());
		User visitedProfile = (User)pageContext.getSession().getAttribute(_VISITED_USER);
		if(visitedProfile == null || (visitedProfile != null && user != null && user.getUserId().equals(visitedProfile.getUserId())))
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