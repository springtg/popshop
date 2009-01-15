/*
 * Copyright (c) 2006 Jianmin Liu.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.light.portal.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 
 * @author Jianmin Liu
 * @version 0.8.0
 * Creation date: April 4, 2006
 **/
public class DateFormatter {
    
    public DateFormatter (){
        
    }

    public static String format(Date date){
        SimpleDateFormat formatter = 
            (SimpleDateFormat)DateFormat.getDateTimeInstance(DateFormat.LONG,
             DateFormat.LONG, Locale.CANADA);
        formatter.applyPattern("MM/dd/yyyy");
        return formatter.format(date);
    }
	
	public static String format(Date date,String format){
        String value = null;
        try{
			SimpleDateFormat formatter = 
	            (SimpleDateFormat)DateFormat.getDateTimeInstance(DateFormat.LONG,
	             DateFormat.LONG, Locale.CANADA);
	        formatter.applyPattern(format);
	        value= formatter.format(date);
        }catch(Exception e){
        	
        }
        return value;
    }
	
	public static String format(Date date,Locale locale,String format){
		String value = null;
        try{
        	if(locale == null) locale = Locale.getDefault();
        	 SimpleDateFormat formatter = 
                 (SimpleDateFormat)DateFormat.getDateTimeInstance(DateFormat.LONG,
                  DateFormat.LONG, locale);
             formatter.applyPattern(format);
             value= formatter.format(date);
        }catch(Exception e){
        	
        }
        return value;
       
    }
	
	public static String calculateDifference(Date a, Date b)
	{   
		int yearDifference = 0;
	    int tempDifference = 0;
	    int hourDifference = 0;
	    StringBuffer difference = new StringBuffer();
	    Calendar earlier = Calendar.getInstance();
	    Calendar later = Calendar.getInstance();
	 
	    if (a.compareTo(b) < 0)
	    {
	        earlier.setTime(a);
	        later.setTime(b);
	    }
	    else
	    {
	        earlier.setTime(b);
	        later.setTime(a);
	    }
	 	    
	    yearDifference = later.get(Calendar.YEAR) - earlier.get(Calendar.YEAR);
        if(yearDifference > 1)
        	difference.append(yearDifference+" years ");
        else if(yearDifference == 1)
        	difference.append(yearDifference+" year ");
	     	 	   
        tempDifference = later.get(Calendar.DAY_OF_YEAR) - earlier.get(Calendar.DAY_OF_YEAR);
        if(tempDifference > 1)
        	difference.append(tempDifference+" days ");
        else if(tempDifference == 1)
        	difference.append(tempDifference+" day ");
        else if(yearDifference == 0){
        	hourDifference = later.get(Calendar.HOUR_OF_DAY) - earlier.get(Calendar.HOUR_OF_DAY);
	        
	        tempDifference = later.get(Calendar.MINUTE) - earlier.get(Calendar.MINUTE);
	        if(tempDifference > 0){
	        	 if(hourDifference > 1)
	 	        	difference.append(hourDifference+" hours ");
	 	         else if(hourDifference == 1)
	 	        	difference.append(hourDifference+" hour ");
	        	 if(tempDifference == 1)
	        		 difference.append(tempDifference+" minute ");
	        	 else
	        		 difference.append(tempDifference+" minutes ");
	        }	        	
	        else if(tempDifference < 0){
	        	hourDifference--;
	        	if(hourDifference > 1)
	 	        	difference.append(hourDifference+" hours ");
	 	        else if(hourDifference == 1)
	 	        	difference.append(hourDifference+" hour ");
	        	tempDifference = 60 + tempDifference;
	        	if(tempDifference == 1)
	        		 difference.append(tempDifference+" minute ");
	        	 else
	        		 difference.append(tempDifference+" minutes ");
	        }
        }
        difference.append("ago");
	    return difference.toString();
	}
	
	public static int calculateDifferenceDays(Date a, Date b)
	{
	    int tempDifference = 0;
	    int difference = 0;
	    Calendar earlier = Calendar.getInstance();
	    Calendar later = Calendar.getInstance();
	 
	    if (a.compareTo(b) < 0)
	    {
	        earlier.setTime(a);
	        later.setTime(b);
	    }
	    else
	    {
	        earlier.setTime(b);
	        later.setTime(a);
	    }
	 
	    while (earlier.get(Calendar.YEAR) != later.get(Calendar.YEAR))
	    {
	        tempDifference = 365 * (later.get(Calendar.YEAR) - earlier.get(Calendar.YEAR));
	        difference += tempDifference;
	 
	        earlier.add(Calendar.DAY_OF_YEAR, tempDifference);
	    }
	 
	    if (earlier.get(Calendar.DAY_OF_YEAR) != later.get(Calendar.DAY_OF_YEAR))
	    {
	        tempDifference = later.get(Calendar.DAY_OF_YEAR) - earlier.get(Calendar.DAY_OF_YEAR);
	        difference += tempDifference;
	    }
	 
	    return difference;
	}

}
