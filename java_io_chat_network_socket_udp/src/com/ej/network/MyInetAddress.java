package com.ej.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

// InetAddress.class :  IP �ּ�, HOST�� ������
public class MyInetAddress {
	private InetAddress ip;
	
	public MyInetAddress() {
	}
	
	public MyInetAddress(InetAddress ip) {
		this.ip = ip;
	}
	
	public void setIp(InetAddress ip) {
		this.ip = ip;
	}

		// InetAddress ��ü�� ���� ������ �����ϴ� �޼���
	public void info(){
		System.out.println(this.ip.getHostAddress());	// IP ��ȣ�� ����
		System.out.println(this.ip.getHostName());		// �����θ� ����
		System.out.println(this.ip.toString());				// IP, ������ �߷�
	}

	//main
	public static void main(String[] args) {
	
			try {
				// InetAddress.getLocalHost() ���� �� PC
				// InetAddress : ip ��ȣ �� ������ �� ���� �����ϴ� ��ü(Ŭ����)
				MyInetAddress my = new MyInetAddress(InetAddress.getLocalHost());
				my.info();
				
				
				//InetAddress.getByName() : �������� ���� ip ��ȣ ���� �����Ͽ�  InetAddress ��ü�� ��ȯ
				my.setIp(InetAddress.getByName("www.youtube.com"));
				my.info();
			} catch (UnknownHostException e) {
				System.out.println(e.getMessage());
				
			}
			
	

	}

} // class end
