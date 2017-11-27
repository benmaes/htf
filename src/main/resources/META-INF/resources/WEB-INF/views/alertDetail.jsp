<!DOCTYPE html>
<html>
<head>
    <style>
        #map {
            height: 400px;
            width: 100%;
        }
    </style>
</head>
<body>
<h1>Alert ${alert.id}</h1>
<p>${alert.message}</p>
<div id="map"></div>
<img src="${image}"/>
<script>
    function initMap() {
        var uluru = {lat: ${alert.latitude}, lng: ${alert.longitude}};
        var map = new google.maps.Map(document.getElementById('map'), {
            zoom: 15,
            center: uluru
        });
        var marker = new google.maps.Marker({
            position: uluru,
            map: map
        });
    }
</script>
<script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCnM6BINCXdYOy82I5t4WhhvOzcComBWU0&callback=initMap">
</script>
</body>
</html>