<%@page import="java.util.ArrayList"%>
<%@page import="com.teamp.spring.tp.dto.BoardVO"%>
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

<div>
	<h1>게시판</h1>
	<table>
		<tr>
			<td>글번호</td>
			<td>글제목</td>
			<td>글쓴이</td>
			<td>작성일</td>
			<td>카테고리</td>
		</tr>
		
		<c:forEach var="board" items="${list}">
			<tr>
				<td>${board.no}</td>
				<td><a href = "/tp/board/BoardRead?no=${board.no}">${board.title}</a></td>
				<td>${board.writer}</td>
				<td>${board.writedate}</td>
				<td>${board.category}</td>
		    </tr>
		</c:forEach>
	</table>

	<a href = "/tp/board/BoardWrite"><button>글쓰기</button></a>
		<hr>
	<div style="display: block; text-align: center;">		
			<c:if test="${paging.startPage != 1 }">
				<a href="/tp/board//BoardList?currentPage=${paging.startPage - 1 }">&lt;</a>
			</c:if>
			<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
				<c:choose>
					<c:when test="${p == paging.nowPage }">
						<b>${p }</b>
					</c:when>
					<c:when test="${p != paging.nowPage }">
						<a href="/tp/board//BoardList?currentPage=${p }">${p }</a>
					</c:when>
				</c:choose>
			</c:forEach>
			<c:if test="${paging.endPage != paging.lastPage}">
				<a href="/tp/board//BoardList?currentPage=${paging.endPage+1 }">&gt;</a>
			</c:if>
		</div>
		
	</div>




</body>
</html>
    
    
