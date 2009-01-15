package org.light.portlets.forum.service.spring;

import java.util.List;

import org.light.portal.core.service.spring.BaseServiceImpl;
import org.light.portlets.forum.ForumPost;
import org.light.portlets.forum.ForumCategory;
import org.light.portlets.forum.Forum;
import org.light.portlets.forum.dao.ForumDao;
import org.light.portlets.forum.service.ForumService;

public class ForumServiceImpl extends BaseServiceImpl implements ForumService{
	private ForumDao forumDao;
	
	public int getTopicsCountByForum(long forumId){
		return forumDao.getTopicsCountByForum(forumId);
	}
	public int getPostsCountByTopic(long topicId){
		return forumDao.getPostsCountByTopic(topicId);
	}
	public List<ForumPost> getTopicsByForum(long forumId,int pageId,int maxRow){
		return forumDao.getTopicsByForum(forumId,pageId,maxRow);
	}
	
	public List<ForumPost> getPostsByTopic(long topicId,int pageId,int maxRow){
		return forumDao.getPostsByTopic(topicId,pageId,maxRow);
	}
	
	public void deleteTopic(long topicId){
		forumDao.deleteTopic(topicId);
	}
	public ForumPost getPostById(long id){
		return forumDao.getPostById(id);
	}
	
	public ForumCategory getForumCategoryById(long id){
		return forumDao.getForumCategoryById(id);
	}
	public Forum getForumById(long id){
		return forumDao.getForumById(id);
	}
	public List<ForumCategory> getForumCategories(String lanuage, long orgId){
		return forumDao.getForumCategories(lanuage,orgId);
	}
	
	public List<Forum> getForumByCategory(long categoryId){
		return forumDao.getForumByCategory(categoryId);
	}
	 
	public ForumDao getForumDao() {
		return forumDao;
	}
	
	public void setForumDao(ForumDao forumDao) {
		this.forumDao = forumDao;
	}
	
}
