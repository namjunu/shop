<%@page import="java.util.ArrayList"%>
<%@page import="com.teamp.spring.tp.dto.BoardVO"%>
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
    <a href = "/tp/board/BoardRead?no=${board.no}">${board.title}</a>
    ${board.writer}
    ${board.writedate}
    ${board.category}
    <hr>
</c:forEach>

<a href = "/tp/board/BoardWrite"><button>글쓰기</button></a>
</body>
</html>
    
    
