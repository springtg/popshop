package org.light.portlets.profile;

import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.light.portal.model.User;
import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portlets.chat.Chat;

public class VisitedProfilePortlet extends LightGenericPortlet {
	 
	 public void processAction (ActionRequest request, ActionResponse response) 
	    throws PortletException, java.io.IOException {
	    //throw new PortletException("processAction method not implemented");
	  }
	 
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
//	     User user = this.getVisitedUser(request);
//		 Chat chat = this.getChatService(request).getChatByUser(user.getUserId());		
//		 request.setAttribute("chat",chat);
//		 request.setAttribute("userProfile",user);
// 		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/profile/visitedProfilePortletView.jsp").include(request,response);  
			
	 }	


}
