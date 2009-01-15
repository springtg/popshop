package org.light.portlets.connection;

import java.sql.Timestamp;

import org.light.portal.model.Entity;

public class Connection extends Entity{

	private long userId;
	private long buddyUserId;
	private int type;// 0 friend; 1 family; 2 close friend; 3 classmate; 4 colleague; 
	
	//	read only
	//private String buddyName;
	private int buddyCurrentStatusId;
	private String buddyCurrentStatus;
	
	private String photoUrl;
	private int photoWidth;
	private int photoHeight;
	private String assignedUri;
	private String chosedUri;
	private String displayName;
	private int showTitleToFriends;
	private String title;
	private String birth;
	private Timestamp lastLoginDate;
	private String city;
	private String province;
	
	public Connection(){
		super();
	}
	
	public Connection(long userId, long buddyUserId){
		this();
		this.userId = userId;
		this.buddyUserId = buddyUserId;
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
	public String getUri() {
		String uri = this.assignedUri;
		if(this.chosedUri != null)
			uri = this.chosedUri;
		return uri;
	}
	public String getBirthM(){
		return birth.substring(5,7);
	}
	public String getBirthD(){
		return birth.substring(8,10);
	}
	
	public long getBuddyUserId() {
		return buddyUserId;
	}
	

	public void setBuddyUserId(long buddyUserId) {
		this.buddyUserId = buddyUserId;
	}
		

	public long getUserId() {
		return userId;
	}
	

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getBuddyCurrentStatus() {
		return buddyCurrentStatus;
	}
	

	public void setBuddyCurrentStatus(String buddyCurrentStatus) {
		this.buddyCurrentStatus = buddyCurrentStatus;
	}

	public int getBuddyCurrentStatusId() {
		return buddyCurrentStatusId;
	}
	

	public void setBuddyCurrentStatusId(int buddyCurrentStatusId) {
		this.buddyCurrentStatusId = buddyCurrentStatusId;
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

	public int getShowTitleToFriends() {
		return showTitleToFriends;
	}

	public void setShowTitleToFriends(int showTitleToFriends) {
		this.showTitleToFriends = showTitleToFriends;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Timestamp getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
}
