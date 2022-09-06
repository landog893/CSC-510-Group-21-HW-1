package com.group21.csc510.csv.lua;

import java.util.HashMap;
import java.util.Map;

public class Eg {

	public HashMap<String,String> the;
	
	public Eg(HashMap<String,String> the) {
		this.the = the;
	}
	
	public void runs() {

		try {
			this.getClass().getMethod(the.get("eg").toLowerCase()).invoke(this);
		} catch(Exception e) {
			//Wrongly written prompt
		}
	}
	public void all() {
		System.out.println("\n-----------------------------------");
		sym();
		num();
		bignum();
		the();
	}
	
	public void sym() {
		Sym symsym = new Sym(0, null);
		String[] testCase = new String[] {"a","a","a","a","b","b","c"};
		for(String item : testCase) {
			symsym.add(item);
		}
		String symmode = symsym.mid();
		double symentropy = symsym.div();
		symentropy = Math.floor(1000*symentropy)/1000;
		Map<String,Object> t = new HashMap<>();
		t.put("mid", symmode);
		t.put("div", (int)symentropy);
		Utility.oo(t);
		System.out.println(symmode.equals("a"));
		System.out.println(symentropy >= 1.37);
		System.out.println(symentropy <= 1.38);
	}
	
	public void num() {
		Num num = new Num(the);
		for(int i = 1; i < 100; i++) {
			num.add(Integer.toString(i));
		}
		double mid = num.mid();
		double div = num.div();
		System.out.println( mid >= 50 && mid <= 100);
		System.out.println( div >= 30.5 && div <= 32);
	}
	
	public void bignum() {
		Num num = new Num(the);
		the.put("nums", "32");
		for(int i = 1; i < 1000; i++) {
			num.add(Integer.toString(i));
		}
		Utility.oo(the);
		System.out.println(32 == num._has.size());
	}
	
	public void the() {
		Map<String, Object>thethe = new HashMap<>();
		Utility.oo(thethe);
	}
	
}
