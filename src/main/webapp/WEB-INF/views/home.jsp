<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDEENR2roiOLyMjj7Emo1PRmTqf98qJGrU"></script> 
	<title>Home</title>
</head>
<body>
<P>  The time on the server is ${serverTime}. </P>
남준우
남준우 프로젝트 브랜치
 <div id="map" style="width:100%; height: 100vh;"></div>
  <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDEENR2roiOLyMjj7Emo1PRmTqf98qJGrU&callback=initMap&region=kr"></script>
  <script>
    function initMap() {
      var seoul = { lat: 37.5642135 ,lng: 127.0016985 };
      var map = new google.maps.Map(
        document.getElementById('map'), {
          zoom: 12,
          center: seoul
        });
      
    }
  </script>
</body>
</html>
