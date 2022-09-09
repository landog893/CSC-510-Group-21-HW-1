/**
 * 
 */
package com.group21.csc510.csv.lua;

import java.util.*;
import java.util.stream.Collectors;

public class Utility {
	public static void oo(Object t) {
		System.out.println(o(t));
	}
	
	@SuppressWarnings("unchecked")
	private static String o(Object t) {
		if (!t.getClass().toString().equals("class java.util.HashMap")){
			return t.toString();
		}
		List<String> u = new ArrayList<>();
		HashMap<String, Object> tCast = (HashMap<String, Object>) t;
		for (Map.Entry<String, Object> entry: tCast.entrySet()) {
			String key = (String) entry.getKey();
			Object value = entry.getValue();
			u.add(show(key,value,tCast));
		}
		if(tCast.size() == 0) {
			Collections.sort(u);
		}
		return "{" + u.stream().collect(Collectors.joining("," )) + "}";
	}
	
	private static String show(String k, Object v, HashMap<String,Object> t) {
		if(k.indexOf("^_")  == -1) {
			return t.size() == 0 ? String.format(":%s %s",k,v.toString()) : String.valueOf(v);
		}
		return null;
	}
	
	public static double rnd(double x, int places) {
		if (places == 0) places = 2;
		double mult = 10^places;
		return Math.floor(x*mult + 0.5) / mult;
	}
	
	public static int per(List<Integer> t, double p) {
		/*
		  Input:
		    t: sorted list from this.nums()
		    p: float number
		    
		  output:
		    k-th element from t
		    
		*/
			double Pnew = Math.floor(p * t.size() + 0.5);
			double idx = Math.max(1, Math.min(t.size(), Pnew));

			
			return t.get((int)idx); 
	}
}
