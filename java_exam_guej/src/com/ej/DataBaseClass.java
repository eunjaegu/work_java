package com.ej;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataBaseClass {

	public final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	public final String DB_URL = "jdbc:mysql://localhost:3306/";
	public final String DB_ADMIN_ID = "root";
	public final String DB_ADMIN_PW = "1234";

	public Connection conn = null;

	static ArrayList<CafeClass> al = new ArrayList<CafeClass>();

	public DataBaseClass() {
	} // 기본생성자

	public void connMYSQL() {

		try {
			Class.forName(DB_DRIVER);
			conn = DriverManager.getConnection(DB_URL + "test", DB_ADMIN_ID, DB_ADMIN_PW);
			System.out.println("드라이버, 접속 성공!!!");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFound ERR :" + e.getMessage());

		} catch (SQLException e) {
			System.out.println("DriverManager.getConnection() ERR :" + e.getMessage());
		}
	}

	public void selectAll() {
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from cafe_ej");

			while (rs.next()) {
				System.out.print(rs.getString("order_id") + "\t");
				System.out.println(rs.getInt("item"));
			}

		} catch (SQLException e) {
			System.out.println("SELECT ALL ERR:" + e.getMessage());
		} finally {
			try {
				rs.close();
				stmt.close();

			} catch (Exception e) {
				System.out.println("SELECT ALL CLOSE ERR:" + e.getMessage());
			}
		}

	} // selcetAll END()

	// insert into cafe_ej(Order_id, Order_date, category, item, price) values
	// ('C38167668', '2017-09-13 10:15', 'Coffee', '카라멜마끼아또', 5000);

	public void insert() {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into cafe_ej(Order_id, Order_date, category, item, price) values (?, ?, ?, ?, ?)";
		String Order_id = "C38167668";
		String Order_date = "2017-09-13 10:15";
		String category = "Coffee";
		String item = "카라멜마끼아또";
		String price = "5000";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, Order_id);
			pstmt.setString(2, Order_date);
			pstmt.setString(3, category);
			pstmt.setString(4, item);
			pstmt.setString(5, price);

			result = pstmt.executeUpdate();
			if (result < 1) {
				System.out.println("INSERT FAIL !!!");
			}

		} catch (SQLException e) {
			System.out.println("INSERT ERR : " + e.getMessage());
		} finally {
			try {
				pstmt.close();
			} catch (Exception e) {
				System.out.println("INSERT CLOSE ERR : " + e.getMessage());
			}
		}

	} // insert END()

	public void update() {
		PreparedStatement pstmt = null;
		String query = "update cafe_ej set item=?, where item=?";
		String newItem = "시그니처 커피";
		String oldItem = "비엔나커피";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newItem);
			pstmt.setString(2, oldItem);

			int result = pstmt.executeUpdate();
			if (result < 1) {
				System.out.println("UPDATE FAIL");
			}
		} catch (SQLException e) {
			System.out.println("UPDATE ERR" + e.getMessage());
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				System.out.println("UPDATE CLOSE ERR" + e.getMessage());
			}
		}

	} // update END()

	public void delete() {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from cafe_ej where 0= ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, result);
			result = pstmt.executeUpdate();
			if (result < 1) {
				System.out.println("UPDATE FAIL");
			}

		} catch (SQLException e) {
			System.out.println("DELETE ERR" + e.getMessage());
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				System.out.println("DELETE CLOSE ERR" + e.getMessage());
			}
		}
	} // delete END()
} // DataBaseClass END
