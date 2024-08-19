package com.ej.util;

import java.util.ArrayList;
import java.util.Scanner;

import com.ej.db.MySQLconnector;
import com.ej.dto.Cafe;

public class UtilClass {

	public UtilClass() {
	}
	
	public static void ee() {
		MySQLconnector mysql = new MySQLconnector();
		mysql.connectMySQL();
		
		Scanner scan = new Scanner(System.in);
		boolean status = true;
		ArrayList<Cafe> empList = null;
		
		System.out.println("아래 메뉴에서 작업할 메뉴번호 입력!");
		System.out.println("1. 일일 판매 목록 및 평균 판매액 / 2. 최다 판매 상품과 해당 상품의 총 판매액 / 3. 최대 판매 시간대 및 총 판매액 / 4. 최다 판매 카테고리 및 총 판매 / 5. 종료");
		System.out.println("------------------------------------------------------------------------------");
		Scanner scanner = new Scanner(System.in);															
		 boolean status = true;								
		 while(status)	{
			 int key = scanner.nextInt();
		 switch (key) {
		 case 1:
			 System.out.println("레코드 삭제");
			 dbc.delete();
		 break;
		 
		 case 2:
		 	status = false;
			 break;
		 	}	// switch (key) end
		} //while (status) end
		scanner.close();
		System.out.println("종료되었습니다.");

	}
}
