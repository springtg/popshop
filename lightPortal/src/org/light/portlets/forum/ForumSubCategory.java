package org.light.portlets.forum;

import org.light.portal.core.PortalContextFactory;
import org.light.portal.model.Entity;

import static org.light.portal.util.Constants.*;

public class ForumSubCategory extends Entity {

	private String name;
	private String desc;
	private ForumCategory category;
	private long owner;
	private int status;
	
	//read only
	private int topics;
	private int posts;
	private String lastForumId;
	private Forum lastForum;
	
	public ForumSubCategory(){
		super();
	}
	
	public ForumSubCategory(String name, boolean hasDesc){
		this();
		this.name = _FORUM_CATEGORY_SUB_PROFIX+name;
		if(hasDesc)
			this.desc = _FORUM_CATEGORY_SUB_DESC_PROFIX+name;
		this.owner = 0;
		this.status = 1;//available to the public
	}
	public ForumSubCategory(String name,String desc,ForumCategory category,long owner){
		this();
		this.name =name;
		this.desc = desc;
		this.category = category;
		this.owner = owner;
		this.status = 0;//waiting for approve
	}
	public String getDisplayName(){
		String displayName = PortalContextFactory.getPortalContext().getMessageByKey(this.name);
		return displayName;
	}
	public String getDisplayDesc(){
		String displayDesc = "";
		if(this.desc != null)
			displayDesc = PortalContextFactory.getPortalContext().getMessageByKey(this.desc);
		return displayDesc;
	}
	public long getCategoryId() {
		return category.getId();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Forum getLastForum() {
		return lastForum;
	}
	public void setLastForum(Forum lastForum) {
		this.lastForum = lastForum;
	}
	public String getLastForumId() {
		return lastForumId;
	}
	public void setLastForumId(String lastForumId) {
		this.lastForumId = lastForumId;
	}
	public int getPosts() {
		return posts;
	}
	public void setPosts(int posts) {
		this.posts = posts;
	}
	public int getTopics() {
		return topics;
	}
	public void setTopics(int topics) {
		this.topics = topics;
	}
	public ForumCategory getCategory() {
		return category;
	}
	public void setCategory(ForumCategory category) {
		this.category = category;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public long getOwner() {
		return owner;
	}

	public void setOwner(long owner) {
		this.owner = owner;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
