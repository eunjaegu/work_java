package com.ej;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/** File 클래스를 이용한 파일 생성 **/
public class CreateFile {

	public static void main(String[] args) {
		// 1. 파일생성 경로 및 파일명.확장자
		String fname = "c:/filetest/newFile2.txt";
		
		// 2. File 객체 생성
		File f = new File(fname);
		
		// 3. 생성할 파일의 존재 여부 확인 //if(!f.exists()붙이면 실행
//		if(f.exists()) {	//지정한 파일 존재 여부 확인
//			// 생성할 파일이 없으면 실행
//			System.out.println("해당 파일이 존재~"+fname);
//		}
		// 4. 새로운 파일 생성 : newFile.txt	
		//	  없던 파일 새로 생성하기 때문에 예외처리 필요
			try {
			
				if(!f.exists()) {	//지정한 파일 존재 여부 확인
					// 생성할 파일이 없으면 실행하여 새로운 파일 생성
					f.createNewFile(); 
					System.out.println("해당 파일이 존재~ "+fname);
				}
				
				FileWriter fw = new FileWriter(f);
				fw.write("ssss");
				fw.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
	} // end main

} // end class 
