package org.light.portal.model;

import java.util.Date;


public class UserFavourite extends Entity{

	private long userId;
	private long favouriteId;
	private Date createDate = new Date(System.currentTimeMillis());
	//read only
	private String photoUrl;
	private int photoWidth;
	private int photoHeight;
	private String assignedUri;
	private String chosedUri;
	private String displayName;
	
	public UserFavourite(){
		super();
	}
	
	public UserFavourite(long userId, long favouriteId){
		this();
		this.userId = userId;
		this.favouriteId = favouriteId;	
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
	

	public long getFavouriteId() {
		return favouriteId;
	}
	

	public void setFavouriteId(long favouriteId) {
		this.favouriteId = favouriteId;
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
	

	public long getUserId() {
		return userId;
	}
	

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Date getCreateDate() {
		return createDate;
	}
	

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}
