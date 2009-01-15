package org.light.portlets.calendar.service.spring;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.light.portal.core.service.spring.BaseServiceImpl;
import org.light.portlets.calendar.CalendarBean;
import org.light.portlets.calendar.CalendarEvent;
import org.light.portlets.calendar.CalendarHoliday;
import org.light.portlets.calendar.dao.CalendarDao;
import org.light.portlets.calendar.service.CalendarService;

public class CalendarServiceImpl extends BaseServiceImpl implements CalendarService {
	private CalendarDao calendarDao;
	
	public CalendarBean getCalendarByUser(long userId){
		return calendarDao.getCalendarByUser(userId);
	}
	
	public CalendarEvent getCalendarEventById(long id){
		return calendarDao.getCalendarEventById(id);
	}
	
	public List<CalendarEvent> getCalendarEventsByDate(Date date,long userId){
		return calendarDao.getCalendarEventsByDate(date,userId);
	}
	
	public Map<String,CalendarHoliday> getCalendarHolidays(){
		return calendarDao.getCalendarHolidays();
	}
	public List<CalendarHoliday> getCalendarHoliday(Date date){
		return calendarDao.getCalendarHoliday(date);
	}
	public boolean hasEvents(Date date,long userId){
		return calendarDao.hasEvents(date,userId);
	}
	public void deleteEvents(long id){
		calendarDao.deleteEvents(id);
	}
	public CalendarDao getCalendarDao() {
		return calendarDao;
	}

	public void setCalendarDao(CalendarDao calendarDao) {
		this.calendarDao = calendarDao;
	}
}
