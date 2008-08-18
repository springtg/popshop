package com.poprlz.chat.web;

import com.opensymphony.xwork2.ActionSupport;

public class ChatMessagerAction extends ActionSupport {
	
	private String messageInfo;
	private String sendUserId;
	private String sendUserName;
	private String receiverId;
	private String receiverName;
	
	private int lastAcessId;
	
	public String getMessageInfo() {
		return messageInfo;
	}

	public void setMessageInfo(String messageInfo) {
		this.messageInfo = messageInfo;
	}

	public String getSendUserId() {
		return sendUserId;
	}

	public void setSendUserId(String sendUserId) {
		this.sendUserId = sendUserId;
	}

	public String getSendUserName() {
		return sendUserName;
	}

	public void setSendUserName(String sendUserName) {
		this.sendUserName = sendUserName;
	}

	public String getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public int getLastAcessId() {
		return lastAcessId;
	}

	public void setLastAcessId(int lastAcessId) {
		this.lastAcessId = lastAcessId;
	}

	public String sendMessager() throws Exception{
		return SUCCESS;
	}
	
	public String getMessager() throws Exception{
		return SUCCESS;
	}

}
