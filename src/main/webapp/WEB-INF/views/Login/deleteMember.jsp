<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
</head>
<body>
<form action="/tp/Login/deleteMember" method="post" >
    <input type="hidden" id="U_ID" name ="U_ID" value="<%= session.getAttribute("U_ID") %>">
    회원정보를 삭제하시려면 비밀번호를 입력 해 주세요 <input type="password" name="U_PW" id="password">
    <input type="submit" id="registerButton" value="탈퇴하기">
</form>
</body>
</html>