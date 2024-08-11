<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <title>User Detail</title>
    <link href="/admin/css/styles.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</head>

<body class="sb-nav-fixed">
<jsp:include page="../layout/header.jsp"/>
<div id="layoutSidenav">
    <jsp:include page="../layout/sidebar.jsp"/>
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <h1 class="mt-4">Manage Detail</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item active"><a href="/admin">Dashboard</a></li>
                    <li class="breadcrumb-item active"><a href="/admin/user">Rooms</a></li>
                    <li class="breadcrumb-item active">Detail</li>
                </ol>
                <div class="container mt-5">
                    <div class="row">
                        <div class="col-md-6 col-12 mx-auto">
                            <div class="d-flex justify-content-between">
                                <h3>Details Room ${id}</h3>

                            </div>
                            <hr>
                            <div class="card" >
                                <div class="card-header">
                                    User Information
                                </div>
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item">Id: ${room.id}  </li>
                                    <li class="list-group-item">roomNumber: ${room.roomNumber}  </li>
                                    <li class="list-group-item">type: ${room.type} </li>
                                    <li class="list-group-item">pricePerNight: ${room.pricePerNight} $</li>
                                    <li class="list-group-item">availabilityStatus: ${room.availabilityStatus} </li>
                                    <li class="list-group-item">maxPerson: ${room.maxPerson}</li>
                                    <li class="list-group-item">size: ${room.size} m2</li>
                                    <li class="list-group-item">view: ${room.view}</li>
                                    <li class="list-group-item">bed: ${room.bed}</li>
                                    <li class="list-group-item">description: ${room.description}</li>
                                    <li class="list-group-item">Avatar:
                                        <img src="/admin/images/rooms/${room.image}" alt="Room Image"
                                             style="max-width: 200px; max-height: 200px; margin-left: 50px;">
                                    </li>

<%--                                    <li class="list-group-item">Role: ${room.role.name}</li>--%>
                                    <%--                                    <li class="list-group-item">Avatar: ${room.avatar}</li>--%>
<%--                                    <li class="list-group-item">Avatar:--%>
<%--                                        <img src="/admin/images/avatar/${room.avatar}" alt="User Avatar"--%>
<%--                                             style="max-width: 200px; max-height: 200px; margin-left: 50px;">--%>
<%--                                    </li>--%>
                                </ul>
                            </div>
                            <a href="/admin/room" class="btn btn-success" style="margin-top: 20px;">Back</a>

                        </div>

                    </div>

                </div>
        </main>
        <jsp:include page="../layout/footer.jsp"/>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
<script src="/admin/js/scripts.js"></script>
</body>

</html>