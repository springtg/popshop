package org.light.portlets.feedback;

import java.util.Date;

import org.light.portal.model.Entity;

public class Feedback extends Entity{

	private String subject;
	private String content;
	private String email;
	private Date createDate = new Date(System.currentTimeMillis());
	private int count;
	
	public Feedback(){
		super();
	}
	
	public Feedback(String subject, String content, String email){
		this();
		this.subject = subject;
		this.content = content;
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
		
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
