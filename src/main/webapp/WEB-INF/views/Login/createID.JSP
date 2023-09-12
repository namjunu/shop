<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script>

function validatePassword() {
	
    var pw1 = document.getElementById("password1").value;
    var pw2 = document.getElementById("password2").value;
    
    if (pw1 !== pw2) {
        alert("비밀번호가 일치하지 않습니다.");
        return false;
    }
    return true;
}

//todo ===== id 중복 검사하기
</script>
</head>

<body>
<form action="/tp/Login/createID" method="post" onsubmit="return validatePassword();">
		id : <input type="text" name="U_ID">
		pw : <input type="password" name="U_PW" id="password1">
		pw2 : <input type="password" id="password2">
		<input type="submit" value="회원가입">
	</form>
</body>
</html>