package com.group21.csc510.csv.lua;

import java.util.*;

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

public class Sym {
	int numItems;
	int columnPosition;
	String columnName;
	Map<Integer, Integer> _has = new HashMap<>();
	
	
	public int mid() {
		int most = -1;
		int mode = -1;
		for (Map.Entry<Integer, Integer> entry: this._has.entrySet()) {
			if(entry.getValue()>most) {
				mode = entry.getKey();
				most = entry.getValue();			
			}
		}
		
		return mode;
	}
	
	public double div() {
		double e = 0;
		for (Map.Entry<Integer, Integer> entry: this._has.entrySet()) {
			int n = entry.getValue();
			if(n>0) {
				e = e - this.divFun(n/this.numItems);
			}
		}
		return e;
	}
	
	private double divFun(int n) {
		return n*(Math.log(n)/ Math.log(2));
	}

}
