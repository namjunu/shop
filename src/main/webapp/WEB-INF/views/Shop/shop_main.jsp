<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<c:url value='/resources/css/shop_styles.css'/>">
    <title>제품 목록</title>
</head>
<body>
<!-- 페이징 하기 위한 준비 -->
<c:set var="currentPage" value="${param.page == null ? 1 : param.page}" />
<c:set var="itemsPerPage" value="15" />
<c:set var="begin" value="${(currentPage - 1) * itemsPerPage}" />
<c:set var="end" value="${begin + itemsPerPage - 1}" />
<div class="container">
	<div class="sidebar">
	<div class="main-content">
    <header>
        <h1>제품 목록</h1>
    </header>
        <form action="/tp/Shop/productList" method="get">
            <label for="P_CATEGORY">카테고리:</label>
            <select name="P_CATEGORY" id="P_CATEGORY">
                <option value="" selected>없음</option>
                <option value="1">식류</option>
                <option value="2">의류</option>
                <option value="3">전자제품</option>
                <!-- 카테고리 추가하기 -->
            </select>
            
            <label for="keyword">검색어:</label>
            <input type="text" id="keyword" name="keyword" placeholder="상품 검색하기">
            
            <input type="submit" value="검색하기">
            <c:if test="${U_ID == 'admin' }">
            	<a href="/tp/Shop/insertProduct">제품 추가하기</a>
            </c:if>
        </form>
        <table>
            <tr>
                <th>제품 번호</th>
                <th>제품 이름</th>
                <th>가격</th>
                <th>이미지</th>
            </tr>
            <c:forEach items="${productList}" var="product" begin="${begin}" end="${end}">
                <tr>
                    <td>${product.p_NO}</td>
                    <td>
	                    <a href="<c:url value='/Shop/productDetail?P_NO=${product.p_NO}'/>">
	                            ${product.p_NAME}
	                    </a>
                    </td>
                    <td>${product.p_PRICE}</td>
                    <td>
                        <a href="<c:url value='/Shop/productDetail?P_NO=${product.p_NO}'/>">
                            <img src="${product.p_IMAGE}" alt="${product.p_NAME} 이미지" style="max-width: 100px; max-height: 100px;">
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <!-- 페이지 이동을 위한 링크 -->
        <div>
            <c:set var="currentPage" value="${param.page == null ? 1 : param.page}" />
            <c:set var="itemsPerPage" value="25" />
            <c:set var="totalItems" value="${productList.size()}" />
            <c:set var="totalPages" value="${(totalItems + itemsPerPage - 1) / itemsPerPage}" />

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
    </div>
    </div>
            <div class="common-login">
	            <jsp:include page="/WEB-INF/views/Login/commonLogin.jsp"/>
	        </div>
    </div>
</body>
</html>
