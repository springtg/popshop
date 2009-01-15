/* * Copyright (c) 2006 Jianmin Liu.
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
package org.light.portlets.forum;

import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._MAX_ROW_PER_PAGE;
import static org.light.portal.util.Constants._MESSAGE_EVENT_FORUM_CATEGORY;
import static org.light.portal.util.Constants._MESSAGE_EVENT_FORUM_SUB_CATEGORY;
import static org.light.portal.util.Constants._MESSAGE_EVENT_TYPE_REQUEST;
import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.net.URLDecoder;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.light.portal.model.User;
import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portal.util.OrganizationThreadLocal;
import org.light.portal.util.StringUtils;
import org.light.portlets.message.Message;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 14, 2006
 **/
public class ForumPortlet extends LightGenericPortlet {
	 
	 public void processAction (ActionRequest request, ActionResponse response) 
	    throws PortletException, java.io.IOException {
		String action = request.getParameter("action");
		if("save".equals(action)){
		   String topic = request.getParameter("topic");
		   String content = request.getParameter("content");
		   String forumId = request.getParameter("forumId");
		   String categoryId = request.getParameter("categoryId");
		   if(topic == null || topic.length() <= 0 || content == null || content.length() <= 0){
			   request.setAttribute("error","Forum's topic and content are required field.");
			   response.setPortletMode(PortletMode.EDIT);
			   return;
		   }
		   if(topic != null) topic = URLDecoder.decode(topic,_CHARSET_UTF);		   	
		   if(content != null) content = URLDecoder.decode(content,_CHARSET_UTF);
		   ForumPost forum = new ForumPost(topic,content,0,Long.parseLong(forumId),Long.parseLong(categoryId),this.getUser(request).getId(),OrganizationThreadLocal.getOrganizationId());
		   this.getPortalService(request).save(forum);
		}else if("reply".equals(action)){
			   String topicId = request.getParameter("topicId");			   
			   String content = request.getParameter("content");
			   if(content == null || content.length() <= 0){
				   request.setAttribute("error","Forum's reply content is required field.");
				   response.setPortletMode(PortletMode.EDIT);
				   return;
			   }			   			  
			   if(content != null) content = URLDecoder.decode(content,_CHARSET_UTF);
			   String forumId = request.getParameter("forumId");
			   String categoryId = request.getParameter("categoryId");
			   ForumPost forum = new ForumPost(null,content,Long.parseLong(topicId),Long.parseLong(forumId),Long.parseLong(categoryId),this.getUser(request).getId(),OrganizationThreadLocal.getOrganizationId());
			   this.getPortalService(request).save(forum);
			   ForumPost topForum = this.getForumService(request).getPostById(Integer.parseInt(topicId));
			   topForum.setLastPostId(forum.getId());
			   topForum.setLstChgTm(forum.getCreateDate());
			   topForum.setLastPostById(forum.getPostById());
			   this.getPortalService(request).save(topForum);			   
		}else if("category".equals(action)){
			   String category = request.getParameter("category");			   
			   String categoryDesc = request.getParameter("categoryDesc");
			   if(category == null || category.length() <= 0 || categoryDesc == null || categoryDesc.length() <= 0){
				   request.setAttribute("error","Forum's category and description are required fields.");
				   request.setAttribute("category",category);
				   request.setAttribute("categoryDesc",categoryDesc);
				   response.setPortletMode(PortletMode.EDIT);
				   response.setRenderParameter("add","category");
				   return;
			   }			   			  
			   if(category != null) category = URLDecoder.decode(category,_CHARSET_UTF);
			   if(categoryDesc != null) categoryDesc = URLDecoder.decode(categoryDesc,_CHARSET_UTF);
			   String locale = Locale.ENGLISH.toString(); 
               if(this.getUser(request) != null) locale = this.getUser(request).getRegion();  
			   ForumCategory forumCategory = new ForumCategory(category,categoryDesc,locale,OrganizationThreadLocal.getOrganizationId(),this.getUser(request).getId());
			   this.getPortalService(request).save(forumCategory);
			   User user= this.getUser(request);
			   Message message = new Message(
					   user.getDisplayName()+" want to add a forum category."
						 ,user.getDisplayName()+" want to add a forum category:"+
						  "<br/>Category :"+forumCategory.getName()+
						  "<br/>Category Desc:"+forumCategory.getDesc()						 
						 ,0,user.getId(),_MESSAGE_EVENT_FORUM_CATEGORY,_MESSAGE_EVENT_TYPE_REQUEST,forumCategory.getId());
			   this.getUserService(request).sendMessage(message);
			   request.setAttribute("success","Your new forum category request has been sent to admin successfully, waiting for approve.");
		}else if("sub".equals(action)){
			   String forum = request.getParameter("forum");			   
			   String forumDesc = request.getParameter("forumDesc");
			   String categoryId = request.getParameter("categoryId");
			   if(forum == null || forum.length() <= 0 ){
				   request.setAttribute("error","Forum's name is required field.");
				   request.setAttribute("forum",forum);
				   request.setAttribute("forumDesc",forum);
				   response.setPortletMode(PortletMode.EDIT);
				   request.setAttribute("categoryId",categoryId);
				   response.setRenderParameter("add","sub");
				   return;
			   }	
			   if(forum != null) forum = URLDecoder.decode(forum,_CHARSET_UTF);
			   if(forumDesc != null) forumDesc = URLDecoder.decode(forumDesc,_CHARSET_UTF);
			  			   
			   ForumCategory forumCategory = this.getForumService(request).getForumCategoryById(Integer.parseInt(categoryId));
			   Forum newForum = new Forum(forum,forumDesc,forumCategory,this.getUser(request).getId(),OrganizationThreadLocal.getOrganizationId());
			   this.getPortalService(request).save(newForum);
			   User user= this.getUser(request);
			   Message message = new Message(
						user.getDisplayName()+" want to add a forum sub category."
						 ,user.getDisplayName()+" want to add a forum sub category:"+
						  "<br/>Sub Category :"+newForum.getName()+
						  "<br/>Sub Category Desc:"+newForum.getDesc()+
						  "<br/>in Category:"+forumCategory.getDisplayName()+
						  "<br/> Category Desc:"+forumCategory.getDisplayDesc()
						 ,0,user.getId(),_MESSAGE_EVENT_FORUM_SUB_CATEGORY,_MESSAGE_EVENT_TYPE_REQUEST,newForum.getId());
			   this.getUserService(request).sendMessage(message);
			   request.setAttribute("success","Your new forum request has been sent to admin successfully, waiting for approve.");			   
		}else if("delete".equals(action)){
			String id = request.getParameter("parameter");
			ForumPost forum = this.getForumService(request).getPostById(Integer.parseInt(id));
			if(forum != null){
				this.getPortalService(request).delete(forum);	
			}
		}else if("deleteTopic".equals(action)){
			String id = request.getParameter("parameter");
			this.getForumService(request).deleteTopic(Integer.parseInt(id));
//			List<ForumPost> forums = this.getForumService(request).getPostsByTopic(Integer.parseInt(id));
//			if(forums != null){
//				for(ForumPost forum : forums)
//					this.getPortalService(request).delete(forum);	
//			}		
		}else{
			 String showHtmlEditor = request.getParameter("htmlEditor");
			 if(showHtmlEditor != null)
				 request.setAttribute("showHtmlEditor",true);
			 String topic = request.getParameter("topic");
			 if(topic != null){
				 topic = URLDecoder.decode(topic,_CHARSET_UTF);		   			   
				 request.setAttribute("topic",topic);
			 }
			 String content = request.getParameter("content");
			 if(content != null){
				 content = URLDecoder.decode(content,_CHARSET_UTF);
				 request.setAttribute("content",content);
			 }
			 String topicId = request.getParameter("topicId");
			 if(topicId != null){				 
				 request.setAttribute("topicId",topicId);
			 }
		}
	  }
	 
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
		 String categoryId = request.getParameter("categoryId");
		 String forumId = request.getParameter("forumId");
		 request.setAttribute("categoryId",categoryId);
		 request.setAttribute("forumId",forumId);
		 ForumCategory category = null;
		 Forum forum = null;
		 if(categoryId != null){
			 category = this.getForumService(request).getForumCategoryById(Long.parseLong(categoryId));
			 if(category != null){
				 request.setAttribute("categoryName",category.getDisplayName());
			 }
		 }
		 if(forumId != null){
			 forum = this.getForumService(request).getForumById(Integer.parseInt(forumId));
			 if(forum != null){
				 request.setAttribute("forumName",forum.getDisplayName());
			 }
		 }
		 if(categoryId == null && forumId == null){
			 String locale = Locale.ENGLISH.toString(); 
             if(this.getUser(request) != null) locale = this.getUser(request).getRegion();  
			 List<ForumCategory> listCategory = this.getForumService(request).getForumCategories(locale,OrganizationThreadLocal.getOrganizationId());
			 request.setAttribute("forumCategories",listCategory);
			 if(listCategory != null && listCategory.size() == 1){				 
				 viewForum(request,response,listCategory.get(0));
			 }else
				 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/forum/forumPortletViewCategories.jsp").include(request,response);
		 }else if(categoryId != null && forumId == null){
			 viewForum(request,response,category);
		 }else if(forumId != null){
			 viewTopic(request,response,forum);		 
		 }
	 }	
	 
	 protected void doEdit (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {  		 
		 String forumId = request.getParameter("forumId");
		 String categoryId = request.getParameter("categoryId");
		 request.setAttribute("categoryId",categoryId);
		 request.setAttribute("forumId",forumId);
		 if(categoryId != null){
			 ForumCategory category = this.getForumService(request).getForumCategoryById(Integer.parseInt(categoryId));
			 if(category != null){
				 request.setAttribute("categoryName",category.getDisplayName());
			 }
		 }
		 if(!StringUtils.isEmpty(forumId)){
			 Forum forum = this.getForumService(request).getForumById(Long.parseLong(forumId));
			 if(forum != null){
				 request.setAttribute("forumName",forum.getDisplayName());
			 }
		 }
		 String action = request.getParameter("action");
		 if("category".equals(action)){
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/forum/forumPortletAddCategory.jsp").include(request,response);
		 }else if("sub".equals(action)){
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/forum/forumPortletAddForum.jsp").include(request,response);
		 }else{
			 String postId = request.getParameter("parameter");
			 if(postId != null){
				 ForumPost post = this.getForumService(request).getPostById(Integer.parseInt(postId));
				 long topicId= post.getTopId();
				 if(topicId == 0) topicId = post.getId();
				 request.setAttribute("topicId",topicId);			 
				 if("quote".equals(action)){
					 StringBuffer content = new StringBuffer();
					 content.append("<span class='portlet'>")
					        .append(post.getDisplayName()+" wrote: ")
					        .append("<p/>")
					        .append(post.getContent())
					        .append("</span>")
					        ;
					 request.setAttribute("content",content.toString());
				 }
				 
			 }
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/forum/forumPortletEdit.jsp").include(request,response);
		 }
	 }
	 
	 protected void doHelp (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {  		 
		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/forum/forumPortletHelp.jsp").include(request,response);
	 }
	 
	 private void viewForum (RenderRequest request, RenderResponse response,ForumCategory category)
	  throws PortletException, java.io.IOException
	 {
		 if(category != null){
			 request.setAttribute("categoryId",category.getId());
			 request.setAttribute("categoryName",category.getDisplayName());
			 List<Forum> listForum = this.getForumService(request).getForumByCategory(category.getId());		 
			 request.setAttribute("forumLists",listForum);
			 if(listForum != null && listForum.size() == 1){				 
				 viewTopic(request,response,listForum.get(0));
			 }
			 else
				 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/forum/forumPortletViewCategory.jsp").include(request,response);
		 }
	 }
	 
	 private void viewTopic (RenderRequest request, RenderResponse response,Forum forum)
	  throws PortletException, java.io.IOException
	 {
		 if(forum != null){
			 request.setAttribute("forumName",forum.getDisplayName());
			 request.setAttribute("forumId",forum.getId());
			 String topicId = request.getParameter("topicId");	
			 if(topicId == null){
				 String pageId = request.getParameter("pageId");				 
				 String pages = request.getParameter("pages");
				 if(pageId == null){
				    int count = this.getForumService(request).getTopicsCountByForum(forum.getId());				    
				    pageId ="1";
				    int newPages = count / _MAX_ROW_PER_PAGE;
				    if( count % _MAX_ROW_PER_PAGE != 0)
				    	newPages++;
				    pages = String.valueOf(newPages);
				 }
				 request.setAttribute("pageId",Integer.parseInt(pageId));
				 request.setAttribute("pages",Integer.parseInt(pages));
				 List<ForumPost> list = this.getForumService(request).getTopicsByForum(forum.getId(),Integer.parseInt(pageId) - 1,_MAX_ROW_PER_PAGE);
				 request.setAttribute("topicLists",list);
				 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/forum/forumPortletViewForum.jsp").include(request,response);
			 }else{
				 String pageId = request.getParameter("pageId");				 
				 String pages = request.getParameter("pages");
				 if(pageId == null){
				    int count = this.getForumService(request).getPostsCountByTopic(Long.parseLong(topicId));				    
				    pageId ="1";
				    int newPages = count / _MAX_ROW_PER_PAGE;
				    if( count % _MAX_ROW_PER_PAGE != 0)
				    	newPages++;
				    pages = String.valueOf(newPages);
				 }
				 request.setAttribute("pageId",Integer.parseInt(pageId));
				 request.setAttribute("pages",Integer.parseInt(pages));
				 List<ForumPost> list = this.getForumService(request).getPostsByTopic(Long.parseLong(topicId),Integer.parseInt(pageId) - 1,_MAX_ROW_PER_PAGE);
				 if(list != null && list.size() > 0) request.setAttribute("topicName",list.get(0).getTopic());
				 request.setAttribute("topicId",topicId);
				 request.setAttribute("postLists",list);
				 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/forum/forumPortletViewTopic.jsp").include(request,response);
			 }
		 }
	 }
}
