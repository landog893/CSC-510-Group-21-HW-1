package com.group21.csc510.csv.lua;

import java.util.Dictionary;
import java.util.Hashtable;

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

public class Num {
	
	private int n;
	private boolean isSorted;
	private Dictionary _has;
	private int lo;
	private int hi;
	private the the_var;
	public Num(int n, boolean isSorted, Dictionary _has, int lo, int hi, the the_var){
		this.n=n;
		this.isSorted=isSorted;
		this._has = _has;
		this.lo = lo;
		this.hi= hi;
		this.the_var = the_var;
	}
	
	public void add(String v, int pos) {
		
		/* Considered v as String type. So, if not "?" then we will consider the next steps for changing values for variable 
		 * n, 
		 * lo
		 * hi
		 * Here I declare a dictionary variable for _has storing the frequency for each numbers may be I am not sure
		 * There is a object "the" which have a nums dictionary may be different/ similar to the _has 
		 * According to the declarations of different variables I perform the if else conditions. */
		if (v != "?"){
			int vn = Integer.parseInt(v);
			this.n = this.n + 1;			
			this.lo = Math.min(vn, this.lo);
			this.hi = Math.max(vn,this.hi);
			
			int size_ = this._has.size();
			Dictionary nums = this.the_var.getNums();
			if (size_ < nums.size()) {
				pos = 1 + size_;
			}
			else if (Math.random() < nums.size() *1.0/this.n) {
				this.isSorted = false;
				pos = (int) (Math.random() * size_);
				this._has.put(pos, vn);
			}
		}
		
	}

}
