package com.ej.udp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


public class BasicUDPServer {
	DatagramSocket dsock;					//	��Ŷ�� �ٷ�� ���
	DatagramPacket sPack, rPack;			// ������ ��Ŷ, �޴� ��Ŷ
	InetAddress client;							//	Ŭ���̾�Ʈ ip
	int serverPort = 7777, clientPort;		// ���� ��ũ, Ŭ���̾�Ʈ ��Ʈ
	
	public BasicUDPServer() {
	}
	
	public BasicUDPServer(int port) {	// ������Ʈ��ȣ ���� ����
		this.serverPort = port;
		System.out.println(">> ���� ����!");
		System.out.println(">> Ŭ���̾�Ʈ ������ ��ٸ��� ��!");
		
		try {
			this.dsock = new DatagramSocket(this.serverPort);	// ���� ���� ����
			
		} catch (SocketException e) {
			System.err.println(e.getMessage());
		}
		
	}	// BasicUDPServer() END
	
	public void comm() {
		// 	1. Ű����κ��� �Է¹��� ������ Buffer�� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
		while(true) {		//��� �ۼ��������� ���ѷ�Ʈ
			byte[] buffer = new byte[1024];	// ��Ŷ�� ũ��
	
			// Ŭ���̾�Ʈ���� ���۵� ��Ŷ�� �ޱ� ���� ��ü
			this.rPack = new DatagramPacket(buffer, buffer.length);		//��Ŷ�� ũ��
	
			// ���Ŵ�� 
			this.dsock.receive(rPack); // ���� ������ Ŭ���̾�Ʈ�κ��� ����.
			
			
			// ���޹��� ��Ŷ�� ���ڿ��� ��ȭ
			String str = new String(rPack.getData(), 0, buffer.length);
			
			/**Ŭ���̾�Ʈ�� �ּ�, ��Ʈ��ȯ**/
			this.client = this.rPack.getAddress();
			this.clientPort = this.rPack.getPort();
			
			// ���۹��� ��� ���
			System.out.println("[Ŭ���̾�Ʈ]" + this.client + ":" + str);
			
			// Ŭ���̾�Ʈ�κ��� ���� ��û�� ������ while() ����
			if(str.trim().equals("quit")) break;	// ����� true�� �� ���� ���๮�� {} ���� ����
			// String trim() : ���ڿ��� ��, �� ��������
			
			/**������ Ŭ���̾�Ʈ���� ����**/
			// �Էµ� ������ DatagramPacket ��ü�� ���� Ŭ���̾�Ʈ�� ����
			String out = br.readLine(); 	//���ʿ��� BufferdReader ��ü�� �ֱ� ������ Ȱ��
			this.sPack = new DatagramPacket(out.getBytes(), out.getBytes().length, client, clientPort);
			// String.getBytes() : ���ڿ��� byte �迭�� ��ȯ
			// String.getBytes().length : byte �迭�� ����(ũ��)
			
			this.dsock.send(sPack); // DatagramSocket�� ���� Ŭ���̾�Ʈ�� ����
		}	//while() end Ŭ���̾�Ʈ�� ������ ������.
		
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}	// comm() END


	public static void main(String[] args) {
		//���� �� ����
		BasicUDPServer server = new BasicUDPServer(7777);
		server.comm();
	}

} // end class BasicUDPServer
