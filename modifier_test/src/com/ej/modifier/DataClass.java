package com.ej.modifier;

public class DataClass {
	static int staticVar=10;		
	public int publicVar=100;
	int defaultVar=1000;
	
	private String name="kkh";
	private String category="coffee";
	
	public void setCategory(String category) {
		this.category = category;
		this.name = category;
	}


	static int[] test = new int[3];
	
	public DataClass() {
		this.initData();
	}
	
	static void initData() {
		test[0]=10;
		test[1]=20;
		test[2]=30;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}


}
