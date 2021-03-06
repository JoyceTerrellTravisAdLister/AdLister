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
            <a class="navbar-brand" href="/home">Dadlister</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li>
                <a href="/ads">
                    <span class="oi oi-list-rich"></span>
                    Ads
                </a>
            </li>
            <c:if test="${sessionScope.user != null}">
                <li>
                    <a href="/profile">
                    <span class="oi oi-person"></span>
                         ${sessionScope.user.username}
                    </a>
                </li>
                <li>
                    <a href="/logout">
                        <span class="oi oi-account-logout"></span>
                         Logout
                    </a>
                </li>
            </c:if>
            <c:if test="${sessionScope.user == null}">
                <li>
                    <a href="/register">
                        <span class="oi oi-pencil"></span>
                        Register
                    </a>
                </li>
                <li>
                    <a href="/login">
                        <span class="oi oi-account-login"></span>
                        Login
                    </a>
                </li>
            </c:if>
        </ul>
    <%--</div><!-- /.navbar-collapse -->--%>
    </div><!-- /.container-fluid -->
</nav>

