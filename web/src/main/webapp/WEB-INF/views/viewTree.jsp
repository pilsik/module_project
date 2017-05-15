<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="defaultTemplate">

    <tiles:putAttribute name="title" value="Dynatree(Дерево js)" />

    <tiles:putAttribute name="addToHead">
        <script src="./js/jquery-ui.custom.js" type="text/javascript"></script>
        <script src='./js/jquery.dynatree.js' type='text/javascript'></script>
        <script>
            ;
            $(document).ready(
                $(function () {
                    // Attach the dynatree widget to an existing <div id="tree"> element
                    // and pass the tree options as an argument to the dynatree() function:
                    $("#tree").dynatree({
                        onActivate: function (node) {
                            // A DynaTreeNode object is passed to the activation handler
                            // Note: we also get this event, if persistence is on, and the page is reloaded.
                        },
                        ${tree}
                    });
                    <c:if test="${not empty index}">
                    $("#tree").dynatree("getTree").activateKey(${index});
                    </c:if>
                }));
        </script>
        <link href="./css/ui.dynatree.css" rel="stylesheet" type="text/css"/>
        </script>
    </tiles:putAttribute>

    <tiles:putAttribute name="body">
        <div id="tree"></div>
    </tiles:putAttribute>

</tiles:insertDefinition>


