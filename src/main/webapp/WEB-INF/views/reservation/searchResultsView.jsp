<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.teamp.spring.tp.dto.ReservationVo" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>예약 조회 결과</h2>
    <table>
        <tr>
            <th>예약자 이름</th>
            <th>예약 날짜</th>
            <th>병원 이름</th>
        </tr>
        <!-- 예약 조회 결과를 반복해서 표시하는 코드 -->
        <%
            ArrayList<ReservationVo> searchResults = (ArrayList<ReservationVo>) request.getAttribute("searchResults");
            if (searchResults != null && !searchResults.isEmpty()) {
                for (ReservationVo result : searchResults) {
        %>
        <tr>
            <td><%= result.getR_name() %></td>
            <td><%= result.getR_date() %></td>
            <td><%= result.getR_hospital_name() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="3">검색 결과가 없습니다.</td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>