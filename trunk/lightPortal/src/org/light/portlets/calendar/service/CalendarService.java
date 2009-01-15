package org.light.portlets.calendar.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.light.portlets.calendar.CalendarBean;
import org.light.portlets.calendar.CalendarEvent;
import org.light.portlets.calendar.CalendarHoliday;

public interface CalendarService {
	
	public CalendarBean getCalendarByUser(long userId);
	public CalendarEvent getCalendarEventById(long id);
	public Map<String,CalendarHoliday> getCalendarHolidays();
	public List<CalendarHoliday> getCalendarHoliday(Date date);
	public List<CalendarEvent> getCalendarEventsByDate(Date date,long userId);
	public boolean hasEvents(Date date,long userId);
	public void deleteEvents(long id);
}
