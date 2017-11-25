<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>
        #map {
            height: 600px;
            width: 100%;
        }
    </style>
</head>
<body>
<h1>Users</h1>
<table>
    <c:forEach items="${users}" var="user" varStatus="loop">
        <tr>
            <td><a href="/user/${user.id}"><c:out value="${user.id}" /></a></td>
            <td><c:out value="${user.name}" /></td>
        </tr>
    </c:forEach>
</table>
<div id="map"></div>
<script>
    function initMap() {
        var uluru = {lat: 51.1590922, lng: 4.8059956};
        var map = new google.maps.Map(document.getElementById('map'), {
            zoom: 15,
            center: uluru
        });

        ${list}.forEach(function(user) {
            var marker = new google.maps.Marker({
                position: {lat: user.lastLatitude, lng: user.lastLongitude},
                map: map,
                title : '' + user.name + ''
            });
        });
    }
</script>
<script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCnM6BINCXdYOy82I5t4WhhvOzcComBWU0&callback=initMap">
</script>
</body>
</html>