package com.ej.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MySeverSocket {
	int port = 7070;// port no
	ServerSocket server;	 // ���� ����
	Socket socket;		
	BufferedReader in;
	PrintWriter out;
	
	public MySeverSocket(){
	}
	
	
	public MySeverSocket(int port){
		this.port = port;
		System.out.println(">>>>> ���� ����~");
		
		try {
			this.server = new ServerSocket(7070);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}	// ������ END
		
		// 1. Ŭ���̾�Ʈ ���� ���
		public void waitClient() {
			System.out.println(">>Ŭ���̾�Ʈ�� �����ϱ� ��ٸ�");
			
			try {
				this.socket= this.server.accept();	// Ŭ���̾�Ʈ ��û ����!!!
				printInfo();
				
				// Ŭ���̾�Ʈ ���Ͽ� ��Ʈ�� ����
				this.in=new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			    this.out=new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream()));
						
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		
		// 2. ���� �޼���
		public void receive() {
			try {
				// Ŭ���̾�Ʈ �������κ��� ���� �޽�
				System.out.println("[Ŭ���̾�Ʈ �޽���]" + in.readLine());
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}	
			
				}	
		
		// 3. �۽� �޼���
		public void send(String msg) {
			try {
				// Ŭ���̾�Ʈ ���Ͽ� �޽��� ����
				this.out.println(msg);
				this.out.flush();
				System.out.println("[���� �޽���]" + msg);
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}		
				}	
		
		
		// 4. ���� �޼���
		public void close() {
				try {
					this.socket.close();
					
				
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}	
				}	
		
		// 5. ��� �޼���
		public void printInfo() {
			System.out.println(">> Ŭ���̾�Ʈ ���� ����~~");
			System.out.println("���� ��Ʈ ��ȣ" + this.socket.getLocalPort());
			System.out.println("Ŭ���̾�Ʈ �ּ�" + this.socket.getInetAddress());
			System.out.println("Ŭ���̾�Ʈ ��Ʈ" + this.socket.getPort());
		}	
		
	
	public static void main(String[] args) {
		int port = 7070;
		MySeverSocket myServer = new MySeverSocket(port);
		myServer.waitClient();
		myServer.receive();
		myServer.send("������ ���� ȯ��~~");
		myServer.close();

	}

}
