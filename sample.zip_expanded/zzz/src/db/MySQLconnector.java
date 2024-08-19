package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.cafe;

public class MySQLconnector {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/db_emp?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private String id_mysql = "root";
	private String pw_mysql = "1234"; // 본인 비밀번호

	public Connection conn = null;
	
	public MySQLconnector() {
	}

	/** MySQL Connect Method **/
	public void connectMySQL() {
	
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url + "test", id_mysql, pw_mysql);
			System.out.println(" MySQL 접속 성공 !!!");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Class.forName(driver) ERR : " + e.getMessage());
		}catch (SQLException e) {
			System.out.println("getConnection() ERR : " + e.getMessage());
		}

	} //  connectMySQL() END
	
	public void selectAll() {
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<cafe> emps = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from cafe");

			emps = new ArrayList<cafe>();
			while (rs.next()) {
				String order_id = rs.getString("order_id");
				String order_date = rs.getString("order_date");
				String category = rs.getString("category");
				String item = rs.getString("item");
				int price = rs.getInt("price");
				
				emps.add(new cafe(order_id, order_date, category, item, price));
			}

		} catch (SQLException e) {
			System.out.println("SELECT ALL ERR : " + e.getMessage());
		} finally {
			try {
				rs.close();
				stmt.close();
			} catch (Exception e) {
				System.out.println("SELECT ALL CLOSE ERR:"+ e.getMessage());
			}
			
		
		}
		
		
	} // selectAll() END
	
	
	
	
	
	
	
	
}//end MySQLconnector
