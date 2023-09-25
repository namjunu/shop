<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>주변 병원 찾기</title>
    <style>
        #map {
            width: 100%;
            height: 400px;
        }
		 /* link - 아직 클릭하지 않은 경우 black 색상 설정 */
		 a:link { color: black; text-decoration: none;}	
		 /* visited - 한번 클릭하거나 전에 클릭한적 있을 경우 black 설정 */
		 a:visited { color: black; text-decoration: none;}	
		 /* hover - 마우스를 해당 링크에 위치했을 경우 black 설정 */
		 a:hover { color: black; text-decoration: none;}
    </style>
</head>
<body>
	
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
	}

	// 마커를 표시하고 인포윈도우를 열어주는 함수
	function displayMarker(map, place) {
	    var marker = new kakao.maps.Marker({
	        map: map,
	        position: new kakao.maps.LatLng(place.y, place.x)
	    });

	    kakao.maps.event.addListener(marker, 'click', function () {
	        infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + '</div>');
	        infowindow.open(map, marker);
	    });
	}
	</script>
</body>
</html>