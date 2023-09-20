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
글번호:${read.b_no}
글제목:${read.b_title}
<hr>
글내용:${read.b_content}
<hr>
글쓴이:${read.b_writer}
작성일:${read.b_writedate}
조회수:${read.b_readcount}
추천수:${read.b_likecount}
<hr>
<a href="/tp/board/BoardEdit?no=${read.b_no}"><button>글수정</button></a>
<a href="/tp/board/BoardDelete?no=${read.b_no}"><button>글삭제</button></a>
<a href="/tp/board/BoardList"><button>글목록</button></a>

<form action="/tp/board/ReplyWrite" method="post">
	<textarea rows="10" name='content'></textarea>
	<input type="submit" value="글쓰기">
</form>
</body>
</html>