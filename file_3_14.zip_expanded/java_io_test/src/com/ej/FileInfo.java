package com.ej;

import java.io.File;
import java.util.Date;

/**������ ���� : File (������ ���� �� �а� ���� ���� ����ó��(try {} catch {} ����.)**/
public class FileInfo {

	public static void main(String[] args) {
		//src ���ο����� ��� ����, src �̸����� ����, ������Ʈ�� ���� ����.
		String fname = "C:/filetest";

		// 1. ������ ��� ���� File ��ü ����/ �ش絥���� (fname)
		File f = new File(fname);		
		//getName() : � �������� �˾Ƴ� �� ����.
		System.out.println(f.getName());		// ���ϸ� ReaderFiles.java
		System.out.println(f.getPath());			// ����� : �ڱ���ġ���  // src\com\ej\ReaderFiles.java
		System.out.println(f.getAbsolutePath());	// ������ : ����̺��:\~~ ����̺���ġ���� ���
		//C:\work_java\java_io_test\src\com\ej\ReaderFiles.java
		System.out.println("����" + f.canWrite()); 		// ������ �Ӽ��� ���� Ȱ��ȭ ���� : ��밡���ϸ� true / �б������̸� false
		System.out.println("�б�" + f.canRead()); 		// ������ �Ӽ��� �б� Ȱ��ȭ ���� : ������ ������ true
		System.out.println(f.getParent()); 		//�θ�
		System.out.println("����"+f.isFile());				// ������ ������ �����̸� true
		System.out.println("����"+f.isDirectory());		// ���� ������ �����̸� true (�������� �ƴ��� ���� Ȯ��)
		Date date = new Date(f.lastModified()); 
		System.out.println(date);	// ������ ������ ���� ��¥ �� �ð�(������ ��ȯ)
		System.out.println(f.length());			// ������ ũ��(byte)
		
		String[] fileList = f.list();	// ������ ���� ���� ���ϸ� ����Ʈ ��ȯ // fileList ���� ���� ���ԵǾ� ���� 
		for(String n : fileList) {
			
			System.out.println(n);
		}
		System.out.println(fileList.length);	//��Ʈ��Ŭ������ �������; �迭 /���� �ȿ� ���ϰ��� [Ljava.lang.String;@3ab39c39 / 12
		
		
	}

}
