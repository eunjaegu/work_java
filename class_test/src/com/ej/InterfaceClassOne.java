package com.ej;

//interface
public interface InterfaceClassOne {
	public int a=10;	// 상수로 선언됨!!
	
	/*
	public void test() {		// interface는 생성자를 가질 수 없기 때문에 오류 발생!!!
	}
	*/
	
	// interface는 메서드 명만 선언 가능!!
	public void test();
	public void test(int a);
	public int test(int a, int b);
	// interface 를 구현받는 클래스는 반드시 interface 메서드를 재정의(Override)해야한다! 재정의 안하면 오류
	//즉, 강제성을 가지고 있다!!!
	
	
	/*
	public void sum() {	// interface는 메서드의 {}를 선언할 수 없다!
	}
	 */	
}
