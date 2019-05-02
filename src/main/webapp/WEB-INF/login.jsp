<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <c:if test="${not empty loginIsValid}">
            Username or password is incorrect.
        </c:if>
        <h1 class="d-flex justify-content-center my-4 display-4">Please Log In</h1>
        <form action="/login" method="POST">
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" value="${username}" type="text">
                <c:if test="${!userExists && username!=''}">
                    <p>* Username does not exist *</p>
                </c:if>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" value="${password}"type="password">
                <c:if test="${emtpyPass}">
                    <p>* Please Enter a Password *</p>
                </c:if>
                <c:if test="${wrongPass}">
                    <p>* Incorrect Password *</p>
                </c:if>
            </div>
            <input type="submit" class="btn btn-primary btn-block" value="Log In">
        </form>
        <br>
        <div>
            <p>New User? <a href="/register">CLICK HERE</a> to register</p>
        </div>
    </div>

</body>
</html>
