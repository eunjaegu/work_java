package com.ej.set;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class HashLotto {

	public HashLotto() {
	}
	
	public static void lotto() {
		HashSet<Integer> numbers = new HashSet<Integer>();
		
		// �ζ� ��ȣ : 6�� ���� (������ : random)
		// 1. Math.random()
		// 		=>0~1������ �Ǽ�
		// 		(int)Math.random() * 45 + 1
		//2. Random.class
		//	 Random r = new Random();
		//	 r.nextInt(45) <= 0~44 ������ ������ ������ ��ȯ
		
		//�ζǹ�ȣ 6��
		for(int n=0; n<6; n++) {
			int num = (int)(Math.random()*45+1);
			numbers.add(new Integer(num));
			
		}
		//List �����߿��� �ַ� ��.
		//HashSet�� LinkedList�� ��ȯ						//���� HashSet����
		List<Integer> list = new LinkedList<Integer>(numbers);
		System.out.println(list);
		
		Collections.sort(list);			//���� //numbers�� HashSet���� �����ؾ���.
		System.out.println(list);							// 	HashSet�� �������� ����
		
	}
}
