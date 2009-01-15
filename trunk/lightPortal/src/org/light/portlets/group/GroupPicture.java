package org.light.portlets.group;

import java.sql.Timestamp;

import org.light.portal.model.Entity;

public class GroupPicture extends Entity{

	private long groupId;
	private long userId;
	private String pictureUrl;
	private int pictureWidth;
	private int pictureHeight;
	private String caption="";
	private String tag="";
	private Timestamp  createDate = new Timestamp(System.currentTimeMillis());
	private int status; //0 need to be approved; 1 for members 2 for public;
	
	private int smallWidth;
	private int smallHeight;
	private int largeWidth;
	private int largeHeight;
	
	private int _standardSmallWidth = 300;
	private int _standardLargeWidth = 800;
	private int _showColumns = 1;
	
	public GroupPicture(){
		super();
	}
	
	public GroupPicture(long groupId,String pictureUrl,int pictureWidth,int pictureHeight,long userId){
		this.groupId = groupId;
		this.pictureUrl = pictureUrl;
		this.pictureWidth = pictureWidth;
		this.pictureHeight = pictureHeight;	
		this.userId = userId;
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
	
	public String getCaption() {
		return caption;
	}
	

	public void setCaption(String caption) {
		this.caption = caption;
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

	public long getGroupId() {
		return groupId;
	}
	

	public void setGroupId(long groupId) {
		this.groupId = groupId;
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

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
	
	

}
