<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
	<title>Home</title>
</head>
<body>
<P>  The time on the server is ${serverTime}. </P>

<a href="/tp/board/sessiontest?id='testid1'">test1 계정 세션</a>
<a href="/tp/board/sessiontest?id='testid2'">test2 계정 세션</a>
</body>
</html>
