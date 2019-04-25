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
    <div class="container">

        <c:forEach var="ad" items="${ad}">
            <img src="${ad.imageURL}" height="200" width="800">

            <h1>${ad.title}</h1>
        </div>
        <div class="row">
            <p>${ad.description}</p>
        </div>
        <div class="row">
            <div class="col-md-3">
                <p>posted by: ${user.username}</p>
            </div>
            <div class="col-md-3">
                <p><a href="mailto:bob@bob.com" target="_blank" rel="noopener">${user.email}</a></p>
            </div>
        </div>



        </c:forEach>
    </div>

    <jsp:include page="/WEB-INF/partials/bootstrapJS.jsp" />

</body>
</html>
