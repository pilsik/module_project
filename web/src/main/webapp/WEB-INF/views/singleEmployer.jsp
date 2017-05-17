<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="defaultTemplate">

    <tiles:putAttribute name="title" value="Изменить сотрудника"/>

    <tiles:putAttribute name="body">

        <c:set var="formMethod" value="PUT"/>
        <c:if test="${requestScope['javax.servlet.forward.request_uri'] == '/employer/create'}">
            <c:set var="formMethod" value="POST"/>
        </c:if>

        <div class="form-container">
            <form:form method="${formMethod}" modelAttribute="employer" class="form-horizontal">

                <form:input type="hidden" path="idEmployer"/>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="lastName">LastName</label>
                        <div class="col-md-7">
                            <form:input type="text" path="lastName" id="lastName" class="form-control input-sm"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="firstName">FirstName</label>
                        <div class="col-md-7">
                            <form:input type="text" path="firstName" id="firstName" class="form-control input-sm"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="numberPhone">NumberPhone</label>
                        <div class="col-md-7">
                            <form:input type="text" path="numberPhone" id="numberPhone" class="form-control input-sm"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="positions_now">Positions now</label>
                        <div class="col-md-7">
                            <input id="positions_now" value="${employer.showPositions()}" readonly="readonly"
                                   class="form-control  input-sm">
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="positions">Select needed position to update</label>
                        <div class="col-md-7">
                            <form:select id="positions" path="positions" items="${positionsList}" multiple="true"
                                         itemValue="positionID" itemLabel="positionName" class="form-control input-sm"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-actions floatRight">
                        <input type="submit" value="Update" class="btn btn-primary btn-sm"> or <a
                            href="<c:url value='/' />">Cancel</a>
                    </div>
                </div>

            </form:form>

        </div>

    </tiles:putAttribute>

</tiles:insertDefinition>

<%--
${employer.idEmployer}
${employer.lastName}
${employer.firstName}
${employer.numberPhone}
${employer.positions}--%>
