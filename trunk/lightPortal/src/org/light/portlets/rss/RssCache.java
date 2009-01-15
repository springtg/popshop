package org.light.portlets.rss;

import java.util.List;

public class RssCache {
	private long lastRefreshTime;
	private List<RssBean> news;
	private int refreshRate= 60; // in minutes
	
	public RssCache(List<RssBean> news){
		this.lastRefreshTime = System.currentTimeMillis();
		this.news = news;	
	}
	public long getLastRefreshTime() {
		return lastRefreshTime;
	}
	public void setLastRefreshTime(long lastRefreshTime) {
		this.lastRefreshTime = lastRefreshTime;
	}
	public List<RssBean> getNews() {
		return news;
	}
	public void setNews(List<RssBean> news) {
		this.news = news;
	}
	public int getRefreshRate() {
		return refreshRate;
	}
	public void setRefreshRate(int refreshRate) {
		this.refreshRate = refreshRate;
	}
}
