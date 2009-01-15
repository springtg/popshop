package org.light.portlets.forum.service;

import java.util.List;

import org.light.portlets.forum.ForumPost;
import org.light.portlets.forum.ForumCategory;
import org.light.portlets.forum.Forum;

public interface ForumService {
 public int getTopicsCountByForum(long forumId);
 public List<ForumPost> getTopicsByForum(long forumId,int pageId,int maxRow);
 public int getPostsCountByTopic(long topicId);
 public List<ForumPost> getPostsByTopic(long topicId,int pageId,int maxRow);
 public ForumPost getPostById(long id);
 public ForumCategory getForumCategoryById(long id);
 public Forum getForumById(long id);
 public List<ForumCategory> getForumCategories(String lanuage, long orgId);
 public List<Forum> getForumByCategory(long categoryId);
 public void deleteTopic(long topicId);
}
