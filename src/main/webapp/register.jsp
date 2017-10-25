<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="WEB-INF/partials/navbar.jsp" />
    <form>
        <%--Username--%>
        <div class="form-group">
           <label for="username">Username</label>
            <input id="username" name="" class="" type="text">
        </div>
        <%--Email--%>
        <div class="form-group">
            <label for="email">Email</label>
            <input id="email" name="" class="" type="text">
        </div>
        <%--Password--%>
        <div class="form-group">
            <label for="password">Password</label>
            <input id="password" name="" class="" type="text">
        </div>
        <%--Confirm password--%>
        <div class="form-group">
            <label for="confirm-password">Confirm Password</label>
            <input id="confirm-password" name="" class="" type="text">
        </div>
        <input type="submit" class="btn btn-primary btn-block">
    </form>
</body>
</html>
