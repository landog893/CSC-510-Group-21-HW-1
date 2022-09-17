package com.group21.csc510.csv.lua;


import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * Stores and runs the start-up examples as chosen by the user
 * 
 * @author Landon Gaddy
 * @author Jerry Chang
 * @author Jesse Chen
 * @author Sami Islam
 */
public class Eg {

	/** Map that defines all of the program settings **/
	public HashMap<String,String> the;
	/** Counter variable used by the csv test **/
	public int n = 0;
	/** Output variable used by the csv test **/
	public String output = "";
	/** Flag for whether stack dump is enabled**/
	public boolean status;
	/** Flag for whether a test has failed **/
	public boolean globalTest;
	
	/**
	 * Constructor that defines the settings variable
	 * @param the the provided map of program settings
	 */
	public Eg(HashMap<String,String> the) {
		this.the = the;
	}
	
	/**
	 * Finds the desired function and runs it
	 */
	public void runs() {
		globalTest = true;
		status = the.get("dump").equals("true");
		try {
			this.getClass().getMethod(the.get("eg").toLowerCase()).invoke(this);
		} catch(Exception e) {
			System.out.println("\nError with provided start-up example");
		}
	}
	
	/**
	 * Runs all of the start up examples
	 */
	public void all() {
		ls();
		sym();
		num();
		bignum();
		the();
		try {
			csv();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		data();
		stats();
		String msg = globalTest ? "PASS" : "FAIL";
		System.out.println("!!!!!!	" + msg + "	ALL	" + status);
	}
	
	/**
	 * Lists all of the start-up example functions
	 */
	public void ls() {
		System.out.println("\n-----------------------------------");
		System.out.println("Examples lua csv -e ...\n"
				+ "	ALL\n"
				+ "	LS\n"
				+ "	bignum\n"
				+ "	csv\n"
				+ "	data\n"
				+ "	num\n"
				+ "	stats\n"
				+ "	sym\n"
				+ "	the\n"
				+ "!!!!!!	PASS	LS	" + status);
		
	}
	
	/**
	 * Tests the symbolic value functionality
	 */
	public void sym() {
		System.out.println("\n-----------------------------------");
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
		boolean test = symmode.equals("a") && symentropy >= 1.37 && symentropy <= 1.38;
		String msg = test ? "PASS" : "FAIL";
		System.out.println("!!!!!!	" + msg + "	sym	" + status);
		if (!test) globalTest = false;
	}
	
	/**
	 * Tests the number functionality
	 */
	public void num() {
		System.out.println("\n-----------------------------------");
		Num num = new Num(the);
		for(int i = 1; i < 100; i++) {
			num.add(Integer.toString(i));
		}
		double mid = num.mid();
		double div = num.div();
		boolean test = mid >= 50 && mid <= 100 && div >= 30.5 && div <= 32;
		String msg = test ? "PASS" : "FAIL";
		System.out.println(mid + "	" + div);
		System.out.println("!!!!!!	" + msg + "	num	" + status);
		if (!test) globalTest = false;
	}
	
	/**
	 * Tests the number functionality with a large quantity of numbers
	 */
	public void bignum() {
		System.out.println("\n-----------------------------------");
		Num num = new Num(the);
		the.put("nums", "32");
		for(int i = 1; i < 1000; i++) {
			num.add(Integer.toString(i));
		}
		Utility.oo(num);
		boolean test = 32 == num._has.size();
		String msg = test ? "PASS" : "FAIL";
		System.out.println("!!!!!!	" + test + "	bignum	" + status);
		if (!test) globalTest = false;
	}
	
	/**
	 * Tests the setting variable 
	 */
	public void the() {
		System.out.println("\n-----------------------------------");
		Utility.oo(the);
		System.out.println("!!!!!!	" + "PASS" + "	the	" + status);
	}
	
	/**
	 * Tests getting a file
	 * @throws FileNotFoundException if the file cannot be found
	 */
	public void csv() throws FileNotFoundException {
		System.out.println("\n-----------------------------------");
		String expectedOutput = "[Clndrs, Volume, Hp:, Lbs-, Acc+, Model, origin, Mpg+"
				+ "][8, 304, 193, 4732, 18.5, 70, 1, 10"
				+ "][8, 360, 215, 4615, 14, 70, 1, 10"
				+ "][8, 307, 200, 4376, 15, 70, 1, 10"
				+ "][8, 318, 210, 4382, 13.5, 70, 1, 10"
				+ "][8, 429, 208, 4633, 11, 72, 1, 10"
				+ "][8, 400, 150, 4997, 14, 73, 1, 10"
				+ "][8, 350, 180, 3664, 11, 73, 1, 10"
				+ "][8, 383, 180, 4955, 11.5, 71, 1, 10"
				+ "][8, 350, 160, 4456, 13.5, 72, 1, 10"
				+ "]";
		try {
		Utility.csv("documents/auto93.csv", new CSVInterface() {
			public void csvFunction(Object o) {
				
				n++;
				if (n > 10) {
					return;
				}
				else {
					output = output + Utility.oo(o);
				}
			}
		});	
		boolean test = expectedOutput.equals(output);
		String msg = test ? "PASS" : "FAIL";
		System.out.println("!!!!!!	" + msg + "	csv	" + status);
		if (!test) globalTest = false;
		} catch (FileNotFoundException e){
			System.out.println("!!!!!!	" + "CRASH" + "	the	" + status);
			globalTest = false;
		}
	}
	
	/**
	 * Tests the data functionality
	 */
	public void data() {
		System.out.println("\n-----------------------------------");
		try {
		Data d = new Data("documents/auto93.csv");
			for (Object col: d.cols.y) {
				Utility.oo(col);
			}
			System.out.println("!!!!!!	" + "PASS" + "	data	" + status);
		} catch (FileNotFoundException e) {
			System.out.println("!!!!!!	" + "CRASH" + "	data	" + status);
			globalTest = false;
		}
	}
	
	/**
	 * Tests the stats functionality
	 */
	public void stats() {
		System.out.println("\n-----------------------------------");
		try {
			Data data = new Data("documents/auto93.csv");
			System.out.println("xmid: " + Utility.o(data.stats(2, data.cols.x, "mid")));
			System.out.println("xdiv: " + Utility.o(data.stats(3, data.cols.x, "div")));
			System.out.println("ymid: " + Utility.o(data.stats(2, data.cols.y, "mid")));
			System.out.println("ydiv: " + Utility.o(data.stats(3, data.cols.y, "div")));
			System.out.println("!!!!!!	" + "PASS" + "	stats	" + status);
		} catch (FileNotFoundException e) {
			System.out.println("!!!!!!	" + "CRASH" + "	stats	" + status);
			globalTest = false;
		}

	}
	
	
}
