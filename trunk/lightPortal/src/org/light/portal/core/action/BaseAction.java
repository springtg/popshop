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
package org.light.portal.core.action;

import static org.light.portal.util.Constants._APPLICATION_CONFIG;
import static org.light.portal.util.Constants._CURRENT_LOCALE;
import static org.light.portal.util.Constants._DEFAULT_LOCALE;
import static org.light.portal.util.Constants._LIGHT_PORTAL;
import static org.light.portal.util.Constants._LIGHT_PORTAL_USER_ID;
import static org.light.portal.util.Constants._REMEMBER_LOCALE;
import static org.light.portal.util.Constants._ROLE_ADMIN;
import static org.light.portal.util.Constants._USER;
import static org.light.portal.util.Constants._VISITED_GROUP;
import static org.light.portal.util.Constants._VISITED_STORE;
import static org.light.portal.util.Constants._VISITED_USER;
import static org.light.portal.util.Constants._VISITED_PAGE;
import static org.light.portal.util.Constants._VISITED_PORTAL;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.jstl.core.Config;

import org.light.portal.core.service.PortalService;
import org.light.portal.model.Portal;
import org.light.portal.model.PortalTab;
import org.light.portal.model.PortalUserRole;
import org.light.portal.model.PortletObject;
import org.light.portal.model.User;
import org.light.portal.security.config.Application;
import org.light.portal.user.service.UserService;
import org.light.portlets.ad.service.AdService;
import org.light.portlets.blog.service.BlogService;
import org.light.portlets.chat.service.ChatService;
import org.light.portlets.forum.service.ForumService;
import org.light.portlets.group.Group;
import org.light.portlets.group.service.GroupService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 4, 2006
 **/
public class BaseAction {
	
	protected Locale getLocale(HttpServletRequest request){
		Locale currentLocale = (Locale) Config.get(request.getSession(),Config.FMT_LOCALE);
		if(currentLocale == null){
			String locale = _DEFAULT_LOCALE;
			Application appConfig = (Application)request.getSession().getServletContext().getAttribute(_APPLICATION_CONFIG);
			if(appConfig.getDefaultLocale() != null) locale = appConfig.getDefaultLocale();			
			Cookie[] theCookies =request.getCookies();
			if (theCookies != null) {
		        for (int i =0; i< theCookies.length; i++) {
		           Cookie aCookie = theCookies[i];
		           if(aCookie.getName().equals(_REMEMBER_LOCALE)){
					   if(aCookie.getValue() != null) locale =  aCookie.getValue();
					   break;
		           }
		        }
		    }
			User user = this.getUser(request);			
			if(user != null && user.getLanguage() != null) locale = user.getLanguage();
			currentLocale = new Locale(locale);
			Config.set(request.getSession(), Config.FMT_LOCALE, currentLocale);	
			this.setLocale(request,currentLocale.toString());
		}
		return currentLocale;
	}
	protected boolean setLocale(HttpServletRequest request,String locale){
	 boolean ret = false;			 		 
	 if(locale != null){
		 String[] localeParams = locale.split("_");
		 Locale newLocale = null;
		 if(localeParams.length > 1)
			 newLocale = new Locale(localeParams[0],localeParams[1]);
		 else
			 newLocale = new Locale(localeParams[0]);
		 if(newLocale != null){
			Config.set(request.getSession(), Config.FMT_LOCALE, newLocale);
			request.getSession().setAttribute(_CURRENT_LOCALE,newLocale.toString());
			ret = true;
		 }
	 }
	 return ret;
   }

	protected boolean isAdmin(HttpServletRequest request){
		User user = getUser(request);
		if(user == null) return false;
		List<PortalUserRole> userRoles = this.getPortalService(request).getUserRole(user.getId(),_ROLE_ADMIN);
		if(userRoles != null && userRoles.size() > 0) return true;
		return false;
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
	protected PortalTab getVisitedPage(HttpServletRequest request){				
		return (PortalTab)request.getSession().getAttribute(_VISITED_PAGE);
	}
	protected void removeVisitedUser(HttpServletRequest request){				
		request.getSession().removeAttribute(_VISITED_USER);
	}
	protected void setVisitedPage(HttpServletRequest request,PortalTab page){		
		request.getSession().setAttribute(_VISITED_PAGE,page);
	}
	protected void setVisitedUser(HttpServletRequest request,User user){		
		request.getSession().setAttribute(_VISITED_USER,user);
	}	
	protected void setVisitedGroup(HttpServletRequest request,Group group){		
		request.getSession().setAttribute(_VISITED_GROUP,group);
	}	
	protected Group getVisitedGroup(HttpServletRequest request){				
		return (Group)request.getSession().getAttribute(_VISITED_GROUP);
	}	
	protected void removeVisitedGroup(HttpServletRequest request){				
		request.getSession().removeAttribute(_VISITED_GROUP);
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
			setPortal(request,portal);
		}
		return portal;
	}	
	protected void setPortal(HttpServletRequest request,Portal portal){
		request.getSession().setAttribute(_LIGHT_PORTAL,portal);
	}
	
	protected PortalTab getPortalTab(HttpServletRequest request){
		String tabId = (String)request.getParameter("tabId");
		PortalTab portalTab = null;
		if(tabId != null){
			int tId = Integer.parseInt(tabId);
			portalTab =  getPortalService(request).getPortalTabById(tId);
		}
		return portalTab;
	}
	
	protected PortletObject getPortlet(HttpServletRequest request){	
		String portletId = request.getParameter("portletId");
		if(portletId == null) portletId = (String)request.getAttribute("portletId");
		PortletObject portlet= null;
		if(portletId != null){
			portlet=getPortalService(request).getPortletById(Integer.parseInt(portletId));
		}
		return portlet;
	}
	
//	protected String getMessageByLocale(HttpServletRequest request,String key){
//		Locale currentLocale = (Locale) Config.get(request.getSession(),Config.FMT_LOCALE);
//		ResourceBundle myResources = ResourceBundle.getBundle(_DEFAULT_RESOURCE_BUNDLE, currentLocale);
//		String value = key;
//		try{
//			value = myResources.getString(key);
//		}catch(MissingResourceException e){}
//		
//		return value;			
//	}
	
	protected PortalService getPortalService(HttpServletRequest request) {			
		return (PortalService)getService(request, "portalService");
	}
	
	protected UserService getUserService(HttpServletRequest request) {			
		return (UserService)getService(request, "userService");
	}
	
	protected ChatService getChatService(HttpServletRequest request) {			
		return (ChatService)getService(request, "chatService");
	}
	
	protected ForumService getForumService(HttpServletRequest request) {			
		return (ForumService)getService(request, "forumService");
	}
	
	protected BlogService getBlogService(HttpServletRequest request) {			
		return (BlogService)getService(request, "blogService");
	}	
		
	protected GroupService getGroupService(HttpServletRequest request) {			
		return (GroupService)getService(request, "groupService");
	}
	
	protected AdService getAdService(HttpServletRequest request) {			
		return (AdService)getService(request, "adService");
	}
		
	private Object getService(HttpServletRequest request, String serviceName) {
		ApplicationContext ctx = (ApplicationContext) request.getSession().getServletContext()		
        							.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);		
		return ctx.getBean(serviceName);
	}	
}
