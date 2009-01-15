package org.light.portlets.blog;

import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.net.URLDecoder;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.light.portal.model.PortletObject;
import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portal.util.OrganizationThreadLocal;
import org.light.portlets.forum.ForumPost;

public class BlogViewPortlet extends LightGenericPortlet {
	 
	public void processAction (ActionRequest request, ActionResponse response) 
    throws PortletException, java.io.IOException {
	String action = request.getParameter("action");
	if("draft".equals(action)){
	   String subject = request.getParameter("subject");
	   String summary = request.getParameter("summary");
	   String content = request.getParameter("content");
	   if(subject == null || subject.length() <= 0 ){
		   request.setAttribute("error","Blog's subject is field.");
		   response.setPortletMode(PortletMode.EDIT);
		   return;
	   }
	   if(subject != null) subject = URLDecoder.decode(subject,_CHARSET_UTF);		   	
	   if(summary != null) summary = URLDecoder.decode(summary,_CHARSET_UTF);
	   if(content != null) content = URLDecoder.decode(content,_CHARSET_UTF);
	   Blog blog = new Blog(this.getUser(request).getId(),this.getUser(request).getId(),OrganizationThreadLocal.getOrganizationId(),subject,summary,content,0);
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
		   blog = new Blog(this.getUser(request).getId(),this.getUser(request).getId(),OrganizationThreadLocal.getOrganizationId(),subject,summary,content,1);
	   }else{
		   blog.setTitle(subject);
		   blog.setContent(content);
		   blog.setStatus(1);
	   }
	   this.getPortalService(request).save(blog);
	}	
	else if("delete".equals(action)){
		String id = request.getParameter("parameter");
		ForumPost forum = this.getForumService(request).getPostById(Integer.parseInt(id));
		if(forum != null){
			this.getPortalService(request).delete(forum);	
		}
	}
	else if("config".equals(action)){
		String items = request.getParameter("items");
		String type = request.getParameter("newType");
		PortletObject portlet =getPortlet(request);		
		if(portlet != null){			
			portlet.setShowNumber(Integer.parseInt(items));
			portlet.setParameter("type="+type);
			this.getPortalService(request).save(portlet);
		}
		//request.setAttribute("mode",PortletMode.VIEW.toString());
		response.setPortletMode(PortletMode.VIEW);
	}
	else{
		 String showHtmlEditor = request.getParameter("htmlEditor");
		 if(showHtmlEditor != null)
			 request.setAttribute("showHtmlEditor",true);
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
		 PortletObject portlet = this.getPortlet(request);
		 String type = portlet.getParameter();
		 if(type != null) type = type.substring(type.length() - 1);
		 int showNumber = portlet.getShowNumber();
		 if(showNumber <=0) showNumber = 6;
		 List<Blog> list = this.getBlogService(request).getBlogsByType(type,OrganizationThreadLocal.getOrganizationId(),showNumber);
		 request.setAttribute("type",type);
		 request.setAttribute("showNumber",showNumber);
		 request.setAttribute("blogLists",list);
		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/blog/blogViewPortletView.jsp").include(request,response);
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
	 else{
		 PortletObject portlet = this.getPortlet(request);
		 String type = portlet.getParameter();
		 if(type != null) type = type.substring(type.length() - 1);
		 int showNumber = portlet.getShowNumber();
		 if(showNumber <=0) showNumber = 6;
		 request.setAttribute("type",type);
		 request.setAttribute("showNumber",showNumber);
		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/blog/blogViewPortletConfig.jsp").include(request,response);
	 }		
 }
 
}
