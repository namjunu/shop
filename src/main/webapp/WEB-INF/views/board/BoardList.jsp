<%@page import="java.util.ArrayList"%>
<%@page import="com.teamp.spring.tp.dto.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<c:set var="cp" value="${pageContext.request.contextPath}"></c:set>
    <link rel="stylesheet" href="<c:url value='/resources/css/styles.css'/>"> 
    <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.css'/>"> 
    <meta charset="UTF-8">
    <style>
    	.container{
    	justify-content: space-between;
   	    flex-direction: column;
    	}
    	.td_1{
    	width : 8%;
    	}
    	.td_2{
    	width : 30%;
    	}
    	.td_3{
    	width : 13%;
    	}
    	.td_4{
    	width : 20%;
    	}
    	.td_5{
    	width : 13%;
    	}
    	.td_6{
    	width : 8%
    	}
    	.form-select{
    	display : inline;
    	width : 10%;
    	}
    	.form-control{
    	display : inline;
    	width : 20%;
    	}
    </style>
<title>TP - 게시판</title>
</head>
<body>
<% 
	String searchValue = "";
	String searchTypeValue = "";
	String uid = "";
	String categoryVal = "";
	if(request.getParameter("search")!= null){
		searchValue = (String) request.getParameter("search");
	}
	if(request.getParameter("searchType")!= null){
		searchTypeValue = (String) request.getParameter("searchType");
	}
	if(session.getAttribute("U_ID")==null){
		uid = "Guest";
	}
	else{
		uid = (String) session.getAttribute("U_ID");
	}
	if("main".equals((String)request.getParameter("category")) || (request.getParameter("category")==null)){
		categoryVal = "메인";
	}else if("free".equals((String)request.getParameter("category"))){
		categoryVal = "자유";
	}else if("question".equals((String)request.getParameter("category"))){
		categoryVal = "질문";
	}else if("like".equals((String)request.getParameter("category"))){
		categoryVal = "추천";
	}else if("my".equals((String)request.getParameter("category"))){
		categoryVal = "내가 쓴 글";
	}
%>
<header>
    <h1>Hello world!</h1>
</header>
<nav>
    <a href ="${cp}/jang/Kiosk">보험 키오스크 이동</a>
    <a href="../Shop/main">쇼핑몰</a>
    <a href="${cp}/searchMap">주변병원 검색</a>
    <a href="${cp}/board/BoardList">게시판</a>
</nav>
<div class="container">
	<div><h1>게시판 - <%=categoryVal %> </h1></div>
	<div><p><%= uid %><%-- (<%= session.getAttribute("U_NO") %>) --%> 님 환영합니다.</p></div>
	<div><h2>카테고리</h2></div>
	<div>
		<a href="/tp/board/BoardList"><button class="btn btn-default btn-light">메인</button></a>
		<a href="/tp/board/BoardList?category=free"><button class="btn btn-default btn-light">자유</button></a>
		<a href="/tp/board/BoardList?category=question"><button class="btn btn-default btn-light">질문</button></a>
		<a href="/tp/board/BoardList?category=like"><button class="btn btn-default btn-light">추천</button></a>
		
		<c:if  test="${lgcheck eq true}">
			<a href="/tp/board/BoardList?category=my"><button class="btn btn-default btn-light">내가 쓴 글</button></a>
		</c:if>
		</div>
	
	<table class="table table-hover">
		<tr>
			<td class = "td_1">글번호</td>
			<td class = "td_2">글제목</td>
			<td class = "td_3">글쓴이</td>
			<td class = "td_4">작성일</td>
			<td class = "td_5">카테고리</td>
			<td class = "td_6">조회수</td>
		</tr>
		
		<c:forEach var="board" items="${list}">
			<tr>
				<td>${board.b_no}</td>
				<td><a href = "/tp/board/BoardRead?no=${board.b_no}">${board.b_title}</a></td>
				<td>${board.b_writer}</td>
				<td>${board.b_writedate}</td>
				<td>${board.b_category}</td>
				<td>${board.b_readcount}</td>
		    </tr>
		</c:forEach>
	</table>
	<div>
	<a href = "/tp/board/logincheck"><button class="btn btn-default btn-light">글쓰기</button></a>
	</div>
	<hr>
	<form action="/tp/board/BoardList">
		<div float = "left">
			<select name="searchType" class="form-select form-select-sm" aria-label=".form-select-sm example">
		    <option value="title" selected="selected">제목</option>
		    <option value="content">내용</option>
		    <option value="title_content">제목+내용</option>
		    <option value="writer">글쓴이</option>
			</select>
			<input type = "text" name ="search" class="form-control" value = "<%= searchValue %>" >
			<input type = "submit" value = "검색" class="btn btn-default btn-light">
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
<script src="<c:url value='/resources/js/bootstrap.bundle.css'/>"></script>
</body>
</html>
    
    
