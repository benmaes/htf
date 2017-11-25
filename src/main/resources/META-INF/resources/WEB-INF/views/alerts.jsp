<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<body>
<h1>Alerts</h1>
<table>
    <c:forEach items="${alerts}" var="alert" varStatus="loop">
        <tr>
            <td><a href="/alert/${alert.id}"><c:out value="${alert.id}" /></a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>