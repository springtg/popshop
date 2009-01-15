package org.light.portlets.message;

import java.sql.Timestamp;
import java.util.Date;

import org.light.portal.model.Entity;

public class Message extends Entity {
	
	private long userId;
	private long postById;
	private String subject;
	private String content;
	private Timestamp  createDate = new Timestamp(System.currentTimeMillis());
	private String status = "0"; //"0" is new message;"1" is read message.
	private int event; // 0 regular 1 group 2 calendar
	private int type; // 0 n/a 1 invite 2 request
	private long eventId;
	
	//read only
	private String fromPhotoUrl;
	private int fromPhotoWidth;
	private int fromPhotoHeight;
	private String fromAssignedUri;
	private String fromChosedUri;
	private String fromDisplayName;
	private int fromCurrentStatusId;
	
	private String toPhotoUrl;
	private int toPhotoWidth;
	private int toPhotoHeight;
	private String toAssignedUri;
	private String toChosedUri;
	private String toDisplayName;
	private int toCurrentStatusId;
	public Message(){
		super();
	}
    
	public Message(String subject,String content,long userId){
		this();
		this.subject = subject;
		this.content = content;
		this.userId = userId;
		this.postById = userId;
	}
	
	public Message(String subject,String content,long userId,long postById){
		this();
		this.subject = subject;
		this.content = content;
		this.userId = userId;
		this.postById = postById;
	}
	
	public Message(String subject,String content,long userId,long postById,int event,int type,long eventId){
		this();
		this.subject = subject;
		this.content = content;
		this.userId = userId;
		this.postById = postById;
		this.event =event;
		this.type = type;
		this.eventId = eventId;
	}
	
	public String getFromUri() {
		String uri = this.fromAssignedUri;
		if(this.fromChosedUri != null)
			uri = this.fromChosedUri;
		return uri;
	}
	
	public String getToUri() {
		String uri = this.toAssignedUri;
		if(this.toChosedUri != null)
			uri = this.toChosedUri;
		return uri;
	}
	public int getFromPhotoSmallWidth(){
		int newWidth = this.fromPhotoWidth;
		int newHeight = this.fromPhotoHeight;
		int rate = 9;
		while(newWidth > 200){
			newWidth = this.fromPhotoWidth * rate / 10;
			newHeight= this.fromPhotoHeight * rate / 10;
			rate--;
		}
		return newWidth;
	}
	public int getFromPhotoSmallHeight(){
		int newWidth = this.fromPhotoWidth;
		int newHeight = this.fromPhotoHeight;
		int rate = 9;
		while(newWidth > 200){
			newWidth = this.fromPhotoWidth * rate / 10;
			newHeight= this.fromPhotoHeight * rate / 10;
			rate--;
		}
		return newHeight;
	}
	public int getToPhotoSmallWidth(){
		int newWidth = this.toPhotoWidth;
		int newHeight = this.toPhotoHeight;
		int rate = 9;
		while(newWidth > 200){
			newWidth = this.toPhotoWidth * rate / 10;
			newHeight= this.toPhotoHeight * rate / 10;
			rate--;
		}
		return newWidth;
	}
	public int getToPhotoSmallHeight(){
		int newWidth = this.toPhotoWidth;
		int newHeight = this.toPhotoHeight;
		int rate = 9;
		while(newWidth > 200){
			newWidth = this.toPhotoWidth * rate / 10;
			newHeight= this.toPhotoHeight * rate / 10;
			rate--;
		}
		return newHeight;
	}
	public String getContent() {
		return content;
	}
	

	public void setContent(String content) {
		this.content = content;
	}
	

	public long getPostById() {
		return postById;
	}
	

	public void setPostById(long postById) {
		this.postById = postById;
	}
	

	public String getSubject() {
		return subject;
	}
	

	public void setSubject(String subject) {
		this.subject = subject;
	}
	

	public long getUserId() {
		return userId;
	}
	

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}
	

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFromAssignedUri() {
		return fromAssignedUri;
	}
	

	public void setFromAssignedUri(String fromAssignedUri) {
		this.fromAssignedUri = fromAssignedUri;
	}
	

	public String getFromChosedUri() {
		return fromChosedUri;
	}
	

	public void setFromChosedUri(String fromChosedUri) {
		this.fromChosedUri = fromChosedUri;
	}
	

	public String getFromDisplayName() {
		return fromDisplayName;
	}
	

	public void setFromDisplayName(String fromDisplayName) {
		this.fromDisplayName = fromDisplayName;
	}
	

	public String getToAssignedUri() {
		return toAssignedUri;
	}
	

	public void setToAssignedUri(String toAssignedUri) {
		this.toAssignedUri = toAssignedUri;
	}
	

	public String getToChosedUri() {
		return toChosedUri;
	}
	

	public void setToChosedUri(String toChosedUri) {
		this.toChosedUri = toChosedUri;
	}
	

	public String getToDisplayName() {
		return toDisplayName;
	}
	

	public void setToDisplayName(String toDisplayName) {
		this.toDisplayName = toDisplayName;
	}

	public int getFromPhotoHeight() {
		return fromPhotoHeight;
	}
	

	public void setFromPhotoHeight(int fromPhotoHeight) {
		this.fromPhotoHeight = fromPhotoHeight;
	}
	

	public String getFromPhotoUrl() {
		return fromPhotoUrl;
	}
	

	public void setFromPhotoUrl(String fromPhotoUrl) {
		this.fromPhotoUrl = fromPhotoUrl;
	}
	

	public int getFromPhotoWidth() {
		return fromPhotoWidth;
	}
	

	public void setFromPhotoWidth(int fromPhotoWidth) {
		this.fromPhotoWidth = fromPhotoWidth;
	}
	

	public int getToPhotoHeight() {
		return toPhotoHeight;
	}
	

	public void setToPhotoHeight(int toPhotoHeight) {
		this.toPhotoHeight = toPhotoHeight;
	}
	

	public String getToPhotoUrl() {
		return toPhotoUrl;
	}
	

	public void setToPhotoUrl(String toPhotoUrl) {
		this.toPhotoUrl = toPhotoUrl;
	}
	

	public int getToPhotoWidth() {
		return toPhotoWidth;
	}
	

	public void setToPhotoWidth(int toPhotoWidth) {
		this.toPhotoWidth = toPhotoWidth;
	}

	public int getEvent() {
		return event;
	}
	

	public void setEvent(int event) {
		this.event = event;
	}
	

	public long getEventId() {
		return eventId;
	}
	

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}
	

	public int getType() {
		return type;
	}
	

	public void setType(int type) {
		this.type = type;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}
	

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public int getFromCurrentStatusId() {
		return fromCurrentStatusId;
	}

	public void setFromCurrentStatusId(int fromCurrentStatusId) {
		this.fromCurrentStatusId = fromCurrentStatusId;
	}

	public int getToCurrentStatusId() {
		return toCurrentStatusId;
	}

	public void setToCurrentStatusId(int toCurrentStatusId) {
		this.toCurrentStatusId = toCurrentStatusId;
	}
	
	
	
	

}
