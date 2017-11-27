<!DOCTYPE html>
<html>
<body>
<h1>Hello ${name}</h1>
<p>${message}</p>
<a href="/alert">Send alert</a>

<script>
    var latitude;
    var longitude;

    function getLocation() {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(showPosition, err);
        }
        return false;
    }

    function showPosition(position) {
        console.log('lat: ' + position.coords.latitude);
        console.log('long: ' + position.coords.longitude);
        latitude = position.coords.latitude;
        longitude = position.coords.longitude;
    }

    function err(error) {
        console.log('error: ' + error.message);
        alert(error.message);
    }

    setInterval(function () {
        console.log("inside interval");
        getLocation();
        setTimeout(function() {
            window.location.href = '/user/update?latitude=' + latitude + '&longitude=' + longitude;
        }, 5000);
    }, 60 * 1000);
</script>

</body>
</html>