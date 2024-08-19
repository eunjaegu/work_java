package com.ej;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileMethodClass {

	public FileMethodClass() { // �⺻������
	}

	// �ش�Ŭ������ �ε��ɶ� static >>.(��)�� �� ���� �ٷ� ������ ��

//		String uri = "c:/filetest/�ϵ� �л� ó�� ���� �ý���.txt";  //���� ���������ۼ�
//		FileMethodClass.fileReader(uri);

	public static void fileReader(String uri) {
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(uri); // �����б� ���� ��ü ����
			br = new BufferedReader(fr); // ���پ� �ϱ� ���� ��ü ����

			String temp = null; // ������ ������ ����

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
