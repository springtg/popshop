package org.light.portlets.group;

import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portlets.connection.Connection;

public class GroupMembersPortlet extends LightGenericPortlet {
	 
	 public void processAction (ActionRequest request, ActionResponse response) 
	    throws PortletException, java.io.IOException {
	    String action = request.getParameter("action");		
				
	  }
	 
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
		String groupId= request.getParameter("groupId");
		List<UserGroup> groupMembers = this.getGroupService(request).getUsersByGroup(Integer.parseInt(groupId));
		int memberCount = 0;
		if(groupMembers != null) memberCount = groupMembers.size();
		request.setAttribute("memberCount", memberCount);
		request.setAttribute("groupMembers", groupMembers);
		this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/group/groupPortletMembers.jsp").include(request,response);
	}	
	 
}

