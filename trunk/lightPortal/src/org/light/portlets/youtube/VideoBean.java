package org.light.portlets.youtube;

public class VideoBean {
	private String author;
	private String id;
	private String title;
	private String desc;
	private String picUrl;
	private String videoUrl;
	private String seconds;
	private String ratingAvg;
	private String ratingCount;
	private String viewCount;
	private String commentCount;
	private String tags;
	
	public VideoBean(){
		
	}
	
	public VideoBean(String author,String id,String title,String desc,String picUrl,String videoUrl
			,String seconds,String ratingAvg,String ratingCount,String viewCount,String commentCount,String tags){
		this.author = author;
		this.id = id;
		this.title = title;
		this.desc = desc;
		this.picUrl = picUrl;
		this.videoUrl = videoUrl;
		this.seconds = seconds;
		this.ratingAvg = ratingAvg;
		this.ratingCount = ratingCount;
		this.viewCount = viewCount;
		this.commentCount = commentCount;
		this.tags = tags;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(String commentCount) {
		this.commentCount = commentCount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRatingAvg() {
		return ratingAvg;
	}

	public void setRatingAvg(String ratingAvg) {
		this.ratingAvg = ratingAvg;
	}

	public String getRatingCount() {
		return ratingCount;
	}

	public void setRatingCount(String ratingCount) {
		this.ratingCount = ratingCount;
	}

	public String getSeconds() {
		return seconds;
	}

	public void setSeconds(String seconds) {
		this.seconds = seconds;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getViewCount() {
		return viewCount;
	}

	public void setViewCount(String viewCount) {
		this.viewCount = viewCount;
	}
}
