package com.ej.split;

import java.util.ArrayList;

//������ ���� ���� Ŭ����
public class MethodClass {

	public MethodClass() {
		
	}
	
	//������ �޼���
	public int sum(MemberClass[] mc) {
		int sum=0;
		for(int i=0; i<mc.length; i++) {
			sum=sum+mc[i].age;
			
		}
		return sum;		// ������ ���� ���� ������ ���� ����. �����ڵ� ��� �ȵ�.
	}
	
	//��� �޼���
	public double avg(int sum, int total) {
//		double a = (double)sum/total;
		return (double)sum/total;
	
	}
	
	
	//�̸� �˻� �޼���(�湮Ƚ���� ��ȯ)
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
