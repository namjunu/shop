<%@page import="java.util.ArrayList"%>
<%@page import="com.teamp.spring.tp.dto.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="cp" value="${pageContext.request.contextPath}"></c:set>
<link rel="stylesheet" href="<c:url value='/resources/css/styles.css'/>"> 
<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.css'/>"> 
    <style>
    	.container{
    	justify-content: space-between;
   	    flex-direction: column;
    	}
    	.form-select{
    	display : inline;
    	width : 20%;
    	}
    	.form-control{
    	display : inline;
    	width : 100%;
    	}
    	label{
    	display : block;
    	}
    	textarea { 
    	resize:none; 
    	}
    	.category-select{
    	display : inline;
    	}
    	/* link - 아직 클릭하지 않은 경우 black 색상 설정 */
        a:link { color: black; text-decoration: none;}    
        /* visited - 한번 클릭하거나 전에 클릭한적 있을 경우 black 설정 */
        a:visited { color: black; text-decoration: none;}    
        /* hover - 마우스를 해당 링크에 위치했을 경우 black 설정 */
        a:hover { color: black; text-decoration: none;}
    </style>
<title>TP - 게시판</title>
</head>
<body>
	<header>
	    <h1><a href="${cp}/">Hello world!</a></h1>
	</header>
	<nav>
	    <a href ="${cp}/jang/Kiosk">보험 키오스크 이동</a>
	    <a href="../Shop/main">쇼핑몰</a>
	    <a href="${cp}/searchMap">주변병원 검색</a>
	    <a href="${cp}/board/BoardList">게시판</a>
	</nav>
	<div class = "container">
		<form name = "wform" action="/tp/board/BoardEdit" method="post" onsubmit="return check()">
			<input type="hidden" name = "b_no" value = ${read.b_no }>
			<div class="form-group">
				<h5 for="title" class="form-label mt-4">제목</h5>
				<input readonly type="text"  class="form-control" name='b_title' value="${read.b_title}"> 
			</div>
			<hr>
			<div class="row">
			    <div class="col">
					<h5>작성자 : ${read.b_writer}</h5>
			    </div>
			    <div class="col">
			    	<h5 class="text-end">작성일 : ${read.b_writedate}</h5>
			    </div>
			    <div class="col">
					<h5 class="text-end">조회수 : ${read.b_readcount}</h5>
			    </div>
		  	</div>
			<hr>
			<div class="form-group">
				<textarea class ="form-control" rows="10" name='b_content'>${read.b_content}</textarea>
			</div>
			<div>
			<input type="hidden" name = "b_writer" value = <%=session.getAttribute("U_ID")%>>
			</div>
			
			<br>
			<div class = "row">
				<div class = "col">
					<h5 class = "category-select">카테고리 : ${read.b_category }</h5>
				</div>
				<div class = "col">
					<h5 class = "text-end">작성자 : <%= session.getAttribute("U_ID") %></h5>
				</div>
			</div>
			<input class="btn btn-light mt-3 btn-lg" type="submit" value="글수정">
		</form>
	</div>
	<script>
	function check() {
	        var f = document.wform;
			 if (f.b_content.value == "") {
	            alert("내용을 입력해주세요");
	            f.b_content.focus();
	            return false;
	        }
		}
	</script>
</body>
</html>