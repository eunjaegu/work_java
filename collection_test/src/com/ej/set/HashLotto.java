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
		
		// 로또 번호 : 6개 숫자 (임의의 : random)
		// 1. Math.random()
		// 		=>0~1사이의 실수
		// 		(int)Math.random() * 45 + 1
		//2. Random.class
		//	 Random r = new Random();
		//	 r.nextInt(45) <= 0~44 정수중 임의의 정수가 반환
		
		//로또번호 6번
		for(int n=0; n<6; n++) {
			int num = (int)(Math.random()*45+1);
			numbers.add(new Integer(num));
			
		}
		//List 웹개발에서 주로 씀.
		//HashSet을 LinkedList로 변환						//위에 HashSet에서
		List<Integer> list = new LinkedList<Integer>(numbers);
		System.out.println(list);
		
		Collections.sort(list);			//정렬 //numbers가 HashSet으로 정렬해야함.
		System.out.println(list);							// 	HashSet은 순서없기 때문
		
	}
}
