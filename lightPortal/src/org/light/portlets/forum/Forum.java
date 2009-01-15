package org.light.portlets.forum;

import org.light.portal.core.PortalContextFactory;
import org.light.portal.model.Entity;

import static org.light.portal.util.Constants.*;

public class Forum extends Entity {

	private String name;
	private String desc;
	private ForumCategory category;
	private long ownerId;
	private int status;
	private long orgId;
	
	//read only
	private int topics;
	private int posts;
	private String lastForumId;
	private ForumPost lastForum;
	
	public Forum(){
		super();
	}
	
	public Forum(String name, boolean hasDesc, long orgId){
		this();
		this.name = _FORUM_CATEGORY_SUB_PROFIX+name;
		if(hasDesc)
			this.desc = _FORUM_CATEGORY_SUB_DESC_PROFIX+name;
		this.ownerId = 0;
		this.status = 1;//available to the public
		this.orgId = orgId;
	}
	public Forum(String name,String desc,ForumCategory category,long ownerId,long orgId){
		this();
		this.name =name;
		this.desc = desc;
		this.category = category;
		this.ownerId = ownerId;
		this.status = 0;//waiting for approve
		this.orgId = orgId;
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
	
	public ForumPost getLastForum() {
		return lastForum;
	}
	public void setLastForum(ForumPost lastForum) {
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
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}

	public long getOrgId() {
		return orgId;
	}

	public void setOrgId(long orgId) {
		this.orgId = orgId;
	}
}
