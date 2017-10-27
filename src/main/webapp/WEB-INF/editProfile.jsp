<%--
  Created by IntelliJ IDEA.
  User: brose
  Date: 10/27/17
  Time: 11:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change Profile Info</title>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Login" />
    </jsp:include>
</head>
<body>
<%@include file="partials/navbar.jsp" %>
<form action="/profile/edit" method="POST">
    <%--Email--%>
    <div class="form-group">
        <label for="email">Change Email</label>
        <input id="email" name="email" class="form-control" type="text">
    </div>
    <input type="submit" class="btn btn-primary btn-block">
</form>
</body>
</html>
