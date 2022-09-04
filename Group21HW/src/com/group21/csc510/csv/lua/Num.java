package com.group21.csc510.csv.lua;

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
 * @author Shruti Marota
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
	private boolean isSorted = true;
	private HashMap<String,Integer> _has;
	private int lo = Integer.MAX_VALUE;
	private int hi = Integer.MAX_VALUE;
	private The the_var;
	
	public Num(int n,  HashMap<String,Integer> _has, The the_var){
		this.n=n;
		this._has = new HashMap<String, Integer>();
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
	
	public HashMap<String, Integer> nums(){
		 
		if (!this.isSorted) {
			this._has = sortByValue(this._has );
		}
		return this._has;
	}
	/* Considered v as String type. So, if not "?" then we will consider the next steps for changing values for variable 
	 * n, 
	 * lo
	 * hi
	 * Here I declare a dictionary variable for _has storing the frequency for each numbers may be I am not sure
	 * There is a object "the" which have a nums dictionary may be different/ similar to the _has 
	 * According to the declarations of different variables I perform the if else conditions. */	
	public void add(String v) {
		int pos = 0;
		if (v != "?"){
			int vn = Integer.parseInt(v);
			this.n = this.n + 1;			
			this.lo = Math.min(vn, this.lo);
			this.hi = Math.max(vn,this.hi);
			
			int size_ = this._has.size();
			HashMap<String,Integer> nums = this.the_var.getNums();
			if (size_ < nums.size()) {
				pos = 1 + size_;
			}
			else if (Math.random() < nums.size() *1.0/this.n) {
				this.isSorted = false;
				pos = (int) (Math.random() * size_);
				this._has.put(Integer.toString(pos), vn);
			}
		}
		
	}

}
