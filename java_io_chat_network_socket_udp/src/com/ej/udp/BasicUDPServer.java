package com.ej.udp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


public class BasicUDPServer {
	DatagramSocket dsock;					//	패킷을 다루는 기능
	DatagramPacket sPack, rPack;			// 보내는 패킷, 받는 패킷
	InetAddress client;							//	클라이언트 ip
	int serverPort = 7777, clientPort;		// 서버 포크, 클라이언트 포트
	
	public BasicUDPServer() {
	}
	
	public BasicUDPServer(int port) {	// 서버포트번호 변경 가능
		this.serverPort = port;
		System.out.println(">> 서버 시작!");
		System.out.println(">> 클라이언트 접속을 기다리는 중!");
		
		try {
			this.dsock = new DatagramSocket(this.serverPort);	// 서버 소켓 생성
			
		} catch (SocketException e) {
			System.err.println(e.getMessage());
		}
		
	}	// BasicUDPServer() END
	
	public void comm() {
		// 	1. 키보드로부터 입력받은 내용을 Buffer에 저장
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
		while(true) {		//계속 송수신함으로 무한루트
			byte[] buffer = new byte[1024];	// 패킷의 크기
	
			// 클라이언트에서 전송된 패킷을 받기 위한 객체
			this.rPack = new DatagramPacket(buffer, buffer.length);		//패킷의 크기
	
			// 수신대기 
			this.dsock.receive(rPack); // 서버 소켓이 클라이언트로부터 전달.
			
			
			// 전달받은 패킷을 문자열로 변화
			String str = new String(rPack.getData(), 0, buffer.length);
			
			/**클라이언트의 주소, 포트반환**/
			this.client = this.rPack.getAddress();
			this.clientPort = this.rPack.getPort();
			
			// 전송받은 결과 출력
			System.out.println("[클라이언트]" + this.client + ":" + str);
			
			// 클라이언트로부터 종료 요청이 들어오면 while() 멈춤
			if(str.trim().equals("quit")) break;	// 결과가 true일 때 단일 실행문은 {} 생략 가능
			// String trim() : 문자열의 앞, 뒤 공백제거
			
			/**서버가 클라이언트에게 전송**/
			// 입력된 정보를 DatagramPacket 객체로 만들어서 클라이언트에 전송
			String out = br.readLine(); 	//위쪽에서 BufferdReader 객체가 있기 때문에 활용
			this.sPack = new DatagramPacket(out.getBytes(), out.getBytes().length, client, clientPort);
			// String.getBytes() : 문자열을 byte 배열로 반환
			// String.getBytes().length : byte 배열의 길이(크기)
			
			this.dsock.send(sPack); // DatagramSocket를 통해 클라이언트로 전송
		}	//while() end 클라이언트가 접속을 끊었다.
		
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}	// comm() END


	public static void main(String[] args) {
		//서버 쪽 실행
		BasicUDPServer server = new BasicUDPServer(7777);
		server.comm();
	}

} // end class BasicUDPServer
