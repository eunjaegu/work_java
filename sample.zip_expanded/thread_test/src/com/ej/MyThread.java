package com.ej;

public class MyThread extends Thread{

	public MyThread() {
	}
	
	public void run() {
		int i=0;
		while(i<100) {
			System.out.println(i);
			i++; //���ο��� i����, �ݺ����� ���� �ȳ����� ����
			
		}
	}
	
}
