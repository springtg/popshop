package org.light.portlets.group.service.spring;

import java.util.List;

import org.light.portal.core.service.spring.BaseServiceImpl;
import org.light.portlets.bulletin.Bulletin;
import org.light.portlets.connection.Connection;
import org.light.portlets.forum.ForumPost;
import org.light.portlets.group.Group;
import org.light.portlets.group.GroupBulletin;
import org.light.portlets.group.GroupCategory;
import org.light.portlets.group.GroupForum;
import org.light.portlets.group.GroupPicture;
import org.light.portlets.group.UserGroup;
import org.light.portlets.group.dao.GroupDao;
import org.light.portlets.group.service.GroupService;

public class GroupServiceImpl extends BaseServiceImpl implements GroupService{
	private GroupDao groupDao;
	
	public List<Group> getGroupsByCategory(long categoryId,long orgId){
		return groupDao.getGroupsByCategory(categoryId,orgId);
	}
	public int getUserGroupCount(long userId){
		return groupDao.getUserGroupCount(userId);
	}
	public List<UserGroup> getGroupsByUser(long userId){
		return groupDao.getGroupsByUser(userId);
	}
	public List<UserGroup> getUserGroup(long userId, long groupId){
		return groupDao.getUserGroup(userId,groupId);
	}
	public List<UserGroup> getUsersByGroup(long groupId){
		return groupDao.getUsersByGroup(groupId);
	}
	public List<GroupCategory> getGroupCategories(long orgId){
		return groupDao.getGroupCategories(orgId);
	}
	
	public Group getGroupById(long id){
		return groupDao.getGroupById(id);
	}
	public Group getGroupByUri(String uri,long orgId){
		return groupDao.getGroupByUri(uri,orgId);
	}
	public List<Group> searchGroups(Group group){
		return groupDao.searchGroups(group);
	}
	public List<GroupPicture> getGroupPictures(long groupId){
		return groupDao.getGroupPictures(groupId);
	}
	public GroupPicture getGroupPictureById(long id){
		return groupDao.getGroupPictureById(id);
	}
	public void sendBulletin(GroupBulletin bulletin){
		List<UserGroup> userGroups = groupDao.getUsersByGroup(bulletin.getGroupId());
		Group group = this.getGroupById(bulletin.getGroupId());
		for(UserGroup member : userGroups){
			if(bulletin.getPostById()==group.getLeaderId() && member.getAcceptLeaderBulletin() == 1){
				Bulletin sendToMember = new Bulletin(bulletin.getSubject(),bulletin.getContent(),member.getUserId(),bulletin.getPostById());
				groupDao.save(sendToMember);	
				break;
			}
			if(member.getAcceptMembersBulletin() == 1){
				Bulletin sendToMember = new Bulletin(bulletin.getSubject(),bulletin.getContent(),member.getUserId(),bulletin.getPostById());
				groupDao.save(sendToMember);	
			}
		}
		groupDao.save(bulletin);
	}
	
	public List<GroupBulletin> getBulletinsByGroup(long groupId){		
		return groupDao.getBulletinsByGroup(groupId);
	}
	
	public GroupBulletin getBulletinById(long id){
		return groupDao.getBulletinById(id);
	}
	
	public List<GroupForum> getGroupForums(long groupId){
		return groupDao.getGroupForums(groupId); 
	}
	
	public List<GroupForum> getGroupForumsByTopic(long topicId){
		return groupDao.getGroupForumsByTopic(topicId);
	}
	
	public GroupForum getGroupForumById(long id){
		return groupDao.getGroupForumById(id);
	}
	public int getTopicsCountByGroup(long groupId){
		return groupDao.getTopicsCountByGroup(groupId);
	}
	public List<GroupForum> getTopicsByGroup(long groupId,int pageId,int maxRow){
		return groupDao.getTopicsByGroup(groupId,pageId,maxRow);
	}
	public int getPostsCountByTopic(long topicId){
		return groupDao.getPostsCountByTopic(topicId);
	}
	public List<GroupForum> getPostsByTopic(long topicId,int pageId,int maxRow){
		return groupDao.getPostsByTopic(topicId,pageId,maxRow);
	}
	public GroupDao getGroupDao() {
		return groupDao;
	}
	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
	}
}
