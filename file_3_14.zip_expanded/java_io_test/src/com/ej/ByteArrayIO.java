package com.ej;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/**ByteArrayInputStream**/
public class ByteArrayIO {

	public static void main(String[] args) {
		// byte 배열 데이터를 읽어서 소문자 데이터를 대문자로 출력
		int c;
		byte[] b = {'a', 'b', 'z', 'x', 't'};
		
		//byte 배열을 읽는 ByteArrayInputStream 객체 생성
		// 이 때 생성자에게 byte 배열을 전달
		ByteArrayInputStream bais = new ByteArrayInputStream(b);
		
		// 배열 데이터를 대문자로 변화한 후에 저장할 ByteArrayOutputStream 객체 생성
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		// 소문자 데이터를 읽어 대문자로 출력해보기
		while((c=bais.read()) !=-1) {
//			System.out.println((char)c); // 원본 소문자 확인
//			// 소문자를 대문자로 변환 출력
//			System.out.println(Character.toUpperCase((char)c));
		
			// 대문자로 저장
			baos.write(Character.toUpperCase((char)c));
		}
		// Arrays.toString() 배열 데이터를 문자열로 변환
		System.out.println(Arrays.toString(b));
		
		// baos.toByteAarray()
		// BufferedArrayOutputString 객체 내 데이터를 배열로 변화
		System.out.println(baos.toByteArray());
		System.out.println(Arrays.toString(baos.toByteArray()));
		
		
	}	// end main

}	//end class
