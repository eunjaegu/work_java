package com.ej;

import java.util.Scanner;

public class FileMainClass {

	public static void main(String[] args) {
		String uri = "c:/filetest/�ϵ� �л� ó�� ���� �ý���.txt";  
		uri="C:\\work_java\\file_test\\src\\com\\ej\\FileMainClass.java";
//		FileMethodClass.fileReader(uri);
//
//		uri="c:/filetet.test.txt";
		
		Scanner sc = new Scanner(System.in);
		uri = sc.next();
//		System.out.println(str);
		sc.close();
		String path = "c:/filetest/";
		String ext = ".txt";
		FileMethodClass.fileWrite(path+uri+ext);

	}	//main() END

}
