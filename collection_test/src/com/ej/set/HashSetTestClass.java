package com.ej.set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTestClass {

	public HashSetTestClass() {
	}

	public static void hashSetTest() {
		HashSet<String>set = new HashSet<String>();
		set.add("test1");
		set.add("test1");	//오류 중복 값 허용하지 않기 때문에 추가 되지 않는다!!
		set.add("test2");
		set.add("test3");
		set.add("test4");
		set.add("test5");
		
		System.out.println(set.size()); 	//4
		
		/**Set 전체 데이터 추출**/
		/*
		 * 데이터에 대한 index가 없다.
		 * Map처럼 Key도 존재하지 않기 때문에.
		 * 일단, 데이터는 일렬로 나열해야 한다.
		 * =>Iterator는 Set.iterator(); 얻어낼 수 있다.
		 * 
		 * Iterator 주요 메서드
		 * => next()				: 실제 값을 추출할 때
		 * => hasNext()		: 추출할 값이 있는지를 확인할 때
		 * */
		Iterator<String> iter = set.iterator();		//new 대신 set 으로 객체생성
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
	}
}
