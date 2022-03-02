package com.bank.drool_reward.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class DataConversion 
{
	static SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
	
	public static boolean isAlphaNumeric(String val)
	{
		return val != null && val.matches("^[a-zA-Z0-9]*$");
	}
	
	public static boolean dateCompare(String expDate) throws ParseException
	{
		if(expDate.isEmpty())
			return false;
		else
		{
			Date currentDate = new Date();
			Date exdate = sdformat.parse(expDate);
			if(exdate.compareTo(currentDate)>0)
	 		{
	 			return true;
	 		}
	 		else if(exdate.compareTo(currentDate)<0)
	 		{
	 			return false;
	 		}
		}
		return false;
	}
	
	public static int compareTimeWithCurrentTime(String hrs,String min)
	{
		int hh = Integer.parseInt(hrs);
		int mm = Integer.parseInt(min);
		LocalTime  time1 = LocalTime.of(hh, mm);
		Date curDate = new Date();
		int curtHH = curDate.getHours();
		int curtMM = curDate.getMinutes();		
		LocalTime  curTime = LocalTime.of(curtHH, curtMM);
		
		int returnVal = time1.compareTo(curTime);  
		
		return returnVal;
		
		
	}


}
