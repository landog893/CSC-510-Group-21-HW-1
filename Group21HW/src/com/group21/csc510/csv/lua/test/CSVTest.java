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
	
	/** Counter variable **/
	public int n = 0;
	/** Output variable **/
	public String output = "";
	
	/**
	 * Tests the CSV functionality
	 * @throws FileNotFoundException if the file cannot be found
	 */
	@Test
	void csvTest() throws FileNotFoundException {
		String expectedOutput = "[Clndrs, Volume, Hp:, Lbs-, Acc+, Model, origin, Mpg+"
				+ "][8, 304, 193, 4732, 18.5, 70, 1, 10"
				+ "][8, 360, 215, 4615, 14, 70, 1, 10"
				+ "][8, 307, 200, 4376, 15, 70, 1, 10"
				+ "][8, 318, 210, 4382, 13.5, 70, 1, 10"
				+ "][8, 429, 208, 4633, 11, 72, 1, 10"
				+ "][8, 400, 150, 4997, 14, 73, 1, 10"
				+ "][8, 350, 180, 3664, 11, 73, 1, 10"
				+ "][8, 383, 180, 4955, 11.5, 71, 1, 10"
				+ "][8, 350, 160, 4456, 13.5, 72, 1, 10"
				+ "]";
		
		Utility.csv("documents/auto93.csv", new CSVInterface() {
			public void csvFunction(Object o) {
				n++;
				if (n > 10) {
					return;
				}
				else {
					output = output + Utility.unsortedOO(o);
				}
			}
		});	
		
		assertEquals(expectedOutput, output);
	}


}
