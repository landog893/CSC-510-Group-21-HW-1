package com.group21.csc510.csv.lua;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
	public HashMap<String,Integer> _has;
	private int lo = Integer.MAX_VALUE;
	private int hi = Integer.MAX_VALUE;
	private HashMap<String,Integer> the_var;
	private int at;
	
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
	public Num(int c, String s, HashMap<String,Integer> the_var){
		this.n = 0;
		this.at = c; // unsure about at=c or 0
		this.name = s;
		this._has= new HashMap<String, Integer>();
		this.the_var = the_var;
	}
	
	/**
	 * Sym constructor with only string
	 * @param s String for s 
	 */
	public Num(String s,HashMap<String,Integer> the_var){
		this.n = 0;
		this.at = 0; // unsure about at=c or 0
		this.name = s;
		this._has= new HashMap<String, Integer>();
		this.the_var = the_var;
	}
	
	/**
	 * Sym constructor with only column position
	 * @param c int for column position
	 */
	public Num(int c,HashMap<String,Integer> the_var){
		this.n = 0;
		this.at = c; // unsure about at=c or 0
		this.name = "";
		this._has= new HashMap<String, Integer>();
		this.the_var = the_var;
	}
	
	/**
	 * Sym constructor.
	 */
	public Num(HashMap<String,Integer> the_var){
		this.n = 0;
		this.at = 0; // unsure about at=c or 0
		this.name = "";
		this._has= new HashMap<String, Integer>();
		this.the_var = the_var;
	}
	
	public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
               new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());
 
        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
         
        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
	
	public List nums(){
		 
		if (!this.isSorted) {
			this._has = sortByValue(this._has );
		}
		List<Integer> values = new ArrayList<>(this._has.values());
		return values;
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
			int nums = this.the_var.get("nums");
			if (size_ < nums) {
				pos = 1 + size_;
			}
			else if (Math.random() < nums *1.0/this.n) {
				this.isSorted = false;
				pos = (int) (Math.random() * size_);
				this._has.put(Integer.toString(pos), vn);
			}
		}
		
	}
	
	
	public float per(List t, float p) {
	/*
	  Input:
	    t: sorted list from this.nums()
	    p: float number
	    
	  output:
	    k-th element from t
	    
	*/
		int Pnew = Math.floor(p * t.size() + 0.5);
		
		return t.get(Math.max(1, Math.min(t.size(), Pnew))); 
	}
	
	public float div() {
		List a = new this.nums();
		return (per(a, 0.9) - per(a, 0.1)) / 2.58;
	}
	
	public float mid() {
		List a = new this.nums();
		return per(a, 0.5)
	}

}
