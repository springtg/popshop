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
package org.light.portal;
import static org.light.portal.util.Constants._APPLICATION_CONFIG;
import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._CURRENT_LOCALE;
import static org.light.portal.util.Constants._DEFAULT_LANGUAGE;
import static org.light.portal.util.Constants._DEFAULT_LOCALE;
import static org.light.portal.util.Constants._DEFAULT_RESOURCE_BUNDLE;
import static org.light.portal.util.Constants._LIGHT_PORTAL;
import static org.light.portal.util.Constants._MAX_ROW_PER_PAGE;
import static org.light.portal.util.Constants._REMEMBER_LOCALE;
import static org.light.portal.util.Constants._ROLE_ADMIN;
import static org.light.portal.util.Constants._USER;
import static org.light.portal.util.Constants._VISITED_GROUP;
import static org.light.portal.util.Constants._VISITED_PAGE;
import static org.light.portal.util.Constants._VISITED_PORTAL;
import static org.light.portal.util.Constants._VISITED_USER;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.portlet.PortletException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

import org.light.portal.core.PortalCommand;
import org.light.portal.core.PortalCommandFactory;
import org.light.portal.core.PortalContextFactory;
import org.light.portal.core.RssFactory;
import org.light.portal.core.action.PortalConfigAction;
import org.light.portal.core.service.PortalService;
import org.light.portal.core.service.ServiceContext;
import org.light.portal.logger.Logger;
import org.light.portal.logger.LoggerFactory;
import org.light.portal.model.OrgProfile;
import org.light.portal.model.Portal;
import org.light.portal.model.PortalTab;
import org.light.portal.model.PortalUserRole;
import org.light.portal.model.PortletObject;
import org.light.portal.model.PortletObjectRef;
import org.light.portal.model.User;
import org.light.portal.portlet.contentlibrary.service.ContentLibraryService;
import org.light.portal.portlet.core.impl.PortletEnvironment;
import org.light.portal.portlet.core.impl.PortletWindow;
import org.light.portal.portlet.factory.PortletContainerFactory;
import org.light.portal.security.config.Application;
import org.light.portal.user.service.UserService;
import org.light.portal.util.LabelBean;
import org.light.portal.util.LocaleUtil;
import org.light.portal.util.MessageUtil;
import org.light.portal.util.OrganizationThreadLocal;
import org.light.portal.util.StringUtils;
import org.light.portlets.blog.Blog;
import org.light.portlets.blog.service.BlogService;
import org.light.portlets.chat.service.ChatService;
import org.light.portlets.forum.Forum;
import org.light.portlets.forum.ForumPost;
import org.light.portlets.forum.service.ForumService;
import org.light.portlets.group.Group;
import org.light.portlets.group.GroupForum;
import org.light.portlets.group.service.GroupService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

/**
 * 
 * @author Jianmin Liu
 * @version 1.0.0
 * Creation date: April 4, 2006
 **/
public class Servlet extends HttpServlet {
	
	public void init(ServletConfig config) throws ServletException {
	    super.init(config);	 
	    try{	    	
			PortletContainerFactory.getPortletContainer().init(config);						
		}catch(PortletException e){
			logger.error(e.getMessage());
		}		
	}
	/**
     * Do get.
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws ServletException, IOExeption
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	process(request,response);
    }
    /**
     * Do Post.
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws ServletException, IOExeption
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
    }
	
	/**
     * Do process.
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws ServletException, IOExeption
     */
    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	this.setLocale(request);
		String remoteAddress = request.getRemoteAddr();
		if(remoteAddress != null){
			request.getSession().setAttribute("remoteAddress",remoteAddress);
		}
		StringBuffer resultBuffer = new StringBuffer();
		String uri = request.getRequestURI();			
		int index = uri.lastIndexOf("/");		
		String path = uri.substring(index+1);

		if(uri.indexOf("/group/") >= 0 && (uri.indexOf(".lp") < 0 && uri.indexOf("/light/") < 0)){
			doViewGroup(request, response, path);
			return;
		}
		if(uri.indexOf("/space/") >= 0 && (uri.indexOf(".lp") < 0 && uri.indexOf("/light/") < 0)){
			doViewProfile(request, response, path);
			return;
		}
		if(uri.indexOf("/page/") >= 0 && (uri.indexOf(".lp") < 0 && uri.indexOf("/light/") < 0)){
			doPage(request, response, path);
			return;
		}			
		if(uri.indexOf("/rss/") >= 0){
			doRss(request, response, path);
			return;
		}
		if(uri.indexOf("/opml/") >= 0){
			doOpml(request, response, path);
			return;
		}
		if(uri.indexOf("/cl/") >= 0){
			doContentLibrary(request, response, path);
			return;
		}
		if(uri.indexOf("getDefaultViewTemplates.lp") >= 0){
			getDefaultView(request, response);
			return;
		}
		if(uri.indexOf("getPortalViewTemplates.lp") >= 0){
			this.getServletContext().getRequestDispatcher("/WEB-INF/view/portalViews.jsp").forward(request,response);
			return;
		}
		if(uri.indexOf("getPortletViewTemplates.lp") >= 0){
			this.getServletContext().getRequestDispatcher("/WEB-INF/view/portletViews.jsp").forward(request,response);
			return;
		}

		index = path.indexOf(".");
		if(index > 0) path = path.substring(0,index);
		request.setAttribute("portletName",path);    
				
		response.setContentType("text/xml;charset=UTF-8");
		request.setCharacterEncoding(_CHARSET_UTF);

        try{
        	PortalCommand pCommand = PortalCommandFactory.getInstance().getCommand(path);
        	if(pCommand != null){
        		pCommand.execute(request,response);
        	}else{
        		String portletId = (String)request.getParameter("portletId");
        		String responseId = (String)request.getParameter("responseId");
        		request.setAttribute("portletId",portletId);
        		request.setAttribute("responseId",responseId);
				PortalTab tab = getPortalTab(request);
				
        		PortletEnvironment env = new PortletEnvironment(request,response);
        		PortletWindow portletWindow = env.getPortletWindow();
				String isRenderUrl = (String)request.getParameter("isRenderUrl");
				if(isRenderUrl == null)
					PortletContainerFactory.getPortletContainer().processPortletAction(portletWindow, request, response);        		              		        		        		
				
        		resultBuffer.append("<ajax-response>")
							.append("<response type='element' id='"+responseId+"'>")	
							.append("<div>")
							;
        		response.getWriter().print(resultBuffer.toString());
        		PortletContainerFactory.getPortletContainer().renderPortlet(portletWindow, request, response);
				response.getWriter().print("</div></response>");
	
				if(portletWindow.getPortletObject() != null && portletWindow.getPortletObject().isSupportPageRefreshed()){					
					Iterator<PortletObject> portlets = this.getPortletsByTab(request,tab.getId()).iterator();
					while(portlets.hasNext()){
						PortletObject po = portlets.next();
						if(po.getId() != portletWindow.getPortletObject().getId()){								
							String id = "portletContent_"+po.getId();
							request.setAttribute("portletId",String.valueOf(po.getId()));
							request.setAttribute("portletName",po.getName()); 
							request.setAttribute("responseId",id);
							request.setAttribute("mode","view");
			        		StringBuffer resultBuffer2 = new StringBuffer();
							resultBuffer2.append("<response type='element' id='"+id+"'>")	
							 			 .append("<div>")
							 			 ;
							response.getWriter().print(resultBuffer2.toString());	
							PortletEnvironment env2 = new PortletEnvironment(request,response);
			        		PortletWindow pWindow = env2.getPortletWindow();
			        		PortletContainerFactory.getPortletContainer().renderPortlet(pWindow, request, response);
			        		response.getWriter().print("</div></response>");
						}
					}
				}				
				response.getWriter().print("</ajax-response>");
				response.setContentType("text/xml;charset=UTF-8");
		        response.setHeader("Pragma", "no-cache");
		        response.setHeader("Expires", "0");
		        response.setHeader("Cache-Control", "no-store");
        	}
        }catch(Exception e){			
			throw new ServletException(e);
		}finally{			
			response.getWriter().close();		
		}
    }
	
	private void doViewProfile(HttpServletRequest request, HttpServletResponse response, String uri) throws ServletException, IOException {		
		User user = this.getUserService().getUserByUri(uri,OrganizationThreadLocal.getOrganizationId());
		if(user != null){
			this.setVisitedUser(request ,user);
			Portal portal = getPortalService().getPortalByUser(user.getUserId());
			this.setVisitedPortal(request,portal);
			this.setLocale(request, user.getLanguage());
			this.getServletContext().getRequestDispatcher("/WEB-INF/visitor/index.jsp").forward(request,response);
		}else{
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
	}
	
	private void doPage(HttpServletRequest request, HttpServletResponse response, String uri) throws ServletException, IOException {
		PortalTab tab = this.getVisitedPage(request);
		int id = 0;
		try{
			id = Integer.parseInt(uri);
		}catch(Exception e){}		
		if(id > 0){
			tab = this.getPortalService().getPortalTabById(id);
			long orgId = OrganizationThreadLocal.getOrganizationId();
			if(request.getParameter("orgId") != null){
				try{
					orgId = Long.parseLong(request.getParameter("orgId"));
					request.getSession().setAttribute("orgId",orgId);
				}catch(Exception e){}
			}
			User user = this.getUserService().getUserByUserId(tab.getUserId(),orgId);
			if(tab != null  
					&& ((isAdmin(this.getUser(request))) 
						|| (tab.getStatus() == 3) 
				        || (tab.getStatus() == 2 && this.getChatService().getChatBuddy(user.getId(),this.getUser(request).getId()) != null)
				        || (tab.getStatus() < 2 && tab.getUserId().equals(this.getUser(request).getUserId())))){
				Portal portal = getPortalService().getPortalByUser(tab.getUserId());
				this.setVisitedPortal(request,portal);
				this.setVisitedPage(request,tab);
				String locale = Locale.ENGLISH.toString();
				if(this.getUser(request) != null) locale = this.getUser(request).getLanguage();
				this.setLocale(request, locale);
				this.getServletContext().getRequestDispatcher("/WEB-INF/page/index.jsp").forward(request,response);
			}else{
				response.sendRedirect(request.getContextPath()+"/index.jsp");
			}
		}else{
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
	}
	
	private void doViewGroup(HttpServletRequest request, HttpServletResponse response, String uri) throws ServletException, IOException {		
		Group group = this.getGroupService().getGroupByUri(uri,OrganizationThreadLocal.getOrganizationId());
		if(group != null){
			this.setVisitedGroup(request ,group);
			Portal portal = getPortalService().getPortalByGroup("group_"+group.getId());
			this.setPortal(request,portal);
			String locale = Locale.ENGLISH.toString();
			if(this.getUser(request) != null) locale = this.getUser(request).getLanguage();
			this.setLocale(request, locale);
			this.getServletContext().getRequestDispatcher("/WEB-INF/group/index.jsp").forward(request,response);
		}else{
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
	}
		
	private void doRss(HttpServletRequest request, HttpServletResponse response, String uri) throws ServletException, IOException {
		response.setContentType("text/xml;charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        response.setHeader("Cache-Control", "no-store");
       
        if(uri.startsWith("blog")){
			String id = uri.substring(4,uri.indexOf("."));
			if(!StringUtils.isEmpty(id)){
				long userId = Long.parseLong(id);
				User user = this.getUserService().getUserById(userId);
				if(user != null){
					List<Blog> blogs = this.getBlogService().getBlogsByUser(userId,OrganizationThreadLocal.getOrganizationId());
					String dir = request.getSession().getServletContext().getRealPath("/")+"/feed/blog/";
					(new File(dir)).mkdirs();
					String xml = dir+uri;
					String title = user.getName()+"'s blog";
					if(user.getId() == OrganizationThreadLocal.getOrg().getUserId()) title = OrganizationThreadLocal.getOrg().getWebId()+" blog";
					RssFactory.getInstance().getBlogRss(title,"",xml,blogs);
					this.getServletContext().getRequestDispatcher("/feed/blog/"+uri).forward(request,response);				
				}else{
					response.getWriter().print("this blog is not avaliable");
				}
			}else{
				response.getWriter().print("this blog is not avaliable");
			}
		}
        else if(uri.startsWith("forum")){
			String id = uri.substring(5,uri.indexOf("."));
			if(id.indexOf("p") > 0){
				String[] ids= id.split("p");
				int forumId = Integer.parseInt(ids[0]);
				int pageId = Integer.parseInt(ids[1]);
				List<ForumPost> topics = this.getForumService().getTopicsByForum(forumId,pageId - 1,_MAX_ROW_PER_PAGE);
				Forum forum = this.getForumService().getForumById(forumId);
				if(forum != null){
					String category = MessageUtil.getMessage(forum.getCategory().getName(),getLocale(request))+":"+MessageUtil.getMessage(forum.getName(),getLocale(request));
					String categoryDesc ="";
					if(forum.getCategory().getDesc() != null)
						categoryDesc = MessageUtil.getMessage(forum.getCategory().getDesc(),getLocale(request));
					if(forum.getDesc() != null)
						categoryDesc += " "+MessageUtil.getMessage(forum.getDesc(),getLocale(request));
					String dir = request.getSession().getServletContext().getRealPath("/")+"/feed/forum/";
					(new File(dir)).mkdirs();
					String xml = dir+uri;
					RssFactory.getInstance().getForumRss(category,categoryDesc,id,xml,topics);
					this.getServletContext().getRequestDispatcher("/feed/forum/"+uri).forward(request,response);				
				}else{
					response.getWriter().print("this fourm is not avaliable");
				}
			}else{
				response.getWriter().print("this fourm is not avaliable");
			}
		}
        else if(uri.startsWith("topic")){
			String id = uri.substring(5,uri.indexOf("."));
			if(id.indexOf("p") > 0){
				String[] ids= id.split("p");
				int topicId = Integer.parseInt(ids[0]);
				int pageId = Integer.parseInt(ids[1]);
				List<ForumPost> posts = this.getForumService().getPostsByTopic(topicId,pageId - 1,_MAX_ROW_PER_PAGE);
				Forum forum = this.getForumService().getForumById(topicId);
				if(forum != null){
					String category = MessageUtil.getMessage(forum.getCategory().getName(),getLocale(request))+":"+MessageUtil.getMessage(forum.getName(),getLocale(request));
					String categoryDesc ="";
					if(forum.getCategory().getDesc() != null)
						categoryDesc = MessageUtil.getMessage(forum.getCategory().getDesc(),getLocale(request));
					if(forum.getDesc() != null)
						categoryDesc += " "+MessageUtil.getMessage(forum.getDesc(),getLocale(request));
					String dir = request.getSession().getServletContext().getRealPath("/")+"/feed/forum/";
					(new File(dir)).mkdirs();
					String xml = dir+uri;
					RssFactory.getInstance().getForumTopicRss(category,categoryDesc,id,xml,posts);
					this.getServletContext().getRequestDispatcher("/feed/forum/"+uri).forward(request,response);				
				}else{
					response.getWriter().print("this fourm is not avaliable");
				}
				
			}else{
				response.getWriter().print("this fourm is not avaliable");
			}
		}
        else if(uri.startsWith("gforum")){
			String id = uri.substring(6,uri.indexOf("."));
			if(id.indexOf("p") > 0){
				String[] ids= id.split("p");
				int groupId = Integer.parseInt(ids[0]);
				int pageId = Integer.parseInt(ids[1]);
				List<GroupForum> topics = this.getGroupService().getTopicsByGroup(groupId,pageId - 1,_MAX_ROW_PER_PAGE);
				Group group = this.getGroupService().getGroupById(groupId);
				if(group != null){
					//String category = resource.getString(group.getCategory())+":"+group.getDisplayName();					
					String dir = request.getSession().getServletContext().getRealPath("/")+"/feed/gforum/";
					(new File(dir)).mkdirs();
					String xml = dir+uri;
					RssFactory.getInstance().getGroupForumRss(group.getDisplayName(),group.getShortDesc(),id,xml,topics);
					this.getServletContext().getRequestDispatcher("/feed/gforum/"+uri).forward(request,response);				
				}else{
					response.getWriter().print("this fourm is not avaliable");
				}
			}else{
				response.getWriter().print("this fourm is not avaliable");
			}
		}
        else if(uri.startsWith("gtopic")){
			String id = uri.substring(6,uri.indexOf("."));
			if(id.indexOf("p") > 0){
				String[] ids= id.split("p");
				int topicId = Integer.parseInt(ids[0]);
				int pageId = Integer.parseInt(ids[1]);
				List<GroupForum> posts = this.getGroupService().getPostsByTopic(topicId,pageId - 1,_MAX_ROW_PER_PAGE);
				GroupForum forum = this.getGroupService().getGroupForumById(topicId);
				if(forum != null){
					String category = forum.getTopic();
					String categoryDesc ="";
					Group group = this.getGroupService().getGroupById(forum.getGroupId());
					if(group != null){
						categoryDesc = group.getShortDesc();
					}
					String dir = request.getSession().getServletContext().getRealPath("/")+"/feed/gforum/";
					(new File(dir)).mkdirs();
					String xml = dir+uri;
					RssFactory.getInstance().getGroupForumTopicRss(category,categoryDesc,id,xml,posts);
					this.getServletContext().getRequestDispatcher("/feed/gforum/"+uri).forward(request,response);				
				}else{
					response.getWriter().print("this fourm is not avaliable");
				}
				
			}else{
				response.getWriter().print("this fourm is not avaliable");
			}
		}
	}

	private void doOpml(HttpServletRequest request, HttpServletResponse response, String uri) throws ServletException, IOException {
		response.setContentType("text/xml;charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        response.setHeader("Cache-Control", "no-store");
        User user = this.getUser(request);
        if(user != null){
	        if(uri.indexOf("allfeeds") > 0){
	        	if(this.isAdmin(user)){
	        		List<PortletObjectRef> list = this.getPortalService().getAllFeed();
	        		if(list != null){				
						String dir = request.getSession().getServletContext().getRealPath("/")+"/feed/";
						(new File(dir)).mkdirs();
						String xml = dir+"allfeeds.opml";
						RssFactory.getInstance().getAllOpml(list,xml);
						this.getServletContext().getRequestDispatcher("/feed/allfeeds.opml").forward(request,response);				
					}else{
						response.getWriter().print("you don't have any feeds to export.");
					}
	        	}else{
	    			response.getWriter().print("this is unauthorized action.");
	    		}
	        }else{
	        	List<PortletObjectRef> list = this.getPortalService().getMyFeed(user.getUserId());			
				if(list != null){				
					String dir = request.getSession().getServletContext().getRealPath("/")+"/feed/";
					(new File(dir)).mkdirs();
					String xml = dir+"myfeeds.opml";
					RssFactory.getInstance().getOpml(list,xml);
					this.getServletContext().getRequestDispatcher("/feed/myfeeds.opml").forward(request,response);				
				}else{
					response.getWriter().print("you don't have any feeds to export.");
				}
			}
        }else{
			response.getWriter().print("this user is not available.");
		}
	}
	
	private void getDefaultView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			PortalConfigAction action = new PortalConfigAction();	    
	    	String portalString = action.getPortal(request,response).toString();
	    	String pageString = action.getPortalTabsByUser(request,response).toString();
	    	List<PortalTab> tabs = this.getPortalService().getPortalTabByUser(OrganizationThreadLocal.getDefaultUserId());//_DEFAULT_USER);
	    	request.setAttribute("tabId",String.valueOf(tabs.get(0).getId()));
	    	String portletsString= action.getPortletsByTab(request,response).toString();
	    	List<LabelBean> list = new LinkedList<LabelBean>();
	    	if(this.getUser(request) != null && !this.getUser(request).getUserId().equals(OrganizationThreadLocal.getDefaultUserId())) 
	    		list.add(new LabelBean("loginUserId",this.getUser(request).getUserId()));
	    	else
	    		list.add(new LabelBean("loginUserId","0"));		    	
	    	list.add(new LabelBean("portalString",portalString));
	    	list.add(new LabelBean("pageRoot",pageString));
	    	list.add(new LabelBean("page"+tabs.get(0).getId()+"Portlets",portletsString));
	    	request.setAttribute("list",list);
	    	long orgId = OrganizationThreadLocal.getOrganizationId();
	 	    OrgProfile orgProfile =this.getUserService().getOrgProfileByOrgId(orgId,(String)request.getSession().getAttribute(_CURRENT_LOCALE));
	 	    if(orgProfile == null){
			   orgProfile =this.getUserService().getOrgProfileByOrgId(orgId, _DEFAULT_LANGUAGE);
		    }
	 	    if(orgProfile != null){
	 		   request.setAttribute("orgView", orgProfile.getView());
	 		   request.setAttribute("orgMaxView", orgProfile.getMaxView());
	 	    }
	    }catch(Exception e){
	    	throw new RuntimeException(e);
	    }
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/defaultViews.jsp").forward(request,response);
	}
	
	private void setLocale(HttpServletRequest request){
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
			if(this.getUser(request) != null){	
				locale = this.getUser(request).getLanguage();
			}
			String[] localeParams = locale.split("_");
			if(localeParams.length > 1)
				 currentLocale = new Locale(localeParams[0],localeParams[1]);
			else
				 currentLocale = new Locale(localeParams[0]);
			Config.set(request.getSession(), Config.FMT_LOCALE, currentLocale);	
			request.getSession().setAttribute(_CURRENT_LOCALE,currentLocale.toString());			
		}
		ResourceBundle resourceBundle = ResourceBundle.getBundle(_DEFAULT_RESOURCE_BUNDLE, currentLocale);
		PortalContextFactory.getPortalContext().setCurrentLocale(currentLocale);
		PortalContextFactory.getPortalContext().setResourceBundle(resourceBundle);		
	}
	private void doContentLibrary(HttpServletRequest request, HttpServletResponse response, String uri) throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        response.setHeader("Cache-Control", "no-store");
       
        //TODO: remove hard coded userId
        long orgId = OrganizationThreadLocal.getOrganizationId();
        long userId = this.getUser(request).getId();
        long parentFolderId = 0;
        if(userId > 0){
        	ContentLibraryService cls = this.getContentLibraryService();
			String treeSource = cls.getTreeSource(orgId, userId, parentFolderId);
			response.getWriter().print(treeSource);
		}else{
			response.getWriter().print("this user is not available.");
		}			
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
	protected Locale getLocale(HttpServletRequest request){
    	Locale currentLocale = (Locale) Config.get(request.getSession(),Config.FMT_LOCALE);
		if(currentLocale == null){
	    	String locale = _DEFAULT_LOCALE;
	    	if(request.getSession().getAttribute("currentLocale") != null)
	    		locale = (String)request.getSession().getAttribute("currentLocale");
	    	
	    	String[] localeParams = locale.split("_");
			if(localeParams.length > 1)
				 currentLocale = new Locale(localeParams[0],localeParams[1]);
			else
				 currentLocale = new Locale(localeParams[0]);
		}
		return currentLocale;
    }
	protected boolean isAdmin(User user){
		if(user == null) return false;
		List<PortalUserRole> userRoles = this.getPortalService().getUserRole(user.getId(),_ROLE_ADMIN);
		if(userRoles != null && userRoles.size() > 0) return true;
		return false;
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
	protected PortalTab getVisitedPage(HttpServletRequest request){				
		return (PortalTab)request.getSession().getAttribute(_VISITED_PAGE);
	}
	protected Group getVisitedGroup(HttpServletRequest request){		
		return (Group)request.getSession().getAttribute(_VISITED_GROUP);
	}
	protected Portal getPortal(HttpServletRequest request){
		Portal portal = (Portal)request.getSession().getAttribute(_LIGHT_PORTAL);
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
			portalTab =  getPortalService().getPortalTabById(tId);
		}
		return portalTab;
	}
    
    protected List<PortletObject> getPortletsByTab(HttpServletRequest request,long id){
    	return getPortalService().getPortletsByTab(id);
    }
    
	protected PortletObject getPortlet(HttpServletRequest request){
		String portletId = (String)request.getParameter("portletId");
		PortletObject portlet= null;
		if(portletId != null){
			portlet=getPortalService().getPortletById(Integer.parseInt(portletId));
		}
		return portlet;
	}
	
	protected PortalService getPortalService() {			
		return (PortalService)getService(this.getServletContext(), "portalService");
	}
	
	protected UserService getUserService() {			
		return (UserService)getService(this.getServletContext(), "userService");
	}
	
	protected GroupService getGroupService() {			
		return (GroupService)getService(this.getServletContext(), "groupService");
	}
	
	protected ForumService getForumService() {			
		return (ForumService)getService(this.getServletContext(), "forumService");
	}
		
	protected ChatService getChatService() {			
		return (ChatService)getService(this.getServletContext(), "chatService");
	}
	
	protected BlogService getBlogService() {			
		return (BlogService)getService(this.getServletContext(), "blogService");
	}
	protected ContentLibraryService getContentLibraryService() {			
		return (ContentLibraryService)getService(this.getServletContext(), "contentLibraryService");
	}
	private Object getService(ServletContext context, String serviceName) {
		ApplicationContext ctx = (ApplicationContext) context		
        							.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);		
		return ctx.getBean(serviceName);
	}
	
	protected User getUser(HttpServletRequest request){
		return (User)request.getSession().getAttribute(_USER);
	}	
	
	private Logger logger = LoggerFactory.getLogger(Servlet.class); 
}
