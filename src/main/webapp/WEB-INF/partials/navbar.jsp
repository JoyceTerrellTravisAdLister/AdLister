<%--
  Created by IntelliJ IDEA.
  User: ironicsushi
  Date: 10/25/17
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Dadlister</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/ads">Ads</a></li>
            <c:if test="${sessionScope.user != null}">
                <li><a href="/profile">${sessionScope.user.username}</a></li>
                <li><a href="/logout">Logout</a></li>
            </c:if>
            <c:if test="${sessionScope.user == null}">
                <li><a href="/register">Register</a></li>
                <li><a href="/login">Login</a></li>
            </c:if>
        </ul>
    <%--</div><!-- /.navbar-collapse -->--%>
    </div><!-- /.container-fluid -->
</nav>

