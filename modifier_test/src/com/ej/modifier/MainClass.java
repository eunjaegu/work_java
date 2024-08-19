package com.ej.modifier;

import com.ej.modifier.test.MethodClass;

public class MainClass {

	public static void main(String[] args) {
		TestClass test = new TestClass();
		MethodClass mc = new MethodClass();
		DataClass dc = new DataClass();
		System.out.println(dc.getName());
		
		
		
		
//		dc1.defaultVar = 20000;
//		DataClass.staticVar = 30000;
		//Data.staticVar = 30000; 객체생성없이 바로 사용 가능
//		변수에 static을 붙일경우 고유값이라고 생각한다.
//		한쪽이 바뀌면 다른 한쪽도 바뀌기 때문.
		
		DataClass.initData();
		System.out.println(DataClass.test[0]);
		
		System.out.println(DataClass.staticVar + ":" + DataClass.staticVar);
//		System.out.println(dc1.defaultVar + ":" + dc2.defaultVar);
	}

}
