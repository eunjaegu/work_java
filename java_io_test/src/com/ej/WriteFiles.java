package com.ej;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/** stream ������� ���� ���� **/
public class WriteFiles {

	public static void main(String[] args) {
		/** WriteFiles.java ������ �о ��� ���� �����**/

		int data; // byte ���� ���ڸ� ����
		FileInputStream fis;
		FileOutputStream fos;
		
		String inFname = "src/com/ej/WriteFiles.java";		// ���� ����
		String outFname = "src/com/ej/WriteFiles.bak";		// �����������
		
		try {
			fis = new FileInputStream(inFname);
			fos = new FileOutputStream(outFname);
			
			//WriteFiles.java�� �� ���ھ� �о WriteFiles.bak�� ����
			while((data = fis.read()) != -1) {
				fos.write(data);
			}
			fos.close();
			fis.close();
			System.out.println("��� ������ �����Ǿ����ϴ�...");
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());

		}
		
	}	// end main

}	// end class
