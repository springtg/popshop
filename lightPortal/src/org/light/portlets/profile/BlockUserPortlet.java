package org.light.portlets.profile;

import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.light.portal.model.User;
import org.light.portal.model.UserBlock;
import org.light.portal.portlet.core.impl.LightGenericPortlet;

public class BlockUserPortlet extends LightGenericPortlet {
	 
	 public void processAction (ActionRequest request, ActionResponse response) 
	    throws PortletException, java.io.IOException {
		String action = request.getParameter("action");
		if("unblock".equals(action)){
		   String blockId = request.getParameter("blockId");
		   if(blockId != null){
			   UserBlock block= this.getUserService(request).getUserBlockById(Integer.parseInt(blockId));
			   if(block != null){				   				   
				   this.getPortalService(request).delete(block);
				   request.setAttribute("success", "This User has been unblocked successfully.");
			   }else
				   request.setAttribute("error", "System cannot find this user.");		 
		   }else
			   request.setAttribute("error", "Please pick a User to unblock.");		
	   }
	  }
	 
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
		 User user = this.getUser(request);
	     if(this.getVisitedUser(request) != null)
	    	 user = this.getVisitedUser(request);
		 List<UserBlock> userBlocks = this.getUserService(request).getUserBlocks(user.getId());
		 int blockCount = 0;
		 if(userBlocks != null)
			 blockCount = userBlocks.size();
		 request.setAttribute("blockCount",blockCount);
		 request.setAttribute("userBlocks",userBlocks);
		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/profile/blockPortletView.jsp").include(request,response);  
			
	 }	


}
