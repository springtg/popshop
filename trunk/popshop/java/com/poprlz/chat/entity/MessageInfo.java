package com.poprlz.chat.entity;

import java.io.Serializable;
import java.util.Date;

public class MessageInfo implements Serializable {
	
	private Chat chat;
	private Integer messageInfoId;
	private ChatUser sender;
	private ChatUser receiver;
	private String messageContent;
	private Date createDate;
	public Chat getChat() {
		return chat;
	}
	public void setChat(Chat chat) {
		this.chat = chat;
	}
	public Integer getMessageInfoId() {
		return messageInfoId;
	}
	public void setMessageInfoId(Integer messageInfoId) {
		this.messageInfoId = messageInfoId;
	}
	public ChatUser getSender() {
		return sender;
	}
	public void setSender(ChatUser sender) {
		this.sender = sender;
	}
	public ChatUser getReceiver() {
		return receiver;
	}
	public void setReceiver(ChatUser receiver) {
		this.receiver = receiver;
	}
 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chat == null) ? 0 : chat.hashCode());
		result = prime * result
				+ ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result
				+ ((messageContent == null) ? 0 : messageContent.hashCode());
		result = prime * result
				+ ((messageInfoId == null) ? 0 : messageInfoId.hashCode());
		result = prime * result
				+ ((receiver == null) ? 0 : receiver.hashCode());
		result = prime * result + ((sender == null) ? 0 : sender.hashCode());
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
		MessageInfo other = (MessageInfo) obj;
		if (chat == null) {
			if (other.chat != null)
				return false;
		} else if (!chat.equals(other.chat))
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (messageContent == null) {
			if (other.messageContent != null)
				return false;
		} else if (!messageContent.equals(other.messageContent))
			return false;
		if (messageInfoId == null) {
			if (other.messageInfoId != null)
				return false;
		} else if (!messageInfoId.equals(other.messageInfoId))
			return false;
		if (receiver == null) {
			if (other.receiver != null)
				return false;
		} else if (!receiver.equals(other.receiver))
			return false;
		if (sender == null) {
			if (other.sender != null)
				return false;
		} else if (!sender.equals(other.sender))
			return false;
		return true;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
	
	

}
