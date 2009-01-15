package org.light.portlets.group;

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

import org.light.portal.portlet.core.impl.LightGenericPortlet;

public class GroupBulletinPortlet extends LightGenericPortlet {
	 
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
		   long groupId = 0;
		   if(this.getVisitedGroup(request) != null)
		    	 groupId = this.getVisitedGroup(request).getId();
		   else{
				 String id = request.getParameter("groupId");
				 if(id == null){
					 request.setAttribute("error", "System cannot find this group.");						 			
				 }
		   }
		   GroupBulletin bulletin = new GroupBulletin(subject,content,groupId,this.getUser(request).getId());
		   this.getGroupService(request).sendBulletin(bulletin);
		}	
		
		if("delete".equals(action)){
			String id = request.getParameter("parameter");
			GroupBulletin bulletin = this.getGroupService(request).getBulletinById(Integer.parseInt(id));
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
			 GroupBulletin bulletin = this.getGroupService(request).getBulletinById(Integer.parseInt(bulletinId));
			 request.setAttribute("bulletin",bulletin);
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/group/bulletinPortletDetailView.jsp").include(request,response);
			 return;
		 }
		 long groupId = 0;
	     if(this.getVisitedGroup(request) != null)
	    	 groupId = this.getVisitedGroup(request).getId();
	     else{
			 String id = request.getParameter("groupId");
			 if(id == null){
				 request.setAttribute("error", "System cannot find this group.");	
				 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/error/error.jsp").include(request,response);
				 return;
			 }
			 groupId = Integer.parseInt(id);
	     }
		 Group group = this.getGroupService(request).getGroupById(groupId);	 
		 List<GroupBulletin> bulletins = this.getGroupService(request).getBulletinsByGroup(groupId);
		 request.setAttribute("group",group);
		 request.setAttribute("bulletins",bulletins);
		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/group/bulletinPortletView.jsp").include(request,response);
	 }	

	 protected void doEdit (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
		
		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/group/bulletinPortletEdit.jsp").include(request,response);
	 }
}
