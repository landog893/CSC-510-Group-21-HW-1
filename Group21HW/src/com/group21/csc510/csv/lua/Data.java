package com.group21.csc510.csv.lua;

import java.util.*;

public class Data {
	Cols cols;
	int[] rows;
	
	
	public HashMap<String, Object> stats(int places, List<List<Integer>> showCols, String fun){
		if(showCols == null) showCols = cols.y;
		if(fun == null) fun = "mid";
		
		final statFun func;
		switch(fun) {
			case("mid"):
				func = Data :: mid;
			break;
		}
		
		HashMap<String, Object> t = new HashMap<>();
		for (List<Integer> col : showCols) {
			Object v = func.run(col); 
			v = v.getClass().equals(Double.class) ? Utility.rnd((double)v, 2) : v;
			t.put(col.name, v);
		}
		
		return t;
		
	}
	
	private static double mid(List<Integer> col) {
		return Utility.per(col, 0.5);
	}
	
	@FunctionalInterface
	public interface statFun{
		Object run(List<Integer> col); 
	}
}
