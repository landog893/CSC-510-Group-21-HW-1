package com.group21.csc510.csv.lua.test;

import com.group21.csc510.csv.lua.Data;
import com.group21.csc510.csv.lua.Utility;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author Landon Gaddy
 * 
 * This is a DataTest class testing Data class test cases.
 *
 */

class DataTest {

	/**
	 * Test method
	 * Reading Data from CSV through Data Object and printing the desired value through "oo" function from Utility class
	 * @Test annotation represents the core test of the dataclass
	 */
	@Test
	void test() {
		try {
			Data d = new Data("documents/auto93.csv");
				for (Object col: d.cols.y) {
					Utility.oo(col);
				}
				assertTrue(true);
			} catch (FileNotFoundException e) {
				fail();
			}
	}

}
