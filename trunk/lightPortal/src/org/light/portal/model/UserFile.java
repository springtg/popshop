package org.light.portal.model;

import java.sql.Timestamp;


public class UserFile extends Entity{

	private long userId;
	private String fileUrl;	
	private String caption;	
	private int status; //0 for me only; 1 for my friends 2 for public;
	private Timestamp  createDate = new Timestamp(System.currentTimeMillis());
	
	public UserFile(){
		super();
	}
	
	public UserFile(long userId,String fileUrl,String caption, int status){
		this.userId = userId;
		this.fileUrl = fileUrl;
		this.caption = caption;		
		this.status = status;
	}
	public String getFileName(){
		String name = this.fileUrl;
		int index = name.lastIndexOf("/");
		name = name.substring(index+1,name.length());
		return name;
	}
	

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}	

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


}
