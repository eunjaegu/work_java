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

		System.out.println("총 30개 레코드가 삭제되었습니다.");
		System.out.println("프로그램이 종료되었습니다.");
		Scanner scanner = new Scanner(System.in);
		boolean status = true;
		while (status) {
			int key = scanner.nextInt();
			switch (key) {
			case 1:
				System.out.println("레코드 삭제");
				dbc.delete();
				break;
			} // switch (key) end
		} // while (status) end
		scanner.close();
	} // main() end
} // class() end
