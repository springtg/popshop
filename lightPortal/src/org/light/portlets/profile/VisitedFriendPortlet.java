package org.light.portlets.profile;

import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.net.URLDecoder;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.light.portal.model.PortletObject;
import org.light.portal.model.User;
import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portlets.chat.Chat;
import org.light.portlets.connection.Connection;

public class VisitedFriendPortlet extends LightGenericPortlet {
	 
	 public void processAction (ActionRequest request, ActionResponse response) 
	    throws PortletException, java.io.IOException {
	    
	  }
	 
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
//		 User user = this.getVisitedUser(request);
//		Chat chat = this.getChatService(request).getChatByUser(user.getUserId());
//		List<ChatBuddy> buddys = this.getChatService(request).getBuddysByUser(user.getUserId());
//		int buddyCount =0;
//		if(buddys != null) buddyCount=buddys.size();
//		request.setAttribute("chat",chat);
//		request.setAttribute("buddys", buddys);
//		request.setAttribute("buddyCount", buddyCount);
//		this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/profile/visitedFriendPortletView.jsp").include(request,response);  
		
	 }	
	 
	 protected void doEdit (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {			
	 }	
	 
	 protected void doHelp (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {  		 
	 }
}
