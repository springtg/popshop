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

import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._CURRENT_LOCALE;
import static org.light.portal.util.Constants._LIGHT_PORTAL;
import static org.light.portal.util.Constants._LIGHT_PORTAL_USER_ID;
import static org.light.portal.util.Constants._PORTLET_JSP_PATH;
import static org.light.portal.util.Constants._PORTLET_MODE_CONFIG;
import static org.light.portal.util.Constants._ROLE_ADMIN;
import static org.light.portal.util.Constants._USER;
import static org.light.portal.util.Constants._VISITED_GROUP;
import static org.light.portal.util.Constants._VISITED_PORTAL;
import static org.light.portal.util.Constants._VISITED_USER;

import java.io.File;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;

import org.light.portal.core.PortalContextFactory;
import org.light.portal.core.service.PortalService;
import org.light.portal.model.Portal;
import org.light.portal.model.PortalTab;
import org.light.portal.model.PortalUserRole;
import org.light.portal.model.PortletObject;
import org.light.portal.model.User;
import org.light.portal.portlet.contentlibrary.service.ContentLibraryService;
import org.light.portal.user.service.UserService;
import org.light.portlets.ad.service.AdService;
import org.light.portlets.blog.service.BlogService;
import org.light.portlets.calendar.service.CalendarService;
import org.light.portlets.chat.service.ChatService;
import org.light.portlets.forum.service.ForumService;
import org.light.portlets.group.Group;
import org.light.portlets.group.service.GroupService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
/**
 * 
 * @author Jianmin Liu
 * @version 1.0.0
 * Creation date: April 14, 2006
 **/
public abstract class LightGenericPortlet extends GenericPortlet {
	
	public void processAction (ActionRequest request, ActionResponse response) 
    throws PortletException, java.io.IOException {
		
	}
	
	protected void doDispatch (RenderRequest request,
			  RenderResponse response) throws PortletException,java.io.IOException
	{ 
	  WindowState state = request.getWindowState();
	  PortletMode mode = request.getPortletMode();
	  if(!request.isWindowStateAllowed(state))
		  throw new PortletException("unknown portlet window state: " + state);
	  	  
	  if ( ! state.equals(WindowState.MINIMIZED)) {
		if(!request.isPortletModeAllowed(mode))
			  throw new PortletException("This portlet doesn't support mode: " + mode);
		
	    if (mode.equals(PortletMode.VIEW)) {
			doView (request, response);
	    }
	    else if (mode.equals(PortletMode.EDIT)) {
			doEdit (request, response);
	    }
	    else if (mode.equals(PortletMode.HELP)) {
			doHelp (request, response);
	    }
	    else if (mode.equals(new PortletMode(_PORTLET_MODE_CONFIG))) {
			doConfig (request, response);
		}		
	    else {
			throw new PortletException("unknown portlet mode: " + mode);
	    }
	  }	
	}
	protected void doEdit (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
		StringBuffer resultBuffer = new StringBuffer();
		resultBuffer.append("<span class='portlet-rss'>")
		            .append("TODO: doEdit")
		            .append("</span>")
		            .append("<img src='"+request.getContextPath()+"/light/images/spacer.gif' height='200' style='border: 0px' width='1' alt='' />")
					;
		response.getWriter().print(resultBuffer.toString());
	 }		
	
	protected void doHelp (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
		StringBuffer resultBuffer = new StringBuffer();
		resultBuffer.append("<span class='portlet-rss'>")
		            .append("TODO: doHelp")
		            .append("</span>")
		            .append("<img src='"+request.getContextPath()+"/light/images/spacer.gif' height='200' style='border: 0px' width='1' alt='' />")
					;
		response.getWriter().print(resultBuffer.toString());
	 }		
	
	protected void doConfig (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {		
		String responseId = (String)request.getParameter("responseId");
		String action = request.getParameter("action");
		if("configPortlet".equals(action)){				
			String title = request.getParameter("title");
			if(title != null) title = URLDecoder.decode(title,_CHARSET_UTF);				
			String barBgColor = request.getParameter("barBgColor");
			String barFontColor = request.getParameter("barFontColor");
			String contentBgColor = request.getParameter("contentBgColor");	
			String textColor = request.getParameter("textColor");	
			String transparent = request.getParameter("transparent");	
			PortletObject portlet =getPortlet(request);		
			if(portlet != null){
				portlet.setLabel(title);
				portlet.setBarBgColor(barBgColor);
				portlet.setBarFontColor(barFontColor);
				portlet.setContentBgColor(contentBgColor);
				portlet.setTextColor(textColor);
				portlet.setTransparent(Integer.parseInt(transparent));
				this.getPortalService(request).save(portlet);
			}
		}
		PortletObject portlet =getPortlet(request);		
		if(portlet != null){	
			request.setAttribute("portlet", portlet);
			this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/core/configMode.jsp").include(request,response);
		}else{
			StringBuffer resultBuffer = new StringBuffer();		
			resultBuffer.append("error: this portlet is not exist.");
			response.getWriter().print(resultBuffer.toString());
		}		
	 }		
	
	protected HttpServletRequest getServletRequest(PortletRequest request){
		HttpServletRequest httpServletRequest = (HttpServletRequest)request.getAttribute("httpServletRequest");		
		return httpServletRequest;
	}
	protected HttpServletResponse getServletResponse(PortletRequest request){
		HttpServletResponse httpServletResponse = (HttpServletResponse)request.getAttribute("httpServletResponse");		
		return httpServletResponse;
	}
	protected HttpSession getServletSession(PortletRequest request){			
		HttpSession session = getServletRequest(request).getSession();
		return session;
	}
	
	protected String getActionName(PortletRequest request){
		String action = request.getParameter("submit");
		if(request.getParameter("action") != null) action = request.getParameter("action");
		if(action != null) action = PortalContextFactory.getPortalContext().getActionName(action);
		return action;
	}
	protected void setUser(PortletRequest request, User user){				
		request.getPortletSession().setAttribute(_USER,user,PortletSession.APPLICATION_SCOPE);
		Map<String,String> userData = new HashMap<String,String>();
		userData.put(_LIGHT_PORTAL_USER_ID,user.getUserId());
		request.getPortletSession().setAttribute(PortletRequest.USER_INFO,userData,PortletSession.APPLICATION_SCOPE);
	}	
	protected User getUser(PortletRequest request){				
		return (User)request.getPortletSession().getAttribute(_USER,PortletSession.APPLICATION_SCOPE);
	}
	protected User getVisitedUser(PortletRequest request){				
		return (User)request.getPortletSession().getAttribute(_VISITED_USER,PortletSession.APPLICATION_SCOPE);
	}
	protected Portal getVisitedPortal(PortletRequest request){				
		return (Portal)request.getPortletSession().getAttribute(_VISITED_PORTAL,PortletSession.APPLICATION_SCOPE);
	}
	protected Group getVisitedGroup(PortletRequest request){				
		return (Group)request.getPortletSession().getAttribute(_VISITED_GROUP,PortletSession.APPLICATION_SCOPE);
	}	
	protected boolean isAdmin(PortletRequest request,User user){
		if(user == null) return false;
		List<PortalUserRole> userRoles = this.getPortalService(request).getUserRole(user.getId(),_ROLE_ADMIN);
		if(userRoles != null && userRoles.size() > 0) return true;
		return false;
	}
	protected Portal getPortal(PortletRequest request){
		Portal portal = (Portal)this.getServletRequest(request).getSession().getAttribute(_LIGHT_PORTAL);
		if(portal == null && this.getUser(request) != null){
			portal = this.getPortalService(request).getPortalByUser(this.getUser(request).getUserId());
			portal.setCount(portal.getCount() + 1);
			this.getPortalService(request).save(portal);
			setPortal(request,portal);
		}
		return portal;
	}	
	protected void setPortal(PortletRequest request,Portal portal){
		this.getServletRequest(request).getSession().setAttribute(_LIGHT_PORTAL,portal);
	}
	protected void setLocale(PortletRequest request,String language){
		String[] localeParams = language.split("_");
		Locale currentLocale = null;
		if(localeParams.length > 1)
			 currentLocale = new Locale(localeParams[0],localeParams[1]);
		else
			 currentLocale = new Locale(localeParams[0]);
		Config.set(this.getServletRequest(request).getSession(), Config.FMT_LOCALE, currentLocale);	
		this.getServletRequest(request).getSession().setAttribute(_CURRENT_LOCALE,currentLocale.toString());
	}
	
	protected PortalTab getPortalTab(PortletRequest request){
		String tabId = (String)request.getParameter("tabId");
		PortalTab portalTab = null;
		if(tabId != null){
			int tId = Integer.parseInt(tabId);
			portalTab =  getPortalService(request).getPortalTabById(tId);
		}
		return portalTab;
	}
	
	protected PortletObject getPortlet(PortletRequest request){		
		String portletId = (String)request.getAttribute("portletId");
		PortletObject portlet= null;
		if(portletId != null){
			portlet=getPortalService(request).getPortletById(Integer.parseInt(portletId));
		}
		return portlet;
	}
	
	protected java.lang.String getTitle(RenderRequest request) {
	    return getPortletConfig().getResourceBundle(request.getLocale()).getString("javax.portlet.title");
	}
		
	protected PortalService getPortalService(PortletRequest request) {			
		return (PortalService)getService(this.getServletRequest(request), "portalService");
	}	
	protected UserService getUserService(PortletRequest request) {			
		return (UserService)getService(this.getServletRequest(request), "userService");
	}	
	protected ChatService getChatService(PortletRequest request) {			
		return (ChatService)getService(this.getServletRequest(request), "chatService");
	}	
	protected GroupService getGroupService(PortletRequest request) {			
		return (GroupService)getService(this.getServletRequest(request), "groupService");
	}	
	protected ForumService getForumService(PortletRequest request) {			
		return (ForumService)getService(this.getServletRequest(request), "forumService");
	}
	
	protected BlogService getBlogService(PortletRequest request) {			
		return (BlogService)getService(this.getServletRequest(request), "blogService");
	}	
	protected AdService getAdService(PortletRequest request) {			
		return (AdService)getService(this.getServletRequest(request), "adService");
	}
	protected CalendarService getCalendarService(PortletRequest request) {			
		return (CalendarService)getService(this.getServletRequest(request), "calendarService");
	}
	protected ContentLibraryService getContentLibraryService(PortletRequest request) {			
		return (ContentLibraryService)getService(this.getServletRequest(request), "contentLibraryService");
	}
	protected boolean deleteFile(PortletRequest request, String fileName){
		String dir = request.getPortletSession().getPortletContext().getRealPath("/");
	    return (new File(dir+"/WEB-INF"+fileName)).delete();
	}
	protected Object getService(HttpServletRequest request, String serviceName) {
		ApplicationContext ctx = (ApplicationContext) request.getSession().getServletContext()		
        							.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);		
		return ctx.getBean(serviceName);
	}
}
