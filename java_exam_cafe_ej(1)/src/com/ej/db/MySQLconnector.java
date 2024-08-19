package com.ej.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLconnector {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/";
	private String id_mysql = "root";
	private String pw_mysql = "1234"; // ���� ��й�ȣ

	public Connection conn = null;
	
	public MySQLconnector() {	// �⺻ ������
	}
	
	/** 1. MySQL Connect Method **/
	public void connectMySQL() {
	
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url+"test", id_mysql, pw_mysql);
			System.out.println(" MySQL ���� ���� !!!");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Class.forName(driver) ERR : " + e.getMessage());
		}catch (SQLException e) {
			System.out.println("getConnection() ERR : " + e.getMessage());
		}

	} //  connectMySQL() END
	
	//���̺� ��ü��ȸ
	// select * from Cafe
	public void selectAll() {
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement(); //Statement ��ü ����
			rs = stmt.executeQuery("select * from employee"); // ��ü ��ȸ��, ����� ����
			
			while(rs.next()) {	// �о���� ���ڵ尡 �����ϸ� true
				System.out.print(rs.getString("empname")+"\t"); // ��ȸ�� �ʵ��� empname �ʵ� ���� Ȯ��
				System.out.println(rs.getInt("sale")); // ��ȸ�� �ʵ��� sale �ʵ� ���� Ȯ��
			}
			
		}catch (SQLException e) {
			System.out.println("SELECT ALL ERR:"+ e.getMessage());
		}finally {
			try {
				rs.close();
				stmt.close();
				
			}catch (Exception e) {
				System.out.println("SELECT ALL CLOSE ERR:"+ e.getMessage());
			} 
		}
}	// selcetAll END()
	
	
	//���ڵ� ����
	public void delete() {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from employee where empno = ?";
		int empno = 1015;
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, empno);
			result = pstmt.executeUpdate();
			if (result < 1) {
				System.out.println("UPDATE FAIL");
			}
			
			
		} catch (SQLException e) {
			System.out.println("DELETE ERR"+e.getMessage());
		}finally {
			try {
				pstmt. close();
			} catch (SQLException e) {
				System.out.println("DELETE CLOSE ERR"+e.getMessage());
			}
		}
		
	}
	
	
} // end class
