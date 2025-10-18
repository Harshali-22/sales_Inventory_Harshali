package com.client.Sales_InventoryGenericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber() {
		Random rm=new Random();
		int rnNo=rm.nextInt(5000);
		return rnNo;	
	}
	
	public String getRequiredDate(int days) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal=sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqdate = sdf.format(cal.getTime());
		return reqdate;		
	}
	
	public String getSystemDate() {
		Date dobj=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String data = sdf.format(dobj);
		return data;
	}
	
	public String getSystemDateDDMMYYYY() {
		Date dobj=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		String Date=sdf.format(dobj);
		return Date;
	}

}
