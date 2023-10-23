<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<c:url value='/resources/css/shop_styles.css'/>">
    <link rel="stylesheet" href="<c:url value='/resources/css/cart_styles.css'/>">
    <title>장바구니</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
    $(document).ready(function() {
        // Quantity update
        $("input[value='수량 변경하기']").on('click', function(event) {
            event.preventDefault();
            var form = $(this).closest('form');
            var P_NO = form.find("input[name='p_NO']").val();
            var quantity = form.find("input[name='quantity']").val();
            var action = form.attr('action');
            
            $.ajax({
                url: action,
                type: 'POST',
                data: { P_NO: P_NO, quantity: quantity },
                success: function(data) {
                    location.reload();
                }
            });
        });
        
        // Remove item
        $("input[value='제거하기']").on('click', function(event) {
            event.preventDefault();
            var form = $(this).closest('form');
            var P_NO = form.find("input[name='p_NO']").val();
            var action = form.attr('action');
            
            $.ajax({
                url: action,
                type: 'POST',
                data: { P_NO: P_NO },
                success: function(data) {
                    location.reload();
                }
            });
        });
    });
    </script>
</head>
<body>
    <div class="container">
        <div class="cart-info">
            <header>
                <h2>장바구니</h2>
            </header>

            <c:set var="totalPrice" value="0" />

            <c:forEach var="item" items="${sessionScope.cart}">
                <div class="cart-item">
                    <form action="updateCart" method="post">
                        <c:set var="product" value="${productDetails[item.key]}" />
                        <p>상품 ID: ${item.key}</p>
                        <p>상품 이름: ${product.p_NAME}</p>
                        <p class="product-image"><img src="${product.p_IMAGE}" alt="${product.p_NAME}" /></p>
                        <p>상품 가격: <fmt:formatNumber value="${product.p_PRICE}" type="currency" currencySymbol="₩"/></p>
                        <p>수량: 
                            <input type="number" name="quantity" value="${item.value}" min="1" />
                            <input type="hidden" name="p_NO" value="${item.key}" />
                            <input type="submit" value="수량 변경하기" />
                        </p>
                    </form>
                    <form action="removeFromCart" method="post">
                        <input type="hidden" name="p_NO" value="${item.key}" />
                        <input type="submit" value="제거하기" />
                    </form>
                    <c:set var="totalPrice" value="${totalPrice + (product.p_PRICE * item.value)}" />
                </div>
            </c:forEach>

            <h3 class="total-price">총 가격: <fmt:formatNumber value="${totalPrice}" type="currency" currencySymbol="₩"/></h3>
            <a href="/tp/Shop/purchaseConfirm" class="purchase-button">구매하기</a>
        </div>

        <div class="common-login">
            <jsp:include page="/WEB-INF/views/Login/commonLogin.jsp"/>
        </div>
    </div>
</body>
</html>
