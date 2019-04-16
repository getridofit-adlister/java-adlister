<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: travisvela
  Date: 2019-04-16
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<%--   login page header   --%>
<div class="container">
    <div class="jumbotron">
        <h1 class="display-4 d-flex justify-content-center align-items-center">Login In</h1>
    </div>
</div>


<%--   login form   --%>
<div class="container">
    <form method="POST" action="login.jsp">
        <div class="row">
            <div class="col">
                <input type="text" class="form-control" name="username" placeholder="username">
            </div>
            <div class="col">
                <input type="text" class="form-control" name="password" placeholder="password">
            </div>
        </div>
        <div class="my-3">
            <button type="submit" class="btn btn-primary mb-2">Login</button>
        </div>
    </form>
</div>

<% String username = request.getParameter("username");%>
<% String password = request.getParameter("password");%>
<% String adminUsername = "admin"; %>
<% String adminPassword = "password"; %>;

<%
if (username != null && password != null) {
    if (username.equals(adminUsername) && password.equals(adminPassword)) {
        response.sendRedirect("http://localhost:8080/profile.jsp");
    } else {
        response.sendRedirect("http://localhost:8080/login.jsp");
    }
}
%>


<%--   bootstrap srcipts   --%>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
