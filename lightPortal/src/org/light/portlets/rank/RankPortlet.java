package org.light.portlets.rank;

import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

import org.light.portal.model.Portal;
import org.light.portal.model.PortletObject;
import org.light.portal.model.User;
import org.light.portal.model.UserPicture;
import org.light.portal.model.UserPictureRank;
import org.light.portal.portlet.core.impl.LightGenericPortlet;

public class RankPortlet extends LightGenericPortlet {
	 
	 public void processAction (ActionRequest request, ActionResponse response) 
	    throws PortletException, java.io.IOException {
		String action = request.getParameter("action");
		if("rank".equals(action)){
		   String pictureId = request.getParameter("pictureId");
		   String score = request.getParameter("score");
		   if(pictureId != null){
			   UserPicture picture= this.getUserService(request).getUserPictureById(Integer.parseInt(pictureId));
			   if(picture != null){				   
				   UserPictureRank rank = new UserPictureRank(picture.getUserId(),picture.getId(),Integer.parseInt(score),this.getUser(request).getId());
				   this.getPortalService(request).save(rank);
				   request.setAttribute("success", "This picture has been ranked successfully.");
			   }else
				   request.setAttribute("error", "System cannot find this picture.");		 
		   }else
			   request.setAttribute("error", "Please pick a picture to rank.");		
	   }
	 }
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
		 User user = this.getUser(request);
		 List<UserPicture> userPictures = null;
	     if(this.getVisitedUser(request) != null)
			 userPictures = this.getUserService(request).getUserRankPictures(this.getVisitedUser(request).getId());
		 else
		     userPictures = this.getUserService(request).getUserRankPictures(user.getId());
		 int pictureCount =0;		 
		 if(userPictures != null && userPictures.size() > 0) {
			 pictureCount=userPictures.size();			
		 }

		 request.setAttribute("pictureCount",pictureCount);
		 request.setAttribute("userPictures",userPictures);
		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/rank/rankPortletView.jsp").include(request,response);  
			
	 }	
    
	 protected void doEdit (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
		//this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/rank/rankPortletEdit.jsp").include(request,response);  
			
	 }	


}

