package org.light.portlets.blog;

import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

import org.light.portal.model.PortletObject;
import org.light.portal.model.User;
import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portal.util.OrganizationThreadLocal;

public class BlogPortlet extends LightGenericPortlet {
	 
	public void processAction (ActionRequest request, ActionResponse response) 
    throws PortletException, java.io.IOException {
	String action = request.getParameter("action");
	if("draft".equals(action)){
	   String subject = request.getParameter("subject");
	   String summary = request.getParameter("summary");
	   String content = request.getParameter("content");
	   if(subject == null || subject.length() <= 0 ){
		   request.setAttribute("error","Blog's subject is field.");
		   request.setAttribute("subject",subject);
		   request.setAttribute("summary",summary);
		   request.setAttribute("content",content);
		   request.setAttribute("mode",PortletMode.EDIT.toString());
		   return;
	   }
	   if(subject != null) subject = URLDecoder.decode(subject,_CHARSET_UTF);		   	
	   if(summary != null) summary = URLDecoder.decode(summary,_CHARSET_UTF);
	   if(content != null) content = URLDecoder.decode(content,_CHARSET_UTF);
	   Blog blog = null;
	   String blogId = request.getParameter("blogId");
	   if(blogId != null) blog = this.getBlogService(request).getBlogById(Long.parseLong(blogId));
	   if(blog == null){
		   PortletPreferences portletPreferences = request.getPreferences();
		   String type = portletPreferences.getValue("type","0");
		   long userId = this.getUser(request).getId();		   
		   if("1".equals(type)) userId = OrganizationThreadLocal.getOrg().getUserId();
		   blog = new Blog(userId,this.getUser(request).getId(),OrganizationThreadLocal.getOrganizationId(),subject,summary,content,0);
	   }else{
		   blog.setTitle(subject);
		   blog.setContent(content);
		   blog.setStatus(0);
	   }
	   this.getPortalService(request).save(blog);
	}	
	else if("save".equals(action)){
	   String subject = request.getParameter("subject");
	   String summary = request.getParameter("summary");
	   String content = request.getParameter("content");
	   if(subject != null) subject = URLDecoder.decode(subject,_CHARSET_UTF);		   	
	   if(summary != null) summary = URLDecoder.decode(summary,_CHARSET_UTF);
	   if(content != null) content = URLDecoder.decode(content,_CHARSET_UTF);
	   if(subject == null || subject.length() <= 0 || content == null || content.length() <= 0){
		   request.setAttribute("error","Blog's subject and content are required field.");
		   request.setAttribute("subject",subject);
		   request.setAttribute("summary",summary);
		   request.setAttribute("content",content);
		   response.setPortletMode(PortletMode.EDIT);
		   
		   response.setRenderParameter("add","add");
		   return;
	   }	   
	   Blog blog = null;
	   String blogId = request.getParameter("blogId");
	   if(blogId != null) blog = this.getBlogService(request).getBlogById(Long.parseLong(blogId));
	   if(blog == null){
		   PortletPreferences portletPreferences = request.getPreferences();
		   String type = portletPreferences.getValue("type","0");
		   long userId = this.getUser(request).getId();		   
		   if("1".equals(type)) userId = OrganizationThreadLocal.getOrg().getUserId();
		   blog = new Blog(userId,this.getUser(request).getId(),OrganizationThreadLocal.getOrganizationId(),subject,summary,content,1);
	   }else{
		   blog.setTitle(subject);
		   blog.setSummary(summary);
		   blog.setContent(content);
		   blog.setStatus(1);
	   }
	   this.getPortalService(request).save(blog);
	}	
	else if("delete".equals(action)){
		String blogId = request.getParameter("parameter");
		Blog blog = this.getBlogService(request).getBlogById(Long.parseLong(blogId));
		if(blog != null){
			this.getPortalService(request).delete(blog);	
		}
	}	
	else if("config".equals(action)){
		String items = request.getParameter("items");
		PortletObject portlet =getPortlet(request);		
		if(portlet != null){			
			portlet.setShowNumber(Integer.parseInt(items));
			this.getPortalService(request).save(portlet);
		}
		response.setPortletMode(PortletMode.VIEW);
	}
	else{
		 String showHtmlEditor = request.getParameter("htmlEditor");
		 if(showHtmlEditor != null)
			 request.setAttribute("showHtmlEditor",true);
		 String blogId = request.getParameter("blogId");
		 if(blogId != null){			    			   
			 request.setAttribute("blogId",blogId);
		 }
		 String subject = request.getParameter("subject");
		 if(subject != null){
			 subject = URLDecoder.decode(subject,_CHARSET_UTF);		   			   
			 request.setAttribute("subject",subject);
		 }
		 String summary = request.getParameter("summary");
		 if(summary != null){
			 summary = URLDecoder.decode(summary,_CHARSET_UTF);		   			   
			 request.setAttribute("summary",summary);
		 }
		 String content = request.getParameter("content");
		 if(content != null){
			 content = URLDecoder.decode(content,_CHARSET_UTF);
			 request.setAttribute("content",content);
		 }			 			 
	}
  }
 
 protected void doView (RenderRequest request, RenderResponse response)
   throws PortletException, java.io.IOException
 {
	 String blogId = request.getParameter("blogId");
	 if(blogId == null){
		 List<Blog> list = null;
		 User user = this.getUser(request);
	     if(this.getVisitedUser(request) != null)
	    	 user = this.getVisitedUser(request);
	     PortletPreferences portletPreferences = request.getPreferences();
		 String type = portletPreferences.getValue("type","0");
		 long userId = user.getId();		   
		 if("1".equals(type)) userId = OrganizationThreadLocal.getOrg().getUserId();		   
		 request.setAttribute("userId",userId);
	     list = this.getBlogService(request).getBlogsByUser(userId,OrganizationThreadLocal.getOrganizationId());
		 List<Blog> showList = null;
		 PortletObject portlet = this.getPortlet(request);
		 int showNumber = 0;
		 if(portlet != null) showNumber = portlet.getShowNumber();
		 if(showNumber<=0) showNumber = 6;
		 if(!request.getWindowState().equals(WindowState.MAXIMIZED) && list.size() >= showNumber){
			 showList = new ArrayList<Blog>();
			 for(int i=0;i<showNumber;i++){
				 showList.add(list.get(i));
			 }
		 }else
			 showList = list;
		 int blogCount = 0;
		 if(list != null && list.size() > 0) blogCount= list.size();
		 if(showNumber < blogCount)
			 request.setAttribute("showMore",true);
		 request.setAttribute("blogCount",blogCount);
		 request.setAttribute("blogLists",showList);
		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/blog/blogPortletView.jsp").include(request,response);
	 }else{		 
		 Blog blog = this.getBlogService(request).getBlogById(Long.parseLong(blogId));
		 request.setAttribute("blog",blog);
		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/blog/blogPortletDetail.jsp").include(request,response);
	 }
 }	
 
 protected void doEdit (RenderRequest request, RenderResponse response)
   throws PortletException, java.io.IOException
 {  
	 if(request.getParameter("add") != null)
		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/blog/blogPortletEdit.jsp").include(request,response);
	 else if("edit".equals(request.getParameter("action")) && request.getParameter("parameter") != null){
		 String blogId = request.getParameter("parameter");
		 Blog blog = this.getBlogService(request).getBlogById(Long.parseLong(blogId));
		 request.setAttribute("blog",blog);
		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/blog/blogPortletEdit.jsp").include(request,response);
	 }else{
		 PortletObject portlet = this.getPortlet(request);
		 int showNumber = portlet.getShowNumber();
		 if(showNumber <=0) showNumber = 6;
		 request.setAttribute("showNumber",showNumber);
		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/blog/blogPortletConfig.jsp").include(request,response);
	 }			 
 }
 
 protected void doHelp (RenderRequest request, RenderResponse response)
   throws PortletException, java.io.IOException
 {  		 
	 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/blog/blogPortletHelp.jsp").include(request,response);
 }
}
