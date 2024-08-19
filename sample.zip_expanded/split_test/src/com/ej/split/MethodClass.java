package com.ej.split;

import java.util.ArrayList;

//연산을 위한 전용 클래스
public class MethodClass {

	public MethodClass() {
		
	}
	
	//나이합 메서드
	public int sum(MemberClass[] mc) {
		int sum=0;
		for(int i=0; i<mc.length; i++) {
			sum=sum+mc[i].age;
			
		}
		return sum;		// 만나는 순간 값을 가지고 빠져 나감. 하위코드 출력 안됨.
	}
	
	//평균 메서드
	public double avg(int sum, int total) {
//		double a = (double)sum/total;
		return (double)sum/total;
	
	}
	
	
	//이름 검색 메서드(방문횟수를 반환)
	public ArrayList<Integer> searchName(String name, MemberClass[] mcArray) {
		ArrayList<Integer> visit=new ArrayList<Integer>();
		
		
		for(int i=0; i<mcArray.length; i++) {
			if(name.equals(mcArray[i].name)) {
				visit.add(mcArray[i].numVisit);
			}
		}
			return visit;
	}
	
	

}
