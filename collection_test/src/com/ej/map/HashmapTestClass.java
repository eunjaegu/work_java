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
		//Map �� Ű�� ���� �ѽ� => <keyŸ��, ������Ÿ��>
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("a", 10);
		m.put("a", 20);
		m.put("c", 30);
		m.put("d", 40);
		
		// ��ü ������ ���� (a,b,c 3��)
		System.out.println(m.size());
		
		// Ư�� ������ ���� : key������ ����
		System.out.println(m.get("c"));
	
		//Map�� key��鸸 ���� : Map.keySet()
		//=>Map.keySet() �� ��ȯ�ϴ� Ÿ���� Set<String>
		Set<String> s = m.keySet();
		List<String> list = new LinkedList<String>(s);
		for(String key : list) {
			System.out.println(key+":"+m.get(key));
		}
		System.out.println();	
		System.out.println("Iterator�� ��ȯ�Ͽ� ���");
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