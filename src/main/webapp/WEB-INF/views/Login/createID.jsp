<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
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

        // ID 중복 확인 버튼을 클릭할 때 실행되는 함수
        function checkID() {
            var userID = document.getElementById("C_ID").value;
            if(!userID || userID==""){
            	alert("ID를 입력해주세요.");
            	return;
            }

            // AJAX 요청을 통해 서버에 ID 중복 확인 요청을 보냅니다.
            $.post("/tp/Login/checkID", { C_ID: userID }, function (result) {
                if (!result.valid) {
                	  // ID가 이미 사용 중인 경우
                    alert("이미 사용 중인 ID입니다. 다른 ID를 입력해주세요.");

                    // 회원가입 버튼을 비활성화합니다.
                    document.getElementById("registerButton").disabled = true;
                } else {
                    // ID가 사용 가능한 경우
                    alert("사용 가능한 ID입니다.");

                    // 회원가입 버튼을 활성화합니다.
                    document.getElementById("registerButton").disabled = false;
                    
                    //ID입력 필드를 비활성화 하고 숨겨진 input에 넣어 값을 고정시킴
                    document.getElementById("C_ID").disabled = true;
           			document.getElementById("U_ID").value = userID;
               
                }
            });
        }
    </script>
</head>

<body>
<form action="/tp/Login/createID" method="post" onsubmit="return validatePassword();">
    <input type="hidden" id="U_ID" name ="U_ID">
    id : <input type="text" id = "C_ID" name="C_ID">
    <input type="button" value="ID중복검사" onclick="checkID()">
    pw : <input type="password" name="U_PW" id="password1">
    pw2 : <input type="password" id="password2">
    <input type="submit" id="registerButton" value="회원가입" disabled>
</form>
</body>
</html>
