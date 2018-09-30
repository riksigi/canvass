package com.canvass.challenge;
import junit.framework.TestCase;

public class Challenge1UnitTest extends TestCase {
	 
	public void testNumWithEvenDigits()
    {
        	Challenge1 cl=new Challenge1();
    		assertEquals(true,cl.check(2222));	
    }
	
	public void testNumWithOddDigits() {
		
		Challenge1 c2=new Challenge1();
		assertEquals(false,c2.check(1222));
	}
}
