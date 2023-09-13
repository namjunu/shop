package com.teamp.spring.tp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamp.spring.tp.dto.UserInfo;
import com.teamp.spring.tp.util.DatabaseUtil;
import com.teamp.spring.tp.mapper.LoginMapper;
import com.teamp.spring.tp.dto.BookInfo;

@Service
public class BookServiceImpl implements BookService {

    private LoginMapper loginMapper;
    
    @Autowired
    public BookServiceImpl(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    public String makeBook(String U_ID, String U_PW, BookInfo bookInfo) { // 메서드 이름을 "makeBook"으로 변경
        // 로그인 검증
        boolean isUserAuthenticated = loginMapper.LoginTest(U_ID, U_PW);

        if (isUserAuthenticated) {
            String bookNumber = generateUniqueBookNumber(); //예약번호 생성
            bookInfo.setBookNumber(bookNumber); //bookinfo객체에 예약번호 설정
        	
            boolean isBookSaved = saveBook(bookInfo);
            
            if (isBookSaved) {
                return "예약이 성공적으로 생성되었습니다. 예약 번호: " + bookNumber;
            } else {
                return "예약 생성 실패";
            }
        } else {
            // 로그인 실패
            return "로그인 실패: 사용자 인증 실패";
        }
    }
 // 예약 번호 생성 메서드
    private String generateUniqueBookNumber() {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    	String currentDate = dateFormat.format(new Date());
    	
    	// 일련번호 1부터 시작 + 필요에 따라 형식에 맞게 바꿈
    	String bookNumber = currentDate + "0001";
    	
    	boolean isUnique = isBookNumberUnique(bookNumber);
    	
    	// 중복된 예약 번호를 처리하는 로직 추가
        if (!isUnique) {
            // 중복된 경우, 일련번호를 증가시키면서 다시 생성
            int sequence = 1;
            while (!isUnique) {
                sequence++;
                bookNumber = currentDate + String.format("%04d", sequence);
                isUnique = isBookNumberUnique(bookNumber);
            }
        }
        
		return bookNumber;
        // 예약 번호 생성 로직 (이전 답변에 제공된 코드 참고)
    }

    // 중복 확인 메서드 (실제 데이터베이스와 연동 필요)
    private boolean isBookNumberUnique(String bookNumber) {
		return false;
        // 중복 확인 로직 (이전 답변에 제공된 코드 참고)
    }
    
    private boolean saveBook(BookInfo bookInfo) {
    	try {
            // 여기에서 데이터베이스에 예약 정보를 저장하는 코드를 작성
            // bookInfo 객체의 정보를 데이터베이스에 저장
    		DatabaseUtil databaseUtil = new DatabaseUtil(); // DatabaseUtil 클래스의 인스턴스 생성
            Connection connection = databaseUtil.DatabaseConnection(); // 데이터베이스 연결 메서드 호출
            // 아래는 가상의 코드
            String bookNumber = bookInfo.getBookNumber();
            String bookDate = bookInfo.getBookDate();
            String doctorName = bookInfo.getDoctorName();
            int totalBookCount = bookInfo.getTotalBookCount();
            
            // 예약 정보를 데이터베이스에 저장하는 SQL 쿼리 ?를 이용해서 파라미터 위치를 나타냄
            String sql = "INSERT INTO tb_example (ex_book_number, ex_book_date, ex_doctor_name, ex_total_book_count) VALUES (?, ?, ?, ?)";
            
            // SQL 쿼리 실행 및 예약 정보 저장
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bookNumber);
            preparedStatement.setString(2, bookDate);
            preparedStatement.setString(3, doctorName);
            preparedStatement.setInt(4, totalBookCount);
            
            int rowsAffected = preparedStatement.executeUpdate();
            
            // 연결 및 리소스 정리
            preparedStatement.close();
            connection.close();
            
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    //예약 수정 메소드
    public boolean updateBook(BookInfo bookInfo) {
        try {
            // DatabaseUtil 클래스의 인스턴스 생성
            DatabaseUtil databaseUtil = new DatabaseUtil();
            // 데이터베이스 연결 메서드 호출
            Connection connection = databaseUtil.DatabaseConnection();

            String bookNumber = bookInfo.getBookNumber();
            String bookDate = bookInfo.getBookDate();
            String doctorName = bookInfo.getDoctorName();
            int totalBookCount = bookInfo.getTotalBookCount();

            // 예약 정보를 데이터베이스에서 업데이트하는 SQL 쿼리
            String sql = "UPDATE tb_example SET ex_book_date = ?, ex_doctor_name = ?, ex_total_book_count = ? WHERE ex_book_number = ?";

            // SQL 쿼리 실행 및 예약 정보 업데이트
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bookDate);
            preparedStatement.setString(2, doctorName);
            preparedStatement.setInt(3, totalBookCount);
            preparedStatement.setString(4, bookNumber);

            int rowsAffected = preparedStatement.executeUpdate();

            // 연결 및 리소스 정리
            preparedStatement.close();
            connection.close();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    //예약 삭제 메소드
    public boolean deleteBook(String bookNumber) {
        try {
            // DatabaseUtil 클래스의 인스턴스 생성
            DatabaseUtil databaseUtil = new DatabaseUtil();
            // 데이터베이스 연결 메서드 호출
            Connection connection = databaseUtil.DatabaseConnection();

            // 예약 정보를 데이터베이스에서 삭제하는 SQL 쿼리
            String sql = "DELETE FROM tb_example WHERE ex_book_number = ?";

            // SQL 쿼리 실행 및 예약 정보 삭제
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bookNumber);

            int rowsAffected = preparedStatement.executeUpdate();

            // 연결 및 리소스 정리
            preparedStatement.close();
            connection.close();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
