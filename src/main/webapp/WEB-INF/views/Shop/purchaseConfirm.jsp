<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/resources/css/shop_styles.css'/>">
<title>구매 확정하기</title>
</head>
<body>
    <div class="container">
        <header>
            <h1>구매 확정하기</h1>
        </header>
        <c:set var="totalPrice" value="0" />

        <c:forEach var="item" items="${sessionScope.cart}">
            <div class="order-item">
                <c:set var="product" value="${productDetails[item.key]}" />
                <p>상품 ID: ${item.key}</p>
                <p>상품 이름: ${product.p_NAME}</p>
                <p>상품 이미지: <img src="${product.p_IMAGE}" alt="${product.p_NAME}" /></p>
                <p>상품 가격: <fmt:formatNumber value="${product.p_PRICE}" type="currency" currencySymbol="₩"/></p>
                <p>수량: ${item.value}</p>
                <c:set var="totalPrice" value="${totalPrice + (product.p_PRICE * item.value)}" />
            </div>
        </c:forEach>
        <h3>총 가격: <fmt:formatNumber value="${totalPrice}" type="currency" currencySymbol="₩"/></h3>
        <form action="/tp/Shop/createOrder" method="post">
            <label for="o_NAME">이름:</label>
            <input type="text" id="o_NAME" name="o_NAME" value="${U_NAME}" required><br>
            
            <label for="o_ADDRESS">주소:</label>
            <input type="text" id="o_ADDRESS" name="o_ADDRESS" value="${U_ADDRESS}" required><br>
            
            <label for="o_PHONE">전화번호:</label>
            <input type="text" id="o_PHONE" name="o_PHONE" value="${U_PHONE}"  required><br>
            <input type="submit" value="주문하기">
        </form>
    </div>
</body>
</html>
