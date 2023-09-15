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
    <form action="./Login/logOut" method="post">
        <input type="submit" value="로그아웃">
    </form> 
    <p>환영합니다, ID: <%= idValue %></p>
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