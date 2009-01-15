package org.light.portal.model;

import java.sql.Timestamp;
import java.util.Date;

import org.light.portal.util.DateFormatter;


public class RecommendedItem extends Entity{

	   private long userId;
	   private String link;
	   private String title;
	   private String desc;
	   private String tag;
	   private String locale;
	   private Timestamp createDate;
	   private int weight;
	   private int read; //0 not read yet, 1 read
	   
	   public RecommendedItem(){
	       super();
	   }

	   public RecommendedItem(String link,String title,String desc, String tag, String locale,long userId){
	       this();
	       this.link = link;
	       this.title = title;
	       this.desc = desc;
	       this.tag = tag;
	       this.locale = locale;
	       this.userId = userId;
	       this.createDate = new Timestamp(System.currentTimeMillis());
	   }
	   
	   public void weighIt(){
		   this.weight++;
	   }
	   
	   public String getTime(){
		   return DateFormatter.calculateDifference(new Date(System.currentTimeMillis()),new Date(this.createDate.getTime()));	
	   }
	   
	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
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

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getRead() {
		return read;
	}

	public void setRead(int read) {
		this.read = read;
	}

}
