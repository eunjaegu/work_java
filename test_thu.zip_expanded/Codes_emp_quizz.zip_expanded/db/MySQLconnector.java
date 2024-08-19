package com.freeflux.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.freeflux.dto.Employee;

public class MySQLconnector {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/db_emp?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private String id_mysql = "root";
	private String pw_mysql = "1234"; // ���� ��й�ȣ

	public Connection conn = null;

	public MySQLconnector() { // �⺻ ������
	}
	
	/** MySQL Connect Method **/
	public void connectMySQL() {
	
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id_mysql, pw_mysql);
			System.out.println(" MySQL ���� ���� !!!");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Class.forName(driver) ERR : " + e.getMessage());
		}catch (SQLException e) {
			System.out.println("getConnection() ERR : " + e.getMessage());
		}

	} //  connectMySQL() END

	
	/** ���̺� ������ ��ü ��ȸ **/
	public ArrayList<Employee> selectAll() {
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Employee> emps = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Querys.querySelectAll);

			emps = new ArrayList<Employee>();
			while (rs.next()) {
				int empNo = rs.getInt("empNo");
				String empName = rs.getString("empName");
				String job = rs.getString("job");
				String mgr = rs.getString("mgr");
				String hireDate = rs.getString("hireDate");
				int sale = rs.getInt("sale");
				int commission = rs.getInt("commission");
				int deptNo = rs.getInt("deptNo");
				
				emps.add(new Employee(empNo, empName, job, mgr, hireDate, sale, commission, deptNo));
			}

		} catch (SQLException e) {
			System.out.println("selectAll()  ERR : " + e.getMessage());
		} finally {
			this.close(stmt, rs);
		}
		
		return emps;
	} // selectAll() END

	/** ���̺� ������ �ϳ��� ��ȸ **/
	public void selectOne() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(Querys.querySelectOne);
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				
			}

		} catch (SQLException e) {
			System.out.println("selectOne()  ERR : " + e.getMessage());
		} finally {
			this.close(pstmt, rs);
		}
	} // selectOne() END

	/** ���̺� ������ ����(�߰�) **/
	public void insert() {
		PreparedStatement pstmt = null;
		int n = 0;

//		Scanner scan = new Scanner(System.in);
		
		Employee emp = new Employee(1001, "�ռ���", "����", "05", "2023-07-01", 300, 0, 20);
		try {
			pstmt = conn.prepareStatement(Querys.queryInsert);
			pstmt.setInt(1,  emp.getEmpNo());
			pstmt.setString(2,  emp.getEmpName());
			pstmt.setString(3,  emp.getJob());
			pstmt.setString(4,  emp.getMgr());
			pstmt.setString(5,  emp.getHireDate());
			pstmt.setInt(6,  emp.getSale());
			pstmt.setInt(7,  emp.getDeptNo());
			n = pstmt.executeUpdate();
			
			if(n > 0) {
				System.out.println(n + " ���� RECORD insert Success!!!");
			}
			
		} catch (SQLException e) {
			System.out.println("insert()  ERR : " + e.getMessage());
		} finally {
			this.close(pstmt);
		}
	} // insert() END


	
	/** ���̺� ������ ���� **/
	public ArrayList<Employee> update(ArrayList<Employee> empList) {
		PreparedStatement pstmt = null;
		int n = 0;

		try {
			// üũ ���!!!
			pstmt = conn.prepareStatement(Querys.queryUpdate);
			for(int idx = 0; idx<empList.size(); idx++) {
				pstmt.setInt(1, empList.get(idx).getSale());
				pstmt.setInt(2, idx+1);
				n = pstmt.executeUpdate();
			}
			
			if(n > 0) {
				System.out.println(n + " ���� RECORD update Success!!!");
			}
			
		} catch (SQLException e) {
			System.out.println("update()  ERR : " + e.getMessage());
		} finally {
			this.close(pstmt);
		}
		
		return empList;
	} // update() END

	/** ���̺� ������ ���� **/
	public void delete() {
		PreparedStatement pstmt = null;
		int n = 0;

		try {
			
			pstmt = conn.prepareStatement(Querys.queryDelete);
			pstmt.setString(1, "����");
			n = pstmt.executeUpdate();
			
			if(n > 0) {
				System.out.println(n + " ���� RECORD delete Success!!!");
			}

		} catch (SQLException e) {
			System.out.println("delete()  ERR : " + e.getMessage());
		} finally {
			this.close(pstmt);
		}
	} // delete() END

	
	/** �ڿ� ���� �޼���� : Overloading ��� **/
	public void close(Statement stmt, ResultSet rs) {
		try {
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Statement, ResultSet CLOSE  ERR : " + e.getMessage());
		}
	} // close() END

	public void close(PreparedStatement pstmt, ResultSet rs) {
		try {
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("PreparedStatement, ResultSet  CLOSE  ERR : " + e.getMessage());
		}
	} // close() END

	public void close(PreparedStatement pstmt) {
		try {
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("PreparedStatement  CLOSE  ERR : " + e.getMessage());
		}
	} // close() END

	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("Connection  CLOSE  ERR : " + e.getMessage());
		}
	} // close() END

}
