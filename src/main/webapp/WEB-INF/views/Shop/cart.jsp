<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function() {
    // Quantity update
    $("input[value='수량 변경하기']").on('click', function(event) {
        event.preventDefault();
        var form = $(this).closest('form');
        var p_NO = form.find("input[name='p_NO']").val();
        var quantity = form.find("input[name='quantity']").val();
        var action = form.attr('action');
        
        $.ajax({
            url: action,
            type: 'POST',
            data: { p_NO: p_NO, quantity: quantity },
            success: function(data) {
                location.reload();
            }
        });
    });
    
    // Remove item
    $("input[value='제거하기']").on('click', function(event) {
        event.preventDefault();
        var form = $(this).closest('form');
        var p_NO = form.find("input[name='p_NO']").val();
        var action = form.attr('action');
        
        $.ajax({
            url: action,
            type: 'POST',
            data: { p_NO: p_NO },
            success: function(data) {
                location.reload();
            }
        });
    });
});
</script>
</head>
<body>

<h2>장바구니</h2>

<c:set var="totalPrice" value="0" />

<c:forEach var="item" items="${cartFromDB}">
    <div>
        <form action="updateCart" method="post">
            <c:set var="product" value="${productDetails[item.p_NO]}" />
            <p>상품 ID: ${item.p_NO}</p>
            <p>상품 이름: ${product.pName}</p>
            <p>상품 이미지: <img src="${product.pImage}" alt="${product.pName}" /></p>
            <p>상품 가격: <fmt:formatNumber value="${product.pPrice}" type="currency" currencySymbol="₩"/></p>
            <p>수량: 
                <input type="number" name="quantity" value="${item.quantity}" min="1" />
                <input type="hidden" name="p_NO" value="${item.p_NO}" />
                <input type="submit" value="수량 변경하기" />
            </p>
        </form>
        <form action="removeFromCart" method="post">
            <input type="hidden" name="p_NO" value="${item.p_NO}" />
            <input type="submit" value="제거하기" />
        </form>
        <c:set var="totalPrice" value="${totalPrice + (product.pPrice * item.quantity)}" />
    </div>
</c:forEach>

<h3>총 가격: <fmt:formatNumber value="${totalPrice}" type="currency" currencySymbol="₩"/></h3>

</body>
</html>
