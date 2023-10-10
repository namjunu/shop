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
  <jsp:include page="Login/commonLogin.jsp"/>
<a href="/tp/board/sessiontest?id='testid1'">test1 계정 세션</a>
<a href="/tp/board/sessiontest?id='testid2'">test2 계정 세션</a>
	<a href ="${cp}/jang/Kiosk">보험 키오스크 이동</a>
<a href="./Login/createID">회원가입</a>
<a href="./Shop/main">쇼핑몰</a>
</body>
</html>