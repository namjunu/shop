<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>예약 추가</title>
</head>
<body>
    <h1>예약 추가</h1>
    <form action="/reservation/bookadd" method="get">
    	<input type="text" id="R_name" name="R_name" required><br>
        <label for="R_name">이름:</label>
        <input type="date" id="R_date" name="R_date" required><br>
        <label for="R_date">날짜:</label>
        <input type="text" id="R_hospital_name" name="R_hospital_name" required><br>
        <label for="R_hospital_name">병원 이름:</label>
        <input type="submit" value="예약 추가">
    </form>
</body>
</html>
