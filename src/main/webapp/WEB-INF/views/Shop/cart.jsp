<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
</head>
<body>

<h2>장바구니</h2>

<%-- 로그인 여부 확인 --%>
<% String userId = (String) session.getAttribute("U_ID"); %>
<c:set var="totalPrice" value="0" />

<% if (userId != null) { %>

    <%-- DB에서 장바구니 정보 가져오기 (서버에서 해당 정보를 미리 불러와야 합니다.) --%>
    <c:forEach var="item" items="${cartFromDB}">
        <div>
            <c:set var="product" value="${shopService.getProductById(item.productId)}" />
            <p>상품 ID: ${item.productId}</p>
            <p>상품 이름: ${product.name}</p>
            <p>상품 이미지: <img src="${product.image}" alt="${product.name}" /></p>
            <p>상품 가격: ${product.price}</p>
            <p>수량: ${item.quantity}</p>
            <c:set var="totalPrice" value="${totalPrice + (product.price * item.quantity)}" />
        </div>
    </c:forEach>

<% } else { %>

    <%-- 세션에서 장바구니 정보 가져오기 --%>
    <c:forEach var="item" items="${sessionScope.cart}">
        <div>
            <c:set var="product" value="${shopService.getProductById(item.key)}" />
            <p>상품 ID: ${item.key}</p>
            <p>상품 이름: ${product.productName}</p>
            <p>상품 이미지: <img src="${product.productImage}" alt="${product.productName}" /></p>
            <p>상품 가격: <fmt:formatNumber value="${product.productPrice}" type="currency" currencySymbol="₩"/></p>
            <p>수량: ${item.value}</p>
            <c:set var="totalPrice" value="${totalPrice + (product.productPrice * item.value)}" />
        </div>
    </c:forEach>

<% } %>

<h3>총 가격: <fmt:formatNumber value="${totalPrice}" type="currency" currencySymbol="₩"/></h3>

</body>
</html>
