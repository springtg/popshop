package org.light.portlets.forum;

import static org.light.portal.util.Constants._FORUM_CATEGORY_DESC_PROFIX;
import static org.light.portal.util.Constants._FORUM_CATEGORY_PROFIX;

import java.util.HashSet;
import java.util.Set;

import org.light.portal.core.PortalContextFactory;
import org.light.portal.model.Entity;
import org.light.portal.model.PortalTab;

public class ForumCategory extends Entity {

	private String name;
	private String desc;
	private String language;
	private long orgId;
	private long ownerId;
	private int status;
	
	//read only
	private int topics;
	private int posts;
	private String lastForumId;
	private ForumPost lastForum;
	private Set<Forum> forums = new HashSet<Forum>();
	
	public ForumCategory(){
		super();
	}
	
	public ForumCategory(String name,String language,long orgId){
		this();
		this.name = _FORUM_CATEGORY_PROFIX+name;
		this.desc = _FORUM_CATEGORY_DESC_PROFIX+name;
		this.language = language;
		this.orgId = orgId;
		this.ownerId = 0;
		this.status = 1;//available to the public
	}
	
	public ForumCategory(String name,String desc,String language,long orgId,long ownerId){
		this();
		this.name = name;
		this.desc = desc;
		this.language = language;
		this.orgId = orgId;
		this.ownerId = ownerId;
		this.status = 0;//waiting for approve
	}
	
	public ForumCategory(String name,String desc,String language,long orgId,long ownerId,int status){
		this();
		this.name = name;
		this.desc = desc;
		this.language = language;
		this.orgId = orgId;
		this.ownerId = ownerId;
		this.status = status;//waiting for approve
	}
	
	public void addForum(Forum forum){
		this.forums.add(forum);
		forum.setCategory(this);
		
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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public ForumPost getLastForum() {
		return lastForum;
	}
	public void setLastForum(ForumPost lastForum) {
		this.lastForum = lastForum;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Set<Forum> getForums() {
		return forums;
	}

	public void setForums(Set<Forum> forums) {
		this.forums = forums;
	}

	public long getOrgId() {
		return orgId;
	}

	public void setOrgId(long orgId) {
		this.orgId = orgId;
	}

	public long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}
}
