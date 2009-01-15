package org.light.portlets.group;

import org.light.portal.model.Entity;

public class UserGroup extends Entity {

	private long userId;
	private long groupId;
	private int acceptLeaderBulletin =1;
	private int acceptMembersBulletin;
	
	//read only
	private String displayName;
	private String uri;
	private Integer openJoin;
	private Integer memberInvite; 
	private String photoUrl;
	private int photoWidth;
	private int photoHeight;
	
	private String userPhotoUrl;
	private int userPhotoWidth;
	private int userPhotoHeight;
	private String userAssignedUri;
	private String userChosedUri;
	private String userDisplayName;
	private int userCurrentStatusId;
	
	public UserGroup(){
		super();
	}
	
	public UserGroup(long userId,long groupId){
		this();
		this.userId = userId;
		this.groupId= groupId;
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
	public int getUserPhotoSmallWidth(){
		int newWidth = this.userPhotoWidth;
		int newHeight = this.userPhotoHeight;
		int rate = 9;
		while(newWidth > 200){
			newWidth = this.userPhotoWidth * rate / 10;
			newHeight= this.userPhotoHeight * rate / 10;
			rate--;
		}
		return newWidth;
	}
	public int getUserPhotoSmallHeight(){
		int newWidth = this.userPhotoWidth;
		int newHeight = this.userPhotoHeight;
		int rate = 9;
		while(newWidth > 200){
			newWidth = this.userPhotoWidth * rate / 10;
			newHeight= this.userPhotoHeight * rate / 10;
			rate--;
		}
		return newHeight;
	}
	
	public String getUserUri() {
		String uri = this.userAssignedUri;
		if(this.userChosedUri != null)
			uri = this.userChosedUri;
		return uri;
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

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserAssignedUri() {
		return userAssignedUri;
	}
	

	public void setUserAssignedUri(String userAssignedUri) {
		this.userAssignedUri = userAssignedUri;
	}
	

	public String getUserChosedUri() {
		return userChosedUri;
	}
	

	public void setUserChosedUri(String userChosedUri) {
		this.userChosedUri = userChosedUri;
	}
	

	public String getUserDisplayName() {
		return userDisplayName;
	}
	

	public void setUserDisplayName(String userDisplayName) {
		this.userDisplayName = userDisplayName;
	}
	

	public int getUserPhotoHeight() {
		return userPhotoHeight;
	}
	

	public void setUserPhotoHeight(int userPhotoHeight) {
		this.userPhotoHeight = userPhotoHeight;
	}
	

	public String getUserPhotoUrl() {
		return userPhotoUrl;
	}
	

	public void setUserPhotoUrl(String userPhotoUrl) {
		this.userPhotoUrl = userPhotoUrl;
	}
	

	public int getUserPhotoWidth() {
		return userPhotoWidth;
	}
	

	public void setUserPhotoWidth(int userPhotoWidth) {
		this.userPhotoWidth = userPhotoWidth;
	}

	public int getUserCurrentStatusId() {
		return userCurrentStatusId;
	}
	

	public void setUserCurrentStatusId(int userCurrentStatusId) {
		this.userCurrentStatusId = userCurrentStatusId;
	}

	public int getAcceptLeaderBulletin() {
		return acceptLeaderBulletin;
	}
	

	public void setAcceptLeaderBulletin(int acceptLeaderBulletin) {
		this.acceptLeaderBulletin = acceptLeaderBulletin;
	}
	

	public int getAcceptMembersBulletin() {
		return acceptMembersBulletin;
	}
	

	public void setAcceptMembersBulletin(int acceptMembersBulletin) {
		this.acceptMembersBulletin = acceptMembersBulletin;
	}

	public Integer getMemberInvite() {
		return memberInvite;
	}

	public void setMemberInvite(Integer memberInvite) {
		this.memberInvite = memberInvite;
	}

	public Integer getOpenJoin() {
		return openJoin;
	}

	public void setOpenJoin(Integer openJoin) {
		this.openJoin = openJoin;
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
	
	
	
	

}
