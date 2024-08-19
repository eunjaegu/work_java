package com.ej;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/** stream ������� ���� �б� **/
//stream ��� : byte ������ ���ڸ� �б�(��, �� ���ڸ� �����ڵ� ������ �Ͼ�� ���)
//int(����) ���·� ���� ��, char�� ��ȯ�Ͽ� ���
//�����ڵ�� ���� �ٱ��� ������ ���� �� ���
public class ReadFiles {

	public static void main(String[] args) {
		int data; // byte ���� ���ڸ� ����

		// ���� ������ ���
		String fname = "src/com/ej/ReadFiles.java";
		// ������ ���� ���� try{}catch{}

		try {
			// File�� ��Ʈ������ �б�: FileInputStream
			FileInputStream fis = new FileInputStream(fname);

			while ((data = fis.read()) != -1) { // read(); ���̻� ���� ���ڰ� ������ -1 ��ȯ
				System.out.print((char) data);
			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());

		}


	}

}
