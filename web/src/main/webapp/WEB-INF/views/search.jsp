<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="defaultTemplate">

    <tiles:putAttribute name="title" value="Поиск"/>

    <tiles:putAttribute name="addToHead">
        <script src="/js/jquery.js" type="text/javascript"></script>
        <script src="/js/jquery-ui.min.js" type="text/javascript"></script>
        <script src="/js/searchAutocomplete.js" type="text/javascript"></script>
        <link href="/css/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
    </tiles:putAttribute>

    <tiles:putAttribute name="body">
        <div>
            <h4>Форма для поиска клиентов по фамилии</h4>
            <form method="get" action="/viewListEmployer?search">
                <input type="text" class="autocomplete" data-url="/search?employer"/>
                <input type="hidden" name="index"/>
                <input type="submit" value="Показать"/>
            </form>
            <h4>Форма для поиска в дереве</h4>
            <form method="get" action="/viewTree?search">
                <input type="text" class="autocomplete" data-url="/search?tree"/>
                <input type="hidden" name="index"/>
                <input type="submit" value="Показать"/>
            </form>
        </div>
    </tiles:putAttribute>

</tiles:insertDefinition>

<%--<html>
<head>
<title>Search</title>
<sec:csrfMetaTags/>
<script src="/js/jquery.js" type="text/javascript"></script>
<script src="/js/jquery-ui.min.js" type="text/javascript"></script>
<script src="/js/searchAutocomplete.js" type="text/javascript"></script>
<link href="/css/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div>
<h4>Форма для поиска клиентов по фамилии</h4>
<form method="get" action="/viewListEmployer?search">
<input type="text" class="autocomplete" data-url="/search?employer"/>
<input type="hidden" name="index"/>
<input type="submit" value="Показать"/>
</form>
<h4>Форма для поиска в дереве</h4>
<form method="get" action="/viewTree?search">
<input type="text" class="autocomplete" data-url="/search?tree"/>
<input type="hidden" name="index"/>
<input type="submit" value="Показать"/>
</form>
</div>
</body>
</html>--%>