package org.light.portlets.group;

import java.sql.Timestamp;
import java.util.Date;

import org.light.portal.model.Entity;
import org.light.portal.util.DateFormatter;

public class GroupBulletin extends Entity {

	private long groupId;
	private long postById;
	private String subject;
	private String content;
	private Timestamp  createDate = new Timestamp(System.currentTimeMillis());
	
	//read only
	private String photoUrl;
	private int photoWidth;
	private int photoHeight;
	private String assignedUri;
	private String chosedUri;
	private String displayName;
	private int userCurrentStatusId;
	
	public GroupBulletin(){
		super();
	}
    
	public GroupBulletin(String subject,String content,long groupId,long postById){
		this();
		this.subject = subject;
		this.content = content;
		this.groupId = groupId;
		this.postById = postById;
	}
	public int getPhotoSmallWidth(){
		int newWidth = this.photoWidth;
		int newHeight = this.photoHeight;
		int rate = 9;
		while(newWidth > 200){
			newWidth = this.photoWidth * rate / 10;
			newHeight= this.photoHeight * rate / 10;
			rate--;
		}
		return newWidth;
	}
	public int getPhotoSmallHeight(){
		int newWidth = this.photoWidth;
		int newHeight = this.photoHeight;
		int rate = 9;
		while(newWidth > 200){
			newWidth = this.photoWidth * rate / 10;
			newHeight= this.photoHeight * rate / 10;
			rate--;
		}
		return newHeight;
	}
	
	public String getDate(){
		 return DateFormatter.format(this.createDate,"EEE, MMM dd, yyyy HH:mm aaa");
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
	

	public String getContent() {
		return content;
	}
	

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	

	public long getGroupId() {
		return groupId;
	}
	

	public void setGroupId(long groupId) {
		this.groupId = groupId;
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

	public Timestamp getCreateDate() {
		return createDate;
	}
	

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public int getUserCurrentStatusId() {
		return userCurrentStatusId;
	}

	public void setUserCurrentStatusId(int userCurrentStatusId) {
		this.userCurrentStatusId = userCurrentStatusId;
	}
	
	
	
}
