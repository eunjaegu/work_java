package com.ej.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

// InetAddress.class :  IP 주소, HOST가 누군지
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

		// InetAddress 객체를 통해 정보를 추출하는 메서드
	public void info(){
		System.out.println(this.ip.getHostAddress());	// IP 번호만 추출
		System.out.println(this.ip.getHostName());		// 도메인명만 추출
		System.out.println(this.ip.toString());				// IP, 도메인 추력
	}

	//main
	public static void main(String[] args) {
	
			try {
				// InetAddress.getLocalHost() 현재 내 PC
				// InetAddress : ip 번호 및 도메인 명 등을 포함하는 객체(클래스)
				MyInetAddress my = new MyInetAddress(InetAddress.getLocalHost());
				my.info();
				
				
				//InetAddress.getByName() : 도메인을 통해 ip 번호 등을 추출하여  InetAddress 객체로 반환
				my.setIp(InetAddress.getByName("www.youtube.com"));
				my.info();
			} catch (UnknownHostException e) {
				System.out.println(e.getMessage());
				
			}
			
	

	}

} // class end
