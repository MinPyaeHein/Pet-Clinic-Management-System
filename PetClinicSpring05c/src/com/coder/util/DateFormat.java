package com.coder.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class DateFormat {

	public static Date stringToDate_dd_mm_yyy(String date)
	{
		Date formatDate=null;
		try {
			formatDate = new SimpleDateFormat("dd/mm/yyy").parse(date);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		
		return formatDate;
	}
	
	public static Date stringToDateFormat_yyyy_MM_dd(String date)
	{
		Date formatDate=null;
		try {
			formatDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return formatDate;
	}
	
	public static Date stringToDateFormat_dd_mm_yyyy(String date)
	{  // System.out.println("date"+date+":");
		Date date1=null;
		try {
			   date1=new SimpleDateFormat("dd/MM/yyyy").parse(date.trim());  
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return date1;
	}
	
	public static String dateToStringFormat_dd_mm_yyyy(Date date){
	    SimpleDateFormat	formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    String strDate = formatter.format(date);  
	    return strDate;
		}
	public static String dateToString_DB_Format(Date date){
	    SimpleDateFormat	formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    String strDate = formatter.format(date);  
	    //System.out.println("dateToString_DB_Format="+strDate);
	    return strDate;
		}
	public static Date stringToTime_aa(String date)
	{
		Date formatDate=null;
		try {
			formatDate = new SimpleDateFormat("hh:mm aa").parse(date);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		
		return formatDate;
	}
	public static String dateToString_dd_MMMM_yyyy(Date date){
    SimpleDateFormat	formatter = new SimpleDateFormat("dd MMMM yyyy");  
    String strDate = formatter.format(date);  
    return strDate;
	}
	public static String dateToString_YYYY(Date date){
	    SimpleDateFormat	formatter = new SimpleDateFormat("yyyy");  
	    String strDate = formatter.format(date);  
	    return strDate;
		}
	
	public static String dateToDayAM_PM(Date date){
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm aa");
		String formattedDate = dateFormat.format(date).toString();
		return formattedDate;
	}
	
	public static String dateFormat_EEE(String date){
		 SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
		 SimpleDateFormat DATE_FORMAT1 = new SimpleDateFormat("EEE");
		 String dateDay = "";
		try {
		Date date1= DATE_FORMAT.parse(date);
		 dateDay=DATE_FORMAT1.format(date1);
		} catch (ParseException e){
			
			e.printStackTrace();
		}
	     return dateDay+"";   
		
	}
	public static int timeDifference1(String startTime,String endTime) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss"); 

		Date date1 = format.parse(startTime);

		Date date2 = format.parse(endTime);

		long difference = date2.getTime() - date1.getTime(); 

		int minutes = (int) TimeUnit.MILLISECONDS.toMinutes(difference);

		if(minutes<0)minutes += 1440; 
		return minutes;
	}
	public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); 
        return cal.getTime();
    }
	public static Date subDays( int day) 
    {
		
		Calendar calendar = Calendar.getInstance(); 
		calendar.getTime();
		calendar.add(Calendar.DAY_OF_MONTH, day);
		Date date2=calendar.getTime();
		return date2;
	   
    }
	public Date addHoursToJavaUtilDate(Date date, int hours) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.HOUR_OF_DAY, hours);
	    return calendar.getTime();
	}
	public static Date addDateInMinute(int min,Date date){
	
		Calendar myCal = new GregorianCalendar();
		myCal.setTime(date);
	
		
	    
		myCal.add(Calendar.MINUTE, min);
	   
		return myCal.getTime();
	}
	
}
