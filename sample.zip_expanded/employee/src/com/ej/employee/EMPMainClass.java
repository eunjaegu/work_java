package com.ej.employee;

public class EMPMainClass {

	public static void main(String[] args) {
		//EMPDataClass ����
		EMPDataClass emp = new EMPDataClass();

		//���� "��"����.. ����� �ο���?
		//1. emp ��ü ���� name �迭
		//2. name �迭�� ������ �� "��"�� �����ϴ� ������ ã��
		// String ��ü�� �޼��带 �̿��Ͽ� �˻�
		
		String containStr = "��";
		int count = 0;
		for(int k=0; k<emp.name.length; k++) {
			if(emp.name[k].startsWith(containStr)) {
				count++;
			}
		}
		System.out.println(containStr + "�� ���� ���� �ο� �� : " + count);

		//������ Java�̰� �ٹ����� ������ ����� ��� �޿� ���ϱ�
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
     
      System.out.println(j+"�����̰�"+c+"�� �ٹ��ϴ� ����� ��� �޿� : "avg);

          
		
	}
}
