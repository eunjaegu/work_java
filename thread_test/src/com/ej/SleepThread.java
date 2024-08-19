package com.ej;

public class SleepThread extends Thread{

	public SleepThread() {
	}

	public void run() {
		System.out.println("sleep Start!");
		try {
			Thread.sleep(1000);		//1/1000√ 
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("sleep END!");
	}
	
	
}
