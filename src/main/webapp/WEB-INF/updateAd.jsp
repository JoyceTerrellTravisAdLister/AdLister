<%--
  Created by IntelliJ IDEA.
  User: brose
  Date: 10/31/17
  Time: 10:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Update add</h1>
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
