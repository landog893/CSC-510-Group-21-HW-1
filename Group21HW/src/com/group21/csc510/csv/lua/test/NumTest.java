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

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.group21.csc510.csv.lua.Num;
import com.group21.csc510.csv.lua.The;

class NumTest {
	
	private static HashMap<String,String> the;
	
	@Before
	void setup() {
		the = new HashMap<String,String>();
	}
	
	@Test
	void num() {
		Num num = new Num(the);
		for(int i = 1; i < 100; i++) {
			num.add(Integer.toString(i));
		}
		float mid = num.mid();
		float div = num.div();
		assertTrue( mid >= 50 && mid <= 100);
		assertTrue( div >= 30.5 && div <= 32);
	}

	@Test
	void bigNum() {
		Num num = new Num(the);
		the.nums.put("nums", "32");
		for(int i = 1; i < 1000; i++) {
			num.add(Integer.toString(i));
		}
		Utility.oo(the);
		assertEquals(num._has.size(), 32);
	}
}
