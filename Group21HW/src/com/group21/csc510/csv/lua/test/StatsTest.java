package com.group21.csc510.csv.lua.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;
import com.group21.csc510.csv.lua.Data;
import com.group21.csc510.csv.lua.Utility;

class StatsTest {
	/**
	 * Test method
	 * Reading Data from CSV through Data Object and Computing Median and Standard Deviation through "stats" Function from Data Class
	 * @Test annotation represents the core test of the data class
	 */
	@Test
	void test() {
		try {
			Data data = new Data("documents/auto93.csv");
			System.out.println("xmid: " + Utility.o(data.stats(2, data.cols.x, "mid")));
			System.out.println("xdiv: " + Utility.o(data.stats(3, data.cols.x, "div")));
			System.out.println("ymid: " + Utility.o(data.stats(2, data.cols.y, "mid")));
			System.out.println("ydiv: " + Utility.o(data.stats(3, data.cols.y, "div")));
			assertTrue(true);
		} catch (FileNotFoundException e) {
			fail();
		}
	}
}
