package org.light.portlets.blog;

import java.sql.Timestamp;
import java.util.Date;

import org.light.portal.model.Entity;
import org.light.portal.util.DateFormatter;

public class Blog extends Entity {

	private long userId;
	private long postedById;
	private long orgId;
	private String title;
	private String summary;
	private String content;
	private Timestamp  createDate = new Timestamp(System.currentTimeMillis());
	private int status; // 0 draft 1 posted
	private int score;
	//read only
	private String assignedUri;
	private String chosedUri;
	private String displayName;
	private int commentCount;
	
	public Blog(){
		super();
	}
	
	public Blog(long userId, long postedById, long orgId, String title, String summary, String content,int status){
		this();
		this.userId = userId;
		this.postedById = postedById;
		this.orgId  = orgId;
		this.title = title;
		this.summary = summary;
		this.content = content;		
		this.status = status;
	}
	
	public String getDate(){
		 return DateFormatter.format(this.createDate,"EEE, MMM dd, yyyy");
	}
	
	public String getFullDate(){
		 return DateFormatter.format(this.createDate,"EEEE, MMMM dd, yyyy HH:mm aaa");
	}
	
	public String getUri() {
		String uri = this.assignedUri;
		if(this.chosedUri != null)
			uri = this.chosedUri;
		return uri;
	}
	
	public Timestamp getCreateDate() {
		return createDate;
	}
	

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	
	public long getUserId() {
		return userId;
	}
	

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getAssignedUri() {
		return assignedUri;
	}
	

	public void setAssignedUri(String assignedUri) {
		this.assignedUri = assignedUri;
	}
	

	public String getChosedUri() {
		return chosedUri;
	}
	

	public void setChosedUri(String chosedUri) {
		this.chosedUri = chosedUri;
	}

	public String getDisplayName() {
		return displayName;
	}
	

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getContent() {
		return content;
	}
	

	public void setContent(String content) {
		this.content = content;
	}
	

	public int getStatus() {
		return status;
	}
	

	public void setStatus(int status) {
		this.status = status;
	}
	

	public String getTitle() {
		return title;
	}
	

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCommentCount() {
		return commentCount;
	}
	

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public int getScore() {
		return score;
	}
	

	public void setScore(int score) {
		this.score = score;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public long getOrgId() {
		return orgId;
	}

	public void setOrgId(long orgId) {
		this.orgId = orgId;
	}

	public long getPostedById() {
		return postedById;
	}

	public void setPostedById(long postedById) {
		this.postedById = postedById;
	}
	
	
	
	

}
