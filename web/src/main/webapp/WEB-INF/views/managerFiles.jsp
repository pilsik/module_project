<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>


<tiles:insertDefinition name="defaultTemplate">

    <tiles:putAttribute name="title" value="Менеджер файлов"/>

    <tiles:putAttribute name="addToHead">
        <script src="/js/deleteXMLFIle.js" type="text/javascript"></script>
    </tiles:putAttribute>

    <tiles:putAttribute name="body">
        <div class="container">
            <c:forEach items="${listFiles}" var="file" varStatus="status">
                <div>
                    <a href="../file/${file}">${file}</a>
                    <input type="button" value="Удалить файл"/>
                </div>
            </c:forEach>
        </div>
    </tiles:putAttribute>

</tiles:insertDefinition>
