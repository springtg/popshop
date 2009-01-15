package org.light.portlets.profile;

import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.light.portal.model.User;
import org.light.portal.model.UserMusic;
import org.light.portal.model.UserProfile;
import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portlets.chat.Chat;
import org.light.portlets.connection.Connection;

public class ProfilePortlet extends LightGenericPortlet {
	 
	 public void processAction (ActionRequest request, ActionResponse response) 
	    throws PortletException, java.io.IOException {
		 String action = request.getParameter("action");		
		 if("play".equals(action)){
			 request.setAttribute("play",true);
		   }
			if("stop".equals(action)){
				request.removeAttribute("play");	
				request.setAttribute("stop",true);
		   }
	  }
	 
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
	     User user = this.getUser(request);
	     if(user != null && user.getOtherMusucAutoPlay() == 0)
	    	 request.setAttribute("stop",true);
	     if(this.getVisitedUser(request) != null){
	    	 user = this.getVisitedUser(request);
	    	 user = this.getUserService(request).getUserById(user.getId());
	    	 request.setAttribute("isVisitor",true);
	    	 if(user.getMyMusicAutoPlay() == 0)
	    		 request.setAttribute("stop",true);
	     }else
	    	 request.setAttribute("stop",true);
	     if(user != null){
		     UserProfile userProfile = this.getUserService(request).getUserProfileById(user.getId());		                 	
			 Chat chat = this.getChatService(request).getChatByUser(user.getId());		
			 request.setAttribute("chat",chat);
			 request.setAttribute("user", user);
			 request.setAttribute("userProfile", userProfile);
	  		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/profile/profilePortletView.jsp").include(request,response);  
	     }	
	 }	


}