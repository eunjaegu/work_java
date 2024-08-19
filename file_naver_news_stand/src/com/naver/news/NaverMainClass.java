package com.naver.news;

public class NaverMainClass {

	public static void main(String[] args) {
		 final String uri = "c:/filetest/naver_news_stand_data_edit.txt";
		// final »ó¼ö
		String u = "C://filetest/test3.html";
		
		NaverMethodClass.readData(uri);
		NaverMethodClass.makeHTML(u);
		
		System.out.println(NaverDataClass.news.get(0).getImg());
		System.out.println(NaverDataClass.news.get(0).getUrl());
		
	}

}
