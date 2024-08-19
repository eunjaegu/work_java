package com.ej.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HashmapTestClass {

	public HashmapTestClass() {
	}

	public static void hashMapTest() {
		//Map 은 키와 값이 한쌍 => <key타입, 데이터타입>
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("a", 10);
		m.put("a", 20);
		m.put("c", 30);
		m.put("d", 40);
		
		// 전체 데이터 갯수 (a,b,c 3개)
		System.out.println(m.size());
		
		// 특정 데이터 추출 : key명으로 추출
		System.out.println(m.get("c"));
	
		//Map의 key명들만 추출 : Map.keySet()
		//=>Map.keySet() 가 반환하는 타입이 Set<String>
		Set<String> s = m.keySet();
		List<String> list = new LinkedList<String>(s);
		for(String key : list) {
			System.out.println(key+":"+m.get(key));
		}
		System.out.println();	
		System.out.println("Iterator로 변환하여 출력");
		Iterator<String> iter = s.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println(key+":"+m.get(key));
		}
	} //hashMpaTest() END
	


	public static void hashMapStudent() {
		Map<String, Student> m = new HashMap<String, Student>();
		
		m.put("a", new Student(10, "test1"));
		m.put("b", new Student(10, "test2"));
		m.put("c", new Student(10, "test3"));
		m.put("d", new Student(10, "test4"));
		
		System.out.println(m);
		
		Set<String> s = m.keySet();
		List<String> list = new LinkedList<String>(s);
		for(String key : list) {
			System.out.println(m.get(key));
		}
		
	}
}