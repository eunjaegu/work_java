package com.ej; // 	select 순서 나열한 것(암기하면 java 편해짐)

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.ej.db.DataBaseClass;

/**
 * Controller Dispacher class 요청내용에 따라 => controller 선택 (어떤 요청사항이 들어와도 가능) =>
 * controller (조회) => controller (삽입) => controller (수정) => controller (삭제)
 **/
public class MainClass {

	public static void main(String[] args) {
		DataBaseClass dbc = new DataBaseClass();
		dbc.connMYSQL(); // 드라이버 로드 및 접속 							// DataBaseClass -1 작성 후 MainClass 작성하여 값 확인
//		dbc.selectAll();          // 전체 레코드 조회 / 스캐너 1				// DataBaseClass -2 작성 후 MainClass 작성하여 값 확인
//		dbc.selectOne();          // 하나의 레코드 조회	/ 스캐너2 		// DataBaseClass -3 작성 후 MainClass 작성하여 값 확인
//		//scannner  읽어내는 next.int
//		dbc.selectLimit();          // 하나의 레코드 조회						// DataBaseClass -4 작성 후 MainClass 작성하여 값 확인
//		dbc.insert();   																// DataBaseClass -4 작성 후 MainClass 작성하여 값 확인
//		dbc.selectAll();  //JAVA 에서 확인										//
		// select*from employee; (mySQL에서 확인하려면 이 코드)		
//		dbc.update();  																//
//		dbc.delete();  																//

		/** switch ~ case **/														//key값이 아래 case 에 없을 경우 default
		System.out.println("아래 메뉴에서 작업할 메뉴번호 입력!");
		System.out.println("1. 전체조회 / 2. 레코드 삽입 / 3. 레코드 수정 / 4. 레코드 삭제 / 5. 종료");
		System.out.println("------------------------------------------------------------------------------");
		Scanner scanner = new Scanner(System.in);															
		 boolean status = true;								
		 while(status)	{
			 int key = scanner.nextInt();
		 switch (key) {
		 case 1:
			 System.out.println("전체조회 화면");
			 dbc.selectAll();
		 	break;
		 case 2: 
			 System.out.println("레코드 삽입");
			 dbc.selectOne(); 
		 	break;
		 case 3:  
			 System.out.println("레코드 수정");
			 dbc.update();
		 	break;
		 case 4:
			 System.out.println("레코드 삭제");
			 dbc.delete();
		 break;
		 case 5:
		 	status = false;
			 break;
		 	}	// switch (key) end
		} //while (status) end
		scanner.close();
		System.out.println("종료되었습니다.");
	} // main() end
}
