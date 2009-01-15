package org.light.portlets.group.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.light.portal.core.dao.hibernate.BaseDaoImpl;
import org.light.portal.model.UserPicture;
import org.light.portlets.bulletin.Bulletin;
import org.light.portlets.forum.ForumPost;
import org.light.portlets.group.Group;
import org.light.portlets.group.GroupBulletin;
import org.light.portlets.group.GroupCategory;
import org.light.portlets.group.GroupForum;
import org.light.portlets.group.GroupPicture;
import org.light.portlets.group.UserGroup;
import org.light.portlets.group.dao.GroupDao;

public class GroupDaoImpl extends BaseDaoImpl implements GroupDao{
	
	public List<Group> getGroupsByCategory(long categoryId,long orgId){
		List<Group> groups = this.getHibernateTemplate().find("select group from Group group where group.categoryId =? and group.orgId=?", new long[]{categoryId,orgId}); 
		
		return groups;
	}
	public int getUserGroupCount(long userId){			
		String hql="select count(*) from UserGroup where userId='"+userId+"'";
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		Query query =session.createQuery(hql);
		Integer count = (Integer)query.uniqueResult();
		session.close();
		return count.intValue();
	}
	public List<UserGroup> getGroupsByUser(long userId){
		List<UserGroup> userGroups = this.getHibernateTemplate().find("select userGroup from UserGroup userGroup where userGroup.userId =? ", userId);		
		return userGroups;
	}		
	public List<UserGroup> getUsersByGroup(long groupId){
		List<UserGroup> userGroups = this.getHibernateTemplate().find("select userGroup from UserGroup userGroup where userGroup.groupId =? ", groupId);		
		return userGroups;
	}
	public List<UserGroup> getUserGroup(long userId, long groupId){
		Object[] params = new Object[2];
		params[0] = userId;
		params[1] = groupId;
		List<UserGroup> userGroups = this.getHibernateTemplate().find("select userGroup from UserGroup userGroup where userGroup.userId =? and userGroup.groupId=?", params);
		
		return userGroups;
	}
//	public List<GroupCategory> getGroupCategory(long orgId){
//		String hql="select ref from GroupCategory ref where ref.orgId="+orgId+" order by ref.name asc";		
//		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
//		Query query =session.createQuery(hql);
//		List<GroupCategory> groupCategories = query.list();
//		session.close();
//		return groupCategories;
//	}
	public List<GroupCategory> getGroupCategories(long orgId){
		List<GroupCategory> groupCategories = this.getHibernateTemplate().find("select ref from GroupCategory ref where ref.orgId=? order by ref.name asc",orgId);
		
		return groupCategories;
	}
	
	public Group getGroupById(long id){
		return (Group)this.getHibernateTemplate().get(Group.class,id);
	}
	
	public Group getGroupByUri(String uri,long orgId){		
		List<Group> groups = this.getHibernateTemplate().find("select group from Group group where group.uri =? and group.orgId=?", new Object[]{uri,orgId});
		Group group = null;
		if(groups != null && groups.size() > 0) group = groups.get(0);
		return group;
	}
	
	public List<Group> searchGroups(Group group){
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		List<Group> groups =session.createCriteria(Group.class)
		           .add(Example.create(group).ignoreCase().enableLike(MatchMode.ANYWHERE))
		           .list();		
		session.close();
		return groups;
	}
	
	public List<GroupPicture> getGroupPictures(long groupId){
		List<GroupPicture> groupPictures = this.getHibernateTemplate().find("select groupPictures from GroupPicture groupPictures where groupPictures.groupId=? order by id desc", groupId);
		return groupPictures;
	}
		
	public GroupPicture getGroupPictureById(long id){
		return (GroupPicture)this.getHibernateTemplate().get(GroupPicture.class,id);
	}
		
	public List<GroupBulletin> getBulletinsByGroup(long groupId){
		List<GroupBulletin> bulletins = this.getHibernateTemplate().find("select bulletin from GroupBulletin bulletin where bulletin.groupId=? order by id desc", groupId);
		return bulletins;
	}
	
	public GroupBulletin getBulletinById(long id){
		return (GroupBulletin)this.getHibernateTemplate().get(GroupBulletin.class,id);
	}
	
	public List<GroupForum> getGroupForums(long groupId){
		List<GroupForum> groupForums = this.getHibernateTemplate().find("select groupForums from GroupForum groupForums where groupForums.groupId=? and groupForums.topId= 0 order by id desc", groupId);
		return groupForums; 
	}
	public List<GroupForum> getTopicsByGroup(long groupId,int pageId,int maxRow){
		String hql="select forum from GroupForum forum where forum.groupId="+groupId+" and forum.topId= 0 order by id desc ";
		int first = pageId * maxRow;
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		Query query =session.createQuery(hql)
					.setFirstResult(first)
					.setMaxResults(maxRow);
		List<GroupForum> list = query.list();
		session.close();
		return list;
		
	}
	public int getTopicsCountByGroup(long groupId){
		String hql="select count(*) from GroupForum forum where forum.groupId="+groupId+" and forum.topId= 0 ";
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		Query query =session.createQuery(hql);
		Integer count = (Integer)query.uniqueResult();
		session.close();
		return count.intValue();
	}
	
	public int getPostsCountByTopic(long topicId){
		String hql="select count(*) from GroupForum forum where forum.topId="+topicId+" or forum.id= "+topicId;
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		Query query =session.createQuery(hql);
		Integer count = (Integer)query.uniqueResult();
		session.close();
		return count.intValue();
	}
	
	public List<GroupForum> getPostsByTopic(long topicId,int pageId,int maxRow){
		String hql="select forum from GroupForum forum where forum.topId="+topicId+" or forum.id= "+topicId+" order by id desc";
		int first = pageId * maxRow;
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		Query query =session.createQuery(hql)
					.setFirstResult(first)
					.setMaxResults(maxRow);
		List<GroupForum> list = query.list();
		session.close();
		return list;
	}
	
	public List<GroupForum> getGroupForumsByTopic(long topicId){
		Object[] params = new Object[2];
		params[0] = topicId;
		params[1] = topicId;
		List<GroupForum> groupForums = this.getHibernateTemplate().find("select groupForums from GroupForum groupForums where groupForums.topId= ? or groupForums.id = ? order by id desc", params);
		return groupForums; 
	}
	
	public GroupForum getGroupForumById(long id){
		return (GroupForum)this.getHibernateTemplate().get(GroupForum.class,id);
	}

}
