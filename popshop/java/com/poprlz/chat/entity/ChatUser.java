package com.poprlz.chat.entity;

import java.io.Serializable;

public class ChatUser implements Serializable {
	
	private String userId;
	private String userName;
	private String userLogoInfo;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserLogoInfo() {
		return userLogoInfo;
	}
	public void setUserLogoInfo(String userLogoInfo) {
		this.userLogoInfo = userLogoInfo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result
				+ ((userLogoInfo == null) ? 0 : userLogoInfo.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChatUser other = (ChatUser) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userLogoInfo == null) {
			if (other.userLogoInfo != null)
				return false;
		} else if (!userLogoInfo.equals(other.userLogoInfo))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	

}
