package com.ej.ex;

public class ParentClassOne {
	int pVar=10;	// default
	public String pString = "parent";
	private boolean pBool = true;
	protected float pFloat = 0.0003F;
	
	public ParentClassOne() {
		System.out.println("ParentClassOne() 생성자 호출됨!");
	}
	
	public void pMethod() {
		System.out.println("ParentMethod() 생성자 호출됨!");
	}

}
