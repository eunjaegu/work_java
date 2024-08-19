package com.ej;

//하나의 계좌 역할 : 입금, 출금 메서드
public class BankClass {
	private int money = 10000; // 예금 잔액 저장

	public BankClass() {
	}
	
	public int getMoney() { // 잔액조회
		return money;
	}

	public void setMoney(int money) { // 입출금에 따른 잔액 변경
		this.money = money;
	}

	//실제로 입출금하는 save, minus에 synchronized
	public synchronized void saveMoney(int save) { // 입금 메서드
		int m = this.money; // 현재 잔액
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		this.setMoney(m + save);
	}

	public void minusMoney(int minus) { // 출금 메서드
		int m = this.money; // 현재 잔액
		try {
			Thread.sleep(2000); //출금처리 2초
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		this.setMoney(m - minus);
	}

	/* 메서드 동기화 시키는 방법
	 * 1. 메서드 선언 부에 synchronized 키워드 추가 
	 * 2. 메서드 내부에 synchronized(this) { 실행내용 }
	 */



} // end
