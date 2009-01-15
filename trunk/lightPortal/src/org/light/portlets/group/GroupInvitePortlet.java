package org.light.portlets.group;

import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.light.portal.model.User;
import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portlets.connection.Connection;

public class GroupInvitePortlet  extends LightGenericPortlet {
	 
	 public void processAction (ActionRequest request, ActionResponse response) 
	    throws PortletException, java.io.IOException {
	    String action = request.getParameter("action");		
		
		if("invite".equals(action)){
			   response.setRenderParameter("type","invite");
		}
		
	  }
	 
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
		List<Connection> myFriends = this.getChatService(request).getBuddysByUser(this.getUser(request).getId());
		String groupId= request.getParameter("groupId");
		request.setAttribute("groupId",groupId);
		request.setAttribute("myFriends",myFriends);
		this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/group/groupPortletInvite.jsp").include(request,response);
	 }	
	 
}

