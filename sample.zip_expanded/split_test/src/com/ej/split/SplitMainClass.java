package com.ej.split;

import java.util.ArrayList;

public class SplitMainClass {

	public static void main(String[] args) {
		DataClass dc =new DataClass();	// ���õ����� ó��
		
		MemberClass[] mcArray = new MemberClass[98];		//Record ó��
		for(int m=0; m<mcArray.length; m++) {
		//	MemberClass mc = new MemberClass(); 
			mcArray[m]=new MemberClass();
			mcArray[m].inputRecord(dc.member[m]);
			
		}
		
		
		//���� ���� ��ü ����
		MethodClass method = new MethodClass();
		int sum=method.sum(mcArray); 				// ������ �޼��� ȣ��
		double avg=method.avg(sum, mcArray.length);	// ���� ���� �̿��Ͽ� ��ձ��ϴ� �޼���
		System.out.println(avg);
		
		// �̸� �˻��ϱ�
		String name = "����";
		ArrayList<Integer> visit=method.searchName(name, mcArray);
		
		System.out.println(name+"�� ��"+ visit.size()+ "�� �̰�");
		System.out.print("�� �湮Ƚ���� ");
		for(int i=0; i<visit.size(); i++) {
			System.out.print(visit.get(i));
			
		}
		System.out.println("�Դϴ�. ");
		
//		System.out.println("�� �湮Ƚ����" + visit.get(0)+"," + visit.get(1) + "�Դϴ�.");
		
		
		
		
		
		
		
		
	} //END DataClass(){}

} //END DataClass{}
