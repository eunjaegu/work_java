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
	// MyInputStreamReader.java �� �ٴ����� �б�
	String line;	// �� ���� ����
	String fname = "src/com/ej/MyInputStreamReader.java";
	
	//���� �д°��� try catch ��
	try {
		// FileInputStream //���ڴ��� => fname
		FileInputStream fis = new FileInputStream(fname);
		// InputStreamReader // ���ڴ����� �ٴ����� ���̿� �ʿ���.
		InputStreamReader isr = new InputStreamReader(fis);
		//BufferedReader	// �ٴ��� =>	readLine()
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println("Encoding : " + isr.getEncoding()); // main ��±��� ��ģ �� ���� �������� �ۼ�
		//encoding(��ȣȭ) �˾Ƴ��� ���
		
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
