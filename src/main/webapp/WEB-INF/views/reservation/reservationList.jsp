<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>예약 목록</title>
</head>
<body>
    <h1>예약 목록</h1>
    <table>
        <thead>
            <tr>
                <th>이름</th>
                <th>날짜</th>
                <th>병원 이름</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${reservations}" var="reservation">
                <tr>
                    <td>${reservation.R_name}</td>
                    <td>${reservation.R_date}</td>
                    <td>${reservation.R_hospital_name}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
