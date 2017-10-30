<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome!"/>
    </jsp:include>
    <link href="https://fonts.googleapis.com/css?family=Lobster|News+Cycle" rel="stylesheet">
    <link rel="stylesheet" href="stylesheets/index.css" type="text/css">
    <link rel="stylesheet" href="stylesheets/basic.css">
</head>
<body>
<jsp:include page="WEB-INF/partials/navbar.jsp"/>
<div class="jumbotron">
    <div class="container banner">
        <div class="header">
            <h1>The DadLister</h1>
            <p class="subtitle"><em>Find the <strong>perfect</strong> father figure for all your needs. </em></p>
            <p>
                <a class="btn btn-primary btn-lg display-font" href="/ads" role="button">See All Listings Here
                </a>
            </p>
        </div>
    </div>
</div>
<%--<h2 class="heading">Recently Added</h2>--%>
<%--<div class="recent-container">--%>
    <%--<div class="col-sm-4">--%>
        <%--<div class="card" style="">--%>
            <%--<div class="card-body">--%>
                <%--<h4 class="card-title">Loves to BBQ</h4>--%>
                <%--<p class="card-text">I'm having some guests over on Saturday night and hope I can find someone to--%>
                    <%--grill.</p>--%>
                <%--<a href="#" class="btn btn-primary">More Details</a>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="col-sm-4">--%>
        <%--<div class="card" style="">--%>
            <%--<div class="card-body">--%>
                <%--<h4 class="card-title">Baseball game?</h4>--%>
                <%--<p class="card-text">I need a dad to come with me and my son to the baseball game!</p>--%>
                <%--<a href="#" class="btn btn-primary">More Details</a>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="col-sm-4">--%>
        <%--<div class="card" style="">--%>
            <%--<div class="card-body">--%>
                <%--<h4 class="card-title">My dad is too busy</h4>--%>
                <%--<p class="card-text">I need someone to come to my ballet performances at school.</p>--%>
                <%--<a href="#" class="btn btn-primary">More Details</a>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>
<div class="container">
    <div class="row justify-content-around">
        <h3>Most Recent Ads</h3>
        <c:forEach var="Ad" items="${newestAds}">
            <div class="col-sm-4">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">${Ad.title}</h4>
                        <p class="card-text">${Ad.shortDescription}</p>
                    </div>
                    <a href="#" class="btn btn-primary">More Details</a>
                    <div class="card-footer">
                        <p class="card-subtitle">${Ad.timeCreated}</p>
                        <p class="card-subtitle">Added ${Ad.getTimeDifferenceString()}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<%--</div>--%>
</body>
</html>
