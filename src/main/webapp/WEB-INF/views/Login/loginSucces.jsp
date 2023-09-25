<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인 성공</title>
</head>
<body>
    <h1>로그인 성공</h1>
    <p>안녕하세요, <%= session.getAttribute("U_ID") %>님!</p>
</body>
</html>
