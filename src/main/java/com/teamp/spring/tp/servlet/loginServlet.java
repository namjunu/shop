package com.teamp.spring.tp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teamp.spring.tp.util.DatabaseUtil;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String U_ID = request.getParameter("U_ID");
        String U_PW = request.getParameter("U_PW");

        // 데이터베이스 연결을 얻어옴
        DatabaseUtil dbUtil = new DatabaseUtil();
        Connection connection = dbUtil.DatabaseConnection();

        // 여기에서 로그인 로직을 수행
        // 사용자가 입력한 아이디와 비밀번호를 검증하고, 로그인 상태를 확인

        if (isValidUser(connection, U_ID, U_PW)) {
            // 로그인 성공 시 세션에 사용자 정보를 저장
            HttpSession session = request.getSession();
            session.setAttribute("U_ID", U_ID);

            // 로그인 성공 시 book 페이지로 리다이렉트
            response.sendRedirect("/book/hospital_book.jsp");
        } else {
            // 로그인 실패 시 에러 메시지를 출력하거나 다시 로그인 페이지로 이동
            response.sendRedirect("/login/login.jsp");
        }

        try {
            // 데이터베이스 연결을 닫음
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean isValidUser(Connection connection, String U_ID, String U_PW) {
        // 실제로 여기에서 사용자 검증 로직을 구현
        // 예를 들어 데이터베이스와 연동하여 아이디와 비밀번호를 확인할 수 있습니다.

        try {
            // SQL 쿼리 작성
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, U_ID);
            preparedStatement.setString(2, U_PW);

            // SQL 쿼리 실행
            ResultSet resultSet = preparedStatement.executeQuery();

            // 결과 검증
            if (resultSet.next()) {
                // 일치하는 사용자 정보가 있으면 로그인 성공
                resultSet.close();
                preparedStatement.close();
                return true;
            } else {
                // 사용자 정보가 일치하지 않으면 로그인 실패
                resultSet.close();
                preparedStatement.close();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
