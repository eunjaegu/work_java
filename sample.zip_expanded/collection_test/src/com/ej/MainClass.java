package com.ej;

import com.ej.map.HashmapTestClass;
import com.ej.map.Student;
import com.ej.set.HashLotto;
import com.ej.set.HashSetTestClass;

public class MainClass {

	public static void main(String[] args) {
		HashSetTestClass.hashSetTest();
		HashLotto.lotto();
		HashmapTestClass.hashMapTest();
		Student s = new Student(10,"test");		//student클래스에 toString
		System.out.println(s);
		//HashmapTestClass.hashMapStudent();
				
	}
	
	
}
