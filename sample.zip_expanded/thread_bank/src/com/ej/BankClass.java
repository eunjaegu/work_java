package com.ej;

//�ϳ��� ���� ���� : �Ա�, ��� �޼���
public class BankClass {
	private int money = 10000; // ���� �ܾ� ����

	public BankClass() {
	}
	
	public int getMoney() { // �ܾ���ȸ
		return money;
	}

	public void setMoney(int money) { // ����ݿ� ���� �ܾ� ����
		this.money = money;
	}

	//������ ������ϴ� save, minus�� synchronized
	public synchronized void saveMoney(int save) { // �Ա� �޼���
		int m = this.money; // ���� �ܾ�
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		this.setMoney(m + save);
	}

	public void minusMoney(int minus) { // ��� �޼���
		int m = this.money; // ���� �ܾ�
		try {
			Thread.sleep(2000); //���ó�� 2��
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		this.setMoney(m - minus);
	}

	/* �޼��� ����ȭ ��Ű�� ���
	 * 1. �޼��� ���� �ο� synchronized Ű���� �߰� 
	 * 2. �޼��� ���ο� synchronized(this) { ���೻�� }
	 */



} // end
