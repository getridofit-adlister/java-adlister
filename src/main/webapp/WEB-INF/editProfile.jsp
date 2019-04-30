<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1>Update information.</h1>
        <form action="/editProfile" method="post">
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" value="${username}" type="text">
                <c:if test="${duplicate}">
                    <p>* Username already exists *</p>
                </c:if>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input id="email" name="email" class="form-control" value="${email}" type="text">
            </div>
            <input type="submit" class="btn btn-primary btn-block">
    <jsp:include page="/WEB-INF/partials/bootstrapJS.jsp" />


</body>
</html>
