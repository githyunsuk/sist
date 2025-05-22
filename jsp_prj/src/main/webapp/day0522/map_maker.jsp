<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info=""%>
<%@ include file="../common/jsp/site_config.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${ site_name }" /></title>
<c:import url="${ url }/common/jsp/external_file.jsp" />
<style type="text/css">
#container {
	min-height: 600px;
	margin-top: 30px;
	margin-left: 20px
}
</style>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0f0b3bb7c0f56621f9817ea53cbc8e85"></script>
<script>
	var map;
	$(function() {

		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(37.499326, 127.033188), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

		setMarker(37.499326, 127.033188);
		//마커 표현
		// marker.setMap(null);

	});//ready

	function setCenter(lat, lng) {
		// 이동할 위도 경도 위치를 생성합니다 
		var moveLatLon = new kakao.maps.LatLng(lat, lng);

		// 지도 중심을 이동 시킵니다
		map.setCenter(moveLatLon);
	}

	function setMarker(lat, lng) {
		setCenter(lat, lng);//지도 위치를 가운데로 이동
		// 마커가 표시될 위치입니다 
		//위도(latitude) : 37.499326
		//경도(longtitude) : 127.033188
		var markerPosition = new kakao.maps.LatLng(lat, lng);

		// 마커를 생성합니다
		var marker = new kakao.maps.Marker({
			position : markerPosition
		});

		// 마커가 지도 위에 표시되도록 설정합니다
		marker.setMap(map);
		
		//인포윈도우 띄우기
		var iwContent = '<div style="padding:5px;">Hello World! <br><a href="https://map.kakao.com/link/map/Hello World!,33.450701,126.570667" style="color:blue" target="_blank">인사메시지 보기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
		iwPosition = new kakao.maps.LatLng(lat, lng); //인포윈도우 표시 위치입니다

		//인포윈도우를 생성합니다
		var infowindow = new kakao.maps.InfoWindow({
			position : iwPosition,
			content : iwContent
		});

		//마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
		infowindow.open(map, marker);
	}
</script>

<script type="text/javascript">
	$(function() {
		$("#btn").click(function() {
			//37.498196, 127.031596
			setMarker(37.498196, 127.031596);
		});
	});//read
</script>
</head>
<body>
	<header data-bs-theme="dark">
		<c:import url="${ url }/common/jsp/header.jsp" />
	</header>
	<main>
		<div id="container">

			<div id="map" style="width: 600px; height: 400px;"></div>

			<input type="button" value="제주은희네" class="btn btn-info" id="btn">

		</div>
	</main>
	<footer class="text-body-secondary py-5">
		<c:import url="${ url }/common/jsp/footer.jsp" />
	</footer>

</body>
</html>