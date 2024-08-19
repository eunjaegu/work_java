package com.ej;

import java.io.File;
import java.util.Date;

/**파일의 정보 : File (정보만 얻을 뿐 읽고 쓰기 안함 예외처리(try {} catch {} 안함.)**/
public class FileInfo {

	public static void main(String[] args) {
		//src 내부에서만 사용 가능, src 이름으로 시작, 프로젝트명 수정 못함.
		String fname = "C:/filetest";

		// 1. 정보를 얻기 위한 File 객체 생성/ 해당데이터 (fname)
		File f = new File(fname);		
		//getName() : 어떤 파일인지 알아낼 수 있음.
		System.out.println(f.getName());		// 파일명 ReaderFiles.java
		System.out.println(f.getPath());			// 상대경로 : 자기위치경로  // src\com\ej\ReaderFiles.java
		System.out.println(f.getAbsolutePath());	// 절대경로 : 드라이브명:\~~ 드라이브위치부터 경로
		//C:\work_java\java_io_test\src\com\ej\ReaderFiles.java
		System.out.println("쓰기" + f.canWrite()); 		// 파일의 속성이 쓰기 활성화 여부 : 사용가능하면 true / 읽기전용이면 false
		System.out.println("읽기" + f.canRead()); 		// 파일의 속성이 읽기 활성화 여부 : 읽을수 있으면 true
		System.out.println(f.getParent()); 		//부모
		System.out.println("파일"+f.isFile());				// 지정한 내용이 파일이면 true
		System.out.println("폴더"+f.isDirectory());		// 정한 내용이 폴더이면 true (폴더인지 아닌지 여부 확인)
		Date date = new Date(f.lastModified()); 
		System.out.println(date);	// 파일의 마지막 수정 날짜 및 시간(정수로 반환)
		System.out.println(f.length());			// 파일의 크기(byte)
		
		String[] fileList = f.list();	// 지정한 폴더 내의 파일명 리스트 반환 // fileList 파일 폴더 포함되어 있음 
		for(String n : fileList) {
			
			System.out.println(n);
		}
		System.out.println(fileList.length);	//스트링클래스로 만들어진; 배열 /폴더 안에 파일개수 [Ljava.lang.String;@3ab39c39 / 12
		
		
	}

}
