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
			// ip�� �̿��Ͽ� InetAddress ��ü ���
			this.server = InetAddress.getByName(ip);
			this.Port = port;
			this.dsock = new DatagramSocket();
			// ����ڿ��� ������ �޽���
			System.out.println(">>> ������ �����մϴ�.");
			System.out.println(">>> ������ ������ �޼����� �Է� �� , ENTER.");
			System.out.println(">>> ������ ���, quit�� �Է� ��, ENTER.");
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}	// ������ END
	
	// ��� �޼��� 
	public void comm() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String out;
			
			while((out =br.readLine()) !=null) {
				//							�Է¹��ڸ� byte[], ũ��byte[]�� ����,	���۴���ּ�, ���۴��port��ȣ	
				this.sPack = new DatagramPacket(out.getBytes(), out.getBytes().length, this.server, Port);
				this.dsock.send(sPack);	// ��������
				
				//���� ����
				byte[] buffer = new byte[1024];
				this.rPack = new DatagramPacket(buffer, buffer.length);
				this.dsock.receive(this.rPack);	// �޴� ��Ŷ�� �̿��Ͽ� ���� ���� ���
				
				String inStr = new String(this.rPack.getData(), 0, this.rPack.getData().length);
				System.out.println("�����κ��� ���۵� �޽���" + inStr);
				
			}	// while() END
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}	//comm() END
	
	

	public static void main(String[] args) {
		BasicUDPClient client = new BasicUDPClient("127.0.0.1", 7777); //777 ��Ƽ� ����Ŭ������ ����~~
		client.comm();

	}

}
