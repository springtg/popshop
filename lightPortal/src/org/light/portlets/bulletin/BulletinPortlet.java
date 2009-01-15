package org.light.portlets.bulletin;

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

import org.light.portal.model.User;
import org.light.portal.model.UserComments;
import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portlets.forum.ForumPost;

public class BulletinPortlet extends LightGenericPortlet {
	 
	 public void processAction (ActionRequest request, ActionResponse response) 
	    throws PortletException, java.io.IOException {
		String action = request.getParameter("action");
		if("save".equals(action)){
		   String subject = request.getParameter("subject");
		   String content = request.getParameter("content");
		   if(subject == null || subject.length() <= 0 ){
			   request.setAttribute("error","Bulletin's subject is required field.");
			   response.setPortletMode(PortletMode.EDIT);
			   return;
		   }
		   if(subject != null) subject = URLDecoder.decode(subject,_CHARSET_UTF);		   	
		   if(content != null) content = URLDecoder.decode(content,_CHARSET_UTF);
		   Bulletin bulletin = new Bulletin(subject,content,this.getUser(request).getId());
		   this.getUserService(request).sendBulletin(bulletin);
		}	
		else if("delete".equals(action)){
			String id = request.getParameter("parameter");
			Bulletin bulletin = this.getUserService(request).getBulletinById(Integer.parseInt(id));
			if(bulletin != null){
				this.getPortalService(request).delete(bulletin);	
			}
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
		 String bulletinId = request.getParameter("bulletinId");
		 if(bulletinId != null){
			 Bulletin bulletin = this.getUserService(request).getBulletinById(Integer.parseInt(bulletinId));
			 request.setAttribute("bulletin",bulletin);
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/bulletin/bulletinPortletDetailView.jsp").include(request,response);
			 return;
		 }
		 User user = this.getUser(request);
	     if(this.getVisitedUser(request) != null)
	    	 user = this.getVisitedUser(request);
		 List<Bulletin> bulletins = this.getUserService(request).getBulletinsByUser(user.getId());
		 request.setAttribute("bulletins",bulletins);
		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/bulletin/bulletinPortletView.jsp").include(request,response);
	 }	

	 protected void doEdit (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {		 
		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/bulletin/bulletinPortletEdit.jsp").include(request,response);
	 }
}
