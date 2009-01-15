package org.light.portlets.profile;

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
import org.light.portal.model.UserFriendRequest;
import org.light.portal.model.UserProfile;
import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portlets.message.Message;

public class InviteFriendPortlet extends LightGenericPortlet {
	 
	public void processAction (ActionRequest request, ActionResponse response) 
throws PortletException, java.io.IOException {
	String action = request.getParameter("action");
	if("send".equals(action)){
	   String to = request.getParameter("to");
	   if(to == null || to.length() <= 0 ){
		   request.setAttribute("error","your friends' email address are required.");
		   return;
	   }
	   String content = request.getParameter("content");	  	   		   	
	   if(content != null) content = URLDecoder.decode(content,_CHARSET_UTF);
	   if(to != null) to = URLDecoder.decode(to,_CHARSET_UTF);
	      
	   this.getUserService(request).inviteFriends(to,content,this.getUser(request));
	   String[] mails = to.split(",");
	   StringBuffer info = new StringBuffer();
	   info.append("you have invited following friends successfully:<br/>");
	   for(int i=0;i<mails.length;i++){
		   info.append("<br/>"+mails[i]);
	   }
	   info.append("<br/>");
	   request.setAttribute("success",info.toString());
	}	
	
  }
 
 protected void doView (RenderRequest request, RenderResponse response)
   throws PortletException, java.io.IOException
 {
	 
	 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/profile/inviteFriendPortletView.jsp").include(request,response);  
		
 }

}
