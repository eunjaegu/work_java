package com.ej;

//입금자 역할
public class MeClass extends Thread {

	public MeClass() {
		
	}

	public void run() {
		synchronized (MainClass.bank) {
			MainClass.bank.saveMoney(3000);
			
		}
		
		System.out.println("입금 후, 잔액 : "+  MainClass.bank.getMoney());
	}
}
