package org.light.portal.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.light.portal.core.PortalContextFactory;

public class CalendarUtil {

	public static List<LabelBean> getYears(){
		List<LabelBean> labelBeans= new ArrayList<LabelBean>();
		Calendar rightNow = Calendar.getInstance();		 
		int year = rightNow.get(Calendar.YEAR);		
		labelBeans.add(new LabelBean("",PortalContextFactory.getPortalContext().getMessageByKey("year")));
		int i = 10;
		while(i > 0){
			labelBeans.add(new LabelBean(String.valueOf(year + i--)));
		}
		while(i <= 100){
			labelBeans.add(new LabelBean(String.valueOf(year - i++)));
		}
		
		return labelBeans;
	}
	
	public static List<LabelBean> getMonths(){
		List<LabelBean> labelBeans= new ArrayList<LabelBean>();	
		labelBeans.add(new LabelBean("",PortalContextFactory.getPortalContext().getMessageByKey("month")));
		labelBeans.add(new LabelBean("01",PortalContextFactory.getPortalContext().getMessageByKey("month.01")));
		labelBeans.add(new LabelBean("02",PortalContextFactory.getPortalContext().getMessageByKey("month.02")));
		labelBeans.add(new LabelBean("03",PortalContextFactory.getPortalContext().getMessageByKey("month.03")));
		labelBeans.add(new LabelBean("04",PortalContextFactory.getPortalContext().getMessageByKey("month.04")));
		labelBeans.add(new LabelBean("05",PortalContextFactory.getPortalContext().getMessageByKey("month.05")));
		labelBeans.add(new LabelBean("06",PortalContextFactory.getPortalContext().getMessageByKey("month.06")));
		labelBeans.add(new LabelBean("07",PortalContextFactory.getPortalContext().getMessageByKey("month.07")));
		labelBeans.add(new LabelBean("08",PortalContextFactory.getPortalContext().getMessageByKey("month.08")));
		labelBeans.add(new LabelBean("09",PortalContextFactory.getPortalContext().getMessageByKey("month.09")));
		labelBeans.add(new LabelBean("10",PortalContextFactory.getPortalContext().getMessageByKey("month.10")));
		labelBeans.add(new LabelBean("11",PortalContextFactory.getPortalContext().getMessageByKey("month.11")));
		labelBeans.add(new LabelBean("12",PortalContextFactory.getPortalContext().getMessageByKey("month.12")));
		return labelBeans;
	}
	
	public static List<LabelBean> getDays(){
		List<LabelBean> labelBeans= new ArrayList<LabelBean>();		
		labelBeans.add(new LabelBean("",PortalContextFactory.getPortalContext().getMessageByKey("day")));
		labelBeans.add(new LabelBean("01","01"));
		labelBeans.add(new LabelBean("02","02"));
		labelBeans.add(new LabelBean("03","03"));
		labelBeans.add(new LabelBean("04","04"));
		labelBeans.add(new LabelBean("05","05"));
		labelBeans.add(new LabelBean("06","06"));
		labelBeans.add(new LabelBean("07","07"));
		labelBeans.add(new LabelBean("08","08"));
		labelBeans.add(new LabelBean("09","09"));
		labelBeans.add(new LabelBean("10","10"));
		labelBeans.add(new LabelBean("11","11"));
		labelBeans.add(new LabelBean("12","12"));
		labelBeans.add(new LabelBean("13","13"));
		labelBeans.add(new LabelBean("14","14"));
		labelBeans.add(new LabelBean("15","15"));
		labelBeans.add(new LabelBean("16","16"));
		labelBeans.add(new LabelBean("17","17"));
		labelBeans.add(new LabelBean("18","18"));
		labelBeans.add(new LabelBean("19","19"));
		labelBeans.add(new LabelBean("20","20"));
		labelBeans.add(new LabelBean("21","21"));
		labelBeans.add(new LabelBean("22","22"));
		labelBeans.add(new LabelBean("23","23"));
		labelBeans.add(new LabelBean("24","24"));
		labelBeans.add(new LabelBean("25","25"));
		labelBeans.add(new LabelBean("26","26"));
		labelBeans.add(new LabelBean("27","27"));
		labelBeans.add(new LabelBean("28","28"));
		labelBeans.add(new LabelBean("29","29"));
		labelBeans.add(new LabelBean("30","30"));
		labelBeans.add(new LabelBean("31","31"));
		return labelBeans;
	}
	
	
}
