package com.ej;

public class RunnableClass implements Runnable {
//�������̽��̱⶧���� �ݵ�� �����ǰ� �ʿ���.
	public RunnableClass() {
	}

	@Override
	public void run() {
			int i=0;
			while(i<100) {
				System.out.println(i);
				i++; //���ο��� i����, �ݺ����� ���� �ȳ����� ����
			}
		}
		
	}
