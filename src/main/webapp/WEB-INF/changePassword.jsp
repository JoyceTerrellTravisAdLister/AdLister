<%--
  Created by IntelliJ IDEA.
  User: brose
  Date: 10/27/17
  Time: 1:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/profile/password" method="POST">
<%-- new- password field--%>
<div class="form-group">
    <label for="new-password">Old Password</label>
    <input id="new-password" name="new-password" class="form-control" type="password">
</div>
<%--Confirm new-password--%>
<div class="form-group">
    <label for="confirm-new-password">Confirm Password</label>
    <input id="confirm-new-password" name="confirm-new-password" class="form-control" type="password">
</div>
</form>

</body>
</html>
