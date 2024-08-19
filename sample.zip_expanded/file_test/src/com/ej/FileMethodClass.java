package com.ej;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileMethodClass {

	public FileMethodClass() { // 기본생성자
	}

	// 해당클래스가 로딩될때 static >>.(점)에 뜬 공지 바로 가져다 씀

//		String uri = "c:/filetest/하둡 분산 처리 파일 시스템.txt";  //읽을 파일제목작성
//		FileMethodClass.fileReader(uri);

	public static void fileReader(String uri) {
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(uri); // 파일읽기 위한 객체 생성
			br = new BufferedReader(fr); // 한줄씩 일기 위한 객체 생성

			String temp = null; // 한줄을 저장할 변수

			while ((temp = br.readLine()) != null) {
				System.out.println(temp);
			}

			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("fileRead()FileNotFound ERR ================>: " + e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	} // fileRead() END

	public static void fileWrite(String uri) {
			FileWriter fw = null;
			
			try {
				fw = new FileWriter(uri);
				
				fw.write("ddddd");
				fw.close();
			} catch (IOException e) {
				
				System.out.println(e.getMessage());
			}
		
		}
}
