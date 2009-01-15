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

import static org.light.portal.util.Constants._LIGHT_PORTAL;
import static org.light.portal.util.Constants._LIGHT_PORTAL_USER_ID;
import static org.light.portal.util.Constants._USER;
import static org.light.portal.util.Constants._VISITED_GROUP;
import static org.light.portal.util.Constants._VISITED_PAGE;
import static org.light.portal.util.Constants._VISITED_PORTAL;
import static org.light.portal.util.Constants._VISITED_USER;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.light.portal.core.service.PortalService;
import org.light.portal.model.Portal;
import org.light.portal.model.PortalTab;
import org.light.portal.model.User;
import org.light.portal.user.service.UserService;
import org.light.portlets.group.Group;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 4, 2006
 **/
public class BaseTag extends TagSupport {
	   
	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.Tag#doStartTag()
	 */
	public int doStartTag() throws JspException {	
		try{
			JspWriter writer = pageContext.getOut();
            writer.flush(); 
		}catch(Exception e){
		}
		return EVAL_PAGE;
	}
	
	protected PortalService getPortalService(HttpServletRequest request) {			
		return (PortalService)getService(request, "portalService");
	}
	protected UserService getUserService(HttpServletRequest request) {			
		return (UserService)getService(request, "userService");
	}
	protected Object getService(HttpServletRequest request, String serviceName) {
		ApplicationContext ctx = (ApplicationContext) request.getSession().getServletContext()		
        							.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);		
		return ctx.getBean(serviceName);
	}	
	protected void setUser(HttpServletRequest request,User user){
		Map<String,String> userData = new HashMap<String,String>();
		userData.put(_LIGHT_PORTAL_USER_ID,user.getUserId());
		request.getSession().setAttribute(PortletRequest.USER_INFO,userData);
		request.getSession().setAttribute(_USER,user);
	}
	protected Portal getPortal(HttpServletRequest request){
		Portal portal = (Portal)request.getSession().getAttribute(_LIGHT_PORTAL);
		if(portal == null && this.getUser(request) != null){
			portal = this.getPortalService(request).getPortalByUser(this.getUser(request).getUserId());
			portal.setCount(portal.getCount() + 1);
			this.getPortalService(request).save(portal);
			setPortal(request,portal);
		}
		return portal;
	}	
	protected void setPortal(HttpServletRequest request,Portal portal){
		request.getSession().setAttribute(_LIGHT_PORTAL,portal);
	}
	protected User getUser(HttpServletRequest request){
		return (User)request.getSession().getAttribute(_USER);
	}
	protected User getVisitedUser(HttpServletRequest request){				
		return (User)request.getSession().getAttribute(_VISITED_USER);
	}
	protected Portal getVisitedPortal(HttpServletRequest request){				
		return (Portal)request.getSession().getAttribute(_VISITED_PORTAL);
	}
	protected Group getVisitedGroup(HttpServletRequest request){				
		return (Group)request.getSession().getAttribute(_VISITED_GROUP);
	}
	protected PortalTab getVisitedPage(HttpServletRequest request){		
		return (PortalTab) request.getSession().getAttribute(_VISITED_PAGE);
	}
	protected void setVisitedUser(HttpServletRequest request,User user){		
		request.getSession().setAttribute(_VISITED_USER,user);
	}
	protected void setVisitedPortal(HttpServletRequest request,Portal portal){		
		request.getSession().setAttribute(_VISITED_PORTAL,portal);
	}
	protected void setVisitedPage(HttpServletRequest request,PortalTab tab){		
		request.getSession().setAttribute(_VISITED_PAGE,tab);
	}
	protected void setVisitedGroup(HttpServletRequest request,Group group){		
		request.getSession().setAttribute(_VISITED_GROUP,group);
	}
}



