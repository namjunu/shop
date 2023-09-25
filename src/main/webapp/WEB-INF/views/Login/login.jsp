<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
</head>
<body>
    <h1>로그인</h1>

    <form action="loginServlet" method="post">
        <label for="U_ID">사용자 아이디:</label>
        <input type="text" id="U_ID" name="U_ID" required><br>
        <label for="U_PW">비밀번호:</label>
        <input type="password" id="U_PW" name="U_PW" required><br>
        <input type="submit" value="로그인">
    </form>
</body>
</html>
