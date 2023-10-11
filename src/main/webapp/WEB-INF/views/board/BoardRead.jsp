<%@page import="java.util.ArrayList"%>
<%@page import="com.teamp.spring.tp.dto.BoardVO"%>
<%@page import="com.teamp.spring.tp.dto.ReplyVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/water.css@2/out/water.css">
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<% 
	String sessionid = ((String) session.getAttribute("U_ID")).replaceAll("\'", "").toString();
	pageContext.setAttribute("sessionid", sessionid);
%>
글번호:${read.b_no}
글제목:${read.b_title}
<hr>

글쓴이:${read.b_writer}
작성일:${read.b_writedate}
조회수:${read.b_readcount}
<hr>
글내용:${read.b_content}
<br>
<a href="/tp/board/BoardLike?no=${read.b_no}"><button>
	<c:choose>
		<c:when test = "${likeValue}"><h4>추천취소</h4></c:when>
		<c:otherwise><h4>추천</h4></c:otherwise>
	</c:choose>
	<h3>${read.b_likecount}</h3>
</button></a>
<hr>

<c:if test="${idCheck eq 'true'}">
	<a href="/tp/board/BoardEdit?no=${read.b_no}"><button>글수정</button></a>
	<a href="/tp/board/BoardDelete?no=${read.b_no}"><button>글삭제</button></a>
</c:if>
<a href="/tp/board/BoardList"><button>글목록</button></a>
<hr>
<c:forEach var="replys" items="${replys}">
	<tr>
		<td>${replys.r_content}</td>
		<td>${replys.r_writer}</td>
		<td>${replys.r_writedate}</td>
		<c:if test="${replys.r_writer eq sessionid}">
			<a href = "/tp/board/ReplyDelete?r_no=${replys.r_no}&b_no=${replys.b_no}"><button>댓글삭제</button></a>
		</c:if>
    </tr>
    <hr>
</c:forEach>

<form action="/tp/board/ReplyWrite" method="get">
	<input type="hidden" name = "b_no" value = ${read.b_no}>
	<input type="hidden" name = "r_writer" value = <%=sessionid%>>
	<textarea rows="10" name='r_content'></textarea>
	<input type="submit" value="댓글쓰기">
</form>
</body>
</html>