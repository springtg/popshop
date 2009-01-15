package org.light.portlets.horoscope;

import java.util.ArrayList;
import java.util.List;

import org.light.portal.core.PortalContextFactory;
import org.light.portal.model.Entity;
import org.light.portal.model.User;
import org.light.portlets.connection.Connection;

public class Horoscope extends Entity{
	
	private String name;
	private String label;
	private String description;	
	private String startDate;
	private String endDate;
	private int startMonth;
	private int startDay;
	private int endMonth;
	private int endDay;
	
	private User user;
	private List<Connection> buddys;
	private String weeklyInfo;
	
	public Horoscope(){
		super();
	}
	public void setUser(User user){
		this.user = user;		
	}
	public void addBuddy(Connection buddy){
		if(this.buddys == null) this.buddys = new ArrayList<Connection>();
		this.buddys.add(buddy);
	}
	public String getTitle(){
		String title = PortalContextFactory.getPortalContext().getMessageByKey(this.label);
		return title;
	}
	
	public String getOverview() {
		String desc;
	    if(this.weeklyInfo != null && this.weeklyInfo.length() > 0){
	    	desc = this.weeklyInfo;
	    }else{
	    	desc= PortalContextFactory.getPortalContext().getMessageByKey(this.description);
	    }
		return desc;
	}
	public String getShortOverview() {
		String desc;
	    if(this.weeklyInfo != null && this.weeklyInfo.length() > 0){
	    	desc = this.weeklyInfo;
	    }else{
			desc= PortalContextFactory.getPortalContext().getMessageByKey(this.description);
			if(desc.length() > 200) {
				String temp = desc.substring(200,desc.length());
				desc=desc.substring(0,200);
				int index = temp.indexOf(" ");
				desc+= temp.substring(0,index)+"...";
			}
	    }
		return desc;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEndDay() {
		return endDay;
	}
	public void setEndDay(int endDay) {
		this.endDay = endDay;
	}
	public int getEndMonth() {
		return endMonth;
	}
	public void setEndMonth(int endMonth) {
		this.endMonth = endMonth;
	}
	public int getStartDay() {
		return startDay;
	}
	public void setStartDay(int startDay) {
		this.startDay = startDay;
	}
	public int getStartMonth() {
		return startMonth;
	}
	public void setStartMonth(int startMonth) {
		this.startMonth = startMonth;
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getDescription() {
		return description;
	}
	public List<Connection> getBuddys() {
		return buddys;
	}
	public void setBuddys(List<Connection> buddys) {
		this.buddys = buddys;
	}
	public User getUser() {
		return user;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getWeeklyInfo() {
		return weeklyInfo;
	}
	public void setWeeklyInfo(String weeklyInfo) {
		this.weeklyInfo = weeklyInfo;
	}
}
