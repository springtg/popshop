package org.light.portal.model;


public class PopularItem  extends Entity{

	   private String link;
	   private String title;
	   private String desc;
	   private String tag;
	   private String locale;
	   private long postById;
	   private long orgId;
	   private int popCount;

	   //read only
		private String photoUrl;
		private int photoWidth;
		private int photoHeight;
		private String assignedUri;
		private String chosedUri;
		private String displayName;
		private int currentStatusId;
	    private int commentCount;
	    
		public PopularItem(){
	       super();
	   }

	   public PopularItem(String link,String title,String desc, String tag, String locale, long postById, long orgId){
	       this();
	       this.link = link;
	       this.title = title;
	       this.desc = desc;
	       this.tag = tag;
	       this.locale = locale;
	       this.postById = postById;
	       this.orgId = orgId;
	       this.popCount = 1;
	   }

	   public void popIt(){
	       this.popCount++;
	   }
	   
	   public int getPhotoSmallWidth(){
			int newWidth = this.photoWidth;
			//int newHeight = this.photoHeight;
			int rate = 99;
			while(newWidth > 100){
				newWidth = this.photoWidth * rate / 100;
				//newHeight= this.photoHeight * rate / 10;
				rate--;
			}
			return newWidth;
		}
		public int getPhotoSmallHeight(){
			int newWidth = this.photoWidth;
			int newHeight = this.photoHeight;
			int rate = 99;
			while(newWidth > 100){
				newWidth = this.photoWidth * rate / 100;
				newHeight= this.photoHeight * rate / 100;
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

	   public long getPostById() {
	       return postById;
	   }


	   public void setPostById(long postById) {
	       this.postById = postById;
	   }

	   public int getPopCount() {
	       return popCount;
	   }


	   public void setPopCount(int popCount) {
	       this.popCount = popCount;
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

		public String getTag() {
			return tag;
		}

		public void setTag(String tag) {
			this.tag = tag;
		}

		public String getLocale() {
			return locale;
		}

		public void setLocale(String locale) {
			this.locale = locale;
		}

		public int getCommentCount() {
			return commentCount;
		}

		public void setCommentCount(int commentCount) {
			this.commentCount = commentCount;
		}

		public long getOrgId() {
			return orgId;
		}

		public void setOrgId(long orgId) {
			this.orgId = orgId;
		}


	}