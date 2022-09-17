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

import org.junit.jupiter.api.Test;

import com.group21.csc510.csv.lua.Sym;
import com.group21.csc510.csv.lua.Utility;

import java.util.*;

class SymTest {
	/**
	 * Tests the initialization of Sym class instance
	 * and the class methods.
	 * @throws AssertionFailedError if the outputs don't meet the expectation
	 */
	@Test
	void test() {
		Sym sym = new Sym(0, null);
		String[] testCase = new String[] {"a","a","a","a","b","b","c"}; //The test case for setting up the "sym"
		for(String item : testCase) {
			sym.add(item); //Adds test case to "sym"
		}
		String mode = sym.mid(); //Calculates the mode
		double entropy = sym.div(); //Calculates the entropy
		entropy = Math.floor(1000*entropy)/1000; //Three decimal places
		//Construct and display the map for "mid" and "div"
		Map<String,Object> t = new HashMap<>();
		t.put("mid", mode);
		t.put("div", entropy);
		Utility.oo(t);
		//Asserts the value meet the expectation
		assertEquals(mode, "a");
		assertEquals(entropy >= 1.37, true);
		assertEquals(entropy <= 1.38, true);
	}

}
