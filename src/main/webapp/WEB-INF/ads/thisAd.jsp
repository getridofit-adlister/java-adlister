<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: travisvela
  Date: 2019-04-24
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${param.title}</title
    <jsp:include page="/WEB-INF/partials/head.jsp" />
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container-fluid">
        <div class="row d-flex justify-content-center align-items-center mt-5">
            <div class="col"></div>
            <div class="col">
                <img src="${ad.imageURL}">
                <h1>${ad.title}</h1>
                <p>${ad.description}</p>
                <p>posted by: ${user.username}</p>
                <p><a href="mailto:${user.email}?subject=${ad.title}" rel="noopener">${user.email}</a></p>
                <c:if test="${loggedUser.id == ad.userId}">
                    <div class="row">
                        <a href="/editAd?id=${ad.id}" class="btn btn-primary m-2">Edit</a>
                    </div>
                </c:if>
            </div>
            <div class="col"></div>
        </div>



    </div>

    <jsp:include page="/WEB-INF/partials/bootstrapJS.jsp" />

</body>
</html>
