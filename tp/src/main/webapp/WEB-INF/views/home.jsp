<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
	<title>Home</title>
	<c:set var="cp" value="${pageContext.request.contextPath}"></c:set>
</head>
<body>
<P>  The time on the server is ${serverTime}. </P>
	<a href ="${cp}/jang/Kiosk">보험 키오스크 이동</a>
</body>
</html>
