package com.ej.cafe;

public class CafeMainClass {

	public static void main(String[] args) {
		// 1. �ʱ� ������ �ε�
		DataClass.initData();
		

//		/** 2. CafeClass ��ü���� item �� �����Ͽ� ���� �޼��� **/
//		MethodClass.item();
//
//		/** 3. items ��ü���� item �� �����Ͽ� ���� �޼��� **/
//		MethodClass.duplicate();
//	
//		/** 4. no ���� item ���� count������ �ϳ��� ��ü�� �߰� �޼��� ȣ�� **/
//		// => item�� count�� �ѽ����� �ٷ�� ����..
//		MethodClass.item_count_list();
//		
//		/** 5. counting �ϴ� �޼��� ȣ��**/
//		MethodClass.counting();
		
		/** 6. count ���� ���� ū ��ü�� ã�Ƽ� ��ȯ**/
		MethodClass mc = new MethodClass();
		ItemCountClass maxItem = mc.maxItem();
		
		
//		// �����ڵ�
//		for (ItemCountClass item : MethodClass.item_count_list) {
//			System.out.println(item.item +";" + item.count);
//		}
		
		System.out.println("==================");
		System.out.println(maxItem.item + " ===> "+ maxItem.count);
		
		
		
	} // main (String[] args)END


	
} // CafeMainClass {} END
