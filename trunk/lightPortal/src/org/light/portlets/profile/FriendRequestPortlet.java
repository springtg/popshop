package org.light.portlets.profile;

import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.net.URLDecoder;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.light.portal.model.User;
import org.light.portal.model.UserFriendRequest;
import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portlets.connection.Connection;
import org.light.portlets.message.Message;

public class FriendRequestPortlet extends LightGenericPortlet {
	 
	 public void processAction (ActionRequest request, ActionResponse response) 
	    throws PortletException, java.io.IOException {
		String action = request.getParameter("action");
		if("save".equals(action)){
		   String to = request.getParameter("to");
		   long toUserId = Long.parseLong(to);
		   String subject = request.getParameter("subject");
		   String content = request.getParameter("content");
		   if(subject == null || subject.length() <= 0 || to == null || to.length() <= 0 ){
			   request.setAttribute("error","Message's to and subject are required field.");
			   response.setPortletMode(PortletMode.EDIT);
			   return;
		   }
		   if(subject != null) subject = URLDecoder.decode(subject,_CHARSET_UTF);		   	
		   if(content != null) content = URLDecoder.decode(content,_CHARSET_UTF);
		   Message message = new Message(subject,content,toUserId,this.getUser(request).getId());
		   this.getUserService(request).sendMessage(message);
		   //request.setAttribute("mode",PortletMode.VIEW);
		   response.setPortletMode(PortletMode.VIEW);
		}	
		
		if("sendMessage".equals(action)){
			response.setPortletMode(PortletMode.EDIT);
		}
		if("approve".equals(action)){
			String id = request.getParameter("parameter");
			UserFriendRequest friendRequest = this.getUserService(request).getUserFriendRequestById(Integer.parseInt(id));
			if(friendRequest != null){
				this.getUserService(request).approveFriend(friendRequest);				
			}
		}
		if("deny".equals(action)){
			String id = request.getParameter("parameter");
			UserFriendRequest friendRequest = this.getUserService(request).getUserFriendRequestById(Integer.parseInt(id));
			if(friendRequest != null){
				friendRequest.setStatus("2");
				this.getPortalService(request).save(friendRequest);	
			}
		}
	  }
	 
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
		 User user = this.getUser(request);	     
		 List<UserFriendRequest> friendRequests = this.getUserService(request).getFriendRequestsByUser(user.getId());
		 if(friendRequests != null && friendRequests.size() == 0)
			 request.setAttribute("isEmpty",true);
		 request.setAttribute("friendRequests",friendRequests);
		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/profile/friendRequestPortletView.jsp").include(request,response);  
			
	 }
	 
	 protected void doEdit (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {   
		 String subject = "";
		 String content = "";
		 String id = request.getParameter("parameter");
		 UserFriendRequest friendRequest = this.getUserService(request).getUserFriendRequestById(Integer.parseInt(id));
		 if(friendRequest != null){
			 request.setAttribute("toUser",friendRequest.getPostById());
			 request.setAttribute("toUserName",friendRequest.getDisplayName());
		 }
		
		 List<Connection> buddys = this.getChatService(request).getBuddysByUser(this.getUser(request).getId());
		 request.setAttribute("buddys",buddys); 	
		 request.setAttribute("subject",subject);
		 request.setAttribute("content",content);
		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/message/messagePortletEdit.jsp").include(request,response);
	 }


}
