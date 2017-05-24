package com.cloudeport.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;

public class DateFormat {
	 HttpServletRequest request;
	//获得当月的天数
	@SuppressWarnings("static-access")
	public static String getMonthsDay(String month){
		GregorianCalendar g=new GregorianCalendar(); 
		int years =(int)g.get(Calendar.YEAR);
		Calendar  calendar  =  Calendar.getInstance(); 
		int days =1;
		calendar.set(years,Integer.parseInt(month)-1,days);
		int dayst =calendar.getActualMaximum(calendar.DAY_OF_MONTH);
		return String.valueOf(dayst);
	}
	//获得年的月份
	public static String getMonth(){
		GregorianCalendar g=new GregorianCalendar(); 
		int month  =(int)g.get(Calendar.MONTH)+1;
		return String.valueOf(month);
	}
	//获得日
	public static String getDaily(){
		GregorianCalendar g=new GregorianCalendar(); 
		int  daily  =(int)g.get(Calendar.DAY_OF_MONTH);
		return String.valueOf(daily);
	}
	public static String getWeek(){
		GregorianCalendar g=new GregorianCalendar(); 
		int  week =(int)g.get(Calendar.WEEK_OF_MONTH);
		return String .valueOf(week);
	}
	public static String getHour(){
		GregorianCalendar g=new GregorianCalendar(); 
		int  hour =(int)g.get(Calendar.HOUR_OF_DAY);
		return String .valueOf(hour);
	}
    public static String getSecond(){
    	GregorianCalendar g=new GregorianCalendar(); 
		int  second =(int)g.get(Calendar.SECOND);
		return String.valueOf(second);
    }
    public static String getTimeNow(){
    	SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    return simple.format(new Date());
    }
    
    /**
     * 返回格式"yyyy-MM-dd" 例如:2010-09-09
     * @return
     */
    public static String getDateNow(){
    	SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
	    return simple.format(new Date()).toString(); 
    }
    
}
