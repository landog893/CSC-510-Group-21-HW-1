package com.group21.csc510.csv.lua;


import java.util.HashMap;


public class The {
	
	private HashMap<String,Integer> nums;
	
	public The(HashMap<String,Integer> nums) {
		this.nums=nums;
	}

	  // Getter
	  public HashMap<String,Integer> getNums() {
	    return nums;
	  }

	  // Setter
	  public void setName(HashMap<String,Integer> nums) {
	    this.nums = nums;
	  }
}
