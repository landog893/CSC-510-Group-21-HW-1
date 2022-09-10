/**
 * 
 */
package com.group21.csc510.csv.lua;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shruti Marota
 */
public class Cols {
	
	private String[] names;
	private HashMap<Integer, Object> all;
	private Object klass;
	private HashMap<Integer, Object> x; // dependent columns
	private HashMap<Integer, Object> y; // independent columns

	public Cols(String[] names) {
		this.names = names;
		this.all = new HashMap<Integer, Object>();
		this.klass = null;
		this.x = new HashMap<Integer, Object>();
		this.y = new HashMap<Integer, Object>();
		
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
		    if (!s.matches(":$")) {
		    	// if the col has + or -, its an dependent col
		    	if (s.matches("[!+-]")) {
		    		y.put(c, col);
		    	}
		    	// otherwise the col is independent
		    	else {
		    		x.put(c, col);
		    	}
		    }
		}
	}
}


