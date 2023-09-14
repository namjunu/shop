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
	<form action="/tp/board/BoardEdit" method="post">
	<input type="hidden" name = "no" value = ${read.no}>
	글번호:${read.no}
	<p>
	글제목:${read.title}
	<hr>
	<textarea rows="10" name='content'>${read.content}</textarea>
	<br>
	글쓴이:${read.writer}
	작성일:${read.writedate}
	조회수:${read.readcount}
	<br>
	<input type="submit" value="글수정">
	</form>
	
</body>
</html>