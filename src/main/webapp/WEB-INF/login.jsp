<%--
  Created by IntelliJ IDEA.
  User: ironicsushi
  Date: 10/25/17
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Login" />
    </jsp:include>
    <link href="../stylesheets/login.css" rel="stylesheet">
    <link href="../stylesheets/basic.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />
    <div class="form-container">
        <div class="input-container">
            <form action="/login" method="post">
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input id="username" name="username" class="form-control" type="text">
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input id="password" name="password" class="form-control" type="password">
                    </div>
                <input type="submit" class="btn btn-primary btn-block form-button" value="Login">
            </form>
        </div>
    </div>
</body>
</html>
