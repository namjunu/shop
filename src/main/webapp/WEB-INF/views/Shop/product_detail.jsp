<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${product.pName} Details</title>
</head>
<body>
    <h1>${product.pName}</h1>
    <img src="${product.pImage}" alt="${product.pName} Image" width="300">
    <p>Price: ${product.pPrice}</p>
    <p>Brand: ${product.pBrand}</p>
    <p>Description: ${product.pDescription}</p>
    <p>Category: ${product.pCategory}</p>
    <p>Stock: ${product.pStock}</p>
    <p>Tags: ${product.pTags}</p>
    <!-- 장바구니에 담기 폼 시작 -->
    <form action="<c:url value='/Shop/addToCart'/>" method="post">
        <input type="hidden" name="p_NO" value="${product.pNo}"/>
        <label for="quantity">Quantity:</label>
        <input type="number" id="quantity" name="quantity" value="1" min="1"/>
        <button type="submit">Add to Cart</button>
    </form>
    <!-- 장바구니에 담기 폼 끝 -->


    <a href="<c:url value='/Shop/main'/>">Back to Product List</a>
    <aside class="login-panel">
        <jsp:include page="/WEB-INF/views/Login/commonLogin.jsp"/>
    </aside>
</body>
</html>
