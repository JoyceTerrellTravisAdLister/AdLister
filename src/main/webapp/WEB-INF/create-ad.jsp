<%--
  Created by IntelliJ IDEA.
  User: ironicsushi
  Date: 10/26/17
  Time: 10:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Create a New Ad" />
    </jsp:include>
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />
    <h1>Create an Ad</h1>
    <form action="/profile" method="post">
        <div class="form-group">
            <label for="username">Title</label>
            <input id="username" name="username" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="password">Description</label>
            <input id="password" name="password" class="form-control" type="text">
        </div>
        <input type="submit" class="btn btn-primary btn-block">
    </form>
</body>
</html>
