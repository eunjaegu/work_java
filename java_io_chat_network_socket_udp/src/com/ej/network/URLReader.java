package com.ej.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


//웹페이지 읽기
public class URLReader {

	// 1. 접속도메인 저장
	URL url;
	
	// 2. 읽은 데이터를 한줄씩 빨리 처리
	BufferedReader br;
	
	// 3. 한줄 데이터 저장
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
	
	//메서드명 나열
	// 1. 읽은 데이터 출려 메서드
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
	
	// 2. 읽은 데이터에 대한 기본정보 : 인코딩 / 바이트 수 
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
