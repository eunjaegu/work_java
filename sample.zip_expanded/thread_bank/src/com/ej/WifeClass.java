package com.ej;

//��� ����
public class WifeClass extends Thread {

	public WifeClass() {
	}

	public void run() {
		synchronized (MainClass.bank) {
			MainClass.bank.minusMoney(5000);
			
		}
		System.out.println("��� ��, �ܾ� : "+  MainClass.bank.getMoney());
	}
}
