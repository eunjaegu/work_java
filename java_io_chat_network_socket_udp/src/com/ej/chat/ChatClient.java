package com.ej.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
	Socket socket;
	BufferedReader in;
	PrintWriter out;
	
	public ChatClient(String ip, int port) {
		try {
			socket = new Socket(ip, port);
			printInfo();
		} catch (IOException e) {
			e.printStackTrace();			
		}
	}

	public void communicate() {
		//Ŭ���̾�Ʈ ���Ͽ� �Է°� ����� ���� sender�� receiver�� ����
		MsgSender sender = new MsgSender("Ŭ���̾�Ʈ", socket);
		MsgReceiver receiver = new MsgReceiver("Ŭ���̾�Ʈ", socket);
		
		//sender�� receiver�� �����带 ����
		sender.start();
		receiver.start();
	}
	
	public void close() {
		try {
			// Ŭ���̾�Ʈ ���� ����
			socket.close();		
		} catch(IOException e) {
			System.out.println(e.toString());
		}
	}

	public void printInfo() {
		System.out.println(">> ���� ���ӿ� �����߽��ϴ�.");
		//���� ��Ʈ ��ȣ�� Ŭ���̾�Ʈ �ּҿ� ��Ʈ��ȣ ���
		System.out.println("     Ŭ���̾�Ʈ ��Ʈ��ȣ: " + socket.getLocalPort());
		System.out.println("     ���� �ּ�: " + socket.getInetAddress());
		System.out.println("     ���� ��Ʈ��ȣ: " + socket.getPort() + '\n');
		System.out.println(">> ������ ������ �޽����� ���� Enter�� ��������." + '\n');
	}
	
	public static void main(String[] args) {
		//���� �ּҿ� ��Ʈ��ȣ�� �����Ͽ� ������ ����
		ChatClient client = new ChatClient("127.0.0.1", 7070); 
		//������ ���
		client.communicate();
	}
}