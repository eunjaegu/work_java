package com.ej;		

//����� ����
public class Account {
	
	private int total=0;	//��ü ��ݾ� ����
	
	public Account() {
	}

	public int getTotal() {	//��ݾ� Ȯ�θ� �����Ͽ� getter�� ����.
		return total;
	}
	
	public void deposit() {
		this.total=this.total+1000;
		//this.total += 1000�� ����
	}
	
}
