<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        function validatePassword() {
            var pw1 = document.getElementById("password1").value;
            var pw2 = document.getElementById("password2").value;

            if (pw1 !== pw2) {
                alert("비밀번호가 서로 다릅니다.");
                return false;
            }
            return true; 
        }
    </script>
</head>
<body>
<form action="/tp/Login/editPw" method="post" onsubmit="return validatePassword();">
    <input type="hidden" id="U_ID" name ="U_ID" value="<%= session.getAttribute("U_ID") %>">
    pw : <input type="password" name="U_PW" id="password1">
    pw2 : <input type="password" id="password2">
    <input type="submit" id="registerButton" value="비밀번호변경">
</form>

</body>
</html>