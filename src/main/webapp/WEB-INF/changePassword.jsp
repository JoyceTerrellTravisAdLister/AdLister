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
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Login" />
    </jsp:include>
    <link href="../stylesheets/changePass.css" rel="stylesheet">
    <link href="../stylesheets/basic.css" rel="stylesheet">
</head>
<body>
<jsp:include page="partials/navbar.jsp" />
<div class="form-container">
    <div class="input-container">
        <form action="/profile/password" method="POST">
        <%-- old password --%>
        <div class="form-group">
            <label for="old-password">Current Password</label>
            <input id="old-password" name="old-password" class="form-control" type="password">
        </div>
        <%-- new- password field--%>
        <div class="form-group">
            <label for="new-password">New Password</label>
            <input id="new-password" name="new-password" class="form-control" type="password">
        </div>
        <%--Confirm new-password--%>
        <div class="form-group">
            <label for="confirm-new-password">Confirm Password</label>
            <input id="confirm-new-password" name="confirm-new-password" class="form-control" type="password">
        </div>
            <input type="submit" class="btn btn-primary btn-block">
        </form>
    </div>
</div>
</body>
</html>
