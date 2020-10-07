<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
</head>
<body>
<div id="map" style="width:70%; height: 70vh;"></div>
  <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBoamQbwWnYDw_iXu9q-JSZsQpgHksPaak&callback=initMap&region=kr"></script>
  <script>
    function initMap() {
      var locations = [
    	  ['신촌역', 37.555158, 126.936859],
    	  ['서강대역', 37.551935, 126.935768]
    	];
      var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 17,
          center: new google.maps.LatLng(37.553677, 126.936472),
          mapTypeId: google.maps.MapTypeId.ROADMAP
        });
      
      for (var i = 0; i < locations.length; i++) {
					marker = new google.maps.Marker({
						id: i,
						position: new google.maps.LatLng(locations[i][1], locations[i][2]),
						map: map
					})
			}
      
    }
  </script>
</body>
</html>