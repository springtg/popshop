package org.light.portal.model;

import java.sql.Timestamp;
import java.util.Date;

import org.light.portal.util.DateFormatter;

public class UserComments extends Entity {

	private long userId;
	private long postById;
	private String comments;
	private int status; // 0 new 1 approved 2 not approved
	private Timestamp createDate = new Timestamp(System.currentTimeMillis());
	
	//read only
	private String photoUrl;
	private int photoWidth;
	private int photoHeight;
	private String assignedUri;
	private String chosedUri;
	private String displayName;
	
	public UserComments(){
		super();
	}
	
	public UserComments(long userId, long postById, String comments){
		this();
		this.userId = userId;
		this.postById = postById;
		this.comments = comments;		
	}
	public String getDate(){
		 return DateFormatter.format(this.createDate,"EEEE, MMMM dd, yyyy HH:mm");
	}
	
	public String getUri() {
		String uri = this.assignedUri;
		if(this.chosedUri != null)
			uri = this.chosedUri;
		return uri;
	}
	
	public int getPhotoSmallWidth(){
		int newWidth = this.photoWidth;
		int newHeight = this.photoHeight;
		int rate = 99;
		while(newWidth > 100){
			newWidth = this.photoWidth * rate / 100;
			newHeight= this.photoHeight * rate / 100;
			rate--;
		}
		return newWidth;
	}
	public int getPhotoSmallHeight(){
		int newWidth = this.photoWidth;
		int newHeight = this.photoHeight;
		int rate = 99;
		while(newWidth > 100){
			newWidth = this.photoWidth * rate / 100;
			newHeight= this.photoHeight * rate / 100;
			rate--;
		}
		return newHeight;
	}
	
	public String getComments() {
		return comments;
	}
	

	public void setComments(String comments) {
		this.comments = comments;
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
	

	public long getUserId() {
		return userId;
	}
	

	public void setUserId(long userId) {
		this.userId = userId;
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

	public int getStatus() {
		return status;
	}
	

	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
