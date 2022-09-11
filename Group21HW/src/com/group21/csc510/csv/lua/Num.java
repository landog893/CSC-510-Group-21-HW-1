package com.group21.csc510.csv.lua;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * 
 */

/**
 * @author Shruti Marotta
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
	private String name;
	private boolean isSorted = true;
	public List<Integer> _has;
	private int lo = Integer.MAX_VALUE;
	private int hi = Integer.MAX_VALUE;
	private HashMap<String,String> the_var;
	public int at;
	
	/*
	function Num:new(c,s) 
	  return {n=0,at=c or 0, name=s or "", _has={}, -- as per Sym
	          lo= math.huge,   -- lowest seen
	          hi= -math.huge,  -- highest seen
	          isSorted=true,   -- no updates since the last sort of data
	          w = ((s or ""):find"-$" and -1 or 1)  
	         } end*/

	/**
	 * Num constructor.
	 * @param c int for column position
	 * @param s String for s 
	 */
	public Num(int c, String s, HashMap<String,String> the_var){
		this.n = 0;
		this.at = c; // unsure about at=c or 0
		this.name = s;
		this._has= new ArrayList<Integer>();
		this.the_var = the_var;
	}
	
	/**
	 * Num constructor with only string
	 * @param s String for s 
	 */
	public Num(String s,HashMap<String,String> the_var){
		this.n = 0;
		this.at = 0; // unsure about at=c or 0
		this.name = s;
		this._has= new ArrayList<Integer>();
		this.the_var = the_var;
	}
	
	/**
	 * Num constructor with only column position
	 * @param c int for column position
	 */
	public Num(int c,HashMap<String,String> the_var){
		this.n = 0;
		this.at = c; // unsure about at=c or 0
		this.name = "";
		this._has= new ArrayList<Integer>();
		this.the_var = the_var;
	}

	/**
	 * Num constructor.
	 */
	public Num(int c, String s){
		this.n = 0;
		this.at = c; // unsure about at=c or 0
		this.name = s;
		this._has= new ArrayList<Integer>();
		this.the_var = new HashMap<String,String>();
	}
	
	/**
	 * Num constructor.
	 */
	public Num(HashMap<String,String> the_var){
		this.n = 0;
		this.at = 0; // unsure about at=c or 0
		this.name = "";
		this._has= new ArrayList<Integer>();
		this.the_var = the_var;
	}
	
	
	public List<Integer> nums(){
		 
		if (!this.isSorted) {
			 this._has.sort(Comparator.naturalOrder());
		}
		
		return this._has;
	}
	/* Considered v as String type. So, if not "?" then we will consider the next steps for changing values for variable 
	 * n, 
	 * lo
	 * hi
	 * Here I declare a dictionary variable for _has stored the frequency for each number may be I am not sure
	 * There is a object "the" which have a nums dictionary may be different/ similar to the _has 
	 * According to the declarations of different variables I if-else the if else conditions. */	
	public void add(String v) {
		int pos = 0;
		if (v != "?"){
			int vn = Integer.parseInt(v);
			this.n = this.n + 1;			
			this.lo = Math.min(vn, this.lo);
			this.hi = Math.max(vn,this.hi);
			
			int size_ = this._has.size();
			int nums = Integer.parseInt(this.the_var.get("nums"));
			if (size_ < nums) {
				pos = size_;
				this._has.add(pos, vn);
			}
			else if (Math.random() < nums *1.0/this.n) {
				this.isSorted = false;
				pos = (int) (Math.random() * size_);
				this._has.set(pos, vn);
			}
			
		}
		
	}
	
	
	
	
	public double div() {
		List<Integer> a = this.nums();
		return (Utility.per(a, 0.9) - Utility.per(a, 0.1)) / 2.58;
	}
	
	public double mid() {
		List<Integer> a = this.nums();
		return Utility.per(a, 0.5);
	}

}
