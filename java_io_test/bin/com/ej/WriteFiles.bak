package com.ej;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/** stream 방식으로 파일 쓰기 **/
public class WriteFiles {

	public static void main(String[] args) {
		/** WriteFiles.java 파일을 읽어서 백업 파일 만들기**/

		int data; // byte 단위 문자를 저장
		FileInputStream fis;
		FileOutputStream fos;
		
		String inFname = "src/com/ej/WriteFiles.java";		// 읽을 파일
		String outFname = "src/com/ej/WriteFiles.bak";		// 백업생성파일
		
		try {
			fis = new FileInputStream(inFname);
			fos = new FileOutputStream(outFname);
			
			//WriteFiles.java을 한 문자씩 읽어서 WriteFiles.bak에 쓰기
			while((data = fis.read()) != -1) {
				fos.write(data);
			}
			fos.close();
			fis.close();
			System.out.println("백업 파일이 생성되었습니다...");
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());

		}
		
	}	// end main

}	// end class
