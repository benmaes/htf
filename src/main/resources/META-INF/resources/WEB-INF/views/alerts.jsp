<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
    <script src="sockjs-0.3.4.min.js"></script>
    <script src="stomp.min.js"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<h1>Alerts</h1>

<div id = "newAlert"></div>

<table>
    <c:forEach items="${alerts}" var="alert" varStatus="loop">
        <tr>
            <td><a href="/alert/${alert.id}"><c:out value="${alert.id}" /></a></td>
            <td>${alert.message}</td>
        </tr>
    </c:forEach>
</table>

<!-- Javascript functions -->
<script>

    /**
     * Open the web socket connection and subscribe the "/notify" channel.
     */
    function connect() {

        // Create and init the SockJS object
        var socket = new SockJS('/ws');
        var stompClient = Stomp.over(socket);

        // Subscribe the '/notify' channell
        stompClient.connect({}, function(frame) {
            stompClient.subscribe('/user/queue/notify', function(notification) {

                // Call the notify function when receive a notification
                notify(JSON.parse(notification.body).message);

            });
        });

        return;
    } // function connect

    /**
     * Display the notification message.
     */
    function notify(message) {
        var id = message.substring(message.lastIndexOf("[")+1,message.lastIndexOf("]"));
        bootstrap_alert.warning(message, "/alert/" + id);
        return;
    }

    bootstrap_alert = function() {};
    bootstrap_alert.warning = function(message, url) {
        $("#newAlert").html('<div class="alert alert-danger alert-dismissable">\n' +
            '    <a href="#" data-dismiss="alert" aria-label="close">×</a>\n' +
            '    <strong>Danger!</strong> <a id="alertLink" href="' + url + '" class="alert-link">' + message + '</a>\n' +
            '</div>');
    }

    /**
     * Init operations.
     */
    $(document).ready(function() {

        // Start the web socket connection.
        connect();

    });

</script>
</body>
</html>