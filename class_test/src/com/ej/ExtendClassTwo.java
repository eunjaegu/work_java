package com.ej;

import com.ej.ex.ChildClass;

public class ExtendClassTwo extends ChildClass{
	public int extendVar = 100; //ExtendClassTwo 자식이 만듬
	
	public ExtendClassTwo() {
		System.out.println("ExtendClassTwo() 생성자 호출됨");
	}

}
