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
		
		System.out.println("�Ʒ� �޴����� �۾��� �޴���ȣ �Է�!");
		System.out.println("1. ���� �Ǹ� ��� �� ��� �Ǹž� / 2. �ִ� �Ǹ� ��ǰ�� �ش� ��ǰ�� �� �Ǹž� / 3. �ִ� �Ǹ� �ð��� �� �� �Ǹž� / 4. �ִ� �Ǹ� ī�װ� �� �� �Ǹ� / 5. ����");
		System.out.println("------------------------------------------------------------------------------");
		Scanner scanner = new Scanner(System.in);															
		 boolean status = true;								
		 while(status)	{
			 int key = scanner.nextInt();
		 switch (key) {
		 case 1:
			 System.out.println("���ڵ� ����");
			 dbc.delete();
		 break;
		 
		 case 2:
		 	status = false;
			 break;
		 	}	// switch (key) end
		} //while (status) end
		scanner.close();
		System.out.println("����Ǿ����ϴ�.");

	}
}
