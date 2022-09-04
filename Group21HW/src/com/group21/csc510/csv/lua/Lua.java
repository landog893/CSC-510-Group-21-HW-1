package com.group21.csc510.csv.lua;

/**
 * 
 */
import java.util.*;
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

public class Lua {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,Integer> test = new HashMap<>();
		testMethod(test);
		The the = new The();
		String help = "CSV : summarized csv file\n"
				+ "(c) 2022 Tim Menzies <timm@ieee.org> BSD-2 license\n"
				+ "USAGE: lua seen.lua [OPTIONS]\n"
				+ "OPTIONS:\n"
				+ " -e  --eg        start-up example                      = nothing\n"
				+ " -d  --dump      on test failure, exit with stack dump = false\n"
				+ " -f  --file      file with csv data                    = ../data/auto93.csv\n"
				+ " -h  --help      show help                             = false\n"
				+ " -n  --nums      number of nums to keep                = 512\n"
				+ " -s  --seed      random number seed                    = 10019\n"
				+ " -S  --seperator feild seperator                       = ,";
		String[] helpList = help.split("\n");
		for(int i = 0; i < helpList.length; i++) {
			if (helpList[i].charAt(1) == '-') {
				String[] lineList = helpList[i].split(" ");
				String k = lineList[1].substring(2, lineList[i].length());
				String x = lineList[4];
				
				for(int j = 0; j < args.length; j++) {
					if (args[j].equals("-" + k.substring(1,1)) || args[j].equals("--" + k)) {
						if(x.equals("True")) {
							x = "False";
						} else {
							x = "True";
						}
					}
				}
				the.nums.put(k, x);
			}
			
		}
		if(the.nums.get("Help").equals("True")) {
			System.out.println("\n" + help);
			System.exit(0);
		}
		
		
	}
	
	public static void testMethod(Object t) {
		System.out.println(t.getClass().toString());
	}

}
