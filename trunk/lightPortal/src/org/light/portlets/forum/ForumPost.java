package org.light.portlets.forum;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.light.portal.model.Entity;
import org.light.portal.util.DateFormatter;

public class ForumPost extends Entity {

	private String topic;
	private String content;
	private long topId;
	private long forumId;
	private long categoryId;
	private long postById;
	private long orgId;
	private Timestamp  createDate = new Timestamp(System.currentTimeMillis());
	private long lastPostId;
	private long lastPostById;	
	private Timestamp  lstChgTm = new Timestamp(System.currentTimeMillis());
//	read only
	private int posts;
	private String photoUrl;
	private int photoWidth;
	private int photoHeight;
	private String assignedUri;
	private String chosedUri;
	private String displayName;
	private int currentStatusId;
	private String birth;
	private String gender;
	
	private String lastPhotoUrl;
	private int lastPhotoWidth;
	private int lastPhotoHeight;
	private String lastAssignedUri;
	private String lastChosedUri;
	private String lastDisplayName;
	private int lastCurrentStatusId;
	
	public ForumPost(){
		super();
	}
	
	public ForumPost(String topic,String content, long topId, long forumId, long categoryId,long postById, long orgId){
		this.topic = topic;
		this.content = content;
		this.topId = topId;
		this.forumId = forumId;
		this.categoryId = categoryId;
		this.postById = postById;
		this.lastPostById = postById;
		this.orgId = orgId;
	}
	
	public long getTopicId(){
		long topicId = this.topId;
		if(topicId == 0)
			topicId = this.getId();
		return topicId;
	}
	public int getPhotoSmallWidth(){
		int newWidth = this.photoWidth;
		int newHeight = this.photoHeight;
		int rate = 99;
		while(newWidth > 75){
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
		while(newWidth > 75){
			newWidth = this.photoWidth * rate / 100;
			newHeight= this.photoHeight * rate / 100;
			rate--;
		}
		return newHeight;
	}
	
	public int getLastPhotoSmallWidth(){
		int newWidth = this.lastPhotoWidth;
		int newHeight = this.lastPhotoHeight;
		int rate = 99;
		while(newWidth > 75){
			newWidth = this.lastPhotoWidth * rate / 100;
			newHeight= this.lastPhotoHeight * rate / 100;
			rate--;
		}
		return newWidth;
	}
	public int getLastPhotoSmallHeight(){
		int newWidth = this.lastPhotoWidth;
		int newHeight = this.lastPhotoHeight;
		int rate = 99;
		while(newWidth > 75){
			newWidth = this.lastPhotoWidth * rate / 100;
			newHeight= this.lastPhotoHeight * rate / 100;
			rate--;
		}
		return newHeight;
	}
	public String getAge(){
		String age = null;
		if(this.birth != null && this.birth.length() == 10){
			String  year = birth.substring(0,4);
			Calendar calendar = GregorianCalendar.getInstance();
			calendar.setTimeInMillis(System.currentTimeMillis());
			int currentYear = calendar.get( Calendar.YEAR );
			age = String.valueOf(currentYear - Integer.parseInt(year));
		}			
		return age;
	}
	
	public String getDate(){
		 return DateFormatter.format(this.createDate,"EEE, MMM dd, yyyy HH:mm aaa");
	}
	
	public String getFullDate(){
		 return DateFormatter.format(this.createDate,"EEEE, MMMM dd, yyyy HH:mm aaa");
	}
	
	public String getLastDate(){
		 return DateFormatter.format(this.lstChgTm,"EEE, MMM dd, yyyy HH:mm aaa");
	}
	
	public String getLastFullDate(){
		 return DateFormatter.format(this.lstChgTm,"EEEE, MMMM dd, yyyy HH:mm aaa");
	}
	
	public String getUri() {
		String uri = this.assignedUri;
		if(this.chosedUri != null)
			uri = this.chosedUri;
		return uri;
	}
	
	public String getLastUri() {
		String uri = this.lastAssignedUri;
		if(this.lastChosedUri != null)
			uri = this.lastChosedUri;
		return uri;
	}
	
	public String getAssignedUri() {
		return assignedUri;
	}

	public void setAssignedUri(String assignedUri) {
		this.assignedUri = assignedUri;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
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

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public int getCurrentStatusId() {
		return currentStatusId;
	}

	public void setCurrentStatusId(int currentStatusId) {
		this.currentStatusId = currentStatusId;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getLastAssignedUri() {
		return lastAssignedUri;
	}

	public void setLastAssignedUri(String lastAssignedUri) {
		this.lastAssignedUri = lastAssignedUri;
	}

	public String getLastChosedUri() {
		return lastChosedUri;
	}

	public void setLastChosedUri(String lastChosedUri) {
		this.lastChosedUri = lastChosedUri;
	}

	public int getLastCurrentStatusId() {
		return lastCurrentStatusId;
	}

	public void setLastCurrentStatusId(int lastCurrentStatusId) {
		this.lastCurrentStatusId = lastCurrentStatusId;
	}

	public String getLastDisplayName() {
		return lastDisplayName;
	}

	public void setLastDisplayName(String lastDisplayName) {
		this.lastDisplayName = lastDisplayName;
	}

	public int getLastPhotoHeight() {
		return lastPhotoHeight;
	}

	public void setLastPhotoHeight(int lastPhotoHeight) {
		this.lastPhotoHeight = lastPhotoHeight;
	}

	public String getLastPhotoUrl() {
		return lastPhotoUrl;
	}

	public void setLastPhotoUrl(String lastPhotoUrl) {
		this.lastPhotoUrl = lastPhotoUrl;
	}

	public int getLastPhotoWidth() {
		return lastPhotoWidth;
	}

	public void setLastPhotoWidth(int lastPhotoWidth) {
		this.lastPhotoWidth = lastPhotoWidth;
	}

	public long getLastPostById() {
		return lastPostById;
	}

	public void setLastPostById(long lastPostById) {
		this.lastPostById = lastPostById;
	}

	public long getLastPostId() {
		return lastPostId;
	}

	public void setLastPostId(long lastPostId) {
		this.lastPostId = lastPostId;
	}

	public Timestamp getLstChgTm() {
		return lstChgTm;
	}

	public void setLstChgTm(Timestamp lstChgTm) {
		this.lstChgTm = lstChgTm;
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

	public int getPosts() {
		return posts;
	}

	public void setPosts(int posts) {
		this.posts = posts;
	}

	public long getTopId() {
		return topId;
	}

	public void setTopId(long topId) {
		this.topId = topId;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public long getForumId() {
		return forumId;
	}

	public void setForumId(long forumId) {
		this.forumId = forumId;
	}

	public long getOrgId() {
		return orgId;
	}

	public void setOrgId(long orgId) {
		this.orgId = orgId;
	}

	
}
