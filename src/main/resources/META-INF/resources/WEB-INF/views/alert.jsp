<!DOCTYPE html>
<html>
<body>
<h1>Alert</h1>

<form id='form' method="post" enctype="multipart/form-data"
    onsubmit="return getLocation()">
    <input id='file' type="file" name="file" accept="image/*"/>
    <input id="latitude" name="latitude" type="hidden"/>
    <input id="longitude" name="longitude" type="hidden"/>
    <input type="submit" value="Submit"/>
</form>

<script>
    var latitude = document.getElementById('latitude');
    var longitude = document.getElementById('longitude');

    function getLocation() {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(showPosition, err);
        }
        return false;
    }

    function showPosition(position) {
        latitude.value = position.coords.latitude;
        longitude.value = position.coords.longitude;
        document.getElementById('form').submit();
    }

    function err(error) {
        console.log('error: ' + error.message);
        alert(error.message);
    }
</script>
</body>
</html>