package com.ej;

//�Ա��� ����
public class MeClass extends Thread {

	public MeClass() {
		
	}

	public void run() {
		synchronized (MainClass.bank) {
			MainClass.bank.saveMoney(3000);
			
		}
		
		System.out.println("�Ա� ��, �ܾ� : "+  MainClass.bank.getMoney());
	}
}
