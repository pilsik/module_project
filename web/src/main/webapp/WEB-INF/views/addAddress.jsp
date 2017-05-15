<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<tiles:insertDefinition name="defaultTemplate">

    <tiles:putAttribute name="title" value="Добавить адресс" />

    <tiles:putAttribute name="body">
        <div class="form-container">

            <h1>Add address</h1>

            <form:form method="POST" modelAttribute="address" class="form-horizontal">

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="houseNumber">houseNumber</label>
                        <div class="col-md-7">
                            <form:input type="text" path="houseNumber" id="houseNumber" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="houseNumber" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="streetAddress">streetAddress</label>
                        <div class="col-md-7">
                            <form:input type="text" path="streetAddress" id="streetAddress" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="streetAddress" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-label" for="city">city</label>
                        <div class="col-md-7">
                            <form:input type="text" path="city" id="city" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="city" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-label" for="state">state</label>
                        <div class="col-md-7">
                            <form:input type="text" path="state" id="state" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="state" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="zipCode">zipCode</label>
                        <div class="col-md-7">
                            <form:input type="text" path="zipCode" id="zipCode" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="zipCode" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-actions floatRight">
                        <input type="submit" value="Register" class="btn btn-primary btn-sm"> or <a
                            href="<c:url value='/' />">Cancel</a>
                    </div>
                </div>
            </form:form>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>