<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 세션에 id가 있는지 확인 --%>
<% String idValue = (String) session.getAttribute("id"); %>

<%-- id가 있으면 로그아웃 폼 표시, 없으면 로그인 폼 표시 --%>
<% if (idValue != null) { %>
    <form action="./Login/editInfo">
        <input type="submit" value="회원정보수정">
    </form> 
    <form action="./Login/editPw">
        <input type="submit" value="비밀번호변경">
    </form> 
    <form action="./Login/logOut" method="post">
        <input type="submit" value="로그아웃">
    </form> 
    <form action="./Login/addPoint" method="post">
    	<input type="hidden" id="U_ID" name ="U_ID" value="<%= session.getAttribute("id") %>">
    	<input type="text" id="addPoint" name="addPoint">
    	<input type="hidden" id="U_POINT" name="U_POINT" value="<%= session.getAttribute("U_POINT") %>">
    	<input type="submit" value="포인트 얻기">
    </form>
    <form action="./Login/usePoint" method="post">
    	<input type="hidden" id="U_ID" name ="U_ID" value="<%= session.getAttribute("id") %>">
    	<input type="text" id="usePoint" name="usePoint">
    	<input type="hidden" id="U_POINT" name="U_POINT" value="<%= session.getAttribute("U_POINT") %>">
    	<input type="submit" value="포인트 쓰기">
    </form>
    <a href="./Login/deleteMember">탈퇴하기</a>
    
    <p>환영합니다, <%= session.getAttribute("U_NAME") %>님</p>
    <p>남은 포인트 :<%= session.getAttribute("U_POINT") %></p>
<% } else { %>
    <form action="./Login/loginCheck" method="post">
        <input name="U_ID" placeholder="로그인 아이디">
        <input name="U_PW" type="password" placeholder="로그인 암호">
        <input type="submit" value="로그인">
    </form>
    <a href="./Login/createID">회원가입</a>
<% } %>
id:${id}
msg:${message}
</body>
</html>