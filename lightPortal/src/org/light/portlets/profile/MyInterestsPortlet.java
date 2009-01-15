package org.light.portlets.profile;

import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.light.portal.model.User;
import org.light.portal.model.UserProfile;
import org.light.portal.portlet.core.impl.LightGenericPortlet;

public class MyInterestsPortlet extends LightGenericPortlet {
	 
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
		 UserProfile userProfile = this.getUserService(request).getUserProfileById(user.getId());
		 request.setAttribute("user",user);
		 request.setAttribute("userProfile",userProfile);
 		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/profile/myInterestsPortletView.jsp").include(request,response);  
			
	 }	


}
