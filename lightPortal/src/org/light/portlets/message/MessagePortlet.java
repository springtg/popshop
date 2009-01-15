package org.light.portlets.message;

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
import org.light.portal.model.UserComments;
import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portlets.connection.Connection;
import org.light.portlets.forum.Forum;
import org.light.portlets.forum.ForumCategory;
import org.light.portlets.group.UserGroup;

public class MessagePortlet extends LightGenericPortlet {
		 
		 public void processAction (ActionRequest request, ActionResponse response) 
		    throws PortletException, java.io.IOException {
			String action = request.getParameter("action");
			if("save".equals(action)){
			   String to = request.getParameter("to");
			   String subject = request.getParameter("subject");
			   String content = request.getParameter("content");
			   if(subject == null || subject.length() <= 0 || to == null || to.length() <= 0 ){
				   request.setAttribute("error","Message's to and subject are required field.");
				   response.setPortletMode(PortletMode.EDIT);
				   return;
			   }
			   long toUserId = 0;
			   if(to != null) toUserId = Long.parseLong(to);	
			   if(subject != null) subject = URLDecoder.decode(subject,_CHARSET_UTF);		   	
			   if(content != null) content = URLDecoder.decode(content,_CHARSET_UTF).replaceAll("\n","").trim();;
			   Message message = new Message(subject,content,toUserId,this.getUser(request).getId());
			   this.getUserService(request).sendMessage(message);
			}
			else if("reply".equals(action)){
				response.setPortletMode(PortletMode.EDIT);
			}
			else if("forward".equals(action)){
				response.setPortletMode(PortletMode.EDIT);
			}
			else if("approve".equals(action)){
				String id = request.getParameter("parameter");
				Message message = this.getUserService(request).getMessageById(Integer.parseInt(id));
				if(message != null){
					//group
					if(message.getEvent() ==1){
					  //invite me
					  if(message.getType() ==1){
						  UserGroup userGroup = new UserGroup(this.getUser(request).getId(),message.getEventId());
						  this.getPortalService(request).save(userGroup);
					  }
					  //member request
					  if(message.getType() ==2){
						  UserGroup userGroup = new UserGroup(message.getPostById(),message.getEventId());
						  this.getPortalService(request).save(userGroup);
					  }
					}
					//TODO:calendar
					if(message.getEvent() ==2){
						
					}
					//comments
					if(message.getEvent() ==3){
						UserComments comments = this.getUserService(request).getUserCommentsById(message.getEventId());
						comments.setStatus(1);
						this.getPortalService(request).save(comments);
					}
					//forum category
					if(message.getEvent() ==4){
						ForumCategory forumCategory = this.getForumService(request).getForumCategoryById(message.getEventId());
						forumCategory.setStatus(1);
						this.getPortalService(request).save(forumCategory);
					}
					//forum sub category
					if(message.getEvent() ==5){
						Forum forumSubCategory = this.getForumService(request).getForumById(message.getEventId());
						forumSubCategory.setStatus(1);
						this.getPortalService(request).save(forumSubCategory);
					}
					this.getPortalService(request).delete(message);	
				}
			}
			else if("deny".equals(action)){
				String id = request.getParameter("parameter");
				Message message = this.getUserService(request).getMessageById(Integer.parseInt(id));
				if(message != null){
					//group
					if(message.getEvent() ==1){
					  //invite me
					  if(message.getType() ==1){
						  
					  }
					  //member request
					  if(message.getType() ==2){
						  
					  }
					}
					//TODO:calendar
					if(message.getEvent() ==2){
							
					}
					//comments
					if(message.getEvent() ==3){
						UserComments comments = this.getUserService(request).getUserCommentsById(message.getEventId());						
						this.getPortalService(request).delete(comments);
					}
					//forum category
					if(message.getEvent() ==4){
						ForumCategory forumCategory = this.getForumService(request).getForumCategoryById(message.getEventId());
						this.getPortalService(request).delete(forumCategory);
					}
					//forum sub category
					if(message.getEvent() ==5){
						Forum forumSubCategory = this.getForumService(request).getForumById(message.getEventId());
						this.getPortalService(request).delete(forumSubCategory);
					}
					this.getPortalService(request).delete(message);	
				}				
			}
			else if("delete".equals(action)){
				String id = request.getParameter("parameter");
				Message message = this.getUserService(request).getMessageById(Integer.parseInt(id));
				if(message != null){
					this.getPortalService(request).delete(message);	
				}
			}
			else{
				 String showHtmlEditor = request.getParameter("htmlEditor");
				 if(showHtmlEditor != null)
					 request.setAttribute("showHtmlEditor",true);
				 String to = request.getParameter("to");
				 if(to != null){
					 to = URLDecoder.decode(to,_CHARSET_UTF);		   	
					 request.setAttribute("toUser",to);
				 }
				 String toUserName = request.getParameter("toUserName");
				 if(toUserName != null){
					 toUserName = URLDecoder.decode(toUserName,_CHARSET_UTF);		
					 request.setAttribute("toUserName",toUserName);
				 }
				 String subject = request.getParameter("subject");
				 if(subject != null){
					 subject = URLDecoder.decode(subject,_CHARSET_UTF);		   			   
					 request.setAttribute("subject",subject);
				 }
				 String content = request.getParameter("content");
				 if(content != null){
					 content = URLDecoder.decode(content,_CHARSET_UTF);
					 request.setAttribute("content",content);
				 }			 			 
			}
		  }
		 
		 
		 protected void doView (RenderRequest request, RenderResponse response)
		   throws PortletException, java.io.IOException
		 {
			 String messageId = request.getParameter("messageId");
			 String type = request.getParameter("type");
			 if(!"sent".equals(type))			    
				 type = "in";
			 request.setAttribute("type",type);
			 
			 if(messageId != null){
				 Message message = this.getUserService(request).getMessageById(Integer.parseInt(messageId));
				 request.setAttribute("message",message);
				 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/message/messagePortletDetailView.jsp").include(request,response);
				 return;
			 }
			 User user = this.getUser(request);		     
			 			 
			 List<Message> messages = null;
			 if("sent".equals(type))
			     messages =this.getUserService(request).getMessagesBySender(user.getId());
			 else{
				 messages =this.getUserService(request).getMessagesByUser(user.getId()); 
			 }				 
			 request.setAttribute("messages",messages);
			 
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/message/messagePortletView.jsp").include(request,response);
		 }	

		 protected void doEdit (RenderRequest request, RenderResponse response)
		   throws PortletException, java.io.IOException
		 {   
			 String subject = (String)request.getAttribute("subject");			 
			 String content = (String)request.getAttribute("content");
			 if(request.getParameter("visit") != null && this.getVisitedUser(request) != null){
				User user = this.getVisitedUser(request);
				request.setAttribute("toUser",user.getId());
				request.setAttribute("toUserName",user.getDisplayName());
			 }
			 if(request.getParameter("member") != null && request.getParameter("userId") != null){
					User user = this.getUserService(request).getUserById(Long.parseLong(request.getParameter("userId")));
					request.setAttribute("toUser",user.getId());
					request.setAttribute("toUserName",user.getDisplayName());
				 }
			 if(request.getParameter("forward") != null && this.getVisitedUser(request) != null){
				User user = this.getVisitedUser(request);
				subject="Please take a look at my friend's profile";
				content="Check this link: <a href=\"http://www.myportal.com/person/"+user.getUri()+"\">http://www.myportal.com/person/"+user.getUri()+"</a>";				
			 }
			 if(request.getParameter("parameter") != null){
				String action = request.getParameter("action"); 
			    String id = request.getParameter("parameter");
				Message message = this.getUserService(request).getMessageById(Integer.parseInt(id));
				if("reply".equals(action)){
					request.setAttribute("toUser",message.getPostById());
					request.setAttribute("toUserName",message.getFromDisplayName());					
					subject="Re: "+message.getSubject();
					content = message.getContent();
				}else if("forward".equals(action)){					
					subject="Fwd: "+message.getSubject();
					content = message.getContent();
				}else{
				}
			 }	
			 List<Connection> buddys = this.getChatService(request).getBuddysByUser(this.getUser(request).getId());
			 request.setAttribute("buddys",buddys); 	
			 request.setAttribute("subject",subject);
			 request.setAttribute("content",content);
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/message/messagePortletEdit.jsp").include(request,response);
		 }

}
