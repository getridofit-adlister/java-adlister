<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! int counter = 0; %>
<% counter += 1; %>
<%! String name; %>
<% request.setAttribute("message", "Hello, "); %>
<% name = request.getParameter("name");
    if (name == null) name = "Codeup";
%>
<html>
<head>
    <title>Title</title>
    <%@ include file="partials/bootstrap.jsp" %>
</head>
<body>

<%@ include file="partials/navbar.jsp" %>



<h1 class="display-1 d-flex justify-content-center">${message} <%= name %></h1>

<h1 class="d-flex justify-content-center text-primary my-5">The current count is <%= counter %>.</h1>

<p class="d-flex justify-content-center my-5">View the page source! </p>

<%-- this is a JSP comment, you will *not* see this in the html --%>

<!-- this is an HTML comment, you *will* see this in the html -->

<jsp:include page="partials/bootstrapScripts.jsp" />
</body>
</html>