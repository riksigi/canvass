package com.canvass.challenge;

import java.util.Comparator;
import java.text.SimpleDateFormat;
import java.util.Date;

class rowComparator implements Comparator<String>{
	/*
	 * Assuming the rows are separated by comma
	 * And the schema of csv is fixed i.e. 0th column is DeviceId and 5th column is Date
	 * And the date field is present either in "yyyy-MM-dd" format OR in "MM/dd/yy" format
	 */
	public int compare(String row1,String row2) {
		String[] row1Arr=row1.split(",");
		String[] row2Arr=row2.split(",");
		int row1DeviceId;
		int row2DeviceId;
		Date date1=null;
		Date date2=null;
		
		try {
			row1DeviceId=Integer.parseInt(row1Arr[0]);
		} catch(Exception e) {
			return -1; // Its not numeric which means its a header and Header should be placed first
		}
		
		try {
			row2DeviceId=Integer.parseInt(row2Arr[0]);
		} catch(Exception e) {
			return 1; // Its not numeric which means its a header and Header should be placed first
		}
				
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df2 = new SimpleDateFormat("MM/dd/yy");
		
		try { 
			date1=df1.parse(row1Arr[5]); // try to parse the first row date with "yyyy-MM-dd" format 
		} catch (Exception e) {
			try {
				date1=df2.parse(row1Arr[5]); // else try to parse the first row date with "MM/dd/yy" format
			} catch(Exception e1) {
				// do nothing
			}
		}
		
		try { 
			date2=df1.parse(row2Arr[5]); // try to parse the second row date with "yyyy-MM-dd" format 
		} catch (Exception e) {
			try {
				date2=df2.parse(row2Arr[5]); // else try to parse the second row date with "MM/dd/yy" format
			} catch(Exception e1) {
				// do nothing
			}
		}
		
		if(row1DeviceId<row2DeviceId) { // First sort by Device Id
			return -1;
		} else if (row1DeviceId > row2DeviceId) {
			return 1;
		} else {  // If Device Id is same then sort by Date
			// handle blank date fields
			if(date1==null && date2==null) return 0;
			else if(date1==null && date2!=null) return -1;
			else if(date1!=null && date2==null) return 1;
			else return date1.compareTo(date2);
		}
		
	}
}