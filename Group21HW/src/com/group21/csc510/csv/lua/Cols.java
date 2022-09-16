/**
 * 
 */
package com.group21.csc510.csv.lua;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class to represent the list of columns from the data set and holds summaries of all the columns. 
 * @author Shruti Marota
 */
public class Cols {
	
	/** String list of names of all the columns */
	private String[] names;
	/** HashMap of all the columns, including the skipped ones */
	public HashMap<Integer, Object> all;
	/** Represents the single dependent klass column (if it exists) */
	private Object klass;
	/** Represents a list of independent columns */
	public ArrayList<Object> x;
	/** Represents a list of dependent columns */
	public ArrayList<Object> y; 
	
	/**
	 * Constructor for the Cols object.
	 * @param names list of column names
	 */
	public Cols(String[] names) {
		this.names = names;
		this.all = new HashMap<Integer, Object>();
		this.klass = null;
		this.x = new ArrayList<Object>();
		this.y = new ArrayList<Object>();
		
		for (int i = 0; i < names.length; i++) {
		    int c = i;
		    String s = names[i];
		    
		    Object col;
		    // if the first character is uppercase, create a num object
		    if ( s.matches("^[A-Z]*") ) {
		    	col = new Num(c, s);
		    	all.put(c, col);
		    }
		    // else create a sym object
		    else {
		    	col = new Sym(c, s);
		    	all.put(c, col);
		    }
		    
		    // check if the column is skipped
		    if (s.charAt(s.length() - 1) != ':') {
		    	// if the col has + or -, its an dependent col
		    	if (s.charAt(s.length() - 1) == '!' || s.charAt(s.length() - 1) == '-' || s.charAt(s.length() - 1) == '+') {
		    		y.add(col);
		    		if (s.charAt(s.length() - 1) == '!') {
		    			this.klass = col;
		    		}
		    	}
		    	// otherwise the col is independent
		    	else {
		    		x.add(col);
		    	}
		    }
		}
	}
}


