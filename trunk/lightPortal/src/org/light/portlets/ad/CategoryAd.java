package org.light.portlets.ad;

import java.sql.Date;
import java.sql.Timestamp;

import org.light.portal.model.Entity;
import org.light.portal.util.DateFormatter;

public class CategoryAd extends Entity {

	private long userId;
	private String title;
	private String content;
	private Timestamp  createDate = new Timestamp(System.currentTimeMillis());
	private Date showDate;
	private Date effDate;
	private Date endEffDate;
	private int status; // 0 draft 1 posted
	private int category;
	private String country;
	private String province;
	private String city;
	private String adUrl;
	private int score;
//	read only
	private String photoUrl;
	private int photoWidth;
	private int photoHeight;
	private String assignedUri;
	private String chosedUri;
	private String displayName;
	private int commentCount;
    
	public CategoryAd(){
		super();
	}
	
	public CategoryAd(String title, String content,int category,String country,String province,String city,String adUrl,int status,long userId,Date showDate,Date effDate,Date endEffDate){
		this();		
		this.title = title;
		this.content = content;
		this.category = category;
		this.country = country;
		this.province = province;
		this.city = city;
		this.adUrl = adUrl;
		this.status = status;
		this.userId = userId;
		this.showDate = showDate;
		this.effDate = effDate;
		this.endEffDate = endEffDate;
	}
	
	public String getLocation(){
		String location = "";
		if(this.city != null)
			location = this.city;
		if(this.province != null)
			if(location.length() > 0)
				location+=","+this.province;
			else
				location = this.province;
		if(this.country != null)
			if(location.length() > 0)
				location+=" "+this.country;
			else
				location = this.country;
		return location;
	}
	public String getDate(){
		 return DateFormatter.format(this.createDate,"EEE, MMM dd, yyyy");
	}
	
	public String getFullDate(){
		 return DateFormatter.format(this.createDate,"EEEE, MMMM dd, yyyy HH:mm aaa");
	}
	
	public String getUri() {
		String uri = this.assignedUri;
		if(this.chosedUri != null)
			uri = this.chosedUri;
		return uri;
	}

	public String getAssignedUri() {
		return assignedUri;
	}

	public void setAssignedUri(String assignedUri) {
		this.assignedUri = assignedUri;
	}

	public String getChosedUri() {
		return chosedUri;
	}

	public void setChosedUri(String chosedUri) {
		this.chosedUri = chosedUri;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}


	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getAdUrl() {
		return adUrl;
	}

	public void setAdUrl(String adUrl) {
		this.adUrl = adUrl;
	}

	public Date getEffDate() {
		return effDate;
	}

	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}

	public Date getEndEffDate() {
		return endEffDate;
	}

	public void setEndEffDate(Date endEffDate) {
		this.endEffDate = endEffDate;
	}

	public Date getShowDate() {
		return showDate;
	}

	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public int getPhotoHeight() {
		return photoHeight;
	}

	public void setPhotoHeight(int photoHeight) {
		this.photoHeight = photoHeight;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public int getPhotoWidth() {
		return photoWidth;
	}

	public void setPhotoWidth(int photoWidth) {
		this.photoWidth = photoWidth;
	}
	
}
