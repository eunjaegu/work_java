package com.ej.map;

public class Student {
	private int no;
	private String name;
	
	public Student() {
	}
	
	public Student(int no, String name) {
		this.no=no;
		this.name=name;
	}

	@Override
	public String toString() {
		return "Student [no=" + no + ", name=" + name + "]";
	}

}
