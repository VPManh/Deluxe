<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
    <title>crud dashboard</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="admin/css/bootstrap.min.css">
    <!----css3---->
    <link rel="stylesheet" href="admin/css/custom.css">


    <!--google fonts -->

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">


    <!--google material icon-->
    <link href="https://fonts.googleapis.com/css2?family=Material+Icons" rel="stylesheet">

</head>

<body>


<div class="wrapper">


    <div class="body-overlay"></div>

    <!-------------------------sidebar------------>
    <!-- Sidebar  -->
    <jsp:include page="../layout/sidebar.jsp"/>


    <!--------page-content---------------->

    <div id="content">
        <jsp:include page="../layout/header.jsp"/>
        <!--top--navbar----design--------->


        <!--------main-content------------->

        <div class="main-content">

            vieets code trong nafy
        </div>


        <jsp:include page="../layout/footer.jsp"/>
    </div>
</div>


<!----------html code compleate----------->


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="admin/js/jquery-3.3.1.slim.min.js"></script>
<script src="admin/js/popper.min.js"></script>
<script src="admin/js/bootstrap.min.js"></script>
<script src="admin/js/jquery-3.3.1.min.js"></script>


<script type="text/javascript">

    $(document).ready(function () {
        $(".xp-menubar").on('click', function () {
            $('#sidebar').toggleClass('active');
            $('#content').toggleClass('active');
        });

        $(".xp-menubar,.body-overlay").on('click', function () {
            $('#sidebar,.body-overlay').toggleClass('show-nav');
        });

    });

</script>


</body>

</html>