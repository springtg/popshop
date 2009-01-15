package org.light.portal.search.model;

public class SearchResultItem {
	private String userId;
	private String name;
	private String uri;
	private String photoUrl;
	private int photoWidth;
	private int photoHeight;
	private int number;
	private String subject;
	private String summary;
	private String content;
	private String link;
	private String type;
	private boolean showDetail;
	
	private int smallWidth;
	private int smallHeight;
	
	public SearchResultItem(int number, String userId, String name, String uri, String photoUrl, String photoWidth, String photoHeight){
		this.number = number;
		this.userId = userId;
		this.name = name;
		this.uri = uri;
		this.photoUrl = photoUrl;
		try{
			this.photoWidth = Integer.parseInt(photoWidth);
			this.photoHeight = Integer.parseInt(photoHeight);
			setSmallSize();
			
		}catch(Exception e){}
	}
	public SearchResultItem(int number, String userId, String name, String uri, String photoUrl, String photoWidth, String photoHeight, String subject, String summary, String content, String link, String type){
		this(number,userId,name,uri,photoUrl,photoWidth,photoHeight);
		this.subject = subject;
		this.summary = summary;
		this.content = content;
		this.link = link;
		this.type = type;
		this.showDetail = true;
	}
	public void setSmallSize(){
		int newWidth = this.photoWidth;
		int newHeight = this.photoHeight;
		int rate = 90;
		while(newWidth > 100){
			newWidth = this.photoWidth * rate / 100;
			newHeight= this.photoHeight * rate / 100;
			rate--;
		}
		this.smallWidth = newWidth;
		this.smallHeight = newHeight;
	}
	public String getDetail(){
		String desc = (subject == null) ? "" : subject;
		desc+= (summary == null) ? "" : "<br/>"+summary;
		desc+= (content == null) ? "" : "<br/>"+content;
		if(desc.length() > 200) desc=desc.substring(0,200)+"...";
		return desc;
	}
	public int getPhotoSmallWidth(){
		return smallWidth;
	}
	public int getPhotoSmallHeight(){
		return smallHeight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public boolean isShowDetail() {
		return showDetail;
	}
	public void setShowDetail(boolean showDetail) {
		this.showDetail = showDetail;
	}
	
}

