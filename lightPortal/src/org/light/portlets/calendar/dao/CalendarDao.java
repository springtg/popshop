package org.light.portlets.calendar.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.light.portlets.calendar.CalendarBean;
import org.light.portlets.calendar.CalendarEvent;
import org.light.portlets.calendar.CalendarHoliday;

public interface CalendarDao {
	public CalendarBean getCalendarByUser(long userId);
	public CalendarEvent getCalendarEventById(long id);
	public List<CalendarEvent> getCalendarEventsByDate(Date date,long userId);
	public Map<String,CalendarHoliday> getCalendarHolidays();
	public List<CalendarHoliday> getCalendarHoliday(Date date);
	public boolean hasEvents(Date date,long userId);
	public void deleteEvents(long id);
}
