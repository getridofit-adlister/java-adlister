<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Ad</title>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Edit this ad" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1>Edit Ad</h1>
        <form action="/editAd" method="post">
            <div class="form-group">
                <label for="title">Title</label>
                <input id="title" name="title" class="form-control" type="text" placeholder="${ad.title}">
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description" class="form-control" type="text" placeholder="${ad.description}"></textarea>
            </div>
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Choose Categories
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <c:forEach var="category" items="${categories}">
                        <div class="form-check form-check-inline form-group">
                            <input class="form-check-input" type="checkbox" value="${category.id}" id="${category.title}" name="${category.title}">
                            <label class="form-check-label" for="${category.title}">
                                    ${category.title}
                            </label>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="file-url">
                <textarea id="file-url" name="file-url" type="text" hidden></textarea>
            </div>
            <input type="submit" class="btn btn-block btn-primary">

        </form>
    </div>

    <div class="box">
        <form id="pick-form">
            <div class="field">
                <div class="control">
                    <button class="button" type="button" id="picker">Pick file</button>
                    <input type="hidden" id="fileupload" name="fileupload">
                </div>
                <div class="control" id="nameBox"></div>
                <div class="control" id="urlBox"></div>
            </div>
            <div class="field">
                <div class="control">
                    <input class="button" type="submit" value="Submit">
                </div>
            </div>
        </form>
    </div>


    <jsp:include page="/WEB-INF/partials/bootstrapJS.jsp" />

    <script src="//static.filestackapi.com/filestack-js/2.x.x/filestack.min.js"></script>

    <script>
        const client = filestack.init('AHvtwvhIFTIy8EfuGj9OTz');
        const options = {
            onUploadDone: updateForm,
            maxSize: 10 * 1024 * 1024,
            accept: 'image/*',
            uploadInBackground: false,
        };
        const picker = client.picker(options);

        // Get references to the DOM elements

        const form = document.getElementById('pick-form');
        const fileInput = document.getElementById('fileupload');
        const btn = document.getElementById('picker');
        const nameBox = document.getElementById('nameBox');
        const urlBox = document.getElementById('urlBox');
        let fileUrlField = document.querySelector('#file-url');

        // Add our event listeners

        btn.addEventListener('click', function (e) {
            console.log("hellio");
            e.preventDefault();
            picker.open();
        });

        form.addEventListener('submit', function (e) {
            e.preventDefault();
            alert('Submitting: ' + fileInput.value);
        });

        // Helper to overwrite the field input value

        function updateForm(result) {
            const fileData = result.filesUploaded[0];
            fileInput.value = fileData.url;
            fileUrlField.value = fileInput.value;

            // Some ugly DOM code to show some data.
            const name = document.createTextNode('Selected: ' + fileData.filename);
            const url = document.createElement('a');
            url.href = fileData.url;
            url.appendChild(document.createTextNode(fileData.url));
            nameBox.appendChild(name);
            urlBox.appendChild(document.createTextNode('Uploaded to: '));
            urlBox.appendChild(url);
        };

    </script>

</body>
</html>