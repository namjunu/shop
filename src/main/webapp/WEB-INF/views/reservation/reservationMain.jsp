<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>예약 관리</title>
</head>
<body>
    <h1>예약 관리</h1>
    
    <h2>예약 추가</h2>
    <form action="/reservation/add" method="post">
        <label for="exId">예약자 ID:</label>
        <input type="text" id="exId" name="exId" required><br>
        
        <label for="exPw">비밀번호:</label>
        <input type="password" id="exPw" name="exPw" required><br>
        
        <label for="exBookNumber">예약 번호:</label>
        <input type="text" id="exBookNumber" name="exBookNumber" required><br>
        
        <label for="exBookDate">예약 날짜:</label>
        <input type="text" id="exBookDate" name="exBookDate" required><br>
        
        <input type="submit" value="추가">
    </form>
    
    <h2>예약 삭제</h2>
    <form action="/reservation/delete" method="post">
        <label for="exBookNumberToDelete">삭제할 예약 번호:</label>
        <input type="text" id="exBookNumberToDelete" name="exBookNumber" required><br>
        
        <input type="submit" value="삭제">
    </form>
    
    <h2>예약 수정</h2>
    <form action="/reservation/modify" method="post">
        <label for="exBookNumberToModify">수정할 예약 번호:</label>
        <input type="text" id="exBookNumberToModify" name="exBookNumber" required><br>
        
        <label for="exNewBookDate">새로운 예약 날짜:</label>
        <input type="text" id="exNewBookDate" name="exBookDate" required><br>
        
        <input type="submit" value="수정">
    </form>
</body>
</html>
