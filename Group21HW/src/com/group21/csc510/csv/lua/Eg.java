package com.group21.csc510.csv.lua;


import java.util.HashMap;
import java.util.Map;

import com.group21.csc510.csv.lua.test.Utility;

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
		bigNum();
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
		
	}
	
	public void bigNum() {
		
	}
	
	public void the() {
		Map<String, Object>thethe = new HashMap<>();
		Utility.oo(thethe);
	}
	
}
