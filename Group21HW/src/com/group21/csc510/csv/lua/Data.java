package com.group21.csc510.csv.lua;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.*;

/**
 * 
 */

/**
 * This class represents the Data object. This object represents the data set. 
 * @author Saminur Islam
 * @author Jesse Chen
 * @author Landon Gaddy
 * author Jerry Chang
 */

public class Data {
	/** public cols to represent Col object to get column information. */
	public Cols cols;
	/** private rows to represent a list Row object to store rows from the CSV */
	private ArrayList<Row> rows;
	
	/**
	 * Method to the type of String value is passed on the constructor.
	 * param src is string containing either path info or rows
	 * @return boolean
	 */
	public static boolean isPathvalid(String path) {
		try {
			Paths.get(path);
		} catch (InvalidPathException e) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Data Constructor
	 * validating the string data and reading data from file or from variable accordingly
	 * @param src is string containing either path info or rows
	 */
	public Data(String src) throws FileNotFoundException {
		
		this.cols = null;
		this.rows = new ArrayList<Row>();
		
		if(isPathvalid(src)) {
			Scanner sc = new Scanner(new File((String) src));
			while(sc.hasNext()) {
				String row = sc.next();
				String [] xs = row.split(",");
				this.add(xs);
			}
			
		}
		else {
			Scanner sc = new Scanner(src);
			while(sc.hasNext()) {
				  String row = sc.next();
				  String [] xs = row.split(",");
				  this.add(xs);
			}
			sc.close();
		}
		
	}
	
	/**
	 * Method to add something to col. 
	 * @param xs is an array of string containing column values for each row 
	 */
	public void add(String[] xs) {
		if (cols == null) {
			cols = new Cols(xs);
		}
		else {
			Row row = new Row(xs);
			rows.add(row);
			// iterating indepdent columns to get the add, Num or Sym object tp Col
			for (Object object : cols.x) {
				if (object instanceof Num) {
					Num col = (Num)object;
					col.add(row.cells[col.at]);
				} else {
					Sym col = (Sym)object;
					col.add(row.cells[col.at]);
				}
				
			}
			// iterating depedent columns columns to get the add, Num or Sym object tp Col
			for (Object object: cols.y) {
				if (object instanceof Num) {
					Num col = (Num)object;
					col.add(row.cells[col.at]);
				} else {
					Sym col = (Sym)object;
					col.add(row.cells[col.at]);
				}
			}
		}

		
	}
	
	/**
	 * Method to stats something to col. 
	 * @param places is an integer with a default value 2
	 * @param showCols is a List of independent or dependent variable of cols.x or cols.y where shoCols default value is cols.x
	 * @param fun is represents the function we will call here default is "mid"
	 * @return a HasMap of column names and value
	 */
	
	public HashMap<String, Object> stats(int places, ArrayList<Object> showCols, String fun){
		if(showCols == null) {
			showCols = cols.y;
		}
		
		HashMap<String, Object> t = new HashMap<>();
		for (Object col : showCols) {
			Object v = null;
			try {
				// calling function from the Num Class according to the parameter: String fun
				Method func = col.getClass().getMethod(fun);
				try {
					// Invoke the corresponding method
					v = func.invoke(col);
				} catch (IllegalAccessException e) {  //Exception handling
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
			v = v.getClass().equals(Double.class) ? Utility.rnd((double)v, 2) : v;
			//Check the type of instance and get the name
			if(col instanceof Num){
				Num temp = (Num) col;
				t.put(temp.name, v);
			}
			else{
				Sym temp = (Sym) col;
				t.put(temp.name, v);
			}
		}
		
		return t;
		
	}
	
	
}
