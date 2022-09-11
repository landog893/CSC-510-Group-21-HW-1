package com.group21.csc510.csv.lua;


import java.util.*;

public class Row {
	HashMap<String, Object> rowBuilder;
	String [] cells;
	String [] cooked;
	boolean isEvaled;
	public Row(String [] t){
		cells = t;
		cooked = Arrays.copyOf(t,t.length);
		isEvaled = false;
	}
}
