<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<h1>User ${user.name}</h1>

<table>
    <c:forEach items="${historiek}" var="item" varStatus="loop">
        <tr>
            <td><c:out value="${item.date}" /></td>
            <td><c:out value="${item.latitude}" /></td>
            <td><c:out value="${item.longitude}" /></td>
        </tr>
    </c:forEach>
</table>

<div id="map"></div>
<script>
    function initMap() {
        var uluru = {lat: ${user.lastLatitude}, lng: ${user.lastLongitude}};
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