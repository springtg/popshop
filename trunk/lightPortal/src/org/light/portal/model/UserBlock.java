package org.light.portal.model;

import java.util.Date;


public class UserBlock extends Entity{
	private long userId;
	private long blockId;
	private Date createDate = new Date(System.currentTimeMillis());
	//read only
	private String photoUrl;
	private int photoWidth;
	private int photoHeight;
	private String assignedUri;
	private String chosedUri;
	private String displayName;
	
	public UserBlock(){
		super();
	}
	
	public UserBlock(long userId, long blockId){
		this();
		this.userId = userId;
		this.blockId = blockId;	
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
	
	public Date getCreateDate() {
		return createDate;
	}
	

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public long getBlockId() {
		return blockId;
	}

	public void setBlockId(long blockId) {
		this.blockId = blockId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
}
