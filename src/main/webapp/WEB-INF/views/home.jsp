<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> ======= <%@ page language="java" contentType="text/html;
charset=UTF-8" pageEncoding="UTF-8"%> >>>>>>> SonMyungGyun <%@ page
session="false" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Home</title>
    <c:set var="cp" value="${pageContext.request.contextPath}"></c:set>
    <link rel="stylesheet" href="<c:url value='/resources/css/styles.css'/>" />
    <!-- 경로를 수정하세요 -->
  </head>
  <body>
    <header>
      <h1>Hello world!</h1>
    </header>
    <nav>
      <a href="${cp}/jang/Kiosk">보험 키오스크 이동</a>
      <a href="./Shop/main">쇼핑몰</a>
      <a href="/searchMap">주변병원 검색</a>
    </nav>
    <div class="container">
      <main class="main-content">
        <p>The time on the server is ${serverTime}.</p>
      </main>
      <aside class="login-panel">
        <jsp:include page="Login/commonLogin.jsp" />
      </aside>
    </div>
  </body>
</html>
