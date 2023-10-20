<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/resources/css/shop_styles.css'/>">
<title>주문이력</title>
<style>
    .container {
        display: flex;
    }

    .order-info {
        flex: 1;
        margin-right: 20px;
    }

    .common-login {
        flex: 1;
    }
</style>
</head>
<body>
    <div class="container">
        <div class="order-info">
            <header>
                <h1>주문 이력</h1>
            </header>
            <c:forEach var="order" items="${purchaseList}">
                <div class="order-item">
                    <p>주문 번호: ${order.o_ID}</p>
                    <p>주문자 이름: ${order.u_ID}</p>
                    <p>주문 시간: ${order.o_DATE}</p>
                    <a href="/tp/Shop/orderDetails?O_ID=${order.o_ID}">주문 상세 페이지</a>
                </div>
            </c:forEach>
            <a href="/tp/Shop/main">메인 페이지로 이동</a>
        </div>
        <div class="common-login">
            <jsp:include page="/WEB-INF/views/Login/commonLogin.jsp"/>
        </div>
    </div>
</body>
</html>
