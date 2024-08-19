package com.ej.set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTestClass {

	public HashSetTestClass() {
	}

	public static void hashSetTest() {
		HashSet<String>set = new HashSet<String>();
		set.add("test1");
		set.add("test1");	//���� �ߺ� �� ������� �ʱ� ������ �߰� ���� �ʴ´�!!
		set.add("test2");
		set.add("test3");
		set.add("test4");
		set.add("test5");
		
		System.out.println(set.size()); 	//4
		
		/**Set ��ü ������ ����**/
		/*
		 * �����Ϳ� ���� index�� ����.
		 * Mapó�� Key�� �������� �ʱ� ������.
		 * �ϴ�, �����ʹ� �Ϸķ� �����ؾ� �Ѵ�.
		 * =>Iterator�� Set.iterator(); �� �� �ִ�.
		 * 
		 * Iterator �ֿ� �޼���
		 * => next()				: ���� ���� ������ ��
		 * => hasNext()		: ������ ���� �ִ����� Ȯ���� ��
		 * */
		Iterator<String> iter = set.iterator();		//new ��� set ���� ��ü����
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
	}
}
