package com.naver.news;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//�޼��常 ���� �ִ� Ŭ������ ����static ����

//�۾��� ���� �޼���� : Ŭ������.�޼���()
public class NaverMethodClass {
//3-1. ��ü News ������ ���� ��ü : static, private

	public NaverMethodClass() {
	}
	// 3-2. �⺻ ������
	// 3-3. ��ü News ������ ���� ��ü ���� �޼���

	// 3-4. FileReader�� BufferedReader�� �̿��Ͽ� txt ������ �о���̴� �޼���
	public static void readData(String uri) {
		// 1. ���� ���

		// 2. ���� ��θ� �̿��� FileReader��ü
		FileReader fr = null;

		// 3. BufferReader ��ü
		BufferedReader br = null;

		try {
			fr = new FileReader(uri);
			br = new BufferedReader(fr);
			// ("����Ź�", "nsd16500796.gif", "newsstand.naver.com/032", "������"));
			// String one = br.readLine();

			String one = "";
			while ((one = br.readLine()) != null) {
				String[] temp = one.split("\", \"");

				// �ϳ��� ��ü�� ���� ==> NaverNewsClass
				NaverNewsClass news = new NaverNewsClass(temp[1], temp[2]);
//			System.out.println(temp[1]); // �̹����̸� �ΰ������� �ϳ��� ��ü�� ����
//			System.out.println(temp[2]); // ��ũ�ּ�

				// ��ü ������ ����ҿ� �߰�
				NaverDataClass.news.add(news);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		// 4. while(){ } // ���߿� ���� �ϼ��ϸ� �ۼ�

	}

	// 3-5. String�� �̿��Ͽ� HTML �±׵��� �����ϴ� �޼���
	public static void makeHTML(String uri) {

		String tags = "<!dictype html>";
		tags = tags + "<!dictype html>";
		tags = tags + "<html>";
		tags = tags + "<head>";
		tags = tags + "<meta charset=\"utf-8\">";
		tags = tags + "<title>Naver News Stand</title>";
		tags = tags + "</head>";
		tags = tags + "<body>";
		for (int i = 0; i < NaverDataClass.news.size(); i++) {
			tags = tags + "<a href=https://" + NaverDataClass.news.get(i).getUrl() + ">";
			tags = tags + "<img src=./newsImages/" + NaverDataClass.news.get(i).getImg() + " />";
		}
		tags = tags + "</a>";
		tags = tags + "</body>";
		tags = tags + "</html>";
		// �Ʒ� �ڵ�� PrintClass ���� ��� ����
		FileWriter fw = null;

		try {
			fw = new FileWriter(uri);
			fw.write(tags);
			fw.close();

			System.out.println("HTML ���� ���� �Ϸ�!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
