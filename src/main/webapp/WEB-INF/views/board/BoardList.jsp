<%@page import="java.util.ArrayList"%>
<%@page import="com.teamp.spring.dto.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="board" items="${list}">
    ${board.no}
    ${board.title}
    ${board.content}
    ${board.writer}
    ${board.writedate}
    ${board.category}
    <hr>
</c:forEach>
</body>
</html>
    
    
