package com.ej.split;

import java.util.ArrayList;

public class SplitMainClass {

	public static void main(String[] args) {
		DataClass dc =new DataClass();	// 원시데이터 처리
		
		MemberClass[] mcArray = new MemberClass[98];		//Record 처리
		for(int m=0; m<mcArray.length; m++) {
		//	MemberClass mc = new MemberClass(); 
			mcArray[m]=new MemberClass();
			mcArray[m].inputRecord(dc.member[m]);
			
		}
		
		
		//연산 전용 객체 생성
		MethodClass method = new MethodClass();
		int sum=method.sum(mcArray); 				// 나이합 메서드 호출
		double avg=method.avg(sum, mcArray.length);	// 나이 합을 이용하여 평균구하는 메서드
		System.out.println(avg);
		
		// 이름 검색하기
		String name = "근학";
		ArrayList<Integer> visit=method.searchName(name, mcArray);
		
		System.out.println(name+"은 총"+ visit.size()+ "명 이고");
		System.out.print("각 방문횟수는 ");
		for(int i=0; i<visit.size(); i++) {
			System.out.print(visit.get(i));
			
		}
		System.out.println("입니다. ");
		
//		System.out.println("각 방문횟수는" + visit.get(0)+"," + visit.get(1) + "입니다.");
		
		
		
		
		
		
		
		
	} //END DataClass(){}

} //END DataClass{}
