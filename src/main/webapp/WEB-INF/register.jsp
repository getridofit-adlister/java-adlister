<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />
    <div class="container">
        <h1>Please fill in your information.</h1>
        <form action="/register" method="post">
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" value="${username}" type="text">
                <c:if test="${emptyName}">
                    <p>* Please Enter a Username *</p>
                </c:if>
                <c:if test="${duplicate}">
                    <p>* Sorry, that username already exists *</p>
                </c:if>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input id="email" name="email" class="form-control" value="${email}" type="text">
                <c:if test="${emptyEmail}">
                    <p>* Please Enter a valid Email *</p>
                </c:if>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" value="${password}" type="password">
            </div>
            <c:if test="${emptyName}">
                <p>* Please Enter a Password *</p>
            </c:if>
            <div class="form-group">
                <label for="confirm_password">Confirm Password</label>
                <input id="confirm_password" name="confirm_password" class="form-control" value="${passwordC}" type="password">
            </div>
            <c:if test="${passwordsNoMatch}">
                <p>* Passwords do not match *</p>
            </c:if>
            <input type="submit" class="btn btn-primary btn-block">
        </form>
    </div>

    <jsp:include page="/WEB-INF/partials/bootstrapJS.jsp" />

</body>
</html>
