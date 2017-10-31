<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!" />
    </jsp:include>
    <link rel="stylesheet" href="../stylesheets/register.css">
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />
<div class="form-container">
    <div class="input-container">
        <form action="/register" method="POST">

            <%--Username--%>
            <div class="form-group">
               <label for="username">Username</label>
                <input id="username" name="username" class="form-control" value="${username}" type="text">

                <c:if test="${error != null}">
                    <span class="errors">${error}</span>
                </c:if>

                <c:if test="${errors.containsKey('username')}">
                    <span class="errors">${errors.get('username')}</span>
                </c:if>



            </div>
            <%--Email--%>
            <div class="form-group">
                <label for="email">Email</label>
                <input id="email" name="email" class="form-control" value="${email}" type="text">
                <c:if test="${errors.containsKey('email')}">
                    <span class="errors">${errors.get('email')}</span>
                </c:if>
            </div>
            <%--Password--%>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password">
                <c:if test="${errors.containsKey('password')}">
                    <span class="errors">${errors.get('password')}</span>
                </c:if>
            </div>
            <%--Confirm password--%>
            <div class="form-group">
                <label for="confirm-password">Confirm Password</label>
                <input id="confirm-password" name="confirm-password" class="form-control" type="password">
                <c:if test="${errors.containsKey('confirm')}">
                    <span class="errors">${errors.get('confirm')}</span>
                </c:if>
            </div>
            <input type="submit" class="btn btn-primary btn-block">
        </form>
    </div>
</div>
</body>
</html>
