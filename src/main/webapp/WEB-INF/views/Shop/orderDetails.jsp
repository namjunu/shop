<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<c:url value='/resources/css/shop_styles.css'/>">
    <title>주문 상세 정보</title>
</head>
<body>
    <div class="container">
        <header>
            <h1>주문 상세 정보</h1>
        </header>
        <c:forEach var="order" items="${orderDetails}" varStatus="loop">
            <c:if test="${loop.first}">
                <div class="order-info">
                    <p>주문 번호: ${order.o_ID}</p>
                    <p>주문자 이름: ${order.o_NAME}</p>
                    <p>전화번호: ${order.o_PHONE}</p>
                    <p>주소: ${order.o_ADDRESS}</p>
                </div>
            </c:if>
            <div class="product-info">
                <p>상품 번호: ${order.p_NO}</p>
                <p>수량: ${order.QUANTITY}</p>
                <p>결제 금액: <fmt:formatNumber value="${order.PAYMENT_AMOUNT}" type="currency" currencySymbol="₩"/></p>
            </div>
        </c:forEach>
        <a href="/tp/Shop/main">메인 페이지로 이동</a>
        <aside class="login-panel">
            <jsp:include page="/WEB-INF/views/Login/commonLogin.jsp"/>
        </aside>
    </div>
</body>
</html>
