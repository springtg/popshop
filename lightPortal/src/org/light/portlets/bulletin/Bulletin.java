package org.light.portlets.bulletin;

import java.sql.Timestamp;
import java.util.Date;

import org.light.portal.model.Entity;
import org.light.portal.util.DateFormatter;

public class Bulletin extends Entity {

	private long userId;
	private long postById;
	private String subject;
	private String content;
	private int status;
	private Timestamp  createDate = new Timestamp(System.currentTimeMillis());
	
	//read only
	private String photoUrl;
	private int photoWidth;
	private int photoHeight;
	private String assignedUri;
	private String chosedUri;
	private String displayName;
	
	public Bulletin(){
		super();
	}
    
	public Bulletin(String subject,String content,long userId){
		this();
		this.subject = subject;
		this.content = content;
		this.userId = userId;
		this.postById = userId;
	}
	
	public Bulletin(String subject,String content,long userId,long postById){
		this();
		this.subject = subject;
		this.content = content;
		this.userId = userId;
		this.postById = postById;
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
	

	public long getUserId() {
		return userId;
	}
	

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}
	

	public void setContent(String content) {
		this.content = content;
	}

	public int getPhotoHeight() {
		return photoHeight;
	}
	

	public void setPhotoHeight(int photoHeight) {
		this.photoHeight = photoHeight;
	}
	

	public String getPhotoUrl() {
		return photoUrl;
	}
	

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	

	public int getPhotoWidth() {
		return photoWidth;
	}
	

	public void setPhotoWidth(int photoWidth) {
		this.photoWidth = photoWidth;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}
	

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	
	
}
