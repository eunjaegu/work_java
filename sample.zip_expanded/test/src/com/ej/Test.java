package com.ej;

public class Test {

	public static void main(String[] args) {
		int[] arr = new int[4];
		int arr2[] = new int[4];
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
//		arr[4] = 50;
		
		//누적변수 : 반드시 초기값을 설정. 
		int sum = 0;				// 0
//		sum = sum +arr[0];		// 10=0+10 // 한줄씩 저장됨.
//		sum = sum +arr[1];		// 30 = 10+20
//		sum = sum +arr[2];		//	60 = 30+30
//		sum = sum +arr[3];		//	100 = 60+40
		
		//sum 변수에 arr배열의 모든 값을 누적
		for(int i=0; i<arr.length; i++) {
			sum= sum +arr[i];
			
		}
		
		for(int n : arr) {
			sum = sum+n;
		}
		
		System.out.println(sum);
		
		
		//arr배열의 값 중, 40인 index번호 출력
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==40) {
				System.out.println("index:"+i);
			}
		}
		
		
		

		
		
		if(10<20 || arr[1]==arr[2]) {						
			System.out.println("참");		
		}else {
			System.out.println("거짓");		
		}
	
		
/*		if(arr[0]>arr[1]) {						//pc에 묻기
			  //if(10<20)                                //값을 직접 작성해도 무관
					System.out.println("참");			//출력
				}else {
					System.out.println("거짓");		// 10>20 거짓임으로 출력
				}
				
*/
		
		
		int age = 40; 									//int 초기값 위에 배열로 작성
		if(age >=34) {
			System.out.println("월지원금 100만원");
		}
		
		
		int pay =300;
		int num =3;
		
		if(pay <=300	&& num>=2) {
			System.out.println("세금공제");
		}else {
			System.out.println("세금추징");
		}
		
		
		
		String str;
		String str2 = "강";
		str = "구은재";
		
		System.out.println(arr.length)
		;

	}

}
