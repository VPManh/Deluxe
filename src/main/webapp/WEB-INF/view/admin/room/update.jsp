<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="Hotel Booking - Create Room" />
    <meta name="author" content="Your Name" />
    <title>Update Room</title>
    <link href="/admin/css/styles.css" rel="stylesheet" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    <script>
        $(document).ready(() => {
            const avatarFile = $("#avatarFile");
            avatarFile.change(function (e) {
                const imgURL = URL.createObjectURL(e.target.files[0]);
                $("#avatarPreview").attr("src", imgURL);
                $("#avatarPreview").css({ "display": "block" });
            });
        });
    </script>
</head>

<body class="sb-nav-fixed">
<jsp:include page="../layout/header.jsp" />
<div id="layoutSidenav">
    <jsp:include page="../layout/sidebar.jsp" />
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <h1 class="mt-4">Manage Update</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item active"><a href="/admin">Dashboard</a></li>
                    <li class="breadcrumb-item active"><a href="/admin/room">Rooms</a></li>
                    <li class="breadcrumb-item active">Update</li>
                </ol>
                <div class="container mt-5">
                    <div class="row">
                        <div class="col-md-6 col-12 mx-auto">
                            <h3>Update a Room ${soPhong}</h3>
                            <hr />
                            <form:form action="/admin/room/update" method="post"
                                       modelAttribute="newRoom" enctype="multipart/form-data">
                                <div class="mb-3" style="display: none;">
                                    <label class="form-label">Id:</label>
                                    <form:input type="text" class="form-control" path="id"/>
                                </div>
                                <div class="mb-3 row">
                                    <div class="col-12 col-md-6">
                                        <label class="form-label">Room Number:</label>
                                        <form:input type="text" class="form-control" path="roomNumber" />
                                    </div>
                                    <div class="col-12 col-md-6">
                                        <label class="form-label">Type:</label>
                                        <form:input type="text" class="form-control" path="type" />
                                    </div>
                                </div>
                                <div class="mb-3 row">
                                    <div class="col-12 col-md-6">
                                        <label class="form-label">Availability Status:</label>
                                            <%--                                        <form:input type="text" class="form-control" path="availabilityStatus" />--%>
                                        <form:select class="form-select" path="availabilityStatus">
                                            <form:option value="Available">Available</form:option>
                                            <form:option value="NoAvailable">No Available</form:option>
                                        </form:select>
                                    </div>
                                    <div class="col-12 col-md-6">
                                        <label class="form-label">Price per Night:</label>
                                        <form:input type="number" class="form-control" path="pricePerNight" />
                                    </div>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">View:</label>
                                    <form:input type="text" class="form-control" path="view" />
                                </div>
                                <div class="mb-3 row">
                                    <div class="col-12 col-md-4">
                                        <label class="form-label">Bed:</label>
                                        <form:input type="number" class="form-control" path="bed" />
                                    </div>
                                    <div class="col-12 col-md-4">
                                        <label class="form-label">Size (m²):</label>
                                        <form:input type="number" class="form-control" path="size" />
                                    </div>
                                    <div class="col-12 col-md-4">
                                        <label class="form-label">Max Person:</label>
                                        <form:input type="number" class="form-control" path="maxPerson" />
                                    </div>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Description:</label>
                                    <form:textarea class="form-control" path="description"></form:textarea>
                                </div>
                                <div class="mb-3 col-12 col-md-6">
                                    <label for="avatarFile" class="form-label">Avatar:</label>
                                    <input class="form-control" type="file" id="avatarFile"
                                           accept=".png, .jpg, .jpeg" name="hoidanitFile" />
                                </div>
                                <div class="col-12 mb-3">
                                    <img style="max-height: 250px; display: none;" alt="avatar preview"
                                         id="avatarPreview" />
                                </div>
                                <button type="submit" class="btn btn-primary">Update Room</button>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <jsp:include page="../layout/footer.jsp" />
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
<script src="/admin/js/scripts.js"></script>
</body>

</html>
