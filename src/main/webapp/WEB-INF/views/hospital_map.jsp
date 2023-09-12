<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>서울삼성병원 지도</title>
    <style>
        #map {
            width: 400px;
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
    <h1 id="hospitalName">삼성서울병원</h1>
    <div id="map"></div>

    <!-- jQuery 라이브러리를 추가합니다 -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <!-- Kakao Maps API 스크립트를 추가합니다 -->
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=480d6b066347f57f4f5e316ebd771566&libraries=services"></script>

    <!-- jQuery 코드를 추가합니다 -->
    <script>
        $(document).ready(function() {
            var mapOpened = false; // 지도 상태를 나타내는 변수

            // 서울삼성병원 정보를 클릭할 때 지도를 열고 닫기
            $("#hospitalName").click(function() {
                if (!mapOpened) { // 지도가 열려있지 않으면 열기
                    var mapContainer = document.getElementById('map');
                    var mapOption = {
                        center: new kakao.maps.LatLng(33.450701, 126.570667),
                        level: 3
                    };

                    // 지도를 생성
                    var map = new kakao.maps.Map(mapContainer, mapOption);

                    // 주소-좌표 변환 객체를 생성
                    var geocoder = new kakao.maps.services.Geocoder();

                    // 주소로 좌표를 검색
                    geocoder.addressSearch('서울 강남구 일원로 81', function(result, status) {
                        // 정상적으로 검색이 완료되면
                        if (status === kakao.maps.services.Status.OK) {
                            var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

                            // 결과값으로 받은 위치를 마커로 표시
                            var marker = new kakao.maps.Marker({
                                map: map,
                                position: coords
                            });

                            // 인포윈도우로 장소에 대한 설명을 표시
                            var infowindow = new kakao.maps.InfoWindow({
                                content: '<div style="width:100px;text-align:center;padding:6px 0;"><a href="https://place.map.kakao.com/7922895" target="_blank">삼성서울병원</a></div>'
                            });
                            infowindow.open(map, marker);

                            // 지도의 중심을 결과값으로 받은 위치로 이동
                            map.setCenter(coords);
                            mapOpened = true; // 지도 상태를 열림으로 설정
                        }
                    });
                } else { // 지도가 열려있으면 닫기
                    $("#map").empty(); // 지도 컨테이너를 비움
                    mapOpened = false; // 지도 상태를 닫힘으로 설정
                }
            });
        });
    </script>
</body>
</html>