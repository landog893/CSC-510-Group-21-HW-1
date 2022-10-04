package com.group21.csc510.csv.lua.test;

/**
 * 
 */

/**
 * @author Shruti Marota
 * @author Landon Gaddy
 * @author Jerry Chang
 * @author Jesse Chen
 * @author Sami Islam
 * 
 * Feel free to change author tags if needed
 *
 */

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeAll;
//import org.junit.Before;
//import org.junit.Test;
import org.junit.jupiter.api.Test;

import com.group21.csc510.csv.lua.Num;
import com.group21.csc510.csv.lua.Utility;

class NumTest {
	
	private static HashMap<String,String> the;
	
	@BeforeAll
	public static void setup() {
		the = new HashMap<String,String>();
	}
	
	/**
	 * Test method
	 * Compute mid and div through Num object. Mid value has to between 50 and 100 and div value has to between 30.5 and 32.
	 * @Test annotation represents the mid and div test of the Num class.
	 */
	@Test
	public void num() {
		the.put("nums", "512");
		Num num = new Num(the);
		for(int i = 0; i < 100; i++) {
			num.add(Double.toString(i));
		}
		double mid = num.mid();
		double div = num.div();
		assertTrue( mid >= 50 && mid <= 100);
		assertTrue( div >= 30.5 && div <= 32);
	}
	
	/**
	 * Test method
	 * Add 32 numbers of numerical value to columns and print them through Utility.oo
	 * @Test annotation represents the add test of the Num class.
	 */
	@Test
	public void bigNum() {
		Num num = new Num(the);
		the.put("nums", "32");
		for(int i = 0; i < 1000; i++) {
			num.add(String.valueOf(i));
		}
		Utility.oo(num._has);
		assertEquals(32, num._has.size());
	}
}
