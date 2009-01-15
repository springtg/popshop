package org.light.portlets.calendar;

import org.light.portal.model.Entity;

import static org.light.portal.util.Constants.*;

public class CalendarBean extends Entity{
	
	private long userId;
	private int startTime;
	private int endTime;
	private int interval;// 60 1 hour
	private int type; //0 1:00pm,1 13:00
	private int state;//0 private; 1 friend only; 2 public
	
	public CalendarBean(){
		super();
	}
	
	public CalendarBean(long userId){
		this();
		this.userId = userId;
		this.startTime = _CALENDAR_START_TIME;
		this.endTime = _CALENDAR_END_TIME;
		this.interval = _CALENDAR_INTERVAL;
		this.state = _CALENDAR_EVENT_STATE;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
}
