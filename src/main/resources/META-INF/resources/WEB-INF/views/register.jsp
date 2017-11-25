<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<body>
<h1>Register</h1>
<form th:action="@{/register}" th:object="${registration}" method="post">
    <fieldset>
        <legend>Please Login</legend>
        <label for="name">Name</label>
        <input type="text" id="name" name="name" required="true" th:field="*{name}"/>
        <label for="username">Username</label>
        <input type="text" id="username" name="username" required="true" th:field="*{username}"/>
        <label for="password">Password</label>
        <input type="password" id="password" name="password" required="true" th:field="*{password}"/>
        <div class="form-actions">
            <input type="submit" value="Register"/>
        </div>
    </fieldset>
</form>
</body>
</html>