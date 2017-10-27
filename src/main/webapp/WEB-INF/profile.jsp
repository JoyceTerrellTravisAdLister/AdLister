<%--
  Created by IntelliJ IDEA.
  User: brose
  Date: 10/26/17
  Time: 10:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Welcome!" />
    </jsp:include>
</head>
<body>
    <%@include file="partials/navbar.jsp" %>
    <h1>Welcome, ${sessionScope.user.username}!</h1>
    <a href="/profile/edit">Edit Profile information</a>
<span> ${sessionScope.id}</span>
</body>
</html>
