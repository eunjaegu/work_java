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
		
		//�������� : �ݵ�� �ʱⰪ�� ����. 
		int sum = 0;				// 0
//		sum = sum +arr[0];		// 10=0+10 // ���پ� �����.
//		sum = sum +arr[1];		// 30 = 10+20
//		sum = sum +arr[2];		//	60 = 30+30
//		sum = sum +arr[3];		//	100 = 60+40
		
		//sum ������ arr�迭�� ��� ���� ����
		for(int i=0; i<arr.length; i++) {
			sum= sum +arr[i];
			
		}
		
		for(int n : arr) {
			sum = sum+n;
		}
		
		System.out.println(sum);
		
		
		//arr�迭�� �� ��, 40�� index��ȣ ���
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==40) {
				System.out.println("index:"+i);
			}
		}
		
		
		

		
		
		if(10<20 || arr[1]==arr[2]) {						
			System.out.println("��");		
		}else {
			System.out.println("����");		
		}
	
		
/*		if(arr[0]>arr[1]) {						//pc�� ����
			  //if(10<20)                                //���� ���� �ۼ��ص� ����
					System.out.println("��");			//���
				}else {
					System.out.println("����");		// 10>20 ���������� ���
				}
				
*/
		
		
		int age = 40; 									//int �ʱⰪ ���� �迭�� �ۼ�
		if(age >=34) {
			System.out.println("�������� 100����");
		}
		
		
		int pay =300;
		int num =3;
		
		if(pay <=300	&& num>=2) {
			System.out.println("���ݰ���");
		}else {
			System.out.println("������¡");
		}
		
		
		
		String str;
		String str2 = "��";
		str = "������";
		
		System.out.println(arr.length)
		;

	}

}
