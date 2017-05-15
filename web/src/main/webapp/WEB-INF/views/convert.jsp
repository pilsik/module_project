<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>


<tiles:insertDefinition name="defaultTemplate">

    <tiles:putAttribute name="title" value="Домашняя"/>

    <tiles:putAttribute name="addToHead">
        <script src='/js/convertFiles.js' type='text/javascript'></script>
    </tiles:putAttribute>

    <tiles:putAttribute name="body">
        <div>
            <input type='file' class='file' size='50' name='file'/><br>
            <input type="radio" name="extensionConvert" value="json" checked>JSON<br>
            <input type="radio" name="extensionConvert" value="xml" >XML<br>
            <input type="radio" name="type" value="employer" checked>Employer<br>
            <input type="radio" name="type" value="tree" >Tree<br>
            <input type='button' value='Загрузить'/>
            <a id="aConvertFile" href="#"></a>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>

<%--
<html>
<head>
    <title>Конвертация справочника в XML</title>
    <sec:csrfMetaTags />
    <script src="/js/jquery.js" type='text/javascript'></script>
    <script src='/js/convertFiles.js' type='text/javascript'></script>
</head>
<body>
<div>
    <input type='file' class='file' size='50' name='file'/>
    <input type='button' value='Загрузить'/>
    <a id="aConvertFile" href="#"></a>
</div>
<hr>
</body>
</html>
--%>
