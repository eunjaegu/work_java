package com.ej;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/** stream 방식으로 파일 읽기 **/
//stream 방식 : byte 단위로 문자를 읽기(즉, 각 문자를 유니코드 값으로 일어내는 방식)
//int(정수) 형태로 읽은 후, char로 변환하여 출력
//유니코드는 추후 다국어 페이지 만들 때 사용
public class ReadFiles {

	public static void main(String[] args) {
		int data; // byte 단위 문자를 저장

		// 읽을 파일의 경로
		String fname = "src/com/ej/ReadFiles.java";
		// 파일을 열기 위해 try{}catch{}

		try {
			// File을 스트림으로 읽기: FileInputStream
			FileInputStream fis = new FileInputStream(fname);

			while ((data = fis.read()) != -1) { // read(); 더이상 읽을 문자가 없으면 -1 반환
				System.out.print((char) data);
			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());

		}


	}

}
