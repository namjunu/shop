<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>제품 등록</title>
</head>
<body>
    <h1>제품 등록</h1>
     <style>
        body {
            margin-top: 15%;
            margin-left: 30%;
            margin-right: 30%;
            text-align: center;
        }

        form {
            text-align: left;
        }
    </style>
    <form action="<c:url value='/Shop/insertProduct'/>" method="post">
        <label for="P_NAME">제품 이름:</label>
        <input type="text" id="P_NAME" name="P_NAME" required><br>

        <label for="P_PRICE">가격:</label>
        <input type="number" id="P_PRICE" name="P_PRICE" required><br>

        <label for="P_BRAND">브랜드:</label>
        <input type="text" id="P_BRAND" name="P_BRAND"><br>

        <label for="P_DESCRIPTION">설명:</label>
        <input type="text" id="P_DESCRIPTION" name="P_DESCRIPTION"><br>

        <label for="P_CATEGORY">카테고리:</label>
        <input type="text" id="P_CATEGORY" name="P_CATEGORY"><br>

        <label for="P_STOCK">재고:</label>
        <input type="number" id="P_STOCK" name="P_STOCK" required><br>

        <label for="P_IMAGE">이미지 URL:</label>
        <input type="text" id="P_IMAGE" name="P_IMAGE"><br>

        <label for="P_TAGS">태그:</label>
        <input type="text" id="P_TAGS" name="P_TAGS"><br>

        <button type="submit">등록하기</button>
    </form>

    <a href="<c:url value='/Shop/main'/>">돌아가기</a>
</body>
</html>