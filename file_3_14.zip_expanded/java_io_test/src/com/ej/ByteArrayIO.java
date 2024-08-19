package com.ej;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/**ByteArrayInputStream**/
public class ByteArrayIO {

	public static void main(String[] args) {
		// byte �迭 �����͸� �о �ҹ��� �����͸� �빮�ڷ� ���
		int c;
		byte[] b = {'a', 'b', 'z', 'x', 't'};
		
		//byte �迭�� �д� ByteArrayInputStream ��ü ����
		// �� �� �����ڿ��� byte �迭�� ����
		ByteArrayInputStream bais = new ByteArrayInputStream(b);
		
		// �迭 �����͸� �빮�ڷ� ��ȭ�� �Ŀ� ������ ByteArrayOutputStream ��ü ����
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		// �ҹ��� �����͸� �о� �빮�ڷ� ����غ���
		while((c=bais.read()) !=-1) {
//			System.out.println((char)c); // ���� �ҹ��� Ȯ��
//			// �ҹ��ڸ� �빮�ڷ� ��ȯ ���
//			System.out.println(Character.toUpperCase((char)c));
		
			// �빮�ڷ� ����
			baos.write(Character.toUpperCase((char)c));
		}
		// Arrays.toString() �迭 �����͸� ���ڿ��� ��ȯ
		System.out.println(Arrays.toString(b));
		
		// baos.toByteAarray()
		// BufferedArrayOutputString ��ü �� �����͸� �迭�� ��ȭ
		System.out.println(baos.toByteArray());
		System.out.println(Arrays.toString(baos.toByteArray()));
		
		
	}	// end main

}	//end class
