<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link href="../stylesheets/createAd.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />
    <h1>Create an Ad</h1>
    <form action="/ads/create" method="post">
        <div class="form-group">
            <label for="title">Title</label>
            <input id="title" name="title" class="form-control" type="text" value="${title}">
            <c:if test="${adErrors.containsKey('title')}">
                <span class="errors">${adErrors.get('title')}</span>
            </c:if>
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <input id="description" name="description" class="form-control" type="text" value="${description}">
            <c:if test="${adErrors.containsKey('description')}">
                <span class="errors">${adErrors.get('description')}</span>
            </c:if>
        </div>
        <input type="submit" class="btn btn-primary btn-block">
    </form>
</body>
</html>
