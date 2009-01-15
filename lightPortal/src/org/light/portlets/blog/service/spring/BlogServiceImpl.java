package org.light.portlets.blog.service.spring;

import java.util.List;

import org.light.portal.core.service.spring.BaseServiceImpl;
import org.light.portlets.blog.Blog;
import org.light.portlets.blog.BlogComment;
import org.light.portlets.blog.dao.BlogDao;
import org.light.portlets.blog.service.BlogService;

public class BlogServiceImpl extends BaseServiceImpl implements BlogService{
	private BlogDao blogDao;

	public List<Blog> getBlogsByUser(long userId, long orgId){
		return blogDao.getBlogsByUser(userId,orgId);
	}
	public List<Blog> getBlogsByVisitor(long userId, long orgId){
		return blogDao.getBlogsByVisitor(userId,orgId);
	}
	public Blog getBlogById(long id){
	    return blogDao.getBlogById(id);	
	}
	public List<BlogComment> getBlogCommentsById(long id){
		return blogDao.getBlogCommentsById(id);
	}
	public List<Blog> getBlogsByType(String type, long orgId, int showNumber){
		return blogDao.getBlogsByType(type,orgId,showNumber);
	}
	public BlogDao getBlogDao() {
		return blogDao;
	}
	
	public void setBlogDao(BlogDao blogDao) {
		this.blogDao = blogDao;
	}
	
		
}
