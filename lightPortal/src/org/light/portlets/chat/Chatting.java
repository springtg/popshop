package org.light.portlets.chat;

import java.util.Set;

import org.light.portal.model.Entity;

public class Chatting extends Entity{
	
	private long from;
	private long to;
	private int status;
	private Set chattingRecord;
	private String fromName;
	
	public Chatting(){
		super();
	}
	
	public Chatting(long from ,long to){
		this();
		this.from = from;
		this.to = to;
		this.status = 0;
	}
	
	public long getFrom() {
		return from;
	}
	
	public void setFrom(long from) {
		this.from = from;
	}
		
	public long getTo() {
		return to;
	}
	
	public void setTo(long to) {
		this.to = to;
	}

	public int getStatus() {
		return status;
	}
	

	public void setStatus(int status) {
		this.status = status;
	}

	public Set getChattingRecord() {
		return chattingRecord;
	}
	
	public void setChattingRecord(Set chattingRecord) {
		this.chattingRecord = chattingRecord;
	}

	public String getFromName() {
		return fromName;
	}
	

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
				
}
