package com.teamp.jang.kiosk;

public class KioskDB {
	static public String DB_JDBC_DRIVER_PACKAGE_PATH = "com.mysql.cj.jdbc.Driver";
	static private String DB_NAME = "team_portal";
	static private String DB_URL_MYSQL = "jdbc:mysql://localhost:3306/"+DB_NAME;
	static public String DB_URL = DB_URL_MYSQL;
	static public String DB_ID = "root";
	static public String DB_PW = "root";
	
	static public String TABLE_CLASS_BOARD = "insurance_Board";
}
