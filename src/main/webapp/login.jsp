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
    <jsp:include page="partials/bootstrapCSS.jsp" />
</head>
<body>
<jsp:include page="partials/navbar.jsp" />
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

<%--   initial I solved the exercise   --%>

<%--<% String username = request.getParameter("username");%>--%>
<%--<% String password = request.getParameter("password");%>--%>
<%--<% String adminUsername = "admin"; %>--%>
<%--<% String adminPassword = "password"; %>;--%>

<%--<%--%>
<%--if (username != null && password != null) {--%>
    <%--if (username.equals(adminUsername) && password.equals(adminPassword)) {--%>
        <%--response.sendRedirect("http://localhost:8080/profile.jsp");--%>
    <%--} else {--%>
        <%--response.sendRedirect("http://localhost:8080/login.jsp");--%>
    <%--}--%>
<%--}--%>
<%--%>--%>


<%--   sleeker solution using the getMehtod method on the request object. also used filename rather than URL for redirect   --%>
<%
    if(request.getMethod().toLowerCase().equals("post")) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.toLowerCase().equals("admin") && password.equals("password")) {
            response.sendRedirect("profile.jsp");
        }
    }
%>

<jsp:include page="partials/footer.jsp" />
<jsp:include page="partials/bootstrapScripts.jsp" />
</body>
</html>
