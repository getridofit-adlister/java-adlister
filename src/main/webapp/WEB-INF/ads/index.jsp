<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Here Are all the ads!</h1>
    <div class="row">
        <c:forEach var="userAd" items="${userAds}">
            <div class="col-sm-3 mr-3">
                <div class="card" style="width: 18rem;">
                    <img src="..." class="card-img-top" alt="..." style="height: 12rem">
                    <div class="card-body">
                        <h5 class="card-title"><a>${userAd.ad.title}</a></h5>
                        <p class="card-text">${userAd.ad.description}</p>
                        <a href="/thisAd?id=${userAd.ad.id}" class="btn btn-primary">View Ad</a>
                        <p>posted by: ${userAd.user.username}</p>
                    </div>

                </div>
            </div>
        </c:forEach>

    </div>
</div>

<jsp:include page="/WEB-INF/partials/bootstrapJS.jsp" />
</body>
</html>
