package org.light.portlets.rss;

import java.io.Serializable;
import java.util.Date;

import org.light.portal.util.DateFormatter;

public class RssBean implements Serializable{
	private int index;
	private String link;
	private String title;
	private String desc;
	private String author;	
	private Date publishDate;
	private boolean addLink;
	
	public RssBean(){
		
	}
	
	public RssBean(int index, String link, String title, String desc, String author, Date date, boolean addLink){
		this.index = index;
		this.link = link;
		this.title = title;
		this.desc = desc;
		this.author = author;
		this.publishDate = date;
		this.addLink = addLink;
	}
	
	public String getDate(){
		 return DateFormatter.format(this.publishDate,"EEE, MMM dd, yyyy HH:mm");
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
	
	public boolean isAddLink() {
		return addLink;
	}

	public int getIndex() {
		return index;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}
	
}
