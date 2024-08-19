package com.naver.news;

//	하나의 신문사 정보를 담는 클래스

//	1-1. 변수 선언 : private
public class NaverNewsClass {
	private String img = "";
	private String url = "";
	
	public NaverNewsClass() {	//기본생성자
		} //기본 생성자 END
	
//	1-3. 외부로부터 전달받은 데이터를 멤버(인스턴스) 변수에 대입하는 생성자	
	public NaverNewsClass(String img, String url) {	//기본생성자
		this.img=img;
		this.url=url;
	} //Overloading 생성자
	
	// 1-4. private 변수데이터에 접근하기 위한 getter 들
	public String getImg() {
		return img;
	}
	
	public String getUrl() {
		return url;	
	}
	
	
} //NaverNewsClass END
