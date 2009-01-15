package org.light.portlets.chat;

import org.light.portal.model.Entity;

public class ChattingRecord extends Entity{

	private long chattingId;
	private String name;
	private String content;
	private boolean systemAdd;
	
	public ChattingRecord(){
		super();
	}
	
	public ChattingRecord(long chattingId, String name, String content){
		this();
		this.chattingId = chattingId;
		this.name = name;
		this.content = content;
	}
	
	public boolean isSystemAdd(){
		boolean result = false;
		if(this.content != null && this.content.length() > 3 && this.content.subSequence(0,3).equals("***"))
			result = true;
		return result;
	}
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public long getChattingId() {
		return chattingId;
	}
	

	public void setChattingId(long chattingId) {
		this.chattingId = chattingId;
	}
	
	
	
	
}
