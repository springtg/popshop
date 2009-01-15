package org.light.portlets.profile;

import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.light.portal.model.User;
import org.light.portal.portlet.core.impl.LightGenericPortlet;

public class MyMessagePortlet extends LightGenericPortlet {
	 
	 public void processAction (ActionRequest request, ActionResponse response) 
	    throws PortletException, java.io.IOException {
	    //throw new PortletException("processAction method not implemented");
	  }
	 
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
		 User user = this.getUser(request);
	     if(this.getVisitedUser(request) != null)
	    	 user = this.getVisitedUser(request);
	     if(user != null){
			 int messageCount=this.getUserService(request).getNewMessageCountByUser(user.getId());
			 if(messageCount > 0)
				 request.setAttribute("messageCount",messageCount);
			 int friendRequestCount = this.getUserService(request).getNewFriendRequestCountByUser(user.getId());
			 if(friendRequestCount > 0)
				 request.setAttribute("friendRequestCount",friendRequestCount);
			 request.setAttribute("user",user);
	     }
 		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/profile/myMessagePortletView.jsp").include(request,response);  
			
	 }	


}
