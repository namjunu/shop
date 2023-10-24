<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    </style>
<title>TP - 게시판</title>
</head>
<body>
	<header>
	    <h1>Hello world!</h1>
	</header>
	<nav>
	    <a href ="${cp}/jang/Kiosk">보험 키오스크 이동</a>
	    <a href="../Shop/main">쇼핑몰</a>
	    <a href="${cp}/searchMap">주변병원 검색</a>
	    <a href="${cp}/board/BoardList">게시판</a>
	</nav>
	<div class = "container">
		<form name = "wform" action="/tp/board/BoardWrite" method="post" onsubmit="return check()">
			<div class="form-group">
				<h5 for="title" class="form-label mt-4">제목</h5>
				<input type="text" class="form-control" name='b_title'> 
			</div>
			<hr>
			<div class="form-group">
				<textarea class ="form-control" rows="10" name='b_content'></textarea>
			</div>
			<div>
			<input type="hidden" name = "b_writer" value = <%=session.getAttribute("U_ID")%>>
			
			</div>
			
			<br>
			<div class = "row">
				<div class = "col">
					<h5 class = "category-select">카테고리 : </h5>	
					<select class="form-select form-select-lg" name="b_category">
					<option value="free" selected="selected">자유</option>
					<option value="question">질문</option>
					</select>
				</div>
				<div class = "col">
					<h5 class = "text-end">작성자 : <%= session.getAttribute("U_ID") %></h5>
				</div>
				
			</div>
			<input class="btn btn-light mt-3 btn-lg" type="submit" value="글쓰기">
		</form>
	</div>
	
	
	<script>
	function check() {
			var f = document.wform;
	        if (f.b_title.value == "") {
	            alert("제목을 입력해주십시오");
	            f.b_title.focus();
				console.log(f);
	            return false;
	        }
			 if (f.b_content.value == "") {
	            alert("내용을 입력해주세요");
	            f.b_content.focus();
	            return false;
	        }
		}
	</script>
	<script src="<c:url value='/resources/js/bootstrap.bundle.css'/>"></script>
</body>
</html>