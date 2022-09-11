package com.group21.csc510.csv.lua;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.*;

public class Data {
	private Cols cols;
	private ArrayList<Row> rows;
	
	public static boolean isPathvalid(String path) {
		try {
			Paths.get(path);
		} catch (InvalidPathException e) {
			// TODO: handle exception
			return false;
		}
		
		return true;
	}
	public Data(String src) {
		
		this.cols = null;
		this.rows = new ArrayList<Row>();
		
		if(isPathvalid(src)) {
			try {
				Scanner sc = new Scanner(new File((String) src));
				while(sc.hasNext()) {
					String row = sc.next();
					this.add(row);
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
				  this.add(row);
			}
		}
		
	}
	public void add(String xs,String row) {
		String [] valueList = row.split(",");
		if (this.cols == null) {
			this.cols = new Cols(valueList);
		}
		else {
			Row row_ = new Row(valueList);
			this.rows.add(row_);
			for(Map.Entry<Integer,Object> map: this.cols.getY().entrySet()) {
				cols = 
			}
		}
		
		
	}
	public HashMap<String, Object> stats(int places, List<List<Integer>> showCols, String fun){
		if(showCols == null) showCols = cols.y;
		if(fun == null) fun = "mid";
		
		final statFun func;
		switch(fun) {
			case("mid"):
				func = Data :: mid;
			break;
		}
		
		HashMap<String, Object> t = new HashMap<>();
		for (List<Integer> col : showCols) {
			Object v = func.run(col); 
			v = v.getClass().equals(Double.class) ? Utility.rnd((double)v, 2) : v;
			t.put(col.name, v);
		}
		
		return t;
		
	}
	
	private static double mid(List<Integer> col) {
		return Utility.per(col, 0.5);
	}
	
	@FunctionalInterface
	public interface statFun{
		Object run(List<Integer> col); 
	}
}
