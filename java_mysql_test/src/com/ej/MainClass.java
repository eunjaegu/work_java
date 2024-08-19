package com.ej; // 	select ���� ������ ��(�ϱ��ϸ� java ������)

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.ej.db.DataBaseClass;

/**
 * Controller Dispacher class ��û���뿡 ���� => controller ���� (� ��û������ ���͵� ����) =>
 * controller (��ȸ) => controller (����) => controller (����) => controller (����)
 **/
public class MainClass {

	public static void main(String[] args) {
		DataBaseClass dbc = new DataBaseClass();
		dbc.connMYSQL(); // ����̹� �ε� �� ���� 							// DataBaseClass -1 �ۼ� �� MainClass �ۼ��Ͽ� �� Ȯ��
//		dbc.selectAll();          // ��ü ���ڵ� ��ȸ / ��ĳ�� 1				// DataBaseClass -2 �ۼ� �� MainClass �ۼ��Ͽ� �� Ȯ��
//		dbc.selectOne();          // �ϳ��� ���ڵ� ��ȸ	/ ��ĳ��2 		// DataBaseClass -3 �ۼ� �� MainClass �ۼ��Ͽ� �� Ȯ��
//		//scannner  �о�� next.int
//		dbc.selectLimit();          // �ϳ��� ���ڵ� ��ȸ						// DataBaseClass -4 �ۼ� �� MainClass �ۼ��Ͽ� �� Ȯ��
//		dbc.insert();   																// DataBaseClass -4 �ۼ� �� MainClass �ۼ��Ͽ� �� Ȯ��
//		dbc.selectAll();  //JAVA ���� Ȯ��										//
		// select*from employee; (mySQL���� Ȯ���Ϸ��� �� �ڵ�)		
//		dbc.update();  																//
//		dbc.delete();  																//

		/** switch ~ case **/														//key���� �Ʒ� case �� ���� ��� default
		System.out.println("�Ʒ� �޴����� �۾��� �޴���ȣ �Է�!");
		System.out.println("1. ��ü��ȸ / 2. ���ڵ� ���� / 3. ���ڵ� ���� / 4. ���ڵ� ���� / 5. ����");
		System.out.println("------------------------------------------------------------------------------");
		Scanner scanner = new Scanner(System.in);															
		 boolean status = true;								
		 while(status)	{
			 int key = scanner.nextInt();
		 switch (key) {
		 case 1:
			 System.out.println("��ü��ȸ ȭ��");
			 dbc.selectAll();
		 	break;
		 case 2: 
			 System.out.println("���ڵ� ����");
			 dbc.selectOne(); 
		 	break;
		 case 3:  
			 System.out.println("���ڵ� ����");
			 dbc.update();
		 	break;
		 case 4:
			 System.out.println("���ڵ� ����");
			 dbc.delete();
		 break;
		 case 5:
		 	status = false;
			 break;
		 	}	// switch (key) end
		} //while (status) end
		scanner.close();
		System.out.println("����Ǿ����ϴ�.");
	} // main() end
}
