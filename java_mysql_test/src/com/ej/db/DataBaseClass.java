package com.ej.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*** 데이터베이스 접속, 각종 쿼리 실행
 * 	  dao class : 데이터에 접근하는 오브젝트다!
 *    MVC / M : 모델 
 */

// 4가지 : Driver, URL, id, pwd
public class DataBaseClass {
	public final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";	//좌측 Referenced Libraries 하위위치 확인 
	public final String DB_URL = "jdbc:mysql://localhost:3306/";
	public final String DB_ADMIN_ID = "root";
	public final String DB_ADMIN_PW = "1234";

	//java.sql.~~ //공유변수 static
	public Connection conn = null;
	
		
	public DataBaseClass() {	// 기본 생성자
	}
	
//	/** 1. 데이터베이스 접속 메서드**/
	public void connMYSQL( ) {
		
		try {
			Class.forName(DB_DRIVER);	// 드라이버 로드 
			conn = DriverManager.getConnection(DB_URL+"test", DB_ADMIN_ID, DB_ADMIN_PW);
			System.out.println("드라이버, 접속 성공!!!");
		}catch (ClassNotFoundException e) {
			System.out.println("ClassNotFound ERR :" + e.getMessage());
			
		}catch (SQLException e) {
			System.out.println("DriverManager.getConnection() ERR :" + e.getMessage());
		}
	}
		
		/** 2. 데이터베이스 내의  테이블 전체 레코드 조회**/
		// select * from employee
		// Connection, Statement, ResultSet
		public void selectAll() {
			Statement stmt = null;
			ResultSet rs = null;
			
			try {
				stmt = conn.createStatement(); //Statement 객체 생성
				rs = stmt.executeQuery("select * from employee"); // 전체 조회후, 결과값 저장
				
				while(rs.next()) {	// 읽어들일 레코드가 존재하면 true
					System.out.print(rs.getString("empname")+"\t"); // 조회된 필드중 empname 필드 값만 확인
					System.out.println(rs.getInt("sale")); // 조회된 필드중 sale 필드 값만 확인
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
		
		/** 3. 데이터베이스 내의 테이블에서 empNo(사원 고유번호)로 조회 **/
	
		//	select * from employee where empon=?"	
		//  	? => String n = "1234";			
		// "select* from employee where empon="+n	
		// "select* from employee where empon="+"1234"	
		// "select* from employee where empon='1234'"	
		// "select* from employee where empon=?"	
		// Connection, PreparedStatement, ReultSet
		// PreparedStatement를 통해 객체를 반환 받는다
		// 		*****단, 미리 쿼리를넣어 주어야 한다!!!!!*****
		public void selectOne() {
			PreparedStatement pstmt= null;
			ResultSet rs = null;
			
			String query = "select* from employee where empno=?";
			
			try {
				pstmt=conn.prepareStatement(query);	//***미리 쿼리를넣기*** 
				pstmt.setInt(1, 1001); 						//첫번쨰 물음표 1번 인덱스
				
				rs = pstmt.executeQuery(); //()에 쿼리 집어 넣으면 안됨.
				
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

		//전체 레코드 중 일부분만 조회
		//select * from employee limit 시작 index, count	=< MySQL 전용
		//select * from employee limit ?,? //?는 statement
		public void selectLimit() {		//scannner (,)  삭제
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String query = "select * from employee limit ?,?";
			int startIndex = 0;		//scannner 시 삭제
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
		
		/**레코드 추가**/
		/* job, mgr, commission, deptNo  X 	<= not null 없는 상태(수습기간임으로)
		 * insert into employee(empNo, empName, hireDate, sale) values (1015, '구은재', '2024-03-12', 500);   //변수처리 하면 물음표?가 4개.
		 * insert into employee(empNo, empName, hireDate, sale) values (?, ?, ?, ?);
		 * Connection, PreparedStatement, int result 
		 * */
		public void insert() {
			PreparedStatement pstmt = null;
			int result = 0;							//insert into 성공 여부 확인..
			String query = "insert into employee(empNo, empName, hireDate, sale) values (?, ?, ?, ?)"; 
			//? 와 치환될 변수들...
			int empno = 1015;
			String empname = "구은재";
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
		
		
		/**레코드 수정**/			//사번으로 업데이트(수정)
		// update employee set job=?, mgr=?, commission=0, deptno=20 where empno=?
		// 사원, 13, 1015
		// Connection, PreparedSatement, int result
		public void update() {
			PreparedStatement pstmt = null;
			String query = "update employee set job=?, mgr=?, commission=0, deptno=20 where empno=?";
			int result = 0;							//Update 성공여부 확인
			String job = "사원";
			String mgr = "13";
			int empno = 1015;
			
			try {
				pstmt = conn.prepareStatement(query);		// 얘가 없으면 close를 못만듬.
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
		
		/**레코드 삭제**/
		//delete from employee where empno = ?  //mySQL 에 작성하여 값 삭제
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
