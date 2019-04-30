<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp" >
        <jsp:param name="title" value="Delete this ad" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <div class="row">
            <div class="col">
                <h1 class="my-4">Are you sure you wn to delete this ad?</h1>
                <img src="${ad.imageURL}">
                <h1>${ad.title}</h1>
                <p>${ad.description}</p>
            </div>
        </div>
        <div class="row">
            <input type="submit" class="btn btn-primary">
        </div>
    </div>

</body>
</html>
