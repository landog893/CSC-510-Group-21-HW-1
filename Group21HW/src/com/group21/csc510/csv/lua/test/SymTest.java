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

	@Test
	void test() {
		Sym sym = new Sym(0, null);
		String[] testCase = new String[] {"a","a","a","a","b","b","c"};
		for(String item : testCase) {
			sym.add(item);
		}
		String mode = sym.mid();
		double entropy = sym.div();
		entropy = Math.floor(1000*entropy)/1000;
		Map<String,Object> t = new HashMap<>();
		t.put("mid", mode);
		t.put("div", (int)entropy);
		Utility.oo(t);
		assertEquals(mode, "a");
		assertEquals(entropy >= 1.37, true);
		assertEquals(entropy <= 1.38, true);
	}

}
