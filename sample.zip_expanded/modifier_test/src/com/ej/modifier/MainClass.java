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
		//Data.staticVar = 30000; ��ü�������� �ٷ� ��� ����
//		������ static�� ���ϰ�� �������̶�� �����Ѵ�.
//		������ �ٲ�� �ٸ� ���ʵ� �ٲ�� ����.
		
		DataClass.initData();
		System.out.println(DataClass.test[0]);
		
		System.out.println(DataClass.staticVar + ":" + DataClass.staticVar);
//		System.out.println(dc1.defaultVar + ":" + dc2.defaultVar);
	}

}
