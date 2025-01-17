package com.ej.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyClientSocket {
	Socket socket;
	BufferedReader in;	// 한줄씩 읽기
	PrintWriter out;
	
	public MyClientSocket (){
	}
	
	public MyClientSocket (String ip, int port){	// 사용자랑 클라이언트랑 주고받기 때문에 2항목
		try {
			this.socket = new Socket(ip, port);
			// 서버 소켓에 스트림 연결
			this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			this.out = new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream()));
			
			//출력 메서드 호출
			PrinterInfo();
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}	// 생성자 END
	
	//메시지 받는 메서드 
	public void receive() {
		try {
			//	서버 소켓으로부터 받은 메시지 출력
			System.out.println("[서버 : ]" + this.in.readLine());
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	//메시지 전송 메서드 
	public void send(String msg) {
		//서버 소켓에 메시지 전송
		this.out.println(msg);
		this.out.flush(); //flush?
		System.out.println("[클라이언트 : ]" + msg);
	}
	
	//소켓 종료 메서드 
	public void close() {
		try {
			this.socket.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	
	// 출력 메서드 : MyServerSocket() 생성자내에서 호출
	private void PrinterInfo() { 
		System.out.println(">>> 서버 접속 성공!!");
		System.out.println(">>> 서버 주소 : " + this.socket.getInetAddress());
		System.out.println(">>> 서버 포트번호 : " + this.socket.getPort());
		System.out.println(">>> 클라이언트 포트번호 : " + this.socket.getLocalPort());
	}

	public static void main(String[] args) {
		// 서버 주소와 포트번호를 설정, 서버에 접속
		MyClientSocket client = new MyClientSocket("127.0.0.1", 7070);
		
		System.out.println(">>> 서버에 보내 메시지 입력 후, ENTER");
	    Scanner scanner = new Scanner(System.in);
		String msg = scanner.nextLine();
		client.send(msg);	// 송신
		client.receive();	// 수신
		client.close();		// 종료
		
		
		
		System.out.println();
		
	}

}
