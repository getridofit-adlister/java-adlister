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
        <c:forEach var="ad" items="${ads}">
            <div class="col-sm-3 p-0">
                <div class="card" style="width: 16rem;">
                    <img src="..." class="card-img-top" alt="..." style="height: 12rem">
                    <div class="card-body">
                        <h5 class="card-title"><a>${ad.title}</a></h5>
                        <p class="card-text my-1">${ad.description}</p>
                        <p class="card-text my-1">posted by: ${user.username}</p>
                        <a href="/thisAd?id=${ad.id}" class="card-text my-1">View Ad</a>
                    </div>

                </div>
            </div>
        </c:forEach>
    </div>
</div>

<jsp:include page="/WEB-INF/partials/bootstrapJS.jsp" />
</body>
</html>
