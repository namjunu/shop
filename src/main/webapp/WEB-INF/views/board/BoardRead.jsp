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
글번호:${read.no}
글제목:${read.title}
<hr>
글내용:${read.content}
<hr>
글쓴이:${read.writer}
작성일:${read.writedate}
</body>
</html>