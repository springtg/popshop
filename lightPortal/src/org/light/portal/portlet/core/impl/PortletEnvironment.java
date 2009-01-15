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
package org.light.portal.portlet.core.impl;

import java.util.List;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.light.portal.core.service.PortalService;
import org.light.portal.model.Portal;
import org.light.portal.model.PortalTab;
import org.light.portal.model.PortletObject;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import static org.light.portal.util.Constants._LIGHT_PORTAL;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 14, 2006
 **/
public class PortletEnvironment {
		
	private PortletWindow portletWindow;
	
	public PortletEnvironment(HttpServletRequest request,
                             HttpServletResponse response){
		String name = (String)request.getAttribute("portletName");
		String state= request.getParameter("state");
	    String mode = request.getParameter("mode");
		if(request.getAttribute("mode") != null)
			mode = (String)request.getAttribute("mode");
	    if(state == null || "".equals(state))
			 state = "normal";
		 if(mode == null || "".equals(mode))
			 mode = "view";
		 
		WindowState windowState = new WindowState(state);
		PortletMode portletMode = new PortletMode(mode);
		PortletObject portletObject = this.getPortlet(request);
	    this.portletWindow = new PortletWindow(name, windowState, portletMode, portletObject);
			    
		request.setAttribute("state",state);
		request.setAttribute("mode",mode);
		request.setAttribute("portletObject",portletObject);				        		
	}
	
	protected Portal getPortal(HttpServletRequest request){
		Portal portal = (Portal)request.getSession().getAttribute(_LIGHT_PORTAL);
		return portal;
	}
	
    protected PortalTab getPortalTab(HttpServletRequest request){
		String tabId = (String)request.getParameter("tabId");
		PortalTab portalTab = null;
		if(tabId != null){
			int tId = Integer.parseInt(tabId);
			portalTab =  getPortalService(request.getSession().getServletContext()).getPortalTabById(tId);
		}
		return portalTab;
	}
    
    protected List<PortletObject> getPortletsByTab(HttpServletRequest request,int id){
    	return getPortalService(request.getSession().getServletContext()).getPortletsByTab(id);
    }
    
	protected PortletObject getPortlet(HttpServletRequest request){
		String portletId = (String)request.getAttribute("portletId");
		PortletObject portlet= null;
		if(portletId != null){
			try{
				int id = Integer.parseInt(portletId);
				portlet=getPortalService(request.getSession().getServletContext()).getPortletById(id);
			}catch(Exception e){}
			
		}
		return portlet;
	}
	
	protected PortalService getPortalService(ServletContext context) {			
		return (PortalService)getService(context, "portalService");
	}
	
	private Object getService(ServletContext context, String serviceName) {
		ApplicationContext ctx = (ApplicationContext) context		
        							.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);		
		return ctx.getBean(serviceName);
	}

	public PortletWindow getPortletWindow() {
		return portletWindow;
	}
	
}
