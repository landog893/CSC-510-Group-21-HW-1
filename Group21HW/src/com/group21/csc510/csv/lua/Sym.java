package com.group21.csc510.csv.lua;

import java.util.*;

/**
 * 
 */

/**
 * This class represents the Sym object. This object represents binary/categorical data in the data set. If a column in the dataset
 * is lowercase, it is represented by a Sym object. 
 * 
 * @author Shruti Marota
 * @author Jesse Chen
 *
 */

public class Sym {
	
	/** Private int to represent how many items the Sym object has seen. */
	private int n;
	/** Private int to represent the column position. */
	public int at;
	/** Private string to represent the column name. */
	public String name;
	/** Private HashMap to represent the data the object has kept. */
	
	private HashMap<String,Integer> _has;
	
	/**
	 * Sym constructor.
	 * @param c int for column position
	 * @param s String for s 
	 */
	public Sym(int c, String s){
		this.n = 0;
		this.at = c;
		this.name = s;
		this._has= new HashMap<String, Integer>();
	}
	
	/**
	 * Sym constructor with only string
	 * @param s String for s 
	 */
	public Sym(String s){
		this.n = 0;
		this.at = 0; 
		this.name = s;
		this._has= new HashMap<String, Integer>();
	}
	
	/**
	 * Sym constructor with only column position
	 * @param c int for column position
	 */
	public Sym(int c){
		this.n = 0;
		this.at = c; 
		this.name = "";
		this._has= new HashMap<String, Integer>();
	}
	
	/**
	 * Sym constructor with no parameters (empty Sym object).
	 */
	public Sym(){
		this.n = 0;
		this.at = 0; // unsure about at=c or 0
		this.name = "";
		this._has= new HashMap<String, Integer>();
	}
	
	/**
	 * Method to add something to col. If the first letter of the column name is ?, skip the column.
	 * @param v 
	 */
	public void add(String v) {
		if (!v.equals("?")) {
			this.n = this.n + 1;
			// if the key is already in the hashmap, increment the value
			if (this._has.get(v) != null) {
				int currentValue = this._has.get(v);
				this._has.put(v, (1 + currentValue));
			}
			// if the key is not already in the hashmap, add with 0 as the value
			else {
				this._has.put(v, 1);
			}
		}
	}
	
	/**
	 * Method to return the mode of col.
	 * @return mode of col
	 */
	public String mid() {
		int most = -1;
		String mode = null;
		
		for (Map.Entry<String, Integer> entry : this._has.entrySet()) {
		    String key = entry.getKey();
		    Integer value = entry.getValue();
		    if (value > most) {
		    	mode = key;
		    	most = value;
		    }
		}
		return mode;
	}

	/**
	 * Method to return standard deviation of col. 
	 * @return standard deviation
	 */
	public double div() {
		double e = 0;
		for (Map.Entry<String, Integer> entry: this._has.entrySet()) {
			int n = entry.getValue();
			if(n>0) {
				e = e - this.divFun((double)n/this.n);
			}
		}
		return e;
	}

	/**
	 * Helper method to calculate standard deviation. 
	 * @param n integer to perform log calculation on
	 * @return output of log calculation
	 */
	private double divFun(double n) {
		return n*(Math.log(n)/ Math.log(2));
	}
	
}
