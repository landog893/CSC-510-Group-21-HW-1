package com.group21.csc510.csv.lua;


import java.util.HashMap;


public class The {
	
	public HashMap<String,String> nums;
	
	public The(HashMap<String,String> nums) {
		this.nums=nums;
	}
	
	public The() {
		this.nums = new HashMap<String,String>();
	}

	  // Getter
	  public HashMap<String,String> getNums() {
	    return nums;
	  }

	  // Setter
	  public void setName(HashMap<String,String> nums) {
	    this.nums = nums;
	  }
}
