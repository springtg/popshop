package org.light.portlets.horoscope;

import org.light.portal.model.Entity;

public class HoroscopeWeekly extends Entity{

	private long horoscopeId;
	private int weekNumber;
	private String description;
	private String language;
	
	public HoroscopeWeekly(){
		super();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getHoroscopeId() {
		return horoscopeId;
	}

	public void setHoroscopeId(long horoscopeId) {
		this.horoscopeId = horoscopeId;
	}


	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getWeekNumber() {
		return weekNumber;
	}

	public void setWeekNumber(int weekNumber) {
		this.weekNumber = weekNumber;
	}

}
