package com.poprlz.chat.entity;

import java.io.Serializable;
import java.util.List;

public class Chat implements Serializable {
	
	private Integer chatId;
	private String chatName;
	private List<ChatUser> chatUser;
	public Integer getChatId() {
		return chatId;
	}
	public void setChatId(Integer chatId) {
		this.chatId = chatId;
	}
	public String getChatName() {
		return chatName;
	}
	public void setChatName(String chatName) {
		this.chatName = chatName;
	}
	public List<ChatUser> getChatUser() {
		return chatUser;
	}
	public void setChatUser(List<ChatUser> chatUser) {
		this.chatUser = chatUser;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chatId == null) ? 0 : chatId.hashCode());
		result = prime * result
				+ ((chatName == null) ? 0 : chatName.hashCode());
		result = prime * result
				+ ((chatUser == null) ? 0 : chatUser.hashCode());
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
		Chat other = (Chat) obj;
		if (chatId == null) {
			if (other.chatId != null)
				return false;
		} else if (!chatId.equals(other.chatId))
			return false;
		if (chatName == null) {
			if (other.chatName != null)
				return false;
		} else if (!chatName.equals(other.chatName))
			return false;
		if (chatUser == null) {
			if (other.chatUser != null)
				return false;
		} else if (!chatUser.equals(other.chatUser))
			return false;
		return true;
	}
	
	
	
	

}
