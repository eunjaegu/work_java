package com.ej.cafe;

public class CafeMainClass {

	public static void main(String[] args) {
		// 1. 초기 데이터 로드
		DataClass.initData();
		

//		/** 2. CafeClass 객체에서 item 만 추출하여 저장 메서드 **/
//		MethodClass.item();
//
//		/** 3. items 객체에서 item 만 추출하여 저장 메서드 **/
//		MethodClass.duplicate();
//	
//		/** 4. no 내의 item 값과 count변수를 하나의 객체로 추가 메서드 호출 **/
//		// => item과 count를 한쌍으로 다루기 위해..
//		MethodClass.item_count_list();
//		
//		/** 5. counting 하는 메서드 호출**/
//		MethodClass.counting();
		
		/** 6. count 값이 가장 큰 객체를 찾아서 변환**/
		MethodClass mc = new MethodClass();
		ItemCountClass maxItem = mc.maxItem();
		
		
//		// 검증코드
//		for (ItemCountClass item : MethodClass.item_count_list) {
//			System.out.println(item.item +";" + item.count);
//		}
		
		System.out.println("==================");
		System.out.println(maxItem.item + " ===> "+ maxItem.count);
		
		
		
	} // main (String[] args)END


	
} // CafeMainClass {} END
