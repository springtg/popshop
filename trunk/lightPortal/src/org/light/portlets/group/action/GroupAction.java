package org.light.portlets.group.action;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.light.portal.core.action.BaseAction;
import org.light.portal.model.PopularItem;
import org.light.portal.model.User;
import org.light.portal.util.OrganizationThreadLocal;
import org.light.portlets.bookmark.Bookmark;
import org.light.portlets.connection.Connection;
import org.light.portlets.forum.Forum;
import org.light.portlets.forum.ForumCategory;
import org.light.portlets.forum.ForumPost;
import org.light.portlets.group.Group;
import org.light.portlets.group.GroupForum;
import org.light.portlets.group.UserGroup;
import org.light.portlets.message.Message;
import static org.light.portal.util.Constants.*;

public class GroupAction extends BaseAction{
	
	public Object validateGroupUri(HttpServletRequest request, HttpServletResponse response) throws Exception{			
		 String uri = request.getParameter("uri");		 
		 Group group = this.getGroupService(request).getGroupByUri(uri,OrganizationThreadLocal.getOrganizationId());
		 if(group != null){			
			return 1;			 
		 }			 
		 return 0;	
	}
	
	public Object joinToGroup(HttpServletRequest request, HttpServletResponse response) throws Exception{
		 String responseId = request.getParameter("responseId");
		 if(this.getUser(request) == null)
			 return "9;"+responseId;
		 Group group =  this.getVisitedGroup(request);
		 if(group == null){
			 String groupId = request.getParameter("groupId");			
			 int id = Integer.parseInt(groupId);
			 group = this.getGroupService(request).getGroupById(id);
		 }
		 if(group != null){
			 if(group.getOpenJoin() == 1){
				 List<UserGroup> userGroups = this.getGroupService(request).getUserGroup(this.getUser(request).getId(),group.getId());
				 if(userGroups == null || userGroups.size() == 0){
					 UserGroup userGroup = new UserGroup(this.getUser(request).getId(),group.getId());
					 this.getPortalService(request).save(userGroup);
					 return "1;"+responseId;
				 }else{
					 return "2;"+responseId;
				 }
			 }
			 if(group.getOpenJoin() == 0){		
				 //send request message to the owner.
				 User user = this.getUser(request);
				 Message message = new Message(
						 user.getDisplayName()+" request to join to the group "+group.getDisplayName()
						 ,user.getDisplayName()+" request to join to the group "+group.getDisplayName()
						 ,group.getOwnerId(),user.getId(),_MESSAGE_EVENT_GROUP,_MESSAGE_EVENT_TYPE_REQUEST,group.getId());
				 this.getUserService(request).sendMessage(message);
				 return "3;"+responseId;
			 }
			 
		 }			 
		 return "0;"+responseId;	
	}
	
	public Object inviteToGroup(HttpServletRequest request, HttpServletResponse response) throws Exception{			
		 String groupId = request.getParameter("groupId");
		 String responseId = request.getParameter("responseId");
		 int id = Integer.parseInt(groupId);
		 Group group = this.getGroupService(request).getGroupById(id);
		 StringBuffer friendNames=new StringBuffer("<br/>");
		 if(group != null){
			 User user = this.getUser(request);
			 String friends = request.getParameter("friends");
			 if(friends != null){
				 String[] friendArray = friends.split(";");				 
				 //send invite message to friends.
				 for(int i=0;i<friendArray.length;i++){					 
					 Message message = new Message(
							 user.getDisplayName()+" would like to invite you to join the group "+group.getDisplayName()
							 ,user.getDisplayName()+" would like to invite you to join the group "+group.getDisplayName()							 
							 ,Long.parseLong(friendArray[i]),this.getUser(request).getId(),_MESSAGE_EVENT_GROUP,_MESSAGE_EVENT_TYPE_INVITE,group.getId());
					 this.getUserService(request).sendMessage(message);
					 User f = this.getUserService(request).getUserByUserId(friendArray[i],OrganizationThreadLocal.getOrganizationId());
					 friendNames.append(f.getDisplayName())
					            .append("<br/>");
					 
				 }
			 }
			 
		 }			 
		 return friendNames.toString()+";"+responseId;	
	}
	
	public Object resignGroup(HttpServletRequest request, HttpServletResponse response) throws Exception{			
		 String groupId = request.getParameter("groupId");
		 String responseId = request.getParameter("responseId");
		 int id = Integer.parseInt(groupId);
		 List<UserGroup> userGroup = this.getGroupService(request).getUserGroup(this.getUser(request).getId(),id);
		 if(userGroup != null){
			 for(UserGroup ug : userGroup){
				 this.getPortalService(request).delete(ug);
			 }
		 }
		 return responseId;	
	}
	
	public Object getGroupPrivacy(HttpServletRequest request, HttpServletResponse response) throws Exception{			
		 String groupId = request.getParameter("groupId");		 
		 long id = Long.parseLong(groupId);
		 List<UserGroup> userGroup = this.getGroupService(request).getUserGroup(this.getUser(request).getId(),id);
		 if(userGroup != null && userGroup.size() > 0){
			 groupId+=";"+userGroup.get(0).getAcceptLeaderBulletin()+";"+userGroup.get(0).getAcceptMembersBulletin();
		 }
		 return groupId;	
	}
	
	public Object saveGroupPrivacy(HttpServletRequest request, HttpServletResponse response) throws Exception{			
		 String groupId = request.getParameter("groupId");		 
		 long id = Long.parseLong(groupId);
		 List<UserGroup> userGroups = this.getGroupService(request).getUserGroup(this.getUser(request).getId(),id);
		 if(userGroups != null && userGroups.size() > 0){
			 UserGroup userGroup = userGroups.get(0);
			 if(request.getParameter("lBulletin") != null)
			    userGroup.setAcceptLeaderBulletin(1);
			 else
				 userGroup.setAcceptLeaderBulletin(0);
			 if(request.getParameter("mBulletin") != null)
			    userGroup.setAcceptMembersBulletin(1);
			 else
				userGroup.setAcceptMembersBulletin(0);
			 this.getPortalService(request).save(userGroup);
		 }
		 return groupId;	
	}
	
	public Object deleteGroupProfile(HttpServletRequest request, HttpServletResponse response) throws Exception{			
		 String groupId = request.getParameter("groupId");	
		 String responseId = request.getParameter("responseId");
		 long id = Long.parseLong(groupId);
		 List<UserGroup> userGroup = this.getGroupService(request).getUserGroup(this.getUser(request).getId(),id);
		 if(userGroup != null && userGroup.size() > 1){
			 groupId="0";
		 }else{
			 Group group = this.getGroupService(request).getGroupById(id);
			 this.getPortalService(request).delete(group);
			 for(UserGroup ug : userGroup)
				 this.getPortalService(request).delete(ug);
			 
		 }
		 return groupId+";"+responseId;	
	}
	public Object popGroupForumItem(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String id = request.getParameter("index");
        String pageId = request.getParameter("pageId");
        Group group = this.getGroupService(request).getGroupById(Integer.parseInt(id));
        if(group != null){        		 
        	String title = group.getDisplayName();
			String desc = group.getShortDesc();
			String url = "http://www."+OrganizationThreadLocal.getOrg().getWebId()+"/groupforum.do?id="+group.getId()+"p"+pageId;
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
	
	public Object popGroupTopicItem(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String id = request.getParameter("index");
        String pageId = request.getParameter("pageId");
        GroupForum topic = this.getGroupService(request).getGroupForumById(Integer.parseInt(id));        
		if(topic != null){			
			String desc = topic.getContent();
			String url = "http://www."+OrganizationThreadLocal.getOrg().getWebId()+"/grouptopic.do?id="+topic.getId()+"p"+pageId;
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
	
	public Object forwardGroupForumToFriend(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String id = request.getParameter("index");
		String pageId = request.getParameter("pageId");
		Group group = this.getGroupService(request).getGroupById(Integer.parseInt(id));
        if(group != null){        		 
        	String title = group.getDisplayName();
			String desc = group.getShortDesc();
			String url = "http://www."+OrganizationThreadLocal.getOrg().getWebId()+"/groupforum.do?id="+group.getId()+"p"+pageId;
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
	
	public Object forwardGroupTopicToFriend(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String id = request.getParameter("index");
		String pageId = request.getParameter("pageId");
		GroupForum topic = this.getGroupService(request).getGroupForumById(Integer.parseInt(id));        
		if(topic != null){			
			String desc = topic.getContent();
			String url = "http://www."+OrganizationThreadLocal.getOrg().getWebId()+"/grouptopic.do?id="+topic.getId()+"p"+pageId;
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
	
	public Object saveGroupForumToBookmark(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String id = request.getParameter("index");
		String pageId = request.getParameter("pageId");
		Group group = this.getGroupService(request).getGroupById(Integer.parseInt(id));
        if(group != null){        		 
        	String title = group.getDisplayName();
			String desc = group.getShortDesc();
			String url = "http://www."+OrganizationThreadLocal.getOrg().getWebId()+"/groupforum.do?id="+group.getId()+"p"+pageId;
			String tag = group.getCategoryName();	           
	           Bookmark bookmark = new Bookmark(title,url,group.getCategory(),tag,desc,this.getUser(request).getId());
	           this.getPortalService(request).save(bookmark);
	           request.getSession().removeAttribute("bookmarkTags");
			   request.getSession().removeAttribute("defaultBookmarks");	
        }
        return request.getParameter("responseId"); 
		
	   }
	
	public Object saveGroupTopicToBookmark(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String id = request.getParameter("index");
		String pageId = request.getParameter("pageId");
		GroupForum topic = this.getGroupService(request).getGroupForumById(Integer.parseInt(id));        
		if(topic != null){		
			Group group = this.getGroupService(request).getGroupById(topic.getId());
			String desc = topic.getContent();
			String url = "http://www."+OrganizationThreadLocal.getOrg().getWebId()+"/grouptopic.do?id="+topic.getId()+"p"+pageId;
			String tag = group.getDisplayName();
			String tagId= "group"+group.getId();
           Bookmark bookmark = new Bookmark(topic.getTopic(),url,tagId,tag,desc,this.getUser(request).getId());
           this.getPortalService(request).save(bookmark);
           request.getSession().removeAttribute("bookmarkTags");
		   request.getSession().removeAttribute("defaultBookmarks");	
        }
        return request.getParameter("responseId");
	}
}
