package com.group21.csc510.csv.lua;

public class Eg {

	public The the;
	public Eg(The the) {
		this.the = the;
	}
	
	public void runs() {

		try {
			this.getClass().getMethod(the.nums.get("eg") .toLowerCase()).invoke(null);
		} catch(Exception e) {
			//Wrongly written prompt
		}
	}
	public void all() {
		System.out.println("\n-----------------------------------");
		sym();
		num();
		bigNum();
		the();
	}
	
	public void sym() {
		
	}
	
	public void num() {
		
	}
	
	public void bigNum() {
		
	}
	
	public void the() {
		
	}
	
}
