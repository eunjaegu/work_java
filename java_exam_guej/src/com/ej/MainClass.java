package com.ej;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		MethodClass mc = new MethodClass();
		mc.fileReader();
		// System.out.println(DataBaseClass.al.get(0).getPrice());

		DataBaseClass dbc = new DataBaseClass();
		dbc.connMYSQL();
		// dbc.selectAll();
		// dbc.insert();
		// dbc.selectAll();
		// dbc.update();
		// dbc.delete();

		System.out.println("�� 30�� ���ڵ尡 �����Ǿ����ϴ�.");
		System.out.println("���α׷��� ����Ǿ����ϴ�.");
		Scanner scanner = new Scanner(System.in);
		boolean status = true;
		while (status) {
			int key = scanner.nextInt();
			switch (key) {
			case 1:
				System.out.println("���ڵ� ����");
				dbc.delete();
				break;
			} // switch (key) end
		} // while (status) end
		scanner.close();
	} // main() end
} // class() end
