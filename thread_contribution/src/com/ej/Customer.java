package com.ej;	//스레드

//ARS 회선 역할
public class Customer extends Thread {

	private Account same;
	
	
	public Customer() {
	}
	
	public Customer(Account a, String s) {
		this.same = a;
		this.setName(s);	//Thread 클래스로 부터 상속받은 메서드
		
	}

	public void run() {
		for(int i=1; i<200; i++) {
			System.out.println(this.getName()+":"+i+"번쨰 성금자");
			this.same.deposit();
			if(same.getTotal()>=200000) {
				break;
			}
			
		}
	}
}
