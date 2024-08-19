package com.ej;


public class MainClass {

	public static BankClass bank  = new BankClass();

	
	public static void main(String[] args) {
		System.out.println("ÇöÀç ÀÜ¾× : "+bank.getMoney());

		MeClass me = new MeClass();
		WifeClass wife  = new WifeClass();
		me.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		wife.start();
	}

}
