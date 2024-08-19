package com.ej;

public class ThreadTest {

	//주(메인) 스레드 : 이 스레드가 종료되면 보조 스레드들은 자동 종료!
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
		
		RunnableClass r1 = new RunnableClass();		//객체만들고 1부터 쭈욱 찍음. 반드시 start 해야함
		Thread t1 = new Thread(r1);		//변수 조작을 원할때, sleep메서드 추가작업
		t1.setName("aaaa");
		System.out.println(t1.getName());
		//join() : 해당 스레가 일을 마치고 난 후, 다음코드를 진행
				//			try{}catch{}가 필요 /강제적으로 막아서 예외코드 처리 필요
				//			start() 보다 선행되도록...
		try {
			t1.join();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}

		t1.start();
		
		Thread t2 = new Thread(new RunnableClass()); // sleep메서드 추가작업
		t2.setName("bbbb");
		System.out.println(t2.getName());
		
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		
		new Thread(new RunnableClass()).start();	// start 만하고 구동만할 경우 // v3바이러스검사 돌릴때 사용
	
		System.out.println("main() 종료");
		*/
	}

}
