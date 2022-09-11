/**
 * 
 */
package com.group21.csc510.csv.lua;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Shruti Marota
 */
public class Cols {
	
	private String[] names;
	public HashMap<Integer, Object> all;
	private Object klass;
	public ArrayList<Object> x; // dependent columns
	public ArrayList<Object> y; // independent columns

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
		    if (!s.matches(":$")) {
		    	// if the col has + or -, its an dependent col
		    	if (s.matches("[!+-]")) {
		    		y.add(col);
		    	}
		    	// otherwise the col is independent
		    	else {
		    		x.add(col);
		    	}
		    }
		}
	}
}


