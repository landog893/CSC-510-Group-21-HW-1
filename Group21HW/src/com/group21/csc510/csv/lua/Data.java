package com.group21.csc510.csv.lua;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;

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
			// TODO: handle exception
			return false;
		}
		
		return true;
	}
	
	/**
	 * Data Constructor
	 * validating the string data and reading data from file or from variable accordingly
	 * @param src is string containing either path info or rows
	 */
	public Data(String src) {
		
		this.cols = null;
		this.rows = new ArrayList<Row>();
		
		if(isPathvalid(src)) {
			try {
				Scanner sc = new Scanner(new File((String) src));
				while(sc.hasNext()) {
					String row = sc.next();
					String [] xs = row.split(",");
					this.add(xs);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			
		}
		else {
			Scanner sc = new Scanner(src);
			while(sc.hasNext()) {
				  String row = sc.next();
				  String [] xs = row.split(",");
				  this.add(xs);
			}
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
			for (Object object : cols.x) {
				if (object instanceof Num) {
					Num col = (Num)object;
					col.add(row.cells[col.at]);
				} else {
					Sym col = (Sym)object;
					col.add(row.cells[col.at]);
				}
				
			}
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
	
	public HashMap<String, Object> stats(int places, ArrayList<Object> showCols, String fun){
		if(showCols == null) showCols = cols.y;
		
		HashMap<String, Object> t = new HashMap<>();
		for (Object col : showCols) {
			Object v = null;
			if(col.getClass().equals(Num.class)){
				Num castedCol = (Num) col;
				try {
					Method func = castedCol.getClass().getMethod(fun, null);
					try {
						v = func.invoke(castedCol);
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}
				v = v.getClass().equals(Double.class) ? Utility.rnd((double)v, 2) : v;
				t.put(castedCol.name, v);
			} else {
				Sym castedCol = (Sym) col;
				try {
					Method func = castedCol.getClass().getMethod(fun, null);
					try {
						v = func.invoke(castedCol);
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}
				v = v.getClass().equals(Double.class) ? Utility.rnd((double)v, 2) : v;
				t.put(castedCol.name, v);
			}
		}
		
		return t;
		
	}
	
	
}
