<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>예약 관리</title>
    <script src="/resources/reservation.js"></script>
	<c:set var="cp" value="${pageContext.request.contextPath}"></c:set>
	<link rel="stylesheet" href="<c:url value='/resources/css/styles.css'/>"> 
	<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.css'/>">
	<style>
        .container{
        	display:block;
        	justify-content: space-between;
		    max-width: 1200px;
		    margin: 0 auto;
		    padding: 2em;
        }
    </style> 
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
<div class="container">
    <script>
      // 예약 관리 페이지에서 URL 매개변수 읽기
      var urlParams = new URLSearchParams(window.location.search);
      var hospitalName = urlParams.get("hospital");

      document.addEventListener("DOMContentLoaded", function () {
        if (hospitalName) {
          document.getElementById("add_R_hospital_name").value = hospitalName;
          document.getElementById("edit_R_hospital_name").value = hospitalName;
        }
      });
    </script>
    <h1>예약 관리</h1>
    <!-- 예약 추가 폼 -->
    <form action="/reservation/bookadd" method="post">
      <h2>예약 추가</h2>
      <label for="add_R_name">이름:</label>
      <input type="text" id="add_R_name" name="R_name" required /><br />
      <label for="edit_R_date">날짜:</label>
      <input
        type="date"
        id="edit_R_date"
        name="R_date"
        value="날짜"
        required
      /><br />
      <!-- 병원 이름을 세션에서 가져와서 설정 -->
      <label for="add_R_hospital_name">병원 이름:</label>
      <input type="text" id="add_R_hospital_name" name="R_hospital_name"
      value="<%= session.getAttribute("selectedHospital") %>" required><br />
      <input type="submit" value="예약 추가" />
    </form>

    <!-- 예약 수정 폼 -->
    <h2>예약 수정</h2>
    <form action="/reservation/bookmodify" method="post">
      <label for="edit_R_name">이름:</label>
      <input
        type="text"
        id="edit_R_name"
        name="R_name"
        value="예약자 이름"
        required
      /><br />
      <label for="edit_R_date">날짜:</label>
      <input
        type="date"
        id="edit_R_date"
        name="R_date"
        value="날짜"
        required
      /><br />
      <label for="edit_R_hospital_name">병원 이름:</label>
      <input type="text" id="edit_R_hospital_name" name="R_hospital_name"
      value="<% session.getAttribute("selectedHospital"); %>" required><br />
      <input type="submit" value="예약 수정" />
    </form>
    
    <h2>예약 조회</h2>
	<form action="/reservation/booksearch" method="post">
	  <label for="search_R_name">이름:</label>
	  <input type="text" id="search_R_name" name="R_name" required /><br />
	  <input type="submit" value="예약 조회" />
	</form>
	
	<!-- 예약 삭제 폼 -->
	<h2>예약 삭제</h2>
	<form action="/reservation/bookdelete" method="post">
	  <label for="delete_R_name">예약자 이름:</label>
	  <input type="text" id="delete_R_name" name="R_name" required /><br />
	  <input type="submit" value="예약 삭제" />
	</form>
	</div>
  </body>
</html>
