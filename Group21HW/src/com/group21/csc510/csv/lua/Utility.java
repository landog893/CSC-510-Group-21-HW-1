/**
 * 
 */
package com.group21.csc510.csv.lua;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public abstract class Utility implements CSVInterface{
	/**
	 * Method to print out objects
	 * @param t the object to be displayed
	 * @return void
	 */
	public static String oo(Object t) {
		System.out.println(o(t));
		return o(t);
	}


	/**
	 * Method to transform objects to strings
	 * @param t the object to be displayed
	 * @return String
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String o(Object t) {
		if (t.getClass().toString().equals("class java.util.HashMap")
			||t instanceof Sym
			||t instanceof Num){
			
			List<String> u = new ArrayList<>();
			HashMap<String, Object> tCast = new HashMap<>();
			if(t instanceof Num) {
				Num temp = (Num) t;
				tCast.put("at", temp.at);
				tCast.put("hi", temp.hi);
				tCast.put("isSorted", temp.isSorted);
				tCast.put("lo", temp.lo);
				tCast.put("n", temp.n);
				tCast.put("name", temp.name);
				tCast.put("w", temp.w);
			}
			else if (t instanceof Sym) {
				Sym temp = (Sym) t;
				tCast.put("at", temp.at);
				tCast.put("n", temp.n);
				tCast.put("name", temp.name);
			}
			else {
				tCast = (HashMap<String, Object>) t;
			}
			for (Map.Entry<String, Object> entry: tCast.entrySet()) {
				String key = (String) entry.getKey();
				Object value = entry.getValue();
				u.add(show(key,value,tCast));
			}
			if(tCast.size() != 0) {
				Collections.sort(u);
			}
			return "{" + u.stream().collect(Collectors.joining("," )) + "}";
		}
		else {
			if(t.getClass().equals(ArrayList.class)){
				Collections.sort((ArrayList)t);
			}
			return t.toString();
		}		
	}
	
	/**
	 * Helper Method to change HashMap to String
	 * @param k the key of the HashMap
	 * @param v the value of the HashMap
	 * @return String
	 */
	private static String show(String k, Object v, HashMap<String,Object> t) {
		if(k.indexOf("^_")  == -1) {
			return t.size() != 0 ? String.format(":%s %s",k,v.toString()) : String.valueOf(v);
		}
		return null;
	}

	/**
	 * Method to round up a double number
	 * @param x the double value
	 * @param places the places of digits
	 * @return double
	 */
	public static double rnd(double x, int places) {
		if (places == 0) places = 2;
		double mult = Math.pow(10, places);
		int floored = (int)Math.floor(x*mult + 0.5);
		return (double) floored / mult;
	}
	
	/**
	 * This fountion is working with the sored list
	 * @param t: sorted list from this.nums()
	 * @param p: float number
	 * @return k-th element from t
	 **/
	public static double per(List<Double> t, double p) {
		    
			double Pnew = Math.floor(p * t.size() + 0.5);
			double idx = Math.max(1, Math.min(t.size(), Pnew));

			
			return t.get((int)idx); 
	}
	
	/**
	 * Method to read the given CSV file and call a specific function given a csv file name
	 * 
	 * @param fName file path 
	 * @param i instance of CSVInterface
	 * @throws FileNotFoundException when fail to read files
	 */
	public static void csv(String fName, CSVInterface i) throws FileNotFoundException {
		Scanner scanner = null;
		File file = new File(fName);
		scanner = new Scanner(file);

		
		scanner.useDelimiter("\n");
		
		while (scanner.hasNext()) {
			String s = scanner.next();
			String[] split = s.split(",");
			
			ArrayList<String> t = new ArrayList<String>();
			for (int x = 0; x < split.length; x++ ) {
				String currentString = split[x].trim();
				t.add(currentString);
			}
			
			i.csvFunction(t);
		}
		scanner.close();
	}
	
	/**
	 * Method to print out objects in unsorted way
	 * @param t the object to be displayed
	 * @return void
	 */
	public static String unsortedOO(Object t) {
		System.out.println(unsortedO(t));
		return unsortedO(t);
	}

	/**
	 * Method to transform objects to strings in unsorted way
	 * @param t the object to be displayed
	 * @return String
	 */
	@SuppressWarnings("unchecked")
	public static String unsortedO(Object t) {
		if (t.getClass().toString().equals("class java.util.HashMap")
			||t instanceof Sym
			||t instanceof Num){
			
			List<String> u = new ArrayList<>();
			HashMap<String, Object> tCast = new HashMap<>();
			if(t instanceof Num) {
				Num temp = (Num) t;
				tCast.put("at", temp.at);
				tCast.put("hi", temp.hi);
				tCast.put("isSorted", temp.isSorted);
				tCast.put("lo", temp.lo);
				tCast.put("n", temp.n);
				tCast.put("name", temp.name);
				tCast.put("w", temp.w);
			}
			else if (t instanceof Sym) {
				Sym temp = (Sym) t;
				tCast.put("at", temp.at);
				tCast.put("n", temp.n);
				tCast.put("name", temp.name);
			}
			else {
				tCast = (HashMap<String, Object>) t;
			}
			for (Map.Entry<String, Object> entry: tCast.entrySet()) {
				String key = (String) entry.getKey();
				Object value = entry.getValue();
				u.add(show(key,value,tCast));
			}
			if(tCast.size() != 0) {
				Collections.sort(u);
			}
			return "{" + u.stream().collect(Collectors.joining("," )) + "}";
		}
		else {
			return t.toString();
		}
		
		
	}
	

}
