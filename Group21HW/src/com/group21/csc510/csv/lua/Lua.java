package com.group21.csc510.csv.lua;

/**
 * 
 */
import java.util.*;
/**
 * @author Shruti Marotas
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
	 * Main method that is called when the program runs and sets up all user provided variables
	 * @param args the command line arguments passed by the user
	 */
	public static void main(String[] args) {
		HashMap<String,String> the = new HashMap<String,String>();
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
				String[] lineList = helpList[i].split("\\s+");
				String k = lineList[2].substring(2, lineList[2].length());
				String x = lineList[lineList.length - 1];
				
				for(int j = 0; j < args.length - 1; j = j + 2) {
					if (args[j].equals("-" + k.substring(0,1)) || args[j].equals("--" + k)) {
						if(x.equals("True")) {
							x = "False";
						} else if (x.equals("False")) {
							x = "True";
						} else {
							x = args[j + 1];
						}
					}
				}
				the.put(k, x);
			}
			
		}
		if(the.get("help").equals("True")) {
			System.out.println("\n" + help);
			System.exit(0);
		}
		if (!the.get("eg").equals("nothing")) {
			Eg eg = new Eg(the);
			eg.runs();
		}
	}
}
