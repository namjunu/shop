<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<P>  The time on the server is ${serverTime}. </P>
강동형
<a href="./Login/createID">회원가입</a>

<form action="./Login/loginCheck" method="post">
	<input name="U_ID" placeholder="로그인 아이디">
	<input name="U_PW" type="password" placeholder="로그인 암호">
	<input type="submit" value="로그인">
</form>

id:${id}
msg:${message}
</body>
</html>
