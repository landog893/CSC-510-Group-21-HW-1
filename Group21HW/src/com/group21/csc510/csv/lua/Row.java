package com.group21.csc510.csv.lua;


import java.util.*;
/**
 * Class to represent row which holds one record from the CSV
 * @author Landon Gaddy
 */
public class Row {
	
	HashMap<String, Object> rowBuilder;
	/** String Array holds one record in each cells **/
	String [] cells;
	/** String Array which is used if we discretize the data**/
	String [] cooked;
	/** a boolan value return true if y -values evaluated **/
	boolean isEvaled;
	
	/**
	 * Constructor for the Cols object.
	 * @param t for passing the record from csv
	 */
	public Row(String [] t){
		cells = t;
		cooked = Arrays.copyOf(t,t.length);
		isEvaled = false;
	}
}
