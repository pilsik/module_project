<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>


<tiles:insertDefinition name="defaultTemplate">

    <tiles:putAttribute name="title" value="Импортировать в базу данных"/>

    <tiles:putAttribute name="addToHead">
        <script src='/js/newInputFiles.js' type='text/javascript'></script>
        <script src='/js/prototypeJSON.js' type='text/javascript'></script>
        <script src='/js/uploadFiles.js' type='text/javascript'></script>
        <script type='text/javascript'>
            $(document).ready(function () {
                $("input[typeFile]").click(uploadFiles);
            /*    $('div', 'form').first().find("input[typeFile]").forEach(this.click(uploadFiles));*/
            });
        </script>
    </tiles:putAttribute>

    <tiles:putAttribute name="body">
        <form action="${pageContext.request.contextPath}/import" method="post" enctype="multipart/form-data" class="employer">
            <div>
                <p>Загрузить сотрудников</p>
                <input type='file' class='file' size='50' name='file'/><input type='button' value='Загрузить'
                                                                              typeFile="employer"/>
                <input class='addInputEmployer' type='button' onclick='addInputFile(this)' value='Загрузить еще'/>
            </div>
        </form>
        <hr>
        <form action="${pageContext.request.contextPath}/import" method="post" enctype="multipart/form-data" class="tree">
            <div>
                <p>Загрузить дерево</p>
                <input type='file' class='file' size='50' name='file'/><input type='button' value='Загрузить' typeFile="tree"/>
                <input class='addInputTree' type='button' onclick='addInputFile(this)' value='Загрузить еще'/>
            </div>
        </form>
        <div id="template" style="display: none">
            <input type='file' class='file' size='50' name='file'/>
            <input type='button' value='Загрузить'/>
        </div>
    </tiles:putAttribute>

</tiles:insertDefinition>

<%--<html>
<head>
    <title>Загрузка справочников</title>
    <link rel="shortcut icon" href="">
    <sec:csrfMetaTags/>
    <script src="/js/jquery.js" type='text/javascript'></script>
    <script src='/js/newInputFiles.js' type='text/javascript'></script>
    <script src='/js/prototypeJSON.js' type='text/javascript'></script>
    <script src='/js/uploadFiles.js' type='text/javascript'></script>
    <script type='text/javascript'>
        $(document).ready(function () {
            $('div', 'form').first().find("input[type='button']").first().click(uploadFiles);
        });
    </script>
    <c:set var="context" value="${pageContext.request.contextPath}"/>
</head>
<body>
<form action="${pageContext.request.contextPath}/import" method="post" enctype="multipart/form-data" class="employer">
    <div>
        <p>Загрузить сотрудников</p>
        <input type='file' class='file' size='50' name='file'/><input type='button' value='Загрузить'
                                                                      typeFile="employer"/>
        <input class='addInputEmployer' type='button' onclick='addInputFile(this)' value='Загрузить еще'/>
    </div>
</form>
<hr>
<form action="${pageContext.request.contextPath}/import" method="post" enctype="multipart/form-data" class="tree">
    <div>
        <p>Загрузить дерево</p>
        <input type='file' class='file' size='50' name='file'/><input type='button' value='Загрузить' typeFile="tree"/>
        <input class='addInputTree' type='button' onclick='addInputFile(this)' value='Загрузить еще'/>
    </div>
</form>
<div id="template" style="display: none">
    <input type='file' class='file' size='50' name='file'/>
    <input type='button' value='Загрузить'/>
</div>
</body>
</html>--%>
