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
<meta charset="UTF-8">
<c:set var="cp" value="${pageContext.request.contextPath}"></c:set>
    <link rel="stylesheet" href="<c:url value='/resources/css/styles.css'/>"> 
    <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.css'/>"> 
    <meta charset="UTF-8">
    <style>
    	.container{
    	justify-content: space-between;
   	    flex-direction: column;
    	}
    	.form-select{
    	display : inline;
    	width : 10%;
    	}
    	.form-control{
    	display : inline;
    	width : 80%;
    	}
    	h5{
    	margin-bottom : 0;
    	}
    	p{
    	font-size : 1.5rem;
    	}
    	.replyform{
    	width = 1rem;
    	}
    	textarea{
    	resize:none; 
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

<% 
	String sessionid = "Guest";
	if(session.getAttribute("U_ID")!=null){
		sessionid = ((String) session.getAttribute("U_ID")).replaceAll("\'", "").toString();
	}
	pageContext.setAttribute("sessionid", sessionid);
%>
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
	<div>
		<%-- 글번호:${read.b_no} --%>
		<h4>제목 : ${read.b_title}</h4>
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
	<div>
		<p>${read.b_content}</p>
	</div>
	<br>
	<div class = "row">
		<div class = "col text-center">
			<a href="/tp/board/BoardLike?no=${read.b_no}">
			<button class = "btn btn-success">
			<c:choose>
				<c:when test = "${likeValue}"><h4>추천취소</h4></c:when>
				<c:otherwise><h4>추천</h4></c:otherwise>
			</c:choose>
			<h3>${read.b_likecount}</h3>
			</button>
			</a>
		</div>
	</div>
	
	<hr>
	
	<div>
		<a href="/tp/board/BoardList"><button class="btn btn-secondary">글목록</button></a>
		<c:if test="${idCheck eq 'true'}">
		<a href="/tp/board/BoardEdit?no=${read.b_no}"><button class="btn btn-info">글수정</button></a>
		<a href="/tp/board/BoardDelete?no=${read.b_no}"><button class="btn btn-danger">글삭제</button></a>
		</c:if>
	</div>
			
	<hr>
	<c:forEach var="replys" items="${replys}">
		<div class = "row">
			<div class = "col-2 align-self-center">
			<h5 >작성자 : ${replys.r_writer}</h5>
			</div>
			<div class = "col-5 align-self-center">
			<h5 class="align-middle">${replys.r_content}</h5>
			</div>
			<div class = "col-3 text-end align-self-center">
			<h5 class="align-middle">${replys.r_writedate}</h5>
			</div>
			<div class = "col-2 text-end align-self-center">
			<c:if test="${replys.r_writer eq sessionid}">
				<a href = "/tp/board/ReplyDelete?r_no=${replys.r_no}&b_no=${replys.b_no}">
					<button class="btn btn-danger">댓글삭제</button>
				</a>
			</c:if>
			</div>
		</div>	
	    <hr>
	</c:forEach>
	<form class = "replyform"name = "rform" action="/tp/board/ReplyWrite" method="get" onsubmit="return check()">	
		<div class="input-group mb-3">
			<input type="hidden" name = "b_no" value = ${read.b_no}>
			<input type="hidden" name = "r_writer" value = <%=sessionid%>>
			<textarea type="text" class="form-control" rows="5" name='r_content'></textarea>
			<input class = "btn btn-outline-secondary" type="submit" value="댓글쓰기">
		</div>
	</form>
</div>


<script>
	function check() {
	    var f = document.rform;
		if (f.r_content.value == "") {
	        alert("내용을 입력해주세요");
	        f.r_content.focus();
	        return false;
	    }
	}
</script>
<script src="<c:url value='/resources/js/bootstrap.bundle.css'/>"></script>
</body>
</html>