package com.ej;	//������

//ARS ȸ�� ����
public class Customer extends Thread {

	private Account same;
	
	
	public Customer() {
	}
	
	public Customer(Account a, String s) {
		this.same = a;
		this.setName(s);	//Thread Ŭ������ ���� ��ӹ��� �޼���
		
	}

	public void run() {
		for(int i=1; i<200; i++) {
			System.out.println(this.getName()+":"+i+"���� ������");
			this.same.deposit();
			if(same.getTotal()>=200000) {
				break;
			}
			
		}
	}
}
