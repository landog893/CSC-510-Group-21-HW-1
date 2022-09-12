package com.group21.csc510.csv.lua.test;

import com.group21.csc510.csv.lua.Data;

import com.group21.csc510.csv.lua.Utility;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.junit.jupiter.api.Test;

class DataTest {

	@Test
	void test() {
		Data d = new Data("documents/auto93.csv");
		for (Object col: d.cols.y) {
			Utility.oo(col);
		}
	}

}
