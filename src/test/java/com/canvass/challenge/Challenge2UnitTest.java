package com.canvass.challenge;

import java.util.Arrays;
import junit.framework.TestCase;

public class Challenge2UnitTest extends TestCase{
	
	// tests if 2 rows are sorted first by device id
	public void testRowsWithDifferentDeviceId() {
		String row1="1,78,89,36,52,2/15/18";
		String row2="2,16,1,16,54,1/31/18";
		String[] arr=new String[2];
		arr[0]=row1;
		arr[1]=row2;
		
		Arrays.sort(arr, new rowComparator());
		assertEquals("1",arr[0].split(",")[0]);
	}
	
	// tests if 2 rows are sorted by date if device id is same
	public void testRowsWithSameDeviceIdAndDifferentDate() { 
		String row1="1,78,89,36,52,2/15/18";
		String row2="1,16,1,16,54,1/31/18";
		String[] arr=new String[2];
		arr[0]=row1;
		arr[1]=row2;
		
		Arrays.sort(arr, new rowComparator());
		assertEquals("1/31/18",arr[0].split(",")[5]);
	}
	
	// tests if the row with blank date field(same device id) is placed first which is what I have assumed
	public void testRowsWithOneBlankDate() { 
		String row1="1,78,89,36,52,";
		String row2="1,16,1,16,54,1/31/18";
		String[] arr=new String[2];
		arr[0]=row1;
		arr[1]=row2;
		
		Arrays.sort(arr, new rowComparator());
		assertEquals("1/31/18",arr[1].split(",")[5]); // testing for non-blank field present as second entry in array
	}
	
	// tests if the date format of two rows are in different format(yyyy-MM-dd,mm/dd/yy)
	public void testRowsWithDifferentDateFormat() { 
		String row1="1,78,89,36,52,2001-10-11";
		String row2="1,16,1,16,54,1/31/18";
		String[] arr=new String[2];
		arr[0]=row1;
		arr[1]=row2;
		
		Arrays.sort(arr, new rowComparator());
		assertEquals("2001-10-11",arr[0].split(",")[5]);
	}
	
	//tests if 2 rows have different device ids and their dates are in different formats
	public void testRowsWithDifferentDeviceIDAndDifferentDateFormat() { 
		String row1="2,78,89,36,52,2001-10-11";
		String row2="1,16,1,16,54,1/31/18";
		String[] arr=new String[2];
		arr[0]=row1;
		arr[1]=row2;
		
		Arrays.sort(arr, new rowComparator());
		assertEquals("1",arr[0].split(",")[0]); 
	}
}
