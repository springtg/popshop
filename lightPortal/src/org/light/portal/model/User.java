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
import java.util.Date;


/**
 * 
 * @author Jianmin Liu
 * @version 1.0.0
 * Creation date: Aug 12, 2006
 **/
public interface User {
	public long getId();
	public long getOrgId();	
	public String getUserId();
	public String getPassword();	
	public String getEmail();	
	public String getBirth();
	public String getLanguage();
	public String getCountry();
	public String getProvince();
	public String getCity();
	public String getPostalCode();
	public String getName();
	public String getAge();
	public String getAssignedUri();	
	public String getChosedUri();
	public String getUri();
	public Timestamp getLastLoginDate();
	public Date getCreateDate();
	public int getVisitCount();
	public String getPhotoUrl();
	public String getLastDate();
	public String getGender();
	public String getGenderName();
	public int getPhotoWidth();
	public int getPhotoHeight();
	public String getDisplayName();
	public String getCaption();
	public String getMusicUrl();
	public int getOtherMusucAutoPlay();
	public int getMyMusicAutoPlay();
	public String getRingToneUrl();
	public int getBlogCommentFriendOnly();
	public int getCommentNeedApprove();
	public int getFqNel();
	public int getImprivacy();	
	public int getNewsLetter();
	public int getNoPicForward();
	public int getNotification();
	public int getProfileFriendViewOnly();
	public int getShowBirthToFriend();
	public String getVideoUrl() ;
	public String getRegion();
	public String getBirthY();
	public String getBirthM();
	public String getBirthD();
	public String getTimeZone();
	public int getDefaultFileStatus();
	public int getDefaultPictureStatus();
	public int getDefaultMusicStatus();
	public int getGrowKeyword();
	public int getShowTitleToFriends();
	public String getTitle();
	public int getPhotoSmallWidth();
	public int getPhotoSmallHeight();
	
	public boolean userDisabled();
	public boolean userLocked();
	
	public void setId(long id);
	public void setOrgId(long orgId);
	public void setTitle(String title);
	public void setShowTitleToFriends(int showTitleToFriends);
	public void setGrowKeyword(int growKeyword);
	public void setDefaultFileStatus(int defaultFileStatus);
	public void setDefaultPictureStatus(int defaultPictureStatus);
	public void setDefaultMusicStatus(int defaultMusicStatus);
	public void setDisabled(int disabled);
	public void setLocked(int locked);
	public void setTimeZone(String timeZone);
	public void setRegion(String region);
	public void setBlogCommentFriendOnly(int blogCommentFriendOnly);
	public void setCommentNeedApprove(int commentNeedApprove);
	public void setFqNel(int fqNel);
	public void setImprivacy(int imprivacy);
	public void setNewsLetter(int newsLetter);
	public void setNoPicForward(int noPicForward);
	public void setNotification(int notification);
	public void setProfileFriendViewOnly(int profileFriendViewOnly);	
	public void setShowBirthToFriend(int showBirthToFriend);
	public void setVideoUrl(String videoUrl);
	public void setRingToneUrl(String ringToneUrl);
	public void setMyMusicAutoPlay(int myMusicAutoPlay);
	public void setOtherMusucAutoPlay(int otherMusucAutoPlay);
	public void setMusicUrl(String musicUrl);
	public void setCaption(String caption);
	public void setDisplayName(String displayName);
	public void setPhotoHeight(int photoHeight);	
	public void setPhotoWidth(int photoWidth);
	public void setGender(String gender);
	public void setCreateDate(Date createDate);
	public void setVisitCount(int visitCount);
	public void setPhotoUrl(String photoUrl);
	public void setLastLoginDate(Timestamp lastLoginDate);
	public void setAssignedUri(String givenUri);
	public void setChosedUri(String chosedUri);
	public void setUserId(String userId);
	public void setPassword(String password);	
	public void setEmail(String email);
	public void setBirth(String birth);
	public void setLanguage(String language);
	public void setCountry(String country);
	public void setProvince(String province);
	public void setCity(String city);
	public void setPostalCode(String postalCode);
	
}
