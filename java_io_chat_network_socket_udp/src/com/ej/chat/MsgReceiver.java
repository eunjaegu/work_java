
package com.ej.chat;

import java.io.BufferedReader;
//import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MsgReceiver extends Thread {
	String nickname;
	Socket socket;
	BufferedReader in;

	
	public MsgReceiver(String nickname, Socket socket) {
		this.nickname = "[" + nickname + "] ";
		this.socket = socket;
		try {
			//���Ͽ� �Է� ��Ʈ���� ����
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			System.out.println(e.toString());			
		}
	}
	
	public void run() {
		while (in != null) {
			try {
				//�������κ��� ���� �޽����� ȭ�鿡 ���
				System.out.println(in.readLine());		
			} catch (IOException e) {
				System.out.println(e.toString());			
			}
		}
		try {
			// Ŭ���̾�Ʈ ���� ����
			socket.close();		
		} catch(IOException e) {
			e.printStackTrace();			
		}
	}
}
