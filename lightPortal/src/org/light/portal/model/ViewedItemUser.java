package org.light.portal.model;

import java.sql.Timestamp;

public class ViewedItemUser extends Entity{
   
	   private long postById;
	   private long itemId;
	   private Timestamp viewedDate;
	   private int popCount;
	   
	   //	 read only
		private String photoUrl;
		private int photoWidth;
		private int photoHeight;
		private String assignedUri;
		private String chosedUri;
		private String displayName;
		private int currentStatusId;
		
		public ViewedItemUser(){
	       super();
	    }
		
		public ViewedItemUser(long itemId,long postById){
	       this();
	       this.itemId = itemId;
	       this.postById = postById;
	       this.viewedDate = new Timestamp(System.currentTimeMillis());
	    }
		
		public void popIt(){
	       this.popCount++;
	       this.viewedDate = new Timestamp(System.currentTimeMillis());
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


		public long getItemId() {
			return itemId;
		}

		public void setItemId(long itemId) {
			this.itemId = itemId;
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

		public int getPopCount() {
			return popCount;
		}

		public void setPopCount(int popCount) {
			this.popCount = popCount;
		}

		public long getPostById() {
			return postById;
		}

		public void setPostById(long postById) {
			this.postById = postById;
		}

		public Timestamp getViewedDate() {
			return viewedDate;
		}

		public void setViewedDate(Timestamp viewedDate) {
			this.viewedDate = viewedDate;
		}
}
