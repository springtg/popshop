/* Copyright (c) 2006 Jianmin Liu.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.light.portlets.chat.action;

import static org.light.portal.util.Constants._VISITED_USER;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.light.portal.core.PortalContextFactory;
import org.light.portal.core.action.BaseAction;
import org.light.portal.model.User;
import org.light.portal.model.UserBlock;
import org.light.portal.model.UserFavourite;
import org.light.portal.model.UserFriendRequest;
import org.light.portal.util.DateFormatter;
import org.light.portal.util.OrganizationThreadLocal;
import org.light.portlets.chat.Chat;
import org.light.portlets.chat.Chatting;
import org.light.portlets.chat.ChattingRecord;
import org.light.portlets.connection.Connection;
import org.light.portlets.message.Message;
/**
* 
* @author Jianmin Liu
* @version 1.0.0
* Creation date: April 4, 2006
**/
public class ChatAction extends BaseAction{
		
	public Object getUserDetail(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String userId = request.getParameter("userId");
		String responseId = (String)request.getParameter("responseId");
		StringBuffer buffer = new StringBuffer();
		if(userId != null){
			User user = this.getUserService(request).getUserById(Long.parseLong(userId));
			int isFriend = 0;
			Connection buddy =this.getChatService(request).getChatBuddy(this.getUser(request).getId(),user.getId());
			if(buddy != null)
				isFriend = 1;
			Chat chat = this.getChatService(request).getChatByUser(user.getId());
			int status = 0;
			if(chat != null) status = chat.getCurrentStatus();
			  buffer.append(responseId)
					.append(",")
					.append(user.getId())
					.append(",")
					.append(isFriend)
					.append(",")
					.append(status)
					.append(",")
					.append(PortalContextFactory.getPortalContext().getMessageByKey("portlet.label.name"))
					.append(": ")
					.append(user.getName())
					.append(",")
					.append(PortalContextFactory.getPortalContext().getMessageByKey("portlet.label.email"))
					.append(": ")
					.append(user.getEmail())
					.append(",")
					.append(user.getEmail())
					.append(",")
					.append(user.getName())
					;
			  if(buddy != null){
				  buffer.append(",")
				   		.append(PortalContextFactory.getPortalContext().getMessageByKey("portlet.label.type"))
				  		.append(",")
				  		.append(buddy.getType());
			  }
		}

		return buffer.toString();
	}
		
	public Object listenServer(HttpServletRequest request, HttpServletResponse response) throws Exception{		
		User user = this.getUser(request);
		if(user != null){
			Chatting chatting = this.getChatService(request).getChattingByUser(user.getId());
			if(chatting != null){
				User fromUser = this.getUserService(request).getUserById(chatting.getFrom());			
				String retValue = "chat"+","+chatting.getFromName()+","+chatting.getId();
				if(fromUser != null && fromUser.getRingToneUrl() != null)
					retValue += ","+fromUser.getRingToneUrl();
				return retValue;
			}
		}
		return "<b/>";
	}
	
	public Object chatWithBuddy(HttpServletRequest request, HttpServletResponse response) throws Exception{			
		long buddyUserId = Long.parseLong(request.getParameter("userId"));
		long userId = this.getUser(request).getId();
		User user = this.getUserService(request).getUserById(buddyUserId);	
		if(user.getImprivacy() == 2){
			return user.getDisplayName()+",n";
		}
		if(this.getUserService(request).getUserBlockByUser(buddyUserId,userId) == null){			
			Chatting chatting = new Chatting(userId,buddyUserId);
			this.getPortalService(request).save(chatting);
			Chat chat = this.getChatService(request).getChatByUser(buddyUserId);
			ChattingRecord record = new ChattingRecord(chatting.getId(), "", "*** Waiting for "+user.getDisplayName()+" to accept.");				  
			this.getChatService(request).save(record);
			return user.getDisplayName()+","+chatting.getId();
		}else{
			return user.getDisplayName()+","+0;
		}
	}
	
	public Object chatWithProfile(HttpServletRequest request, HttpServletResponse response) throws Exception{			
		User user = this.getVisitedUser(request);
		long buddyUserId = user.getId();
		long userId = this.getUser(request).getId();
		if(user.getImprivacy() == 2){
			return user.getDisplayName()+",n";
		}
		if(user.getImprivacy() == 1 && this.getChatService(request).getChatBuddy(buddyUserId,userId) == null){
			return user.getDisplayName()+",f";
		}
		if(this.getUserService(request).getUserBlockByUser(buddyUserId,userId) == null){
			Chatting chatting = new Chatting(userId,buddyUserId);
			this.getPortalService(request).save(chatting);
			Chat chat = this.getChatService(request).getChatByUser(buddyUserId);
			ChattingRecord record = new ChattingRecord(chatting.getId(), "", "*** Waiting for "+user.getDisplayName()+" to accept.");				  
			this.getChatService(request).save(record);
			return user.getDisplayName()+","+chatting.getId();
		}else{
			return user.getDisplayName()+","+0;
		}
	}
	
	public Object chatWithMember(HttpServletRequest request, HttpServletResponse response) throws Exception{			
		long memberId = Long.parseLong(request.getParameter("userId"));
		User user = this.getUserService(request).getUserById(memberId);
		long userId = this.getUser(request).getId();
		if(user.getImprivacy() == 2){
			return user.getDisplayName()+",n";
		}
		if(user.getImprivacy() == 1 && this.getChatService(request).getChatBuddy(memberId,userId) == null){
			return user.getDisplayName()+",f";
		}
		if(this.getUserService(request).getUserBlockByUser(memberId,userId) == null){
			Chatting chatting = new Chatting(userId,memberId);
			this.getPortalService(request).save(chatting);
			Chat chat = this.getChatService(request).getChatByUser(memberId);
			ChattingRecord record = new ChattingRecord(chatting.getId(), "", "*** Waiting for "+user.getDisplayName()+" to accept.");				  
			this.getChatService(request).save(record);
			return user.getDisplayName()+","+chatting.getId();
		}else{
			return user.getDisplayName()+","+0;
		}
	}
	
	public Object acceptChat(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String chattingId = request.getParameter("chattingId");
		int id = Integer.parseInt(chattingId);
		User user = this.getUser(request);
		ChattingRecord record = new ChattingRecord(id, "", "*** "+user.getDisplayName()+"'s IM window is open.");				  
		this.getChatService(request).save(record);
		return null;
	}
	
	public Object refuseChat(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String chattingId = request.getParameter("chattingId");
		int id = Integer.parseInt(chattingId);
		User user = this.getUser(request);
		ChattingRecord record = new ChattingRecord(id, "", "*** "+user.getDisplayName()+" refused to IM you.");				  
		this.getChatService(request).save(record);
		return null;
	}
	
	public Object closeChat(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String chattingId = request.getParameter("chattingId");
		int id = Integer.parseInt(chattingId);
		User user = this.getUser(request);
		ChattingRecord record = new ChattingRecord(id, "", "*** "+user.getDisplayName()+"'s IM window is closed.");				  
		this.getChatService(request).save(record);
		return null;
	}
	
	public Object addFriendRequest(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String sbuddyId = request.getParameter("buddyId");
		long buddyId = 0;
		if(sbuddyId == null || sbuddyId.equals("0"))
			buddyId= this.getVisitedUser(request).getId();
		else
			buddyId= Long.parseLong(sbuddyId);
		if(buddyId > 0 && this.getUser(request) != null){
			if(this.getChatService(request).getChatBuddy(buddyId,this.getUser(request).getId()) == null){
				UserFriendRequest friendRequest = new
				UserFriendRequest(buddyId,this.getUser(request).getId());
				this.getChatService(request).save(friendRequest);
			}
		}
		return request.getParameter("responseId");
	}
		
	public Object addToFavorites(HttpServletRequest request, HttpServletResponse response) throws Exception{		
		User user = this.getVisitedUser(request);
		UserFavourite userFavourite = new UserFavourite(this.getUser(request).getId(),user.getId());				  
		this.getChatService(request).save(userFavourite);
		return request.getParameter("responseId");
	}
	
	public Object forwardToFriends(HttpServletRequest request, HttpServletResponse response) throws Exception{		
		User visitor = this.getVisitedUser(request);
		User user = this.getUser(request);
        if(visitor != null && user != null){
            List<Connection> userFriends =this.getChatService(request).getBuddysByUser(user.getId());
            StringBuffer content = new StringBuffer();
            content.append("<table border='0' cellpadding='0' cellspacing='0' width='100%'>")
            	   .append("<tr>")
            	   .append("<td class='portlet-table-td-center' width='60%' style='padding-top:10px'>")
            	   .append("<a href='http://www."+OrganizationThreadLocal.getOrg().getSpace()+visitor.getUri()+ "' >")
            	   ;
            if(visitor.getPhotoUrl() == null){
            	content.append("<img src='")
            		   .append(request.getContextPath())
            		   .append("/light/images/no_pic.gif' style='border: 0px;'  align='middle' width='75' height='75'/>");
            }else{
            	content.append("<img src='")
            		   .append(request.getContextPath())
            		   .append(visitor.getPhotoUrl())
            		   .append("' style='border: 0px;'  align='middle' width='")
            		   .append(visitor.getPhotoSmallWidth())
            		   .append("' height='")
            		   .append(visitor.getPhotoSmallHeight())
            		   .append("'/>");
            }
            content.append("</a>")
            		.append("<br/>")
            		.append("<span class='portlet-item'>")
            		.append("<a href='http://www."+OrganizationThreadLocal.getOrg().getSpace()+visitor.getUri()+ "' >")
            		.append(visitor.getName())
            		.append("</a>")
            		.append("</span>")
            		.append("</td>")
            		.append("</tr>")
            		.append("</table>")
            		;
            
            for(Connection friend : userFriends){
                Message message = new Message(user.getDisplayName()+" send you a Member link."
                	   ,content.toString()
             		   ,friend.getBuddyUserId(),user.getId());
                this.getUserService(request).sendMessage(message);
            }
        }
        return request.getParameter("responseId");
	}
	 
	public Object blockUser(HttpServletRequest request, HttpServletResponse response) throws Exception{		
		User user = this.getVisitedUser(request);
		if(this.getUserService(request).getUserBlockByUser(this.getUser(request).getId(),user.getId()) == null){
			UserBlock userBlock = new UserBlock(this.getUser(request).getId(),user.getId());				  
			this.getChatService(request).save(userBlock);
		}
		return request.getParameter("responseId");
	}
	public Object deleteBuddy(HttpServletRequest request, HttpServletResponse response) throws Exception{			
		long buddyUserId = Long.parseLong(request.getParameter("userId"));
		Connection buddy = this.getChatService(request).getChatBuddy(this.getUser(request).getId(),buddyUserId);
		this.getChatService(request).delete(buddy);
		return (String)request.getParameter("responseId");
	}
		
	public Object saveBuddyType(HttpServletRequest request, HttpServletResponse response) throws Exception{			
		long buddyUserId = Long.parseLong(request.getParameter("userId"));
		String type = request.getParameter("type");
		Connection buddy = this.getChatService(request).getChatBuddy(this.getUser(request).getId(),buddyUserId);
		if(buddy != null && type != null){
			buddy.setType(Integer.parseInt(type));
			this.getChatService(request).save(buddy);
		}		
		return (String)request.getParameter("responseId");
	}
}

