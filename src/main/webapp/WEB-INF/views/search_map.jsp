<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>주변 병원 찾기</title>
    <c:set var="cp" value="${pageContext.request.contextPath}"></c:set>
    <script src="/resources/reservation.js"></script>
    <link rel="stylesheet" href="<c:url value='/resources/css/styles.css'/>"> 
    <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.css'/>"> 
    <style>
        #map {
		    width: 80%;
		    height: 800px;
		    border: 2px solid #333; /* 테두리 추가 */
		    box-shadow: 0 0 10px rgba(0, 0, 0, 0.2); /* 그림자 효과 추가 */
		    border-radius: 10px; /* 모서리를 둥글게 만듦 */
        }
    </style>
</head>
<body>
	<header>
		<h1><a href="${cp}/">Hello world!</a></h1>
	</header>
<nav>
    <a href ="${cp}/jang/Kiosk">보험 키오스크 이동</a>
    <a href="./Shop/main">쇼핑몰</a>
    <a href="${cp}/searchMap">주변병원 검색</a>
    <a href="${cp}/board/BoardList">게시판</a>
</nav>
<div class="container">
    <div id="map"></div>
    <!-- Kakao Maps API 스크립트를 추가 -->
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=480d6b066347f57f4f5e316ebd771566&libraries=services"></script>
    <script>
    var infowindow = new kakao.maps.InfoWindow({ zIndex: 1 });

    var mapContainer = document.getElementById('map'); // 지도를 표시할 div

    // 사용자의 현재 위치를 가져오는 부분
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
            var lat = position.coords.latitude; // 위도
            var lon = position.coords.longitude; // 경도

            var mapOption = {
                center: new kakao.maps.LatLng(lat, lon), // 사용자의 현재 위치로 중심 좌표 설정
                level: 5 // 지도의 확대 레벨 (원하는 수준으로 조정)
            };

            // 지도를 생성
            var map = new kakao.maps.Map(mapContainer, mapOption);

            var locPosition = new kakao.maps.LatLng(lat, lon);

            // 마커와 인포윈도우를 표시합니다
            displayMarker(map, locPosition, message);

            // 장소 검색 객체를 생성
            var ps = new kakao.maps.services.Places(map);

            // 카테고리로 병원을 검색
            ps.categorySearch('HP8', placesSearchCB, { useMapBounds: true });

            // 키워드 검색 완료 시 호출되는 콜백함수
            function placesSearchCB(data, status, pagination) {
                if (status === kakao.maps.services.Status.OK) {
                    for (var i = 0; i < data.length; i++) {
                        displayMarker(map, data[i]);
                    }
                }
            }
            
            // 병원을 클릭했을 때 세션에 병원 이름 저장
            function onHospitalClick(placeName) {
                // 병원 이름을 세션에 저장
                sessionStorage.setItem('selectedHospital', placeName);
                // 예약 관리 페이지로 이동
                window.location.href = 'reservationMain?hospital=' + encodeURIComponent(placeName);
            }
        });
    } else { // HTML5의 GeoLocation을 사용할 수 없을 때 기본 위치로 설정
        var mapOption = {
            center: new kakao.maps.LatLng(33.450701, 126.570667),
            level: 4 // 기본 확대 레벨
        };

        // 지도를 생성
        var map = new kakao.maps.Map(mapContainer, mapOption);

        var locPosition = new kakao.maps.LatLng(33.450701, 126.570667);
        var message = 'geolocation을 사용할 수 없어 기본 위치로 이동합니다.';

        // 마커와 인포윈도우를 표시합니다
        displayMarker(map, locPosition, message);

        // 장소 검색 객체를 생성
        var ps = new kakao.maps.services.Places(map);

        // 카테고리로 병원을 검색
        ps.categorySearch('HP8', placesSearchCB, { useMapBounds: true });

        // 키워드 검색 완료 시 호출되는 콜백함수
        function placesSearchCB(data, status, pagination) {
            if (status === kakao.maps.services.Status.OK) {
                for (var i = 0; i < data.length; i++) {
                    displayMarker(map, data[i]);
                }
            }
        }
        
        // 병원을 클릭했을 때 세션에 병원 이름 저장
        function onHospitalClick(placeName) {
            // 병원 이름을 세션에 저장
            sessionStorage.setItem('selectedHospital', placeName);
            // 예약 관리 페이지로 이동
            window.location.href = 'reservationMain?hospital=' + encodeURIComponent(placeName);
        }
    }
    
    // 예약하기 버튼을 클릭했을 때 이벤트 핸들러
    function onReserveClick(placeName) {
        // 병원 이름을 URL 매개변수로 전달
        window.location.href = 'reservationMain?hospital=' + encodeURIComponent(placeName);
    }

    // 마커를 표시하고 인포윈도우를 열어주는 함수
    function displayMarker(map, place) {
        var marker = new kakao.maps.Marker({
            map: map,
            position: new kakao.maps.LatLng(place.y, place.x)
        });

        kakao.maps.event.addListener(marker, 'click', function () {
            var content = '<div style="padding:5px;font-size:12px;">' + place.place_name + '</div>';
            content += '<a href="#" onclick="onReserveClick(\'' + place.place_name + '\')">예약하기</a>';
            
            infowindow.setContent(content);
            infowindow.open(map, marker);
        });
    }
    </script>
    </div>
</body>
</html>