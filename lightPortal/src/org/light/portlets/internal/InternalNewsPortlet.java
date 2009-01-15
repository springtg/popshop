package org.light.portlets.internal;

import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

import org.light.portal.model.PortletObject;
import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portal.util.OrganizationThreadLocal;

public class InternalNewsPortlet extends LightGenericPortlet {
	 
	 public void processAction (ActionRequest request, ActionResponse response) 
	    throws PortletException, java.io.IOException {
		String action = request.getParameter("action");
		if("save".equals(action)){
		   String subject = request.getParameter("subject");
		   String content = request.getParameter("content");
		   if(subject != null) subject = URLDecoder.decode(subject,_CHARSET_UTF);		   	
		   if(content != null) content = URLDecoder.decode(content,_CHARSET_UTF).replaceAll("\n","").trim();
		   if(subject == null || subject.length() <= 0 || content == null || content.length() <= 0 ){
			   request.setAttribute("error","News's subject and content are required field.");
			   response.setPortletMode(PortletMode.EDIT);
			   request.setAttribute("subject",subject);
			   request.setAttribute("content",content);
			   return;
		   }
		   String newsId = request.getParameter("newsId");
		   long id = 0;
		   try{
			   id = Long.parseLong(newsId);			   
		   }catch(Exception e){}
		   
		   InternalNews news = null;
		   if(id > 0)
			   news = this.getPortalService(request).getInternalNewsById(id);
		   if(news == null){
			   news = new InternalNews(subject,content,this.getUser(request).getId(),OrganizationThreadLocal.getOrganizationId());
		   }else{
			   news.setSubject(subject);
			   news.setContent(content);
		   }
		   this.getPortalService(request).save(news);
		}			
		else if("edit".equals(action)){
			String id = request.getParameter("parameter");
			InternalNews news = this.getPortalService(request).getInternalNewsById(Long.parseLong(id));
			if(news != null){
				request.setAttribute("newsId",news.getId());
				request.setAttribute("subject",news.getSubject());
				request.setAttribute("content",news.getContent());
			}
		}
		else if("delete".equals(action)){
			String id = request.getParameter("parameter");
			InternalNews news = this.getPortalService(request).getInternalNewsById(Long.parseLong(id));
			if(news != null){
				this.getPortalService(request).delete(news);	
			}
		}
		else{
			 String showHtmlEditor = request.getParameter("htmlEditor");
			 if(showHtmlEditor != null)
				 request.setAttribute("showHtmlEditor",true);
			 String newsId = request.getParameter("newsId");
			 if(newsId != null){	   			   
				 request.setAttribute("newsId",newsId);
			 }
			 String subject = request.getParameter("subject");
			 if(subject != null){
				 subject = URLDecoder.decode(subject,_CHARSET_UTF);		   			   
				 request.setAttribute("subject",subject);
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
		 String newsId = request.getParameter("newsId");		 		 
		 if(newsId != null){
			 InternalNews news = this.getPortalService(request).getInternalNewsById(Long.parseLong(newsId));
			 request.setAttribute("news",news);
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/internal/newsDetailView.jsp").include(request,response);
			 return;
		 }
	     		 			 
		 List<InternalNews> newsList =this.getPortalService(request).getInternalNews(OrganizationThreadLocal.getOrganizationId()); 
		 PortletObject portlet = this.getPortlet(request);
		 int showNumber = 6;
		 if(portlet.getShowNumber() > 0) showNumber = portlet.getShowNumber();
		 List<InternalNews> showList = new ArrayList<InternalNews>();
		 if(newsList.size() > showNumber && request.getWindowState().equals(WindowState.NORMAL)){
			request.setAttribute("showMore",true);
			for(int i=0;i<showNumber;i++){
				showList.add(newsList.get(i));
			}
		 }else{
			 showList= newsList;
		 }
		 request.setAttribute("showList",showList);	 
		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/internal/newsView.jsp").include(request,response);
	 }	

	 protected void doEdit (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {   		 
		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/internal/newsEdit.jsp").include(request,response);
	 }

}
