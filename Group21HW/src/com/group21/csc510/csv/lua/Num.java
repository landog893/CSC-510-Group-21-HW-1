package com.group21.csc510.csv.lua;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 */

/**
 * The Class represents the Num object. This object represents neumerical data in the dataset. If column in the dataset
 * is uppercase, it is represented by a Num Object.
 *
 * @author Landon Gaddy
 * @author Jerry Chang
 * @author Jesse Chen
 * @author Sami Islam

 */
public class Num {
	
	/** Private int to represent how many items the Num object has seen. */
	public int n;
	/** Private string to represent the column name. */
	public String name;
	public boolean isSorted = true;
	/** Private HashMap to represent the data the object has kept. */
	public List<Double> _has;
	public int lo = Integer.MAX_VALUE;
	public int hi = Integer.MIN_VALUE;
	/** Private HashMap to represent the data the object contain the options to fulfill functional conditions. */
	private HashMap<String,String> the_var;
	
	/** Private int to represent the column position. */
	public int at;

	public int w = 1;
	

	/**
	 * Num constructor.
	 * @param c int for column position
	 * @param s String for s 
	 * @param the_var hashMap for geting "nums" option
	 */
	public Num(int c, String s, HashMap<String,String> the_var){
		this.n = 0;
		this.at = c; // unsure about at=c or 0
		this.name = s;
		this._has= new ArrayList<Double>();
		this.the_var = the_var;
		this.match(s);
	}
	
	/**
	 * Num constructor with only string
	 * @param s String for s 
	 * @param the_var the setting parameters
	 */
	public Num(String s,HashMap<String,String> the_var){
		this.n = 0;
		this.at = 0; // unsure about at=c or 0
		this.name = s;
		this._has= new ArrayList<Double>();
		this.the_var = the_var;
		this.match(s);

		
	}
	
	/**
	 * Num constructor with only column position
	 * @param c int for column position
	 * @param the_var the setting parameters
	 */
	public Num(int c,HashMap<String,String> the_var){
		this.n = 0;
		this.at = c; // unsure about at=c or 0
		this.name = "";
		this._has= new ArrayList<Double>();
		this.the_var = the_var;
	}

	/**
	 * Num constructor.
	 * @param c int for column position
	 * @param s the value to add
	 */
	public Num(int c, String s){
		this.n = 0;
		this.at = c; // unsure about at=c or 0
		this.name = s;
		this._has= new ArrayList<Double>();
		this.the_var = new HashMap<String,String>();
		this.match(s);
	}
	
	/**
	 * Num constructor.
	 * @param the_var the setting parameters
	 */
	public Num(HashMap<String,String> the_var){
		this.n = 0;
		this.at = 0; // unsure about at=c or 0
		this.name = "";
		this._has= new ArrayList<Double>();
		this.the_var = the_var;
	}

	/**
	 * Method for regex matching.
	 * @param s the string to be matched
	 */
	private void match(String s) {
		String patternStr = "-$";
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(s);
		if(matcher.find()){
			this.w = -1;
		}
	}
	
	/**
	 * Method to return sorted _has. 
	 * @return _has
	 */
	public List<Double> nums(){
		 
		if (!this.isSorted) {
			 this._has.sort(Comparator.naturalOrder());
		}
		
		return this._has;
	}
	/**
	 * Considered v as String type. So, if not "?" then we will consider the next steps for changing values for variable 
	 * n, 
	 * lo
	 * hi
	 * Here we declare a dictionary variable for _has stored the frequency for each number 
	 * There is a hashMap "the" which have a "nums" key to compare with the size of the _has map  
	 * This method will add neumerical value to columns 
	 * @param v the value to add
	*/	
	public void add(String v) {
		if (the_var.isEmpty() || the_var == null) {
			the_var.put("nums", "512");
		}
		int pos = 0;
		if (v != "?"){
			double vn = Double.parseDouble(v);
			this.n = this.n + 1;			
			this.lo = Math.min((int)vn, this.lo);
			this.hi = Math.max((int)vn,this.hi);
			
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
	
	
	
	/**
	 * Method to return standard deviation of col. 
	 * @return standard deviation
	 */
	public double div() {
		List<Double> a = this.nums();
		return (Utility.per(a, 0.9) - Utility.per(a, 0.1)) / 2.58;
	}
	/**
	 * Method to return the mode of col.
	 * @return mode of col
	 */
	public double mid() {
		List<Double> a = this.nums();
		return Utility.per(a, 0.5);
	}

}
