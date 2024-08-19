package com.ej;

public class RunnableClass implements Runnable {
//인터페이스이기때문에 반드시 재정의가 필요함.
	public RunnableClass() {
	}

	@Override
	public void run() {
			int i=0;
			while(i<100) {
				System.out.println(i);
				i++; //내부에서 i증가, 반복으로 절대 안끝나기 때문
			}
		}
		
	}
