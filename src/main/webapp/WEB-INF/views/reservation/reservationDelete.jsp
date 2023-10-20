<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>예약 삭제</title>
</head>
<body>
    <h1>예약 삭제</h1>
    <p>정말로 예약을 삭제하시겠습니까?</p>
    <form action="/reservation/bookdelete" method="get">
        <input type="hidden" name="R_name" value="${reservation.R_name}">
        <input type="submit" value="예약 삭제">
    </form>
</body>
</html>
