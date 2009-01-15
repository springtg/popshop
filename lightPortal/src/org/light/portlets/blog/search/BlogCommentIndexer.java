package org.light.portlets.blog.search;

import org.light.portal.model.Entity;
import org.light.portlets.blog.Blog;
import org.light.portlets.blog.BlogComment;

public class BlogCommentIndexer extends BlogIndexer {
	public synchronized void reIndex(){
		
	}
	public synchronized void reIndex(Class entityType){

	}
	public void  updateIndex(Entity entity){
		if(!(entity instanceof BlogComment)) return;
		BlogComment comment = (BlogComment)entity;
		Blog blog = null;
		try {
			blog =this.getBlogDao().getBlogById(comment.getBlogId());
			deleteIndex((Blog)blog);
		}
		catch (Exception e) {
		}		
		if(blog != null)
			addIndex(blog);
	}
}
