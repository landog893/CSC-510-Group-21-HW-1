package com.group21.csc510.csv.lua;


import java.util.*;

public class Row {
	HashMap<String, Object> rowBuilder;
	int[] cells;
	int[] cooked;
	boolean isEvaled;
	public Row(int[] t){
		cells = t;
		cooked = Arrays.copyOf(t,t.length);
		isEvaled = false;
	}
}
