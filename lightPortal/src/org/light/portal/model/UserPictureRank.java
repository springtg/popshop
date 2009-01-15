package org.light.portal.model;

import java.util.Date;


public class UserPictureRank extends Entity{

	private long userId;
	private long pictureId;
	private int rankScore;
	private long rankById;
	private Date createDate = new Date(System.currentTimeMillis());	
	
	public UserPictureRank(){
		super();
	}
	
	public UserPictureRank(long userId,long pictureId,int rankScore,long rankById){
		this();
		this.userId = userId;
		this.pictureId = pictureId;
		this.rankScore = rankScore;
		this.rankById= rankById;
	}

	public long getPictureId() {
		return pictureId;
	}
	

	public void setPictureId(long pictureId) {
		this.pictureId = pictureId;
	}
	

	public long getRankById() {
		return rankById;
	}
	

	public void setRankById(long rankById) {
		this.rankById = rankById;
	}
	

	public int getRankScore() {
		return rankScore;
	}
	

	public void setRankScore(int rankScore) {
		this.rankScore = rankScore;
	}
	

	public long getUserId() {
		return userId;
	}
	

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Date getCreateDate() {
		return createDate;
	}
	

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}
