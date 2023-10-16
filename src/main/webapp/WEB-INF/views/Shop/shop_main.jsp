<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>제품 목록</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/Login/commonLogin.jsp"/>
    <h1>제품 목록</h1>
    
    <table border="1">
        <tr>
            <th>제품 번호</th>
            <th>제품 이름</th>
            <th>가격</th>
            <th>이미지</th>
        </tr>
        <c:forEach items="${productList}" var="product" begin="0" end="24">
	    <tr>
	        <td>${product.pNo}</td>
	        <td>${product.pName}</td>
	        <td>${product.pPrice}</td>
	        <td>
	            <a href="<c:url value='/Shop/product_detail/${product.pNo}'/>">
	                <img src="${product.pImage}" alt="${product.pName} 이미지" width="100">
	            </a>
	        </td>
	    </tr>
	</c:forEach>

    </table>

    <!-- 페이지 이동을 위한 링크 -->
    <c:set var="currentPage" value="${param.page == null ? 1 : param.page}" />
    <c:set var="itemsPerPage" value="25" />
    <c:set var="totalItems" value="${productList.size()}" />
    <c:set var="totalPages" value="${(totalItems + itemsPerPage - 1) / itemsPerPage}" />

    <div>
        <c:choose>
            <c:when test="${currentPage > 1}">
                <a href="?page=1">첫 페이지</a>
                <a href="?page=${currentPage - 1}">이전 페이지</a>
            </c:when>
            <c:otherwise>
                <span>첫 페이지</span>
                <span>이전 페이지</span>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${currentPage < totalPages}">
                <a href="?page=${currentPage + 1}">다음 페이지</a>
                <a href="?page=${totalPages}">마지막 페이지</a>
            </c:when>
            <c:otherwise>
                <span>다음 페이지</span>
                <span>마지막 페이지</span>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>