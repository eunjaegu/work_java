package com.ej.employee;

public class EMPMainClass {

	public static void main(String[] args) {
		//EMPDataClass 생성
		EMPDataClass emp = new EMPDataClass();

		//성이 "이"씨인.. 사람들 인원수?
		//1. emp 객체 내의 name 배열
		//2. name 배열의 데이터 중 "이"로 시작하는 데이터 찾기
		// String 객체의 메서드를 이용하여 검색
		
		String containStr = "이";
		int count = 0;
		for(int k=0; k<emp.name.length; k++) {
			if(emp.name[k].startsWith(containStr)) {
				count++;
			}
		}
		System.out.println(containStr + "씨 성을 가진 인원 수 : " + count);

		//직업이 Java이고 근무지가 국내인 사원의 평균 급여 구하기
     int sumPay=0;
     int countH=0;
     String j="java";
     String c="US";
     for(int k=0; k<emp.code.length; k++);{
    	 if(emp.job[k].contains(j)&&emp.code[k].contains(contains(c))) {
    		 sumPay += emp.pay[k];
    		 countH++;
    	 }
     }
     
     double avg = (double)sumPay/countH;
     
      System.out.println(j+"직업이고"+c+"에 근무하는 사원의 평균 급여 : "avg);

          
		
	}
}
