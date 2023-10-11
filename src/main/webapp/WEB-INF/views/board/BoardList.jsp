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
<% 
	String searchValue = (String) request.getParameter("search");
	String searchTypeValue = (String) request.getParameter("searchType");
%>
<div>
	<h1>${category}게시판</h1>
	<p><%= session.getAttribute("U_ID") %>(<%= session.getAttribute("U_NO") %>) 님 환영합니다.</p> 
	<h2>카테고리</h2>
	<a href="/tp/board/BoardList"><button>Main</button></a>
	<a href="/tp/board/BoardList?category=free"><button>free</button></a>
	<a href="/tp/board/BoardList?category=test1"><button>test1</button></a>
	<a href="/tp/board/BoardList?category=test2"><button>test2</button></a>
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
				<td>${board.b_no}</td>
				<td><a href = "/tp/board/BoardRead?no=${board.b_no}">${board.b_title}</a></td>
				<td>${board.b_writer}</td>
				<td>${board.b_writedate}</td>
				<td>${board.b_category}</td>
		    </tr>
		</c:forEach>
	</table>

	<a href = "/tp/board/BoardWrite"><button>글쓰기</button></a>
		<hr>
	<form action="/tp/board/BoardList">
		<div float = "left">
			<select name="searchType" >
		    <option value="title" selected="selected">제목</option>
		    <option value="content">내용</option>
		    <option value="title_content">제목+내용</option>
		    <option value="writer">글쓴이</option>
			</select>
			<input type = "text" name ="search" value = <%= searchValue %>>
			<input type = "submit" value = "검색">
		</div>
	</form>
	<hr>
	<div style="display: block; text-align: center;">		
			<c:if test="${paging.startPage != 1 }">
				<a href="/tp/board//BoardList?currentPage=${paging.startPage - 1 }&category=${category}&searchType=<%=searchTypeValue %>&search=<%=searchValue %>">&lt;</a>
			</c:if>
			<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
				<c:choose>
					<c:when test="${p == paging.nowPage }">
						<b>${p }</b>
					</c:when>
					<c:when test="${p != paging.nowPage }">
						<a href="/tp/board//BoardList?currentPage=${p }&category=${category}&searchType=<%=searchTypeValue %>&search=<%=searchValue %>">${p }</a>
					</c:when>
				</c:choose>
			</c:forEach>
			<c:if test="${paging.endPage != paging.lastPage}">
				<a href="/tp/board//BoardList?currentPage=${paging.endPage+1 }&category=${category}&searchType=<%=searchTypeValue %>&search=<%=searchValue %>">&gt;</a>
			</c:if>
		</div>		
	</div>

</body>
</html>
    
    
