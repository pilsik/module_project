<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tiles:insertDefinition name="defaultTemplate">

    <tiles:putAttribute name="title" value="Список сотрудников"/>

    <tiles:putAttribute name="body">
        <table class="table">
            <thead class="thead-inverse">
            <tr>
                <th>Код клиента:</th>
                <th>Фамилия клиента:</th>
                <th>Имя клиента:</th>
                <th>Телефон:</th>
                <th>Профессии:</th>
                <th>Удалить</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${data}" var="data" varStatus="status">
                <tr valign="top"
                        <c:if test="${data.idEmployer==index}">
                            bgcolor="#FF0000"
                        </c:if>
                    onclick="document.location = '/employer/id/${data.idEmployer}';"
                >
                    <th>${data.idEmployer}</th>
                    <td>${data.lastName}</td>
                    <td>${data.firstName}</td>
                    <td>${data.numberPhone}</td>
                    <td>${data.showPositions()}</td>
                    <td>
                        <form:form method="DELETE" action="/employer/id/${data.idEmployer}">
                            <input type="submit" id="btnSubmit" name="btnSubmit" value="DELETE"/>
                        </form:form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a href="/employer/create" class="btn btn-info" role="button">Creare new Employer</a>
    </tiles:putAttribute>
</tiles:insertDefinition>
