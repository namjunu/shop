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
	<input type="hidden" name = "b_no" value = ${read.b_no }>
	글번호:${read.b_no}
	<p>
	글제목:${read.b_title}
	<hr>
	<textarea rows="10" name='b_content'>${read.b_content}</textarea>
	<br>
	글쓴이:${read.b_writer}
	작성일:${read.b_writedate}
	조회수:${read.b_readcount}
	<br>
	<input type="submit" value="글수정">
	</form>
	
</body>
</html>