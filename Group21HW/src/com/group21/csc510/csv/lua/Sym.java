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
	
	private int n;
	private int at;
	private String name;
	private HashMap<String,Integer> _has;
	
//	function Sym:new(c,s) 
//	  return {n=0,          -- items seen
//	          at=c or 0,    -- column position
//	          name=s or "", -- column name
//	          _has={}       -- kept data
//	         } end
	/**
	 * Sym constructor.
	 * @param c int for column position
	 * @param s String for s 
	 */
	public Sym(int c, String s){
		this.n = 0;
		this.at = c; // unsure about at=c or 0
		this.name = s;
		this._has= new HashMap<String, Integer>();
	}
	
//	  -- ## Sym
//	  -- Add one thing to `col`. For Num, keep at most `nums` items.
//	  function Sym:add(v)
//	    if v~="?" then self.n=self.n+1; self._has[v]= 1+(self._has[v] or 0) end end
	/**
	 * Method to add something to col. 
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
	
//	  function Sym:mid(col,    most,mode) 
//	    most=-1; for k,v in pairs(self._has) do if v>most then mode,most=k,v end end
//	    return mode end 
		
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
//	  function Sym:div(    e,fun)
//	    function fun(p) return p*math.log(p,2) end
//	    e=0; for _,n in pairs(self._has) do if n>0 then e=e - fun(n/self.n) end end
//	    return e end 

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

	private double divFun(double n) {
		return n*(Math.log(n)/ Math.log(2));
}
	
}
