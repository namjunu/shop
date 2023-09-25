<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<c:set var="cp" value="${pageContext.request.contextPath}"></c:set>
</head>
<body>
<h1>
	Hello world!  
</h1>
<P>  The time on the server is ${serverTime}. </P>
	<a href ="${cp}/jang/Kiosk">보험 키오스크 이동</a>
남준우
<a href="./Login/createID">회원가입</a>
</body>
</html>