package org.light.portlets.chat;

import org.light.portal.model.Entity;

public class Chat extends Entity {
	
	private long userId;	
	private int defaultStatus;
	private int currentStatus;
	private String currentStatusDesc;
	
	//read only
	private String displayName;
	
	public Chat(){
		super();
	}
	public Chat(long userId, int defaultStatus, int currentStatus) {
		this();
		this.userId = userId;
		this.defaultStatus = defaultStatus;
		this.currentStatus = currentStatus;
	}
		
	public int getCurrentStatus() {
		return currentStatus;
	}
	
	public void setCurrentStatus(int currentStatus) {
		this.currentStatus = currentStatus;
	}
	
	public int getDefaultStatus() {
		return defaultStatus;
	}
	
	public void setDefaultStatus(int defaultStatus) {
		this.defaultStatus = defaultStatus;
	}
	
	public long getUserId() {
		return userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getCurrentStatusDesc() {
		return currentStatusDesc;
	}
	
	public void setCurrentStatusDesc(String currentStatusDesc) {
		this.currentStatusDesc = currentStatusDesc;
	}
	public String getDisplayName() {
		return displayName;
	}
	
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	
	
}
