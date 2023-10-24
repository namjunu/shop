<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<c:url value='/resources/css/shop_styles.css'/>">
    <title>${product.p_NAME} 상세정보</title>
     <style>
		.container {
            display: flex;
            flex-direction: row; /* 수정: 가로로 요소 나열 */
            align-items: flex-start;
            text-align: left;
        }

        .product-image {
            flex-basis: 30%; /* 수정: 1/3 크기로 설정 */
        }

        .product-info {
            flex-basis: 30%; /* 수정: 1/3 크기로 설정 */
            padding: 10px;
        }

        .product-info h1,
        .product-info p {
            margin: 5px 0;
        }

        .product-info form {
            display: flex;
            flex-direction: column;
            gap: 10px;
        }

        .common-login {
            flex-basis: 30%; /* 수정: 1/3 크기로 설정 */
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="product-image">
            <img src="${product.p_IMAGE}" alt="${product.p_NAME}" width="100%">
        </div>
        <div class="product-info">
            <header>
                <h1>${product.p_NAME} 상세정보</h1>
            </header>
        
        <c:choose>
            <c:when test="${U_ID == 'admin'}">
                <form action="<c:url value='/Shop/updateProduct'/>" method="post">
                    <input type="hidden" id="P_NO" name="P_NO" value="${product.p_NO}"/>
                    
                    <label for="P_NAME">제품명:</label>
                    <input type="text" id="P_NAME" name="P_NAME" value="${product.p_NAME}"/><br>
                    
                    <label for="P_PRICE">가격:</label>
                    <input type="number" id="P_PRICE" name="P_PRICE" value="${product.p_PRICE}"/><br>
                    
                    <label for="P_BRAND">브랜드:</label>
                    <input type="text" id="P_BRAND" name="P_BRAND" value="${product.p_BRAND}"/><br>
                    
                    <label for="P_DESCRIPTION">설명:</label>
                    <input type="text" id="P_DESCRIPTION" name="P_DESCRIPTION" value="${product.p_DESCRIPTION}"/><br>
                    
                    <label for="P_CATEGORY">카테고리:</label>
                    <input type="text" id="P_CATEGORY" name="P_CATEGORY" value="${product.p_CATEGORY}"/><br>
                    
                    <label for="P_STOCK">재고:</label>
                    <input type="number" id="P_STOCK" name="P_STOCK" value="${product.p_STOCK}"/><br>
                    
                    <label for="P_IMAGE">이미지URL:</label>
                    <input type="text" id="P_IMAGE" name="P_IMAGE" value="${product.p_IMAGE}"/><br>
                    
                    <button type="submit">제품정보 업데이트</button>
                </form>
            </c:when>
            <c:otherwise>
                <h1>${product.p_NAME}</h1>
                <img src="${product.p_IMAGE}" alt="${product.p_NAME} Image" width="300">
                <p>가격: ${product.p_PRICE}</p>
                <p>브랜드: ${product.p_BRAND}</p>
                <p>설명: ${product.p_DESCRIPTION}</p>
                <p>카테고리: ${product.p_CATEGORY}</p>
                <p>재고: ${product.p_STOCK}</p>
            </c:otherwise>
        </c:choose>
        
        <!-- 장바구니에 담기 폼 시작 -->
        <form action="<c:url value='/Shop/addToCart'/>" method="post">
            <input type="hidden" name="P_NO" value="${product.p_NO}"/>
            <label for="quantity">수량:</label>
            <input type="number" id="quantity" name="quantity" value="1" min="1"/>
            <button type="submit">장바구니에 담기</button>
        </form>
        
        <a href="<c:url value='/Shop/main'/>">쇼핑몰 페이지로 돌아가기</a>
        </div>
                <aside class="common-login">
            <jsp:include page="/WEB-INF/views/Login/commonLogin.jsp"/>
        </aside>
        </div>

</body>
</html>
