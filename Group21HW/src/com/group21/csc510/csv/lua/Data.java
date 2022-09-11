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
	
	public HashMap<String, Object> stats(int places, List<Object> showCols, String fun){
		if(showCols == null) showCols = cols.y;
		if(fun == null) fun = "mid";
		
		final statFun func;
		switch(fun) {
			case("mid"):
				func = Data :: mid;
			break;
		}
		
		HashMap<String, Object> t = new HashMap<>();
		for (Object col : showCols) {
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
