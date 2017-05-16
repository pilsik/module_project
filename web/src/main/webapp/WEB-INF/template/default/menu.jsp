<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="menu">
    <ul>
        <li>
            <spring:url value="/home" var="homeUrl" htmlEscape="true"/>
            <a href="${homeUrl}">Home</a>
        </li>
        <li>
            <spring:url value="/about" var="aboutUrl" htmlEscape="true"/>
            <a href="${aboutUrl}">About</a>
        </li>
        <li>
            <spring:url value="/newUser" var="newUserUrl" htmlEscape="true"/>
            <a href="${newUserUrl}">New Client</a>
        </li>
        <li>
            <spring:url value="/convert" var="convertUrl" htmlEscape="true"/>
            <a href="${convertUrl}">Конвентировать</a>
        </li>
        <li>
            <spring:url value="/import" var="importUrl" htmlEscape="true"/>
            <a href="${importUrl}">Импорт в таблицу</a>
        </li>
        <li>
            <spring:url value="/viewListEmployer" var="viewListEmployerUrl" htmlEscape="true"/>
            <a href="${viewListEmployerUrl}">Просмотреть список</a>
        </li>
        <li>
            <spring:url value="/viewTree" var="viewTree" htmlEscape="true"/>
            <a href="${viewTree}">Просмотреть дерево</a>
        </li>
        <li>
            <spring:url value="/search" var="searchUrl" htmlEscape="true"/>
            <a href="${searchUrl}">Поиск</a>
        </li>
        <li>
            <spring:url value="/managerFiles" var="managerUrl" htmlEscape="true"/>
            <a href="${managerUrl}">Manager</a>
        </li>
        <li>
            <c:url value="/logout" var="logoutUrl" />
            <form action="${logoutUrl}" method="post">
                <input type="submit" value="Logout"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </li>
    </ul>
</div>