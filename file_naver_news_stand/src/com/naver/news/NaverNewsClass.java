package com.naver.news;

//	�ϳ��� �Ź��� ������ ��� Ŭ����

//	1-1. ���� ���� : private
public class NaverNewsClass {
	private String img = "";
	private String url = "";
	
	public NaverNewsClass() {	//�⺻������
		} //�⺻ ������ END
	
//	1-3. �ܺηκ��� ���޹��� �����͸� ���(�ν��Ͻ�) ������ �����ϴ� ������	
	public NaverNewsClass(String img, String url) {	//�⺻������
		this.img=img;
		this.url=url;
	} //Overloading ������
	
	// 1-4. private ���������Ϳ� �����ϱ� ���� getter ��
	public String getImg() {
		return img;
	}
	
	public String getUrl() {
		return url;	
	}
	
	
} //NaverNewsClass END
