package org.light.portlets.profile;

import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

import org.light.portal.model.User;
import org.light.portal.model.UserComments;
import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portlets.todolist.ToDoBean;

public class MyCommentsPortlet extends LightGenericPortlet {
	 
	 public void processAction (ActionRequest request, ActionResponse response) 
	    throws PortletException, java.io.IOException {
		 String action = request.getParameter("action");
		 if("delete".equals(action)){
			String id = request.getParameter("parameter");
			UserComments comment = this.getUserService(request).getUserCommentsById(Integer.parseInt(id));
			if(comment != null){
				this.getPortalService(request).delete(comment);	
			}
		 }
	  }
	 
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
		 User user = this.getUser(request);
	     if(this.getVisitedUser(request) != null)
	    	 user = this.getVisitedUser(request);
		 
		 int showNumber = 6;
		 if(this.getPortlet(request) != null && this.getPortlet(request).getShowNumber() > 0) showNumber = this.getPortlet(request).getShowNumber();
		 int count = this.getUserService(request).getUserCommentsCount(user.getId());
		 if(request.getWindowState().equals(WindowState.NORMAL) && count > showNumber){
			 List<UserComments> userComments = this.getUserService(request).getUserComments(user.getId(), showNumber);
			 request.setAttribute("userComments",userComments);
		     request.setAttribute("showMore",true);
		 }else{
			 List<UserComments> userComments = this.getUserService(request).getUserComments(user.getId());
			 request.setAttribute("userComments",userComments);
		 }
			 
		 
 		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/profile/myCommentsPortletView.jsp").include(request,response);  
			
	 }	


}