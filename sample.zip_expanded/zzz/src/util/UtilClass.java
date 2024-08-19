package util;

import db.MySQLconnector;

public class UtilClass {

	public UtilClass() {
	}
	public static void ee() {
		MySQLconnector mysql = new MySQLconnector();
		mysql.connectMySQL();
	}
}	
