package org.light.portlets.group;

import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._MAX_ROW_PER_PAGE;
import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

import org.light.portal.model.PortletObject;
import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portlets.forum.ForumPost;

public class GroupForumPortlet extends LightGenericPortlet {
	 
	 public void processAction (ActionRequest request, ActionResponse response) 
	    throws PortletException, java.io.IOException {
		String action = request.getParameter("action");
		if("save".equals(action)){
		   String subject = request.getParameter("subject");
		   String content = request.getParameter("content");
		   if(subject == null || subject.length() <= 0 || content == null || content.length() <= 0){
			   request.setAttribute("error","Forum's subject and content are required field.");
			   response.setPortletMode(PortletMode.EDIT);
			   return;
		   }
		   if(subject != null) subject = URLDecoder.decode(subject,_CHARSET_UTF);		   	
		   if(content != null) content = URLDecoder.decode(content,_CHARSET_UTF);
		   Group group = this.getVisitedGroup(request);
		   GroupForum forum = new GroupForum(subject,content,0,group.getId(),this.getUser(request).getId());
		   this.getPortalService(request).save(forum);
		}else if("reply".equals(action)){
			   String topicId = request.getParameter("topicId");
			   Group group = this.getVisitedGroup(request);
			   String content = request.getParameter("content");
			   if(content == null || content.length() <= 0){
				   request.setAttribute("error","Forum's reply content is required field.");
				   response.setPortletMode(PortletMode.EDIT);
				   return;
			   }			   
			   if(content != null) content = URLDecoder.decode(content,_CHARSET_UTF);
			   GroupForum forum = new GroupForum(null,content,Long.parseLong(topicId),group.getId(),this.getUser(request).getId());
			   this.getPortalService(request).save(forum);
			   GroupForum topForum = this.getGroupService(request).getGroupForumById(Integer.parseInt(topicId));
			   topForum.setLastPostId(forum.getId());
			   topForum.setLstChgTm(forum.getCreateDate());
			   topForum.setLastPostById(forum.getPostById());
			   this.getPortalService(request).save(topForum);			   
		}else if("delete".equals(action)){
			String id = request.getParameter("parameter");
			GroupForum forum = this.getGroupService(request).getGroupForumById(Integer.parseInt(id));
			if(forum != null){
				this.getPortalService(request).delete(forum);	
				if(forum.getTopId() == 0){
					List<GroupForum> list = this.getGroupService(request).getGroupForumsByTopic(Integer.parseInt(id));
					for(GroupForum gf : list){
						this.getPortalService(request).delete(gf);	
					}
				}
			}
		}else if("deleteTopic".equals(action)){
			String id = request.getParameter("parameter");
			List<GroupForum> forums = this.getGroupService(request).getGroupForumsByTopic(Integer.parseInt(id));
			if(forums != null){
				for(GroupForum forum : forums)
					this.getPortalService(request).delete(forum);	
			}
		}else{
			 String topicId = request.getParameter("topicId");	
			 if(topicId != null)
				 request.setAttribute("topicId",topicId);
			 String showHtmlEditor = request.getParameter("htmlEditor");			 
			 if(showHtmlEditor != null)
				 request.setAttribute("showHtmlEditor",true);
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
		 String topicId = request.getParameter("topicId");
		 long groupId = 0;
	     if(this.getVisitedGroup(request) != null)
	    	 groupId = this.getVisitedGroup(request).getId();
	     else{
			 String id = request.getParameter("groupId");
			 if(id == null){
				 request.setAttribute("error", "System cannot find this group.");	
				 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/error/error.jsp").include(request,response);
				 return;
			 }
			 groupId = Integer.parseInt(id);
	     }
		 Group group = this.getGroupService(request).getGroupById(groupId);	 
		 request.setAttribute("group",group);
		 String pageId = request.getParameter("pageId");				 
		 String pages = request.getParameter("pages");
		 if(topicId == null){	
			 if(pageId == null){
			    int count = this.getGroupService(request).getTopicsCountByGroup(groupId);				    
			    pageId ="1";
			    int newPages = count / _MAX_ROW_PER_PAGE;
			    if( count % _MAX_ROW_PER_PAGE != 0)
			    	newPages++;
			    pages = String.valueOf(newPages);
			 }
			 request.setAttribute("pageId",Integer.parseInt(pageId));
			 request.setAttribute("pages",Integer.parseInt(pages));
			 List<GroupForum> list = this.getGroupService(request).getTopicsByGroup(groupId,Integer.parseInt(pageId) - 1,_MAX_ROW_PER_PAGE);
			 request.setAttribute("topLists",list);
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/group/forumPortletView.jsp").include(request,response);
		 }else{			 
			 if(pageId == null){
			    int count = this.getGroupService(request).getPostsCountByTopic(Integer.parseInt(topicId));				    
			    pageId ="1";
			    int newPages = count / _MAX_ROW_PER_PAGE;
			    if( count % _MAX_ROW_PER_PAGE != 0)
			    	newPages++;
			    pages = String.valueOf(newPages);
			 }
			 request.setAttribute("pageId",Integer.parseInt(pageId));
			 request.setAttribute("pages",Integer.parseInt(pages));	 
			 List<GroupForum> list = this.getGroupService(request).getPostsByTopic(Integer.parseInt(topicId),Integer.parseInt(pageId) - 1,_MAX_ROW_PER_PAGE);
			 
			 request.setAttribute("topicId",topicId);
			 request.setAttribute("forumLists",list);
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/group/forumPortletView.jsp").include(request,response);
		 }
		 
	 }	
	 
	 protected void doEdit (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {   
		 String forumId = request.getParameter("parameter");
		 if(forumId != null){
			 GroupForum forum = this.getGroupService(request).getGroupForumById(Integer.parseInt(forumId));
			 long topicId= forum.getTopId();
			 if(topicId == 0) topicId = forum.getId();
			 request.setAttribute("topicId",topicId);
			 String action = request.getParameter("action");
			 if("quote".equals(action)){
				 StringBuffer content = new StringBuffer();
				 content.append("<span class='portlet'>")
				        .append(forum.getDisplayName()+" wrote: ")
				        .append("<p/>")
				        .append(forum.getContent())
				        .append("</span>")
				        ;
				 request.setAttribute("content",content.toString());
			 }
			 
		 }
		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/group/forumPortletEdit.jsp").include(request,response);
	 }
	 
	 protected void doHelp (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {  		 
		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/group/forumPortletHelp.jsp").include(request,response);
	 }
}

