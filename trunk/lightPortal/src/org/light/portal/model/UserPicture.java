package org.light.portal.model;

import java.sql.Timestamp;
import java.util.Date;


public class UserPicture extends Entity{
	
	private long userId;
	private String pictureUrl;
	private int pictureWidth;
	private int pictureHeight;
	private String caption;
	private String tag;
	private int status; //0 for me only; 1 for my friends 2 for public;
	private int rankable;//1 for rank
	private Timestamp  createDate = new Timestamp(System.currentTimeMillis());
	
	private int smallWidth;
	private int smallHeight;
	private int largeWidth;
	private int largeHeight;
	
	private int _standardSmallWidth = 300;
	private int _standardLargeWidth = 600;
	private int _showColumns = 1;
	
	public UserPicture(){
		super();
	}
	
	public UserPicture(long userId,String pictureUrl,int status,int pictureWidth,int pictureHeight){
		this.userId = userId;
		this.pictureUrl = pictureUrl;
		this.pictureWidth = pictureWidth;
		this.pictureHeight = pictureHeight;		
		this.status = status;
	}
	public UserPicture(long userId,String pictureUrl,int status,int pictureWidth,int pictureHeight, Date takenDate){
		this.userId = userId;
		this.pictureUrl = pictureUrl;
		this.pictureWidth = pictureWidth;
		this.pictureHeight = pictureHeight;		
		this.status = status;
		if(takenDate != null){
			this.createDate = new Timestamp(takenDate.getTime());
		}
	}
	public UserPicture(long userId,String pictureUrl,int status,int pictureWidth,int pictureHeight,String caption){
		this.userId = userId;
		this.pictureUrl = pictureUrl;
		this.pictureWidth = pictureWidth;
		this.pictureHeight = pictureHeight;		
		this.status = status;
		this.caption = caption;
	}
	/* (non-Javadoc)
	    * @see java.lang.Object#hashCode()
	    */
   @Override
   public int hashCode() {       
	   final int PRIME = 31;
       int result = 1;
       result = PRIME * result + new Long(getId()).intValue();
       return result;
   }
  
   /* (non-Javadoc)
    * @see java.lang.Object#equals(java.lang.Object)
    */
   @Override
   public boolean equals(Object obj) {
       if (this == obj)
           return true;
       if (obj == null)
           return false;
       if (getClass() != obj.getClass())
           return false;
       final UserPicture other = (UserPicture) obj;
       if (getId() != other.getId())
           return false;
       return true;
   }
   
   public boolean isHttpUrl(){
	   return this.pictureUrl.startsWith("http");
   }
	public void setStandardSmallWidth(int clientWidth){
		if(clientWidth > 0){
			int width = clientWidth - 10;
			if(_standardSmallWidth != width || _showColumns != 1){
				_standardSmallWidth = width;
				_showColumns = 1;
				smallWidth = 0;
				smallHeight = 0;
			}
		}
	}
	public void setStandardSmallWidth(int clientWidth, int columns){
		int width = _standardSmallWidth;
		if(clientWidth > 0) width = clientWidth - 10;
		if(_standardSmallWidth != width || _showColumns != columns){
			_standardSmallWidth = width / columns;
			_showColumns = columns;
			smallWidth = 0;
			smallHeight = 0;
		}
	}
	
	public int getSmallWidth(){
		if(smallWidth == 0){
			int newWidth = this.pictureWidth;
			int newHeight = this.pictureHeight;
			int rate = 99;
			while(newWidth > _standardSmallWidth){
				newWidth = this.pictureWidth * rate / 100;
				newHeight= this.pictureHeight * rate / 100;
				rate--;
			}
			smallWidth= newWidth;
			smallHeight = newHeight;
		}
		return smallWidth;
	}
	public int getSmallHeight(){
		if(smallHeight == 0){
			int newWidth = this.pictureWidth;
			int newHeight = this.pictureHeight;
			int rate = 99;
			while(newWidth > _standardSmallWidth){
				newWidth = this.pictureWidth * rate / 100;
				newHeight= this.pictureHeight * rate / 100;
				rate--;
			}
			smallWidth= newWidth;
			smallHeight = newHeight;
		}
		return smallHeight;
	}
	
	public int getLargeWidth(){
		if(largeWidth == 0){
			int newWidth = this.pictureWidth;
			int newHeight = this.pictureHeight;
			int rate = 99;
			while(newWidth > _standardLargeWidth){
				newWidth = this.pictureWidth * rate / 100;
				newHeight= this.pictureHeight * rate / 100;
				rate--;
			}
			largeWidth= newWidth;
			largeHeight = newHeight;
		}
		return largeWidth;
	}
	public int getLargeHeight(){
		if(largeHeight == 0){
			int newWidth = this.pictureWidth;
			int newHeight = this.pictureHeight;
			int rate = 99;
			while(newWidth > _standardLargeWidth){
				newWidth = this.pictureWidth * rate / 100;
				newHeight= this.pictureHeight * rate / 100;
				rate--;
			}
			largeWidth= newWidth;
			largeHeight = newHeight;
		}
		return largeHeight;
	}
	
	public int getPictureHeight() {
		return pictureHeight;
	}

	public void setPictureHeight(int pictureHeight) {
		this.pictureHeight = pictureHeight;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public int getPictureWidth() {
		return pictureWidth;
	}

	public void setPictureWidth(int pictureWidth) {
		this.pictureWidth = pictureWidth;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getRankable() {
		return rankable;
	}

	public void setRankable(int rankable) {
		this.rankable = rankable;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	

}
