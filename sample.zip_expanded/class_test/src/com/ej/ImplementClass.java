package com.ej;

public class ImplementClass implements InterfaceClassOne,  InterfaceClassTwo {

	public ImplementClass() {
//		a=100; 
		int test = a; //값을 꺼내쓰는건 됨. 값을 못바꾸는 대신
	}

	@Override 	//@ : 어노테이션
	public void test() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void test(int a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int test(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}

}
