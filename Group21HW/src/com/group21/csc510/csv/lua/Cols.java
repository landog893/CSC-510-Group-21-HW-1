/**
 * 
 */
package com.group21.csc510.csv.lua;

import java.util.HashMap;

/**
 * @author Shruti Marota
 */
public class Cols {
	
	private HashMap<String, String> names;
	private HashMap<String, String> all;
	private String klass;
	private HashMap<String, String> x; // dependent columns
	private HashMap<String, String> y; // independent columns
	
	public Cols(HashMap<String, String> names) {
		this.names = names;
		this.all = new HashMap<String, String>();
		this.klass = null;
		this.x = new HashMap<String, String>();
		this.y = new HashMap<String, String>();
	}
}
