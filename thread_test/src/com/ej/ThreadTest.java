package com.ej;

public class ThreadTest {

	//��(����) ������ : �� �����尡 ����Ǹ� ���� ��������� �ڵ� ����!
	public static void main(String[] args) {
//		SleepThread sleep = new SleepThread();
//		sleep.start();
		
		System.out.println("main start");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		
		}
		System.out.println("main end");

		/*
		System.out.println(Thread.currentThread().getName());
		
		RunnableClass r1 = new RunnableClass();		//��ü����� 1���� �޿� ����. �ݵ�� start �ؾ���
		Thread t1 = new Thread(r1);		//���� ������ ���Ҷ�, sleep�޼��� �߰��۾�
		t1.setName("aaaa");
		System.out.println(t1.getName());
		//join() : �ش� ������ ���� ��ġ�� �� ��, �����ڵ带 ����
				//			try{}catch{}�� �ʿ� /���������� ���Ƽ� �����ڵ� ó�� �ʿ�
				//			start() ���� ����ǵ���...
		try {
			t1.join();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}

		t1.start();
		
		Thread t2 = new Thread(new RunnableClass()); // sleep�޼��� �߰��۾�
		t2.setName("bbbb");
		System.out.println(t2.getName());
		
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		
		new Thread(new RunnableClass()).start();	// start ���ϰ� �������� ��� // v3���̷����˻� ������ ���
	
		System.out.println("main() ����");
		*/
	}

}
