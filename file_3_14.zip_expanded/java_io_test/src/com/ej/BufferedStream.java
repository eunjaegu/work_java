package com.ej;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**Buffered~ �� ����ϴ� ���� **/
// 1. �ٴ����� ���� �޼��带 ����
// 2. ��뷮 �����͸� ���� ó���ϱ� ���ؼ�..
// BufferedReader : FileReader / BufferedWriter : FileWriter
// BufferedInputStream : FileInputStream/ BufferedOutputStream : FileOutputStream
// *~~~inputStream(�����̳� ������ǲ��Ʈ��) �� InputStream �� ����
// *~~~OutputStream((�����̳� ������ǲ��Ʈ��)) �� OutputStream �� ����
// Buffered~~ ���� �ܵ� ��� �Ұ��� �ݵ�� File~~~ ��ü�� �ʿ�

public class BufferedStream {

	public static void main(String[] args) {
		FileOutputStream fos;
		BufferedOutputStream bos;
		BufferedInputStream bis;
		
		String fname = "src/com/ej/test.buff";
		/* 
		 * ������� : ~.bak
		 * �����ͺ��̽� ���� : ~.db
		 * ������ ���� : ~.dat
		 * �ڹٽ�ũ��Ʈ ���� : ~~.js\
		 * CSS ���� : ~~.css
		 * JSP ���� : ~~.jsp
		 * HTML ���� : ~~.html / ~~.html / ~~~.mhtml
		 * �̹��� ���� : ~~~.gif / ~~~.png / ~~~.jpg / ~~~.jpeq
		 * ����� ���� : ~~.mp3 / ~~.mp4 / ~~~.wav
		 * ���� ���� : ~~~.avi / ~~~.mov / ~~~.mkv / ~~~/mp4
		 * ���� ���� : ~~~.buff  / ~~.bff
		*/
		
		try {
			fos = new FileOutputStream(fname); //���Ϸ� ��Ʈ����� �������� �׽�Ʈ ���ۿ�
			
			//buffer�� ������ �������� �׸��� ���Ͽ� ����
			bos = new BufferedOutputStream(fos); //�ƿ�ǲ���� bos�� �׽�Ʈ ���۷� ��������
			byte[] data = {'A', 'B', 'C', 'D', 'E'}; 	//����Ʈ �����Ͷ�� �����ۼ�
			// 					65	 66  67  68
			System.out.println(Arrays.toString(data)); //���
			
			bos.write(data, 0, 4);	//����	// write(�迭, ����index��ȣ, ����) //���ۿ� �������� �� b���� �����ϰ� ������ ���� �ε���1
			bos.close();
			fos.close();
			
			// buffer�� ����� ������ �б�
			bis = new BufferedInputStream(new FileInputStream(fname));		// �о �׽�Ʈ ���۷� �־��� 
			data = new byte[10];			//����													// ������ ����Ʈ �迭 ���� ����Ʈ�� �޾������
			bis.read(data, 0, 5);			//����													// ������ 4�� �о 4�� ��� ������ 0
			bis.close();
			
			System.out.println(Arrays.toString(data));	 //���
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
		
	}	// end class

}	// end main
