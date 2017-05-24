package com.cloudeport.utils;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
	/**
	    * 获取对应星期的日期.
	    * 
	    * @param week
	    * @return
	    */
	    public static Date getDateByWeekDay(final int week) {
	        Calendar calendar = Calendar.getInstance();
	        calendar.clear();
	        calendar.setTimeInMillis(System.currentTimeMillis());
	        calendar.set(Calendar.DAY_OF_WEEK, week);
	        return new Date(calendar.getTimeInMillis());
	    }

	    /**
	    * 根据日期获取星期几.如果返回0则表示出错.
	    * 
	    * @param date
	    * @return
	    */
	    public static int getWeekOfDate(final Date date) {
	        Calendar calendar = Calendar.getInstance();
	        calendar.clear();
	        calendar.setTime(date);
	        return calendar.get(Calendar.DAY_OF_WEEK);
	    }

	    /**
	    * 获取指定日期的前一天.
	    * 
	    * @param date
	    * @return
	    */
	    public static Date getYesterdayOfDate(final Date date) {
	        GregorianCalendar c = new GregorianCalendar();
	        c.clear();
	        c.setTime(date);
	        c.add(Calendar.DAY_OF_MONTH, -1);
	        return c.getTime();
	    }

	    /**
	    * 根据年月日生成日期对象.
	    * 
	    * @param year
	    * @param month
	    * @param day
	    * @return
	    */
	    public static Date getDate(int year, int month, int day) {
	        GregorianCalendar c = new GregorianCalendar(year, month, day);
	        return c.getTime();
	    }

	    /**
	    * 根据指定年份的天数,获取对应的日期.
	    * 
	    * @param days
	    * @return
	    */
	    public static Date getDate(int year, int days) {
	        GregorianCalendar tempC = new GregorianCalendar(year, 1, 1);
	        tempC.add(Calendar.DAY_OF_MONTH, days - 1);
	        return tempC.getTime();
	    }

	    /**
	    * 当days为正数时,获取指定日期之后的days天的日期; 当days为负数时,获取指定日期之前的days天的日期;
	    * 
	    * @param date
	    * @param days
	    * @return
	    */
	    public static Date getDate(final Date date, int days) {
	        GregorianCalendar tempC = new GregorianCalendar();
	        tempC.setTime(date);
	        tempC.add(Calendar.DAY_OF_MONTH, days);
	        return tempC.getTime();
	    }

	    /**
	    * 获取指定日期的后一天.
	    * 
	    * @param date
	    * @return
	    */
	    public static Date getTomorrowOfDate(final Date date) {
	        GregorianCalendar c = new GregorianCalendar();
	        c.clear();
	        c.setTime(date);
	        c.add(Calendar.DAY_OF_MONTH, 1);
	        return c.getTime();
	    }

	    /**
	    * 获取指定日期的年份.
	    * 
	    * @param date
	    * @return
	    */
	    public static int getYearOfDate(final Date date) {
	        GregorianCalendar c = new GregorianCalendar();
	        c.clear();
	        c.setTime(date);
	        return c.get(Calendar.YEAR);
	    }

	    /**
	    * 获取指定日期的月份.
	    * 
	    * @param date
	    * @return
	    */
	    public static int getMonthOfDate(final Date date) {
	        GregorianCalendar c = new GregorianCalendar();
	        c.clear();
	        c.setTime(date);
	        return c.get(Calendar.MONTH) + 1;
	    }

	    /**
	    * 获取指定日期的天数.
	    * 
	    * @param date
	    * @return
	    */
	    public static int getDayOfDate(final Date date) {
	        GregorianCalendar c = new GregorianCalendar();
	        c.clear();
	        c.setTime(date);
	        return c.get(Calendar.DAY_OF_MONTH);
	    }

	    /**
	    * 获取指定日期在当前年份中的天数.
	    * 
	    * @param date
	    * @return
	    */
	    public static int getDaysOfYear(final Date date) {
	        GregorianCalendar c = new GregorianCalendar();
	        c.clear();
	        c.setTime(date);
	        return c.get(Calendar.DAY_OF_YEAR);
	    }

	    /**
	    * 计算两个日期之间的天数.
	    * 
	    * @param fdate
	    *            起始日期
	    * @param oDate
	    *            终止日期
	    * @return
	    */
	    public static int getDaysOfBetween(final Date fDate, final Date oDate) {
	        GregorianCalendar fCalendar = new GregorianCalendar();
	        GregorianCalendar oCalendar = new GregorianCalendar();
	        fCalendar.clear();
	        oCalendar.clear();
	        /*
	        * 起始日期.
	        */
	        fCalendar.setTime(fDate);
	        /*
	        * 计算此日期是一年中的哪一天.
	        */
	        int day1 = fCalendar.get(Calendar.DAY_OF_YEAR);
	        /*
	        * 当前比较日期.
	        */
	        oCalendar.setTime(oDate);
	        int day2 = oCalendar.get(Calendar.DAY_OF_YEAR);
	        /*
	        * 求出两个日期相隔天数.
	        */
	        int oYear = oCalendar.get(Calendar.YEAR);
	        int fYear = fCalendar.get(Calendar.YEAR);

	        /*
	        * 比较是否是同一年份,如果不是则判断是否闰年,累加天数.
	        */
	        if (oYear > fYear) {
	            for (int i = oYear; i > fYear; i--) {
	                /*
	                * 获取当前年份的最大天数.
	                */
	                day2 += oCalendar.getActualMaximum(Calendar.DAY_OF_YEAR);
	            }
	        }
	        return day2 - day1;
	    }
	    
	    /**
	     * 日期比较  date2 - date1
	     * @param date1
	     * @param date2
	     * @return
	     */
	    public static int compareDate(final Date date1, final Date date2){
	    	return getDaysOfBetween(date1, date2);
	    }
	    
	    /**
	     * 日期比较  Timestamp - date
	     * @param timestamp
	     * @return
	     */
	    public static Date timestampToDate(Timestamp timestamp){
	    	Date date = new Date();
			try {
				date = timestamp;
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	return date;
	    }
	    
	    /**
	     * 日期比较 date -Timestamp
	     * @param date
	     * @return
	     */
	    public static Timestamp dateToTimestamp(Date date){
	    	return new Timestamp(date.getTime());
	    }
}
