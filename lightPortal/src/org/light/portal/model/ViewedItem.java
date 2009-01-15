package org.light.portal.model;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.light.portal.util.DateFormatter;

public class ViewedItem  extends Entity{

	   private String link;
	   private String title;
	   private String desc;
	   private String tag;
	   private String locale;
	   //private String postById;
	   private int popCount;
	   private Timestamp viewedDate;
	   
	   //	 read only
		private String photoUrl;
		private int photoWidth;
		private int photoHeight;
		private String assignedUri;
		private String chosedUri;
		private String displayName;
		private int currentStatusId;
		
	   public ViewedItem(){
	       super();
	   }

	   public ViewedItem(String link,String title,String desc, String tag, String locale){
	       this();
	       this.link = link;
	       this.title = title;
	       this.desc = desc;
	       this.tag = tag;
	       this.locale = locale;
	       //this.postById = postById;
	       this.viewedDate = new Timestamp(System.currentTimeMillis());
	   }

	   public void popIt(){
	       this.popCount++;
	       this.viewedDate = new Timestamp(System.currentTimeMillis());
	   }
	   
	   public String getTime(){
		   return DateFormatter.calculateDifference(new Date(System.currentTimeMillis()),new Date(this.viewedDate.getTime()));	
	   }
	   public int getPhotoSmallWidth(){
			int newWidth = this.photoWidth;
			//int newHeight = this.photoHeight;
			int rate = 9;
			while(newWidth > 200){
				newWidth = this.photoWidth * rate / 10;
				//newHeight= this.photoHeight * rate / 10;
				rate--;
			}
			return newWidth;
		}
		public int getPhotoSmallHeight(){
			int newWidth = this.photoWidth;
			int newHeight = this.photoHeight;
			int rate = 9;
			while(newWidth > 200){
				newWidth = this.photoWidth * rate / 10;
				newHeight= this.photoHeight * rate / 10;
				rate--;
			}
			return newHeight;
		}
						
		public String getUri() {
			String uri = this.assignedUri;
			if(this.chosedUri != null)
				uri = this.chosedUri;
			return uri;
		}
		
	   public String getDesc() {
	       return desc;
	   }


	   public void setDesc(String desc) {
	       this.desc = desc;
	   }

	   public String getLink() {
	       return link;
	   }


	   public void setLink(String link) {
	       this.link = link;
	   }


	   public String getTitle() {
	       return title;
	   }


	   public void setTitle(String title) {
	       this.title = title;
	   }

	  
	   public int getPopCount() {
	       return popCount;
	   }


	   public void setPopCount(int popCount) {
	       this.popCount = popCount;
	   }

	public Timestamp getViewedDate() {
		return viewedDate;
	}

	public void setViewedDate(Timestamp viewedDate) {
		this.viewedDate = viewedDate;
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

	public int getCurrentStatusId() {
		return currentStatusId;
	}

	public void setCurrentStatusId(int currentStatusId) {
		this.currentStatusId = currentStatusId;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
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

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}



	}