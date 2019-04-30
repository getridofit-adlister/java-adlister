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

    <div class="container-fluid">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
        <h3>Here are the ads you've posted</h3>
        <div class="row">
            <c:forEach var="ad" items="${ads}">
                <div class="col-12 col-md-3 my-2">
                    <div class="card" style="width: 18rem;">
                        <img src="${ad.imageURL}" class="card-img-top" alt="..." style="height: 12rem">
                        <div class="card-body">
                            <h5 class="card-title"><a>${ad.title}</a></h5>
                            <p class="card-text">${ad.description}</p>
                            <a href="/thisAd?id=${ad.id}" class="btn btn-primary mr-2">View Ad</a>
                            <a href="/deleteAd?id=${ad.id}" class="btn btn-danger">Delete Ad</a>
                            <p>posted by: ${user.username}</p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>


    <jsp:include page="/WEB-INF/partials/bootstrapJS.jsp" />

</body>
</html>
