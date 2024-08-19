package com.ej.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*** �����ͺ��̽� ����, ���� ���� ����
 * 	  dao class : �����Ϳ� �����ϴ� ������Ʈ��!
 *    MVC / M : �� 
 */

// 4���� : Driver, URL, id, pwd
public class DataBaseClass {
	public final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";	//���� Referenced Libraries ������ġ Ȯ�� 
	public final String DB_URL = "jdbc:mysql://localhost:3306/";
	public final String DB_ADMIN_ID = "root";
	public final String DB_ADMIN_PW = "1234";

	//java.sql.~~ //�������� static
	public Connection conn = null;
	
		
	public DataBaseClass() {	// �⺻ ������
	}
	
//	/** 1. �����ͺ��̽� ���� �޼���**/
	public void connMYSQL( ) {
		
		try {
			Class.forName(DB_DRIVER);	// ����̹� �ε� 
			conn = DriverManager.getConnection(DB_URL+"test", DB_ADMIN_ID, DB_ADMIN_PW);
			System.out.println("����̹�, ���� ����!!!");
		}catch (ClassNotFoundException e) {
			System.out.println("ClassNotFound ERR :" + e.getMessage());
			
		}catch (SQLException e) {
			System.out.println("DriverManager.getConnection() ERR :" + e.getMessage());
		}
	}
		
		/** 2. �����ͺ��̽� ����  ���̺� ��ü ���ڵ� ��ȸ**/
		// select * from employee
		// Connection, Statement, ResultSet
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
		
		/** 3. �����ͺ��̽� ���� ���̺��� empNo(��� ������ȣ)�� ��ȸ **/
	
		//	select * from employee where empon=?"	
		//  	? => String n = "1234";			
		// "select* from employee where empon="+n	
		// "select* from employee where empon="+"1234"	
		// "select* from employee where empon='1234'"	
		// "select* from employee where empon=?"	
		// Connection, PreparedStatement, ReultSet
		// PreparedStatement�� ���� ��ü�� ��ȯ �޴´�
		// 		*****��, �̸� �������־� �־�� �Ѵ�!!!!!*****
		public void selectOne() {
			PreparedStatement pstmt= null;
			ResultSet rs = null;
			
			String query = "select* from employee where empno=?";
			
			try {
				pstmt=conn.prepareStatement(query);	//***�̸� �������ֱ�*** 
				pstmt.setInt(1, 1001); 						//ù���� ����ǥ 1�� �ε���
				
				rs = pstmt.executeQuery(); //()�� ���� ���� ������ �ȵ�.
				
				while(rs.next()) {
					System.out.println(rs.getString("empname")+" : "+rs.getInt("sale"));
				}
			} catch (SQLException e) {
				System.out.println("SELECT ONE ERR:" + e.getMessage());
			} finally {
				try {
					rs.close();
					pstmt.close();
				} catch (Exception e) {
					System.out.println("SELECT ON CLOSE ERR:" + e.getMessage());
				}
			}
		}

		//��ü ���ڵ� �� �Ϻκи� ��ȸ
		//select * from employee limit ���� index, count	=< MySQL ����
		//select * from employee limit ?,? //?�� statement
		public void selectLimit() {		//scannner (,)  ����
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String query = "select * from employee limit ?,?";
			int startIndex = 0;		//scannner �� ����
			int count = 5;
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, startIndex);
				pstmt.setInt(2, count);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					System.out.println(rs.getString("empname")+ ":" + rs.getInt("sale")+ ":" + rs.getString("hireDate"));
				}
			} catch (SQLException e) {
			System.out.println("SELECT LIMIT ERR"+ e.getMessage());
			}finally {
				try {
					rs.close();
					pstmt.close();
				} catch (SQLException e) {
					System.out.println("SELECT LIMIT CLOSE ERR"+ e.getMessage());
				}
			}
		
			
		}
		
		/**���ڵ� �߰�**/
		/* job, mgr, commission, deptNo  X 	<= not null ���� ����(�����Ⱓ������)
		 * insert into employee(empNo, empName, hireDate, sale) values (1015, '������', '2024-03-12', 500);   //����ó�� �ϸ� ����ǥ?�� 4��.
		 * insert into employee(empNo, empName, hireDate, sale) values (?, ?, ?, ?);
		 * Connection, PreparedStatement, int result 
		 * */
		public void insert() {
			PreparedStatement pstmt = null;
			int result = 0;							//insert into ���� ���� Ȯ��..
			String query = "insert into employee(empNo, empName, hireDate, sale) values (?, ?, ?, ?)"; 
			//? �� ġȯ�� ������...
			int empno = 1015;
			String empname = "������";
			String hiredate = "2024-03-12";
			int sale = 200;
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, empno);
				pstmt.setString(2, empname);
				pstmt.setString(3, hiredate);
				pstmt.setInt(4, sale);
				
				result = pstmt.executeUpdate();
				if(result < 1) {
					System.out.println("INSERT FAIL !!!");
				}
				
			} catch (SQLException e) {
				System.out.println("INSERT ERR : " +e.getMessage());
			}finally {
			try {
				pstmt.close();
			} catch (Exception e) {
				System.out.println("INSERT CLOSE ERR : " + e.getMessage());
			}	
		}
			
	}
		
		
		/**���ڵ� ����**/			//������� ������Ʈ(����)
		// update employee set job=?, mgr=?, commission=0, deptno=20 where empno=?
		// ���, 13, 1015
		// Connection, PreparedSatement, int result
		public void update() {
			PreparedStatement pstmt = null;
			String query = "update employee set job=?, mgr=?, commission=0, deptno=20 where empno=?";
			int result = 0;							//Update �������� Ȯ��
			String job = "���";
			String mgr = "13";
			int empno = 1015;
			
			try {
				pstmt = conn.prepareStatement(query);		// �갡 ������ close�� ������.
				pstmt.setString(1, job);
				pstmt.setString(2, mgr);
				pstmt.setInt(3, empno);
				
				result = pstmt.executeUpdate();
				if (result < 1) {
					System.out.println("UPDATE FAIL");
				}
			} catch (SQLException e) {
				System.out.println("UPDATE ERR"+e.getMessage());
			}finally {
				try {
					pstmt.close();
				} catch (SQLException e) {
					System.out.println("UPDATE CLOSE ERR"+e.getMessage());
				}
			}
			
			
		}			
		
		/**���ڵ� ����**/
		//delete from employee where empno = ?  //mySQL �� �ۼ��Ͽ� �� ����
		// 1015
		// Connection, PreparedStatement, int result 
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
		
		
}	//DataBaseClass END
