package com.ej;

public class FakeThread {

	public FakeThread() {
	}
	
	public void start() {						
		run();
	}
	
	public void run() {
		int i=0;
		while(i<100) {
			System.out.println(i);
			i++; //���ο��� i����, �ݺ����� ���� �ȳ����� ����
		}
	}
}

