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
			i++; //내부에서 i증가, 반복으로 절대 안끝나기 때문
		}
	}
}

