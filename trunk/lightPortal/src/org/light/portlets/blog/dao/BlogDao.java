package org.light.portlets.blog.dao;

import java.util.List;

import org.light.portal.model.User;
import org.light.portlets.blog.Blog;
import org.light.portlets.blog.BlogComment;
import org.light.portlets.forum.ForumPost;

public interface BlogDao {
	public void createUserBlog(User user);
	public List<Blog> getBlogsByUser(long userId, long orgId);
	public List<Blog> getBlogsByVisitor(long userId, long orgId);
	public Blog getBlogById(long id);
	public List<BlogComment> getBlogCommentsById(long id);
	public List<Blog> getBlogsByType(String type, long orgId, int showNumber);
	public List<Blog> getBlogs(long orgId);
}
