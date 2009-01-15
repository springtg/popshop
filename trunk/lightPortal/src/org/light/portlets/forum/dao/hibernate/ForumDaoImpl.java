package org.light.portlets.forum.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.light.portal.core.dao.hibernate.BaseDaoImpl;
import org.light.portlets.blog.Blog;
import org.light.portlets.forum.ForumPost;
import org.light.portlets.forum.ForumCategory;
import org.light.portlets.forum.Forum;
import org.light.portlets.forum.dao.ForumDao;
import org.light.portlets.group.GroupForum;

public class ForumDaoImpl extends BaseDaoImpl implements ForumDao{
	
	public List<ForumPost> getPosts(long orgId){
		List<ForumPost> list = this.getHibernateTemplate().find("select forum from ForumPost forum where forum.orgId=? order by id desc ",orgId);		
		return list;
	}
	
	public int getTopicsCountByForum(long forumId){
		String hql="select count(*) from ForumPost forum where forum.forumId="+forumId+" and forum.topId= 0 ";
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		Query query =session.createQuery(hql);
		Integer count = (Integer)query.uniqueResult();
		session.close();
		return count.intValue();
	}
	
	public List<ForumPost> getTopicsByForum(long forumId,int pageId,int maxRow){
		String hql="select forum from ForumPost forum where forum.forumId="+forumId+" and forum.topId= 0 order by id desc ";
		int first = pageId * maxRow;
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		Query query =session.createQuery(hql)
					.setFirstResult(first)
					.setMaxResults(maxRow);
		List<ForumPost> list = query.list();
		session.close();
		return list;
		
	}
	
	public int getPostsCountByTopic(long topicId){
		String hql="select count(*) from ForumPost forum where forum.topId="+topicId+" or forum.id= "+topicId;
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		Query query =session.createQuery(hql);
		Integer count = (Integer)query.uniqueResult();
		session.close();
		return count.intValue();
	}
	
	public List<ForumPost> getPostsByTopic(long topicId,int pageId,int maxRow){
		String hql="select forum from ForumPost forum where forum.topId="+topicId+" or forum.id= "+topicId+" order by id asc";
		int first = pageId * maxRow;
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		Query query =session.createQuery(hql)
					.setFirstResult(first)
					.setMaxResults(maxRow);
		List<ForumPost> list = query.list();
		session.close();		
		return list;
//		Object[] params = new Object[2];
//		params[0] = topicId;
//		params[1] = topicId;
//		List<ForumPost> forums = this.getHibernateTemplate().find("", params);
//		return forums; 
	}
	
	public void deleteTopic(long topicId){
//		String hql="select forum from ForumPost forum where forum.topId="+topicId+" or forum.id= "+topicId;
//		this.getHibernateTemplate().getSessionFactory()
//		 							.openSession()
//		 							.delete(hql);
		String hql="delete ForumPost where topId="+topicId+" or id= "+topicId;
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		session.createQuery(hql)
		 	   .executeUpdate();
		session.close();
		
	}
	public ForumPost getPostById(long id){
		return (ForumPost)this.getHibernateTemplate().get(ForumPost.class, id);
	}
		
	public ForumCategory getForumCategoryById(long id){
		return (ForumCategory)this.getHibernateTemplate().get(ForumCategory.class, id);
	}
	
	public Forum getForumById(long id){
		return (Forum)this.getHibernateTemplate().get(Forum.class, id);
	}
	
	public List<ForumCategory> getForumCategories(String lanuage, long orgId){
		List<ForumCategory> list = this.getHibernateTemplate().find("select forum from ForumCategory forum where forum.language=? and forum.orgId=? and forum.status=1 order by id asc ",new Object[]{lanuage,orgId});		
		for(ForumCategory c : list){
			if(c.getLastForumId() != null){
				c.setLastForum(this.getPostById(Integer.parseInt(c.getLastForumId())));
			}
		}
		return list;
	}
	
	public List<Forum> getForumByCategory(long categoryId){
		ForumCategory category = (ForumCategory)this.getHibernateTemplate().get(ForumCategory.class, categoryId);
		List<Forum> list = this.getHibernateTemplate().find("select forum from Forum forum where forum.category=? and forum.status=1 order by id asc ",category);		
		for(Forum c : list){
			if(c.getLastForumId() != null){
				c.setLastForum(this.getPostById(Integer.parseInt(c.getLastForumId())));
			}
		}
		return list;
	}
}
