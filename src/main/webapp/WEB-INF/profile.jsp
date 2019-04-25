<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
        <h3>Here are the ads you've posted</h3>
        <div class="row">
            <c:forEach var="ad" items="${ads}">
                <div class="col-sm-3 mr-3">
                    <div class="card" style="width: 18rem;">
                        <img src="..." class="card-img-top" alt="..." style="height: 12rem">
                        <div class="card-body">
                            <h5 class="card-title"><a>${ad.title}</a></h5>
                            <p class="card-text">${ad.description}</p>
                            <a href="/thisAd?id=${ad.id}" class="btn btn-primary">View Ad</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <c:forEach var="ad" items="${ads}">
            <div class="col-md-6">
                <img src="${ad.imageURL}" height="200" width="800">
                <h2><a href="/thisAd?id=${ad.id}">${ad.title}</a></h2>
                <p>${ad.description}</p>
            </div>
        </c:forEach>

    </div>


    <jsp:include page="/WEB-INF/partials/bootstrapJS.jsp" />

</body>
</html>
