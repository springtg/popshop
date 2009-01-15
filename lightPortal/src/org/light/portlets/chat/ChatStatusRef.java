package org.light.portlets.chat;

import org.light.portal.model.Entity;

public class ChatStatusRef extends Entity{
	
	public final static int ONLINE = 1;
	public final static int OFFLINE = 0;
	
	private int statusId;
	private String statusDesc;
	
	public ChatStatusRef(){
		super();
	}
	
	public ChatStatusRef(int id,String desc){
		this.statusId = id;
		this.statusDesc = desc;
	}

	public String getStatusDesc() {
		return statusDesc;
	}
	

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	

	public int getStatusId() {
		return statusId;
	}
	

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	
}
