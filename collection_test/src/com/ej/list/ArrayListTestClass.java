package com.ej.list;

import java.util.ArrayList;

public class ArrayListTestClass {

	public ArrayListTestClass() {
	}

	public static void arrayListTest() {
			ArrayList<String> list = new ArrayList<String>();
			list.add("apple");		//0
			list.add("orange");		//1
			list.add("orange");		//2
			list.add("peach");		//3
		
			//Ư�� ��ġ�� ������ �߰�
			list.add(1,"kiwi");
			// 0:apple 1:kiwi, 2:orange, 3:orange, 4:peach
			
			//Ư�� ��ġ�� ������ ����
			list.set(3, "apple");
			// 0:apple 1:kiwi, 2:orange, 3:apple, 4:peach
			
			// Ư�� ��ġ�� ���� �����ϰ� ��ȯ
			String f = list.remove(3);
			// f: apple
			// 0:apple 1:kiwi, 2:orange, 3:apple, 4:peach
			
			//Ư�� �����͸� �̿��Ͽ� �ش� inedx ����
			int idx = list.indexOf("apple");
			// idx:0
			
			list.add("apple");
			// 0:apple 1:kiwi, 2:orange, 3:apple, 4:peach
			
			idx=list.lastIndexOf("apple");
			// idx:
			
			
			// ��ü ������ ��ȸ 1			�ε��� ��ȣ �ʿ������ 
			for(String fu : list) {
				System.out.println(fu);
			}
			
			// ��ü ������ ��ȸ2			�ε��� ��ȣ �ʿ��Ҷ�
			for(int index=0; index<list.size(); index++) {
				System.out.println(list.get(index));
			}
			
			// �Ųٷ�
			int n=list.size()-1;
			for(int index=n; index>-1; index--) {
				System.out.println(list.get(index));
			}	
	}
	
}	//end
