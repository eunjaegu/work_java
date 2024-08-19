package com.ej;		

//모금함 역할
public class Account {
	
	private int total=0;	//전체 모금액 저장
	
	public Account() {
	}

	public int getTotal() {	//모금액 확인만 가능하여 getter만 만듬.
		return total;
	}
	
	public void deposit() {
		this.total=this.total+1000;
		//this.total += 1000과 동일
	}
	
}
