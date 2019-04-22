<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please register" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <form action="/ads/register" method="post">
        <div class="row">
            <div class="col">
                <input type="text" class="form-control" name="username" placeholder="username">
            </div>
            <div class="col">
                <input type="text" class="form-control" name="email" placeholder="email">
            </div>
        </div>
        <div class="row">
            <div class="col">
                <input type="password" class="form-control" name="password" placeholder="password">
            </div>
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</div>

</body>
</html>
