package org.light.portlets.forum.action;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.light.portal.core.PortalContextFactory;
import org.light.portal.core.action.BaseAction;
import org.light.portal.model.PopularItem;
import org.light.portal.model.User;
import org.light.portal.util.OrganizationThreadLocal;
import org.light.portlets.bookmark.Bookmark;
import org.light.portlets.connection.Connection;
import org.light.portlets.forum.ForumPost;
import org.light.portlets.forum.ForumCategory;
import org.light.portlets.forum.Forum;
import org.light.portlets.message.Message;

public class ForumAction extends BaseAction{
	
	public Object getForumDesc(HttpServletRequest request, HttpServletResponse response) throws Exception{			
		 String index = request.getParameter("index");
		 int id = Integer.parseInt(index);
		 String content= null;
		 ForumPost forum = this.getForumService(request).getPostById(id);
		 if(forum != null) content = forum.getContent();
		 if(content == null || content.equals("")) content="this forum's content is unavaliable.";
		 return content;	
	}
	
	public Object getForumDetail(HttpServletRequest request, HttpServletResponse response) throws Exception{			
		 String index = request.getParameter("index");
		 int id = Integer.parseInt(index);
		 String responseId = request.getParameter("responseId");
		 StringBuffer content= new StringBuffer();
		 ForumPost forum = this.getForumService(request).getPostById(id);
		 if(forum != null) {
			 content.append("<span title='"+PortalContextFactory.getPortalContext().getMessageByKey("portlet.button.close")+"'  width='100%' style='clear: both;  display: block; text-align:right;'><a href='javascript:void(0);' onclick='javascript:hideForumDetail();'><img src='"+request.getContextPath()+"/light/images/close_on.gif' style='border: 0px;'/></a></span>")
			 		.append("<table border='0' cellpadding='0' cellspacing='0' >")
		 			.append("<tr>")
					.append("<td class='portlet-table-td-left'>")
					.append(forum.getTopic())
					.append("</td>")
					.append("</tr>")
					.append("<tr>")
					.append("<td class='portlet-table-td-left'>")
					.append("Posted by: "+forum.getDisplayName() + " on "+forum.getFullDate())
					.append("</td>")
					.append("</tr>")
					.append("<tr>")
					.append("<td class='portlet-table-td-left'>")
					.append("<span>"+forum.getContent()+"</span>")
					.append("</td>")
					.append("</tr>")
					.append("<tr>")
					.append("<td class='portlet-table-td-right'>")
					.append("<input type='button' value='"+PortalContextFactory.getPortalContext().getMessageByKey("portlet.button.reply")+"'")
					.append(" onclick='javascript:replyForum(\""+forum.getId()+"\",\""+forum.getTopId()+"\",\"Re: "+forum.getTopic()+"\",\""+responseId+"\");' class='portlet-form-button'/>")
					.append("</td>")
					.append("</tr>")			  
					.append("</table>")
					; 					

		 }else
			 content.append("this forum's content is unavaliable.");
		 return content.toString();	
	}
	
	public Object saveForumReply(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String topic = request.getParameter("topic");
		String content = request.getParameter("content");
		String strParentId = request.getParameter("parentId");
		String strTopId = request.getParameter("topId");
		String subCategoryId = request.getParameter("subCategoryId");
		String categoryId = request.getParameter("categoryId");
		String responseId = request.getParameter("responseId");
		long parentId = Long.parseLong(strParentId);
		long topId = Long.parseLong(strTopId);
		if(topId == 0) topId = parentId;
		if(topic != null && topic.trim().length() > 0){
			ForumPost forum = new ForumPost(topic,content,topId,Long.parseLong(subCategoryId),Long.parseLong(categoryId),this.getUser(request).getId(),OrganizationThreadLocal.getOrganizationId());
			this.getPortalService(request).save(forum);
		}
		return responseId;
	}
	
	public Object popForumItem(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String id = request.getParameter("index");
        String pageId = request.getParameter("pageId");
        Forum forum = this.getForumService(request).getForumById(Integer.parseInt(id));
        if(forum != null){
        	ForumCategory category = this.getForumService(request).getForumCategoryById(forum.getCategoryId());		 
        	String title = category.getDisplayName()+"->"+forum.getDisplayName();
			String desc = category.getDisplayDesc()+"->"+forum.getDisplayDesc();
			String url = "http://www."+OrganizationThreadLocal.getOrg().getWebId()+"/viewforum.do?id="+forum.getId()+"p"+pageId;
            PopularItem item= this.getPortalService(request).getPopularItemByLink(OrganizationThreadLocal.getOrganizationId(),url);
            if(item == null){
            	String tag = "portlet.title.forum";
            	String locale = Locale.ENGLISH.toString(); 
                if(this.getUser(request) != null) locale = this.getUser(request).getRegion();  
                item = new PopularItem(url,title,desc,tag,locale,this.getUser(request).getId(),OrganizationThreadLocal.getOrganizationId());
            }else
                item.popIt();
            this.getPortalService(request).save(item);
        }
        return request.getParameter("responseId");
   }
	
	public Object popTopicItem(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String id = request.getParameter("index");
        String pageId = request.getParameter("pageId");
        ForumPost topic = this.getForumService(request).getPostById(Integer.parseInt(id));
		if(topic != null){			
			String desc = topic.getContent();
			String url = "http://www."+OrganizationThreadLocal.getOrg().getWebId()+"/viewtopic.do?id="+topic.getId()+"p"+pageId;
            PopularItem item= this.getPortalService(request).getPopularItemByLink(OrganizationThreadLocal.getOrganizationId(),url);
            if(item == null){
            	String tag = "portlet.title.forum";
            	String locale = Locale.ENGLISH.toString(); 
                if(this.getUser(request) != null) locale = this.getUser(request).getRegion();  
                item = new PopularItem(url,topic.getTopic(),desc,tag,locale,this.getUser(request).getId(),OrganizationThreadLocal.getOrganizationId());
            }else
                item.popIt();
            this.getPortalService(request).save(item);
        }
        return request.getParameter("responseId");
   }
	
	public Object forwardForumToFriend(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String id = request.getParameter("index");
		String pageId = request.getParameter("pageId");
        Forum forum = this.getForumService(request).getForumById(Integer.parseInt(id));
        if(forum != null){
        	ForumCategory category = this.getForumService(request).getForumCategoryById(forum.getCategoryId());		 
        	String title = category.getDisplayName()+"->"+forum.getDisplayName();
			String desc = category.getDisplayDesc()+"->"+forum.getDisplayDesc();
			String url = "http://www."+OrganizationThreadLocal.getOrg().getWebId()+"/viewforum.do?id="+forum.getId()+"p"+pageId;
			User user = this.getUser(request);
           if(user != null){
               List<Connection> userFriends =this.getChatService(request).getBuddysByUser(user.getId());               	              
               for(Connection friend : userFriends){
                   Message message = new Message(user.getDisplayName()+" send you a link.",
                           "<a href='"+url+"' target='_blank'>"+title+"</a><br/><br/>"+desc,friend.getBuddyUserId(),user.getId());
                   this.getUserService(request).sendMessage(message);
               }
           }
        }
        return request.getParameter("responseId"); 
		
   }
	
	public Object forwardTopicToFriend(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String id = request.getParameter("index");
		String pageId = request.getParameter("pageId");
        ForumPost topic = this.getForumService(request).getPostById(Integer.parseInt(id));
		if(topic != null){			
			String desc = topic.getContent();
			String url = "http://www."+OrganizationThreadLocal.getOrg().getWebId()+"/viewtopic.do?id="+topic.getId()+"p"+pageId;
			User user = this.getUser(request);
           if(user != null){
               List<Connection> userFriends =this.getChatService(request).getBuddysByUser(user.getId());               	              
               for(Connection friend : userFriends){
                   Message message = new Message(user.getDisplayName()+" send you a link.",
                           "<a href='"+url+"' target='_blank'>"+topic.getTopic()+"</a><br/><br/>"+desc,friend.getBuddyUserId(),user.getId());
                   this.getUserService(request).sendMessage(message);
               }
           }
        }
        return request.getParameter("responseId");
  }
	
	public Object saveForumToBookmark(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String id = request.getParameter("index");
		String pageId = request.getParameter("pageId");
        Forum forum = this.getForumService(request).getForumById(Integer.parseInt(id));
        if(forum != null){
        	ForumCategory category = this.getForumService(request).getForumCategoryById(forum.getCategoryId());		 
        	String title = category.getDisplayName()+"->"+forum.getDisplayName();
			String desc = category.getDisplayDesc()+"->"+forum.getDisplayDesc();
			String url = "http://www."+OrganizationThreadLocal.getOrg().getWebId()+"/viewforum.do?id="+forum.getId()+"p"+pageId;
			String tag = category.getDisplayName();	           
	           Bookmark bookmark = new Bookmark(title,url,category.getName(),tag,desc,this.getUser(request).getId());
	           this.getPortalService(request).save(bookmark);
	           request.getSession().removeAttribute("bookmarkTags");
			   request.getSession().removeAttribute("defaultBookmarks");	
        }
        return request.getParameter("responseId"); 
		
	   }
	
	public Object saveTopicToBookmark(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String id = request.getParameter("index");
		String pageId = request.getParameter("pageId");
        ForumPost topic = this.getForumService(request).getPostById(Integer.parseInt(id));
		if(topic != null){
			Forum forum = this.getForumService(request).getForumById(topic.getForumId());
			ForumCategory category = this.getForumService(request).getForumCategoryById(forum.getCategoryId());		 
        	
			String desc = topic.getContent();
			String url = "http://www."+OrganizationThreadLocal.getOrg().getWebId()+"/viewtopic.do?id="+topic.getId()+"p"+pageId;
			String tag = category.getDisplayName()+"->"+forum.getDisplayName();
			String tagId= category.getName()+"->"+forum.getName();
           Bookmark bookmark = new Bookmark(topic.getTopic(),url,tagId,tag,desc,this.getUser(request).getId());
           this.getPortalService(request).save(bookmark);
           request.getSession().removeAttribute("bookmarkTags");
		   request.getSession().removeAttribute("defaultBookmarks");	
        }
        return request.getParameter("responseId");
	}
}
