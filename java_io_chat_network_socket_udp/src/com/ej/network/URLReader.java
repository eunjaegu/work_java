package com.ej.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


//�������� �б�
public class URLReader {

	// 1. ���ӵ����� ����
	URL url;
	
	// 2. ���� �����͸� ���پ� ���� ó��
	BufferedReader br;
	
	// 3. ���� ������ ����
	String line;
	
	
	public URLReader() {
		
	}
	
	public URLReader(String site) {
		try {
		this.url = new URL(site);
		}catch (MalformedURLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	//�޼���� ����
	// 1. ���� ������ ��� �޼���
	public void page( ) {
		
		try {
		InputStreamReader isr = new InputStreamReader(this.url.openStream());
		this.br = new BufferedReader(isr);		
		
		while((this.line = br.readLine()) !=null) {
			System.out.println(this.line);
		}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	// 2. ���� �����Ϳ� ���� �⺻���� : ���ڵ� / ����Ʈ �� 
	public void connectInfo( ) {
		try {
			URLConnection  conn = this.url.openConnection(); //
			System.out.println(conn.getContentEncoding()); 
			System.out.println(conn.getContentType());
			System.out.println(conn.getContentLength());
			System.out.println(conn.getContentLengthLong());
			System.out.println(conn);
			System.out.println(conn.getURL());
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		String site="https://www.naver.com/index.html";
		URLReader url = new URLReader(site);
	//	url.page();
		url.connectInfo();
	}

}	//end class URLReader
