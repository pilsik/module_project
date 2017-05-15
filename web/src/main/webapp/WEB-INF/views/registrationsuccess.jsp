<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="defaultTemplate">

    <tiles:putAttribute name="title" value="Успешная регистрация" />

    <tiles:putAttribute name="body">
        <div class="container">
            <div class="row">
                Confirmation message : ${success}
                <br>
                <spring:url value="/newclient" var="newClientUrl" htmlEscape="true"/>
                Would you like to <a href="<c:url value="${newClientUrl}" />">Add More Users</a>
                <br/>
                <spring:url value="/home" var="homeUrl" htmlEscape="true"/>
                Go to <a href="<c:url value="${homeUrl}" />">Admin Page</a>
                <c:url value="/logout" var="logoutUrl" />
                <form action="${logoutUrl}" method="post">
                    <input type="submit" value="Logout"/>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
            </div>
            <div class="row">
                <spring:url value="/addAddress" var="addAddressUrl" htmlEscape="true"/>
                <a href="<c:url value="${addAddressUrl}" />">Add More Users</a>?
            </div>
        </div>

    </tiles:putAttribute>
</tiles:insertDefinition>
