package com.teamp.jang.kiosk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class KioskDAO_F {
	public Connection con = null;
	public Statement st = null;
	public ResultSet result = null;
	public void DB_Con() {
		try {
			Class.forName(KioskDB.DB_JDBC_DRIVER_PACKAGE_PATH);
			con = DriverManager.getConnection(KioskDB.DB_URL,KioskDB.DB_ID,KioskDB.DB_PW);
			st = con.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void DB_Close() {
		try {
			st.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
