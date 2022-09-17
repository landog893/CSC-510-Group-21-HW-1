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

import java.util.*;

import org.junit.jupiter.api.Test;

import com.group21.csc510.csv.lua.Utility;

class TheTest {
	/**
	 * Tests and displays the "the" data structure
	 * @throws AssertionFailedError if the "the" is null
	 */
	@Test
	void test() {
		Map<String, Object>the = new HashMap<>();
		Utility.oo(the);
		assertNotNull(the);
	}

}
