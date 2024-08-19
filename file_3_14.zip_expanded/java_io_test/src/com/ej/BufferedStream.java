package com.ej;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**Buffered~ 를 사용하는 목적 **/
// 1. 줄단위로 읽은 메서드를 보유
// 2. 대용량 데이터를 빨리 처리하기 위해서..
// BufferedReader : FileReader / BufferedWriter : FileWriter
// BufferedInputStream : FileInputStream/ BufferedOutputStream : FileOutputStream
// *~~~inputStream(파일이나 버퍼인풋스트림) 은 InputStream 이 조상
// *~~~OutputStream((파일이나 버퍼인풋스트림)) 은 OutputStream 이 조상
// Buffered~~ 들은 단독 사용 불가능 반드시 File~~~ 객체가 필요

public class BufferedStream {

	public static void main(String[] args) {
		FileOutputStream fos;
		BufferedOutputStream bos;
		BufferedInputStream bis;
		
		String fname = "src/com/ej/test.buff";
		/* 
		 * 백업파일 : ~.bak
		 * 데이터베이스 파일 : ~.db
		 * 데이터 파일 : ~.dat
		 * 자바스크립트 파일 : ~~.js\
		 * CSS 파일 : ~~.css
		 * JSP 파일 : ~~.jsp
		 * HTML 파일 : ~~.html / ~~.html / ~~~.mhtml
		 * 이미지 파일 : ~~~.gif / ~~~.png / ~~~.jpg / ~~~.jpeq
		 * 오디오 파일 : ~~.mp3 / ~~.mp4 / ~~~.wav
		 * 비디오 파일 : ~~~.avi / ~~~.mov / ~~~.mkv / ~~~/mp4
		 * 버퍼 파일 : ~~~.buff  / ~~.bff
		*/
		
		try {
			fos = new FileOutputStream(fname); //파일로 스트림방식 내보내기 테스트 버퍼에
			
			//buffer로 데이터 내보내기 그리고 파일에 쓰기
			bos = new BufferedOutputStream(fos); //아웃풋으로 bos는 테스트 버퍼로 내보내짐
			byte[] data = {'A', 'B', 'C', 'D', 'E'}; 	//바이트 데이터라는 내용작성
			// 					65	 66  67  68
			System.out.println(Arrays.toString(data)); //출력
			
			bos.write(data, 0, 4);	//강조	// write(배열, 시작index번호, 갯수) //버퍼에 내보내는 것 b부터 저장하고 싶으면 시작 인덱스1
			bos.close();
			fos.close();
			
			// buffer에 저장된 데이터 읽기
			bis = new BufferedInputStream(new FileInputStream(fname));		// 읽어서 테스트 버퍼로 넣어줌 
			data = new byte[10];			//강조													// 위에서 바이트 배열 만들어서 바이트로 받아줘야함
			bis.read(data, 0, 5);			//강조													// 위에서 4개 읽어서 4개 출력 나머지 0
			bis.close();
			
			System.out.println(Arrays.toString(data));	 //출력
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
		
	}	// end class

}	// end main
