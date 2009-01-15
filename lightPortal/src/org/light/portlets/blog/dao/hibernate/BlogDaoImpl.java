package org.light.portlets.blog.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.light.portal.core.dao.hibernate.BaseDaoImpl;
import org.light.portal.model.User;
import org.light.portlets.blog.Blog;
import org.light.portlets.blog.BlogComment;
import org.light.portlets.blog.dao.BlogDao;

public class BlogDaoImpl extends BaseDaoImpl implements BlogDao{
	
	public void createUserBlog(User user){
		
	}
	
	public List<Blog> getBlogsByUser(long userId,long orgId){
		long[] params = new long[]{userId,orgId};
		List<Blog> list = this.getHibernateTemplate().find("select b from Blog b where (b.userId="+userId+" or b.postedById="+userId+") and b.orgId="+orgId+" order by b.createDate desc ");		
		return list;
	}
	
	public List<Blog> getBlogsByVisitor(long userId,long orgId){
		long[] params = new long[]{userId,orgId};
		List<Blog> list = this.getHibernateTemplate().find("select blog from Blog blog where (b.userId="+userId+" or b.postedById="+userId+") and blog.orgId="+orgId+" and blog.status=1 order by createDate desc ");		
		return list;
	}
	
	public List<Blog> getBlogsByType(String type, long orgId, int showNumber){	
		String hql="from Blog blog where blog.orgId=? and blog.status=1 order by createDate desc";//type=1, newest 
		if("2".equals(type))//most popular
			hql = "from Blog blog where blog.orgId=? and blog.status=1 order by score desc, createDate desc" ;
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		Query query =session.createQuery(hql)
					.setLong(0,orgId)
					.setFirstResult(0)
					.setMaxResults(showNumber);
		List<Blog> list = query.list();
		session.close();
		return list;
	
	}
	
	public List<Blog> getBlogs(long orgId){	
		String hql="from Blog blog where blog.orgId=? and blog.status=1 order by createDate desc";//type=1, newest 
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		Query query =session.createQuery(hql)
					.setLong(0,orgId)
					;
		List<Blog> list = query.list();
		session.close();
		return list;
	
	}
	
	public Blog getBlogById(long id){
		return (Blog)this.getHibernateTemplate().get(Blog.class, id);
	}
	
	public List<BlogComment> getBlogCommentsById(long id){
		List<BlogComment> list = this.getHibernateTemplate().find("select comment from BlogComment comment where comment.blogId=? order by id asc ",id);		
		return list;
	}
}
