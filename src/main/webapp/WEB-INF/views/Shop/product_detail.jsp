<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<c:url value='/resources/css/shop_styles.css'/>">
    <title>${product.p_NAME} Details</title>
     <style>
        /* 추가된 CSS 코드 */
        .container {
            display: flex;
            flex-direction: column;
            align-items: flex-start;
            text-align: left;
        }

        .product-image {
            width: 300px; /* 이미지 크기 조정 */
        }

        .product-info {
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
        
        .login-panel {
            order: -1; /* 로그인 패널을 가장 위로 이동 */
            margin-bottom: 20px; /* 로그인 패널과 아래 내용 사이 여백 추가 */
        }

        .main-links {
            flex-grow: 0; /* 메인 페이지 링크가 너무 확장되지 않도록 설정 */
            padding: 10px; /* 링크 영역 패딩 추가 */
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
                <h1>${product.p_NAME} Details</h1>
            </header>
        
        <c:choose>
            <c:when test="${U_ID == 'admin'}">
                <form action="<c:url value='/Shop/updateProduct'/>" method="post">
                    <input type="hidden" id="P_NO" name="P_NO" value="${product.p_NO}"/>
                    
                    <label for="P_NAME">Product Name:</label>
                    <input type="text" id="P_NAME" name="P_NAME" value="${product.p_NAME}"/><br>
                    
                    <label for="P_PRICE">Price:</label>
                    <input type="number" id="P_PRICE" name="P_PRICE" value="${product.p_PRICE}"/><br>
                    
                    <label for="P_BRAND">Brand:</label>
                    <input type="text" id="P_BRAND" name="P_BRAND" value="${product.p_BRAND}"/><br>
                    
                    <label for="P_DESCRIPTION">Description:</label>
                    <input type="text" id="P_DESCRIPTION" name="P_DESCRIPTION" value="${product.p_DESCRIPTION}"/><br>
                    
                    <label for="P_CATEGORY">Category:</label>
                    <input type="text" id="P_CATEGORY" name="P_CATEGORY" value="${product.p_CATEGORY}"/><br>
                    
                    <label for="P_STOCK">Stock:</label>
                    <input type="number" id="P_STOCK" name="P_STOCK" value="${product.p_STOCK}"/><br>
                    
                    <label for="P_IMAGE">Image URL:</label>
                    <input type="text" id="P_IMAGE" name="P_IMAGE" value="${product.p_IMAGE}"/><br>
                    
                    <button type="submit">Update Product</button>
                </form>
            </c:when>
            <c:otherwise>
                <h1>${product.p_NAME}</h1>
                <img src="${product.p_IMAGE}" alt="${product.p_NAME} Image" width="300">
                <p>Price: ${product.p_PRICE}</p>
                <p>Brand: ${product.p_BRAND}</p>
                <p>Description: ${product.p_DESCRIPTION}</p>
                <p>Category: ${product.p_CATEGORY}</p>
                <p>Stock: ${product.p_STOCK}</p>
            </c:otherwise>
        </c:choose>
        
        <!-- 장바구니에 담기 폼 시작 -->
        <form action="<c:url value='/Shop/addToCart'/>" method="post">
            <input type="number" name="P_NO" value="${product.p_NO}"/>
            <label for="quantity">Quantity:</label>
            <input type="number" id="quantity" name="quantity" value="1" min="1"/>
            <button type="submit">Add to Cart</button>
        </form>
        
        <a href="<c:url value='/Shop/main'/>">Back to Product List</a>
        </div>
        </div>
        <aside class="login-panel">
            <jsp:include page="/WEB-INF/views/Login/commonLogin.jsp"/>
        </aside>
</body>
</html>
