<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="<c:url value='/resources/css/commonLogin.css'/>">
</head>
<body>

<%-- 세션에 id가 있는지 확인 --%>
<% String idValue = (String) session.getAttribute("U_ID"); %>

<%-- id가 있으면 로그아웃 폼 표시, 없으면 로그인 폼 표시 --%>
<% if (idValue != null) { %>
<div id="login-box">
    <form action="/tp/Login/editInfo">
        <input type="submit" value="회원정보수정">
    </form> 
    <form action="/tp/Login/editPw">
        <input type="submit" value="비밀번호변경">
    </form> 
    <form action="/tp/Login/logOut" method="post">
        <input type="submit" value="로그아웃">
    </form> 
    <form action="/tp/Login/addPoint" method="post" class="hidden">
    	<input type="hidden" id="U_ID" name ="U_ID" value="<%= session.getAttribute("U_ID") %>">
    	<input type="text" id="addPoint" name="addPoint">
    	<input type="hidden" id="U_POINT" name="U_POINT" value="<%= session.getAttribute("U_POINT") %>">
    	<input type="submit" value="포인트 얻기">
    </form>
    <form action="/tp/Login/usePoint" method="post" class="hidden">
    	<input type="hidden" id="U_ID" name ="U_ID" value="<%= session.getAttribute("U_ID") %>">
    	<input type="text" id="usePoint" name="usePoint">
    	<input type="hidden" id="U_POINT" name="U_POINT" value="<%= session.getAttribute("U_POINT") %>">
    	<input type="submit" value="포인트 쓰기">
    </form>
    <a href="/tp/Login/deleteMember">탈퇴하기</a>
    
    <p>환영합니다, <%= session.getAttribute("U_NAME") %>님</p>
    <p>남은 포인트 :<%= session.getAttribute("U_POINT") %></p>
<% } else { %>
    <form action="/tp/Login/loginCheck" method="post">
        <input name="U_ID" placeholder="로그인 아이디">
        <input name="U_PW" type="password" placeholder="로그인 암호">
        <input type="submit" value="로그인">
    </form>
    <a href="/tp/Login/createID" class="link-button">회원가입</a>
<% } %>
<br>
<br>
<a href="/tp/Shop/cart" class="link-button">장바구니 보기</a>
<br>
<br>
<a href="/tp/Shop/purchaseHistory" class="link-button">주문내역</a>
</div>
</body>
</html>