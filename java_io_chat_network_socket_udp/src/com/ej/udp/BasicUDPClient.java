package com.ej.udp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class BasicUDPClient {
	DatagramSocket dsock;
	DatagramPacket sPack, rPack;
	InetAddress server;
	int Port = 8888;
	
	
	public BasicUDPClient() {
	}
	
	public BasicUDPClient(String ip, int port) {
		try {
			// ip를 이용하여 InetAddress 객체 얻기
			this.server = InetAddress.getByName(ip);
			this.Port = port;
			this.dsock = new DatagramSocket();
			// 사용자에게 보여줄 메시지
			System.out.println(">>> 서버에 접속합니다.");
			System.out.println(">>> 서버에 전송할 메세지를 입력 후 , ENTER.");
			System.out.println(">>> 종료할 경우, quit를 입력 후, ENTER.");
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}	// 생성자 END
	
	// 통신 메서드 
	public void comm() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String out;
			
			while((out =br.readLine()) !=null) {
				//							입력문자를 byte[], 크기byte[]의 길이,	전송대상주소, 전송대상port번호	
				this.sPack = new DatagramPacket(out.getBytes(), out.getBytes().length, this.server, Port);
				this.dsock.send(sPack);	// 실제전송
				
				//서버 수신
				byte[] buffer = new byte[1024];
				this.rPack = new DatagramPacket(buffer, buffer.length);
				this.dsock.receive(this.rPack);	// 받는 패킷을 이용하여 서버 수신 대기
				
				String inStr = new String(this.rPack.getData(), 0, this.rPack.getData().length);
				System.out.println("서버로부터 전송된 메시지" + inStr);
				
			}	// while() END
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}	//comm() END
	
	

	public static void main(String[] args) {
		BasicUDPClient client = new BasicUDPClient("127.0.0.1", 7777); //777 담아서 서버클래스로 간다~~
		client.comm();

	}

}
