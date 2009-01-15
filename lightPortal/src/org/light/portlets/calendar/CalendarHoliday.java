package org.light.portlets.calendar;

import org.light.portal.core.PortalContextFactory;
import org.light.portal.model.Entity;

public class CalendarHoliday extends Entity{

	private String holiday;
	private String name;
	private String country;
	private String desc;
	private String link; //holiday's related link
	
	public CalendarHoliday(){
		super();
	}
	public String getTime(){
		return "";
	}
	public String getHolidayName() {
		return PortalContextFactory.getPortalContext().getMessageByKey(name);
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getHoliday() {
		return holiday;
	}
	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
}
