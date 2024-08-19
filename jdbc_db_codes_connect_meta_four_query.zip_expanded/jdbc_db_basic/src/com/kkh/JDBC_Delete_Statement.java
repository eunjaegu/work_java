package com.kkh;

import java.io.BufferedReader; // ���� �ܼ� â���� ����� �Է��� �޾Ƶ��̱� ���� BufferedReader 
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Delete_Statement {

	public static void main(String[] args) {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/bbsdb";
		Connection con = null;
		Statement stmt = null;

		String sql;
		String name;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "root", "1234");
			stmt = con.createStatement();

			// ---JDBC_Delete ����� ����-------
			// ���̺��� �߰��� ������ ���� �ܼ� â���� ������� �Է��� �޵��� �Ѵ�.
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));

			System.out.println(" customer ���̺����� ���ڵ� �����ϱ� .....");
			System.out.print("� ���� ������ �������� �׺��� �̸��� �Է��ϼ���: ");
			name = br.readLine(); // ���̺����� ������ name �ʵ� ���� �Է� ����

			// DELETE �������� �ۼ�
			sql = "DELETE FROM customer WHERE name ='";
			sql += name + "'";

			// Statement ��ü�� executeUpdate(sql) �޼��带 �̿���
			stmt.executeUpdate(sql); // �����ͺ��̽� ���Ͽ��� ���ڵ� ������Ŵ

		} catch (ClassNotFoundException e) {
			System.out.println("����̹� ERR! : " + e.getMessage());

		} catch (SQLException e) {
			System.out.println("SQL ERR! : " + e.getMessage());

		} catch (IOException e) {
			System.out.println("IO ERR! : " + e.getMessage());

		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("�ڿ����� ERR! : " + e.getMessage());
			}
		}
	}
}