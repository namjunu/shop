package com.teamp.spring.tp.util; // 패키지명을 프로젝트에 맞게 수정하세요

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

    // 데이터베이스 연결을 수행하는 메서드
    public Connection DatabaseConnection() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/root"; // 데이터베이스 URL
        String username = "1234"; // 데이터베이스 사용자명
        String password = "1234"; // 데이터베이스 암호

        Connection connection = null;

        try {
            // JDBC 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 데이터베이스에 연결
            connection = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
