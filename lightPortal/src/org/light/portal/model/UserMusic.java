package org.light.portal.model;

import java.sql.Timestamp;


public class UserMusic extends Entity{

	private long userId;
	private String musicUrl;	
	private String caption;
	private int status; //0 for me only; 1 for my friends 2 for public;
	private int rankable;
	private Timestamp  createDate = new Timestamp(System.currentTimeMillis());
	
	public UserMusic(){
		super();
	}
	
	public UserMusic(long userId,String musicUrl,String caption,int status){
		this.userId = userId;
		this.musicUrl = musicUrl;
		this.caption = caption;		
		this.status = status;
	}
	public String getMusicName(){
		String name = this.musicUrl;
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

	public String getMusicUrl() {
		return musicUrl;
	}

	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}

	public int getRankable() {
		return rankable;
	}

	public void setRankable(int rankable) {
		this.rankable = rankable;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


}
