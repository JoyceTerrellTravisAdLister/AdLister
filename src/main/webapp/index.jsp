<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome!" />
    </jsp:include>
    <link rel="stylesheet" href="stylesheets/index.css" type="text/css">
</head>
<body>
    <jsp:include page="WEB-INF/partials/navbar.jsp" />
    <%--<div class="container">--%>

        <div class="jumbotron header">
            <div class="container">
                <div class="header">
                    <h1>The DadLister</h1>
                    <p>Find the perfect father figure for all your needs!</p>
                    <p>
                        <a class="btn btn-primary btn-lg" href="/ads" role="button">See All Listings Here
                        </a>
                    </p>
                </div>
            </div>
        </div>

        <h2>Recently Added</h2>
        <div class="ad-card">
            <h3>New Ad 1</h3>
            <p>Description...</p>
        </div>
        <div class="ad-card">
            <h3>New Ad 2</h3>
            <p>Description...</p>
        </div>
        <div class="ad-card">
            <h3>New Ad 3</h3>
            <p>Description...</p>
        </div>
    <%--</div>--%>
</body>
</html>
