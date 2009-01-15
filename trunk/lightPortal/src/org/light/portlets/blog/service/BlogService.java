package org.light.portlets.blog.service;

import java.util.List;

import org.light.portlets.blog.Blog;
import org.light.portlets.blog.BlogComment;

public interface BlogService {
	public List<Blog> getBlogsByUser(long userId, long orgId);
	public List<Blog> getBlogsByVisitor(long userId, long orgId);
	public Blog getBlogById(long id);
	public List<BlogComment> getBlogCommentsById(long id);
	public List<Blog> getBlogsByType(String type, long orgId, int showNumber);
}
