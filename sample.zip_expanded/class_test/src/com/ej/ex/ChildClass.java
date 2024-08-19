package com.ej.ex;

public class ChildClass extends ParentClassOne {
	int cVar=10;	// default
	public String cString = "parent";
	private boolean cBool = true;
	protected float cFloat = 0.0003F;
	
	
	public ChildClass() {
		System.out.println("ChildClass() 생성자 호출됨");
	}

}
