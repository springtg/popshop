package org.light.portal.model;

import java.sql.Timestamp;

public class FlashGame extends Entity{
	
   private String link;
   private String title;
   private String desc;
   private String instructions;
   private String tag;
   private String locale;
   private long postById;
   private int popCount;
   private int width;
   private int height;
   private Timestamp createDate;
   
   public FlashGame(){
       super();
   }
   
   public FlashGame(String link, String title, String tag, String desc, String instructions, int width, int height, long postById){
	   this();
	   this.link = link;
	   this.title= title;
	   this.tag = tag;
	   this.desc = desc;
	   this.instructions = instructions;
	   this.width = width;
	   this.height = height;
	   this.postById= postById;
	   this.createDate =new Timestamp(System.currentTimeMillis());
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

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
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

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
}
