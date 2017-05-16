<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <sec:csrfMetaTags/>
    <!--[if lt IE 9]>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script><![endif]-->
    <title><tiles:insertAttribute name="title" ignore="true"/></title>
    <meta name="keywords" content=""/>
    <meta name="description" content="RestFull"/>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/rest.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <tiles:insertAttribute name="addToHead" ignore="true"/>
</head>

<body>

<!--============    ШАПКА САЙТА    ===========-->
<header>
    <tiles:insertAttribute name="header"/>
</header>

<!--============    НАВИГАЦИЯ САЙТА    ===========-->
<nav>
    <tiles:insertAttribute name="nav"/>
</nav>

<!--============    ГЛАВНЫЙ КОНТЕНТ    ===========-->
<section id="main">
    <tiles:insertAttribute name="main"/>
</section>

<!--============    ПОДВАЛ САЙТА    ===========-->
<footer>
    <tiles:insertAttribute name="footer"/>
</footer>

<!--============    Modal   ===========-->

<tiles:insertAttribute name="modalWindows" ignore="true"/>

<!--============    Скрипты инициализация   ===========-->

<tiles:insertAttribute name="modalWindows" ignore="true"/>

</body>
</html>