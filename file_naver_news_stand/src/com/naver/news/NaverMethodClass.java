package com.naver.news;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//메서드만 갖고 있는 클래스로 전부static 붙임

//작업을 위한 메서드들 : 클래스명.메서드()
public class NaverMethodClass {
//3-1. 전체 News 데이터 보유 객체 : static, private

	public NaverMethodClass() {
	}
	// 3-2. 기본 생성자
	// 3-3. 전체 News 데이터 보유 객체 생성 메서드

	// 3-4. FileReader와 BufferedReader를 이용하여 txt 파일을 읽어들이는 메서드
	public static void readData(String uri) {
		// 1. 파일 경로

		// 2. 파일 경로를 이용한 FileReader객체
		FileReader fr = null;

		// 3. BufferReader 객체
		BufferedReader br = null;

		try {
			fr = new FileReader(uri);
			br = new BufferedReader(fr);
			// ("경향신문", "nsd16500796.gif", "newsstand.naver.com/032", "종합지"));
			// String one = br.readLine();

			String one = "";
			while ((one = br.readLine()) != null) {
				String[] temp = one.split("\", \"");

				// 하나의 객체로 저장 ==> NaverNewsClass
				NaverNewsClass news = new NaverNewsClass(temp[1], temp[2]);
//			System.out.println(temp[1]); // 이미지이름 두개정보를 하나의 객체로 생성
//			System.out.println(temp[2]); // 링크주소

				// 전체 데이터 저장소에 추가
				NaverDataClass.news.add(news);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		// 4. while(){ } // 나중에 한줄 완성하면 작성

	}

	// 3-5. String을 이용하여 HTML 태그들을 생성하는 메서드
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
		// 아래 코드는 PrintClass 에서 사용 예정
		FileWriter fw = null;

		try {
			fw = new FileWriter(uri);
			fw.write(tags);
			fw.close();

			System.out.println("HTML 파일 생성 완료!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
