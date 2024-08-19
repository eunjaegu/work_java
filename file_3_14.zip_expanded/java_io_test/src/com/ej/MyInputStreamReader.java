package com.ej;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyInputStreamReader {

	public MyInputStreamReader() {
	} // end main

	public static void test() {
	// MyInputStreamReader.java 를 줄단위로 읽기
	String line;	// 한 줄을 저장
	String fname = "src/com/ej/MyInputStreamReader.java";
	
	//파일 읽는것은 try catch 문
	try {
		// FileInputStream //글자단위 => fname
		FileInputStream fis = new FileInputStream(fname);
		// InputStreamReader // 글자단위와 줄단위에 사이에 필요함.
		InputStreamReader isr = new InputStreamReader(fis);
		//BufferedReader	// 줄단위 =>	readLine()
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println("Encoding : " + isr.getEncoding()); // main 출력까지 마친 후 가장 마지막에 작성
		//encoding(부호화) 알아내는 방법
		
		while((line = br.readLine()) !=null) {
			System.out.println(line);
		}
		br.close();
		isr.close();
		fis.close();
	}catch(FileNotFoundException e) {
		System.out.println(e.getMessage());
	}catch(IOException e) {
		System.out.println(e.getMessage());
	}
	
	} //end test
	

	
} // end class
