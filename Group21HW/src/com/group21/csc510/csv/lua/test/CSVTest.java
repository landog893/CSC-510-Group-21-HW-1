/**
 * 
 */
package com.group21.csc510.csv.lua.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

import com.group21.csc510.csv.lua.CSVInterface;
import com.group21.csc510.csv.lua.Utility;

/**
 * @author Shruti Marota
 *
 */
class CSVTest {
	
	public int n = 0;
	
	@Test
	boolean csvTest() throws FileNotFoundException {
		Utility.csv("documents/auto93.csv", new CSVInterface() {
			public void csvFunction(Object o) {
				n++;
				if (n > 10) {
					return;
				}
				else {
					Utility.oo(o);
				}
			}
		});
		
		return true;
	}


}
