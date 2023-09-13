<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>예약 생성</title>
</head>
<body>
    <h1>예약 생성 페이지</h1>

    <%-- 사용자 입력 폼 --%>
    <form action="createBooking" method="post">
        <%-- 세션에서 사용자 아이디와 비밀번호 가져오기 --%>
		<!-- // 사용자가 로그인하는 서블릿 또는 컨트롤러에서
		HttpSession session = request.getSession();
		session.setAttribute("U_ID", U_ID);
		session.setAttribute("U_PW", U_PW);
		       -->  
        <% 
            String U_ID = (String) session.getAttribute("U_ID");
            String U_PW = (String) session.getAttribute("U_PW");
        %>
        <label for="U_ID">사용자 아이디:</label>
        <input type="text" id="U_ID" name="U_ID" value="<%= U_ID %>" required><br>
        <label for="U_PW">비밀번호:</label>
        <input type="password" id="U_PW" name="U_PW" value="<%= U_PW %>" required><br>
        
        <label for="bookDate">예약 날짜:</label>
        <input type="text" id="bookDate" name="bookDate" required><br>
        <label for="doctorName">의사 이름:</label>
        <input type="text" id="doctorName" name="doctorName" required><br>
        <label for="totalBookCount">총 예약 수:</label>
        <input type="number" id="totalBookCount" name="totalBookCount" required><br>
        
        <input type="submit" value="예약 생성">
    </form>

    <%-- 예약 결과를 표시할 부분 --%>
    <div>
        <h2>예약 결과:</h2>
        <p>
            <%= request.getAttribute("예약 완료되었습니다.") %>
        </p>
    </div>
</body>
</html>
