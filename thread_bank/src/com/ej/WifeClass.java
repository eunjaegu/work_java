package com.ej;

//출금 역할
public class WifeClass extends Thread {

	public WifeClass() {
	}

	public void run() {
		synchronized (MainClass.bank) {
			MainClass.bank.minusMoney(5000);
			
		}
		System.out.println("출금 후, 잔액 : "+  MainClass.bank.getMoney());
	}
}
