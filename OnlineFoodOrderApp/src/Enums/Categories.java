package Enums;

import java.util.HashMap;
import java.util.Map;

public enum Categories {
	VS(1,"Veg Starter"),
	VM(2,"Veg Main Course"),
	VD(3,"Veg Dessert"),
	NS(4,"Non-Veg Starter"),
	NM(5,"Non-Veg Main Course"),
	ND(6,"Non-Veg Dessert"),
	ES(7,"Eggitarian Starter"),
	EM(8,"Eggitarian Main Course"),
	ED(9,"Eggitarian Dessert");
	
	private int categoryCode;
	private String categoryLabel;
	
	private static Map<Integer,Categories> codeToCategoryMapping;
	
	private Categories(int code,String label) {
		this.categoryCode=code;
		this.categoryLabel=label;
	}
	
	public static Categories getCategory(int i) {
		if(codeToCategoryMapping==null) {
			initMapping();
		}
		return codeToCategoryMapping.get(i);
	}
	private static void initMapping() {
		codeToCategoryMapping= new HashMap<Integer,Categories>();
		for(Categories ctr:values()) {
			codeToCategoryMapping.put(ctr.categoryCode,ctr);
		}
	}
	
	public int getCategoryCode() {
		return this.categoryCode;
	}
	public String getCategoryLabel() {
		return categoryLabel;
	}
	
	
	
}
