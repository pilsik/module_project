<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <sec:csrfMetaTags />
    <!--[if lt IE 9]>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script><![endif]-->
    <title><tiles:insertAttribute name="title" ignore="true"/></title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/bootstrap.css" rel="stylesheet"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <tiles:insertAttribute name="addToHead" ignore="true"/>
</head>
<body>
<div class="wrapper">

    <header class="header">
        <tiles:insertAttribute name="header"/>
    </header><!-- .header-->

    <div class="middle">
        <div class="wrapper">
            <div class="row">
                <div class="col-sm-2">
                    <tiles:insertAttribute name="menu"/>
                </div><!-- .left-sidebar -->
                <div class="col-md-10">
                    <tiles:insertAttribute name="body"/>
                </div><!-- .container-->
            </div>
        </div>
    </div><!-- .middle-->

</div><!-- .wrapper -->

<footer class="footer">
    <tiles:insertAttribute name="footer"/>
</footer><!-- .footer -->

</body>
</html>