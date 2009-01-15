package org.light.portlets.internal;

import java.sql.Timestamp;
import java.util.Date;

import org.light.portal.model.Entity;
import org.light.portal.util.DateFormatter;

public class InternalNews extends Entity {

	private long postById;
	private long orgId;
	private String subject;
	private String content;
	private Timestamp  createDate = new Timestamp(System.currentTimeMillis());
	
	public InternalNews(){
		super();
	}
    
	public InternalNews(String subject,String content,long userId, long orgId){
		this();
		this.subject = subject;
		this.content = content;
		this.postById = userId;
		this.orgId = orgId;
	}
	
	public String getDate(){
		return DateFormatter.format(createDate,"MMM dd, yyyy HH:mm");
	}
	public String getContent() {
		return content;
	}
	

	public void setContent(String content) {
		this.content = content;
	}
	

	public Timestamp getCreateDate() {
		return createDate;
	}
	

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	

	public long getPostById() {
		return postById;
	}
	

	public void setPostById(long postById) {
		this.postById = postById;
	}
	

	public String getSubject() {
		return subject;
	}
	

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public long getOrgId() {
		return orgId;
	}

	public void setOrgId(long orgId) {
		this.orgId = orgId;
	}
	

}
