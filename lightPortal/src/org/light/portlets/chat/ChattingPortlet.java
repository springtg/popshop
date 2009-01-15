package org.light.portlets.chat;

import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.net.URLDecoder;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.light.portal.portlet.core.impl.LightGenericPortlet;

public class ChattingPortlet extends LightGenericPortlet {
	 
	 public void processAction (ActionRequest request, ActionResponse response) 
	    throws PortletException, java.io.IOException {
	    String action = request.getParameter("action");
		if("send".equals(action)){
			   String chatting = request.getParameter("chat");
			   String displayName = request.getParameter("displayName");
			   String id = request.getParameter("chattingId");
			   int chattingId = Integer.parseInt(id);
			   if(displayName != null) {
				   displayName = URLDecoder.decode(displayName,_CHARSET_UTF);
			   }else{
				   Chat chat = this.getChatService(request).getChatByUser(this.getUser(request).getId());
				   displayName = this.getUser(request).getUserId();
				   if(chat != null) displayName = chat.getDisplayName();
			   }
				   
			   if(chatting != null) {
				   chatting = URLDecoder.decode(chatting,_CHARSET_UTF);				  
				   ChattingRecord record = new ChattingRecord(chattingId, displayName, chatting);				  
				   this.getChatService(request).save(record);
			   }
			   
		}
	  }
	 
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException{	  
		String id = request.getParameter("chattingId");
	    int chattingId = Integer.parseInt(id);
		List<ChattingRecord> records = this.getChatService(request).getChattingRecordsById(chattingId);	
		Chat chat = this.getChatService(request).getChatByUser(this.getUser(request).getId());
		String displayName = this.getUser(request).getUserId();
		if(chat != null) displayName = chat.getDisplayName();
		request.setAttribute("chattingId",chattingId);
		request.setAttribute("displayName",displayName);
		request.setAttribute("records",records);
		
		this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/chat/chattingPortletView.jsp").include(request,response);  
		
	 }	
	 
}

