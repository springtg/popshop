/*
 * Copyright (c) 2006 Jianmin Liu.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.light.portal.model;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.light.portal.core.PortalContextFactory;
import org.light.portal.util.DateFormatter;
import static org.light.portal.util.Constants._DEFAULT_LANGUAGE;
import static org.light.portal.util.Constants._DEFAULT_LOCALE;
/**
 * 
 * @author Jianmin Liu
 * @version 1.0.0
 * Creation date: Aug 12, 2006
 **/
public class UserEntity extends Entity implements User{

	private long orgId;
	private String userId;
	private String password;
	private String displayName;	
	private String email;
    private String birth;
    private String gender;
	private String language= _DEFAULT_LANGUAGE;
	private String region= _DEFAULT_LOCALE;
	private String timeZone;
	private String country;
	private String province;
	private String city;
	private String postalCode;
	private String assignedUri;
	private String chosedUri;
	private String photoUrl;
	private int photoWidth;
	private int photoHeight;
	private String caption;
	private String musicUrl;
	private String ringToneUrl;
	private String videoUrl;
	private int showFriendPicture = 1;
	private int showGroupPicture= 1;
	private int notification;
	private int newsLetter;
	private int fqNel; //friend request need email or last name
	private int commentNeedApprove;
	private int showBirthToFriend;
	private int blogCommentFriendOnly;
	private int profileFriendViewOnly;
	private int imprivacy; //0 public can istant meessage me 1 friend only 2 no one can im me
	private int noPicForward;
	private int myMusicAutoPlay = 1;
	private int otherMusucAutoPlay = 1;
	private int defaultMusicStatus = 0;//0 me; 1 friends; 2 public
	private int defaultPictureStatus = 0;//0 me; 1 friends; 2 public
	private int defaultFileStatus = 0;//0 me; 1 friends; 2 public
	private int visitCount;	
	private Date createDate = new Date(System.currentTimeMillis());	
	private Timestamp lastLoginDate;
	private int disabled; //0 enable; 1 disabled;
	private int locked; //0 unlocked; 1 locked;
	private int growKeyword = 1; // 0 when user read the news, system don't collect the keywords
	private int showTitleToFriends;
	private int userCurrentStatusId;
	private String title;
	
	public UserEntity(){
		super();
	}
    
	public UserEntity(String userId, String password, String displayName, String email, long orgId){
		this();
		this.userId = userId;
		this.password = password;
		this.displayName = displayName;		
		this.email = email;	
		this.orgId = orgId;
		this.assignedUri = String.valueOf(System.currentTimeMillis());
		this.lastLoginDate = new Timestamp(System.currentTimeMillis());;		
	}
	
	public UserEntity(String userId, String password, String displayName, String email, String uri, long orgId){
		this();
		this.userId = userId;
		this.password = password;
		this.displayName = displayName;		
		this.email = email;	
		this.chosedUri = uri;
		this.orgId = orgId;
		this.assignedUri = String.valueOf(System.currentTimeMillis());
		this.lastLoginDate = new Timestamp(System.currentTimeMillis());		
	}
	
	public UserEntity(String userId, String password, String displayName,
			String email,String birth, String gender, String language,String region, String  timeZone, String chosedUri, String country, String province, String city, String postalCode, long orgId){
		this();
		this.userId = userId;
		this.password = password;
		this.displayName = displayName;
		this.email = email;		
		this.birth = birth;
		this.gender = gender;
		this.language = language;
		this.region = region;
		this.timeZone = timeZone;
		this.chosedUri = chosedUri;
		this.country = country;
		this.province= province;
		this.city = city;
		this.postalCode = postalCode;
		this.orgId = orgId;
		this.assignedUri = String.valueOf(System.currentTimeMillis());
		this.lastLoginDate = new Timestamp(System.currentTimeMillis());;	
	}
	
	public String getName(){		
		return displayName;
	}
	public String getBirthday(){
		String birthday = "unkown";	
		Calendar calendar = GregorianCalendar.getInstance();
		if(this.birth != null && this.birth.length() == 10){
			int  year = Integer.parseInt(getBirthY());
			int  month = Integer.parseInt(getBirthM());
			int  day = Integer.parseInt(getBirthD());
			calendar.set(year,month - 1,day);
			birthday = DateFormatter.format(calendar.getTime(),"MMMM,dd");
		}
		return birthday;
	}
	public String getBirthY(){
		return (this.birth != null && this.birth.length() == 10) ? birth.substring(0,4) : null;
	}
	public String getBirthM(){
		return (this.birth != null && this.birth.length() == 10) ? birth.substring(5,7) : null;
	}
	public String getBirthD(){
		return (this.birth != null && this.birth.length() == 10) ? birth.substring(8,10) : null;
	}
	public String getAge(){
		String age = "unknow";
		if(this.birth != null && this.birth.length() == 10){
			String  year = getBirthY();
			Calendar calendar = GregorianCalendar.getInstance();
			calendar.setTimeInMillis(System.currentTimeMillis());
			int currentYear = calendar.get( Calendar.YEAR );
			age = String.valueOf(currentYear - Integer.parseInt(year));
		}			
		return age;
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
	
	public String getGenderName(){
		if(this.gender != null){
			if("M".equals(this.gender) || "male".equals(this.gender))
				return PortalContextFactory.getPortalContext().getMessageByKey("portlet.label.gender.male");
			else if("F".equals(this.gender) || "female".equals(this.gender))
				return PortalContextFactory.getPortalContext().getMessageByKey("portlet.label.gender.female");
			else 
				return null;
		}else 
			return null;
	}
	
	public String getLastDate(){
		return DateFormatter.format(this.lastLoginDate);
	}
	
	public boolean userDisabled(){
		return (this.disabled == 0) ? false : true;
	}
	
	public boolean userLocked(){
		return (this.locked == 0) ? false : true;
	}
	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getChosedUri() {
		return chosedUri;
	}

	public void setChosedUri(String chosedUri) {
		this.chosedUri = chosedUri;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAssignedUri() {
		return assignedUri;
	}

	public void setAssignedUri(String assignedUri) {
		this.assignedUri = assignedUri;
	}

	public Timestamp getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getVisitCount() {
		return visitCount;
	}

	public void setVisitCount(int visitCount) {
		this.visitCount = visitCount;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getPhotoHeight() {
		return photoHeight;
	}
	

	public void setPhotoHeight(int photoHeight) {
		this.photoHeight = photoHeight;
	}
	

	public int getPhotoWidth() {
		return photoWidth;
	}
	

	public void setPhotoWidth(int photoWidth) {
		this.photoWidth = photoWidth;
	}

	public String getDisplayName() {
		return displayName;
	}
	

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getMusicUrl() {
		return musicUrl;
	}
	

	public void setMusicUrl(String songUrl) {
		this.musicUrl = songUrl;
	}

	public String getCaption() {
		return caption;
	}
	

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getRingToneUrl() {
		return ringToneUrl;
	}

	public void setRingToneUrl(String ringToneUrl) {
		this.ringToneUrl = ringToneUrl;
	}

	public int getShowFriendPicture() {
		return showFriendPicture;
	}

	public void setShowFriendPicture(int showFriendPicture) {
		this.showFriendPicture = showFriendPicture;
	}

	public int getShowGroupPicture() {
		return showGroupPicture;
	}

	public void setShowGroupPicture(int showGroupPicture) {
		this.showGroupPicture = showGroupPicture;
	}

	public int getBlogCommentFriendOnly() {
		return blogCommentFriendOnly;
	}

	public void setBlogCommentFriendOnly(int blogCommentFriendOnly) {
		this.blogCommentFriendOnly = blogCommentFriendOnly;
	}

	public int getCommentNeedApprove() {
		return commentNeedApprove;
	}

	public void setCommentNeedApprove(int commentNeedApprove) {
		this.commentNeedApprove = commentNeedApprove;
	}

	public int getFqNel() {
		return fqNel;
	}

	public void setFqNel(int fqNel) {
		this.fqNel = fqNel;
	}

	public int getImprivacy() {
		return imprivacy;
	}

	public void setImprivacy(int imprivacy) {
		this.imprivacy = imprivacy;
	}

	public int getMyMusicAutoPlay() {
		return myMusicAutoPlay;
	}

	public void setMyMusicAutoPlay(int myMusicAutoPlay) {
		this.myMusicAutoPlay = myMusicAutoPlay;
	}

	public int getNewsLetter() {
		return newsLetter;
	}

	public void setNewsLetter(int newsLetter) {
		this.newsLetter = newsLetter;
	}

	public int getNoPicForward() {
		return noPicForward;
	}

	public void setNoPicForward(int noPicForward) {
		this.noPicForward = noPicForward;
	}

	public int getNotification() {
		return notification;
	}

	public void setNotification(int notification) {
		this.notification = notification;
	}

	public int getOtherMusucAutoPlay() {
		return otherMusucAutoPlay;
	}

	public void setOtherMusucAutoPlay(int otherMusucAutoPlay) {
		this.otherMusucAutoPlay = otherMusucAutoPlay;
	}

	public int getProfileFriendViewOnly() {
		return profileFriendViewOnly;
	}

	public void setProfileFriendViewOnly(int profileFriendViewOnly) {
		this.profileFriendViewOnly = profileFriendViewOnly;
	}

	public int getShowBirthToFriend() {
		return showBirthToFriend;
	}

	public void setShowBirthToFriend(int showBirthToFriend) {
		this.showBirthToFriend = showBirthToFriend;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getRegion() {
		return region;
	}
	

	public void setRegion(String region) {
		this.region = region;
	}

	public int getUserCurrentStatusId() {
		return userCurrentStatusId;
	}

	public void setUserCurrentStatusId(int userCurrentStatusId) {
		this.userCurrentStatusId = userCurrentStatusId;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public int getDisabled() {
		return disabled;
	}

	public void setDisabled(int disabled) {
		this.disabled = disabled;
	}

	public int getLocked() {
		return locked;
	}

	public void setLocked(int locked) {
		this.locked = locked;
	}

	public int getDefaultFileStatus() {
		return defaultFileStatus;
	}

	public void setDefaultFileStatus(int defaultFileStatus) {
		this.defaultFileStatus = defaultFileStatus;
	}

	public int getDefaultMusicStatus() {
		return defaultMusicStatus;
	}

	public void setDefaultMusicStatus(int defaultMusicStatus) {
		this.defaultMusicStatus = defaultMusicStatus;
	}

	public int getDefaultPictureStatus() {
		return defaultPictureStatus;
	}

	public void setDefaultPictureStatus(int defaultPictureStatus) {
		this.defaultPictureStatus = defaultPictureStatus;
	}

	public int getGrowKeyword() {
		return growKeyword;
	}

	public void setGrowKeyword(int growKeyword) {
		this.growKeyword = growKeyword;
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
	
	public long getOrgId() {
		return orgId;
	}

	public void setOrgId(long orgId) {
		this.orgId = orgId;
	}
	
	
	
	

}
