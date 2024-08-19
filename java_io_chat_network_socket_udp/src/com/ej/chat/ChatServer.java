package com.ej.chat;

import java.io.*;
import java.net.*;

public class ChatServer {
	final int port;
	ServerSocket server;
	Socket socket;
	
	public ChatServer (int port) {
		this.port = port;
		System.out.println(">> ������ �����մϴ�.");
		try {
			server = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();			
		}
	}
	
	public void communicate() {
		System.out.println(">> Ŭ���̾�Ʈ�� �����ϱ� ��ٸ��� �ֽ��ϴ�.");
		try {
			// Ŭ���̾�Ʈ ���Ӷ����� ���
			socket = server.accept(); //======
			printInfo();
			
			//���� ���Ͽ� �Է°� ����� ���� sender�� receiver�� ����
			MsgSender sender = new MsgSender("����", socket);
			MsgReceiver receiver = new MsgReceiver("����", socket);
			
			//sender�� receiver�� �����带 ����
			receiver.start();
			sender.start();
		} catch (IOException e) {
			e.printStackTrace();			
		}
	}
	
	public void close() {
		try {
			// Ŭ���̾�Ʈ ���� ����
			socket.close();		
		} catch(IOException e) {
			e.printStackTrace();			
		}
	}

	public void printInfo() {
		System.out.println(">> Ŭ���̾�Ʈ�� ���ӿ� �����߽��ϴ�.");
		
		//���� ��Ʈ ��ȣ�� Ŭ���̾�Ʈ �ּҿ� ��Ʈ��ȣ ���
		System.out.println("     ���� ��Ʈ��ȣ: " + socket.getLocalPort());
		System.out.println("     Ŭ���̾�Ʈ �ּ�: " + socket.getInetAddress());
		System.out.println("     Ŭ���̾�Ʈ ��Ʈ��ȣ: " + socket.getPort() + '\n');
		System.out.println(">> Ŭ���̾�Ʈ�� ������ �޽����� ���� Enter�� ��������.\n");
	}
	
	public static void main(String[] args) {
		int port = 7070;			
		ChatServer myServer = new ChatServer(port);
		myServer.communicate();
	}
}

