<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%@ page
language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Home</title>
    <c:set var="cp" value="${pageContext.request.contextPath}"></c:set>
  </head>
  <body>
    <header>
      <h1><a href="${cp}/">Hello world!</a></h1>
    </header>
    <nav>
      <a href="./Shop/main">쇼핑몰</a>
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
