package org.light.portlets.group.dao;

import java.util.List;

import org.hibernate.Query;
import org.light.portal.core.dao.BaseDao;
import org.light.portlets.bulletin.Bulletin;
import org.light.portlets.forum.ForumPost;
import org.light.portlets.group.Group;
import org.light.portlets.group.GroupBulletin;
import org.light.portlets.group.GroupCategory;
import org.light.portlets.group.GroupForum;
import org.light.portlets.group.GroupPicture;
import org.light.portlets.group.UserGroup;

public interface GroupDao extends BaseDao {
	public List<Group> getGroupsByCategory(long categoryId,long orgId);
	public List<UserGroup> getGroupsByUser(long userId);
	public List<UserGroup> getUserGroup(long userId, long groupId);
	public List<UserGroup> getUsersByGroup(long groupId);
	public List<GroupCategory> getGroupCategories(long orgId);
	public Group getGroupById(long id);
	public Group getGroupByUri(String uri,long orgId);
	public List<Group> searchGroups(Group group);
	public List<GroupPicture> getGroupPictures(long groupId);
	public GroupPicture getGroupPictureById(long id);
	public List<GroupBulletin> getBulletinsByGroup(long groupId);	
	public GroupBulletin getBulletinById(long id);
	public List<GroupForum> getGroupForums(long groupId);	
	public List<GroupForum> getGroupForumsByTopic(long topicId);
	public GroupForum getGroupForumById(long id);
	public int getTopicsCountByGroup(long groupId);
	public List<GroupForum> getTopicsByGroup(long groupId,int pageId,int maxRow);
	public int getPostsCountByTopic(long topicId);	
	public List<GroupForum> getPostsByTopic(long topicId,int pageId,int maxRow);
	public int getUserGroupCount(long userId);
}
