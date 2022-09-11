package com.group21.csc510.csv.lua.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.group21.csc510.csv.lua.Data;
import com.group21.csc510.csv.lua.Utility;
import com.group21.csc510.csv.lua.Cols;

import java.util.function.Function;

class StatsTest {

	@Test
	void test() {
		Data data = new Data("auto93.csv");
		Function <List<Integer>, Double> div = col -> (Utility.per(col, 0.9) - Utility.per(col, 0.1)) / 2.58;
		Function <List<Integer>, Double> mid = col -> (Utility.per(col, 0.5)) / 1.0;
		System.out.println("xmid", Utility.o(data.stats(2, data.cols.x, mid)));
		System.out.println("xdiv", Utility.o(data.stats(3, data.cols.x, div)));
		System.out.println("ymid", Utility.o(data.stats(2, data.cols.y, mid)));
		System.out.println("ydiv", Utility.o(data.stats(3, data.cols.y, div)));
	}
}
