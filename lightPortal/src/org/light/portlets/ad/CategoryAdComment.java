package org.light.portlets.ad;

import java.sql.Timestamp;

import org.light.portal.model.Entity;
import org.light.portal.util.DateFormatter;

public class CategoryAdComment extends Entity {

	private long categoryAdId;
	private long postById;
	private String comment;
	private Timestamp createDate = new Timestamp(System.currentTimeMillis());
	//read only
	private String assignedUri;
	private String chosedUri;
	private String displayName;
	
	public CategoryAdComment(){
		super();
	}
	
	public CategoryAdComment(long categoryAdId, long postById, String comment){
		this();
		this.categoryAdId = categoryAdId;
		this.postById = postById;
		this.comment = comment;		
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
	
	public Timestamp getCreateDate() {
		return createDate;
	}
	

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
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

	public String getDisplayName() {
		return displayName;
	}
	

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getComment() {
		return comment;
	}
	

	public void setComment(String comment) {
		this.comment = comment;
	}
	

	public long getPostById() {
		return postById;
	}
	

	public void setPostById(long postById) {
		this.postById = postById;
	}

	public long getCategoryAdId() {
		return categoryAdId;
	}

	public void setCategoryAdId(long categoryAdId) {
		this.categoryAdId = categoryAdId;
	}
	

}
