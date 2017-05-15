<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<tiles:insertDefinition name="defaultTemplate">

    <tiles:putAttribute name="title" value="Создать нового пользователя" />

    <tiles:putAttribute name="body">
        <div class="form-container">

            <h1>New User Registration Form</h1>

            <form:form method="POST" modelAttribute="user" class="form-horizontal">

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="login">Login</label>
                        <div class="col-md-7">
                            <form:input type="text" path="login" id="login" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="login" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="password">Password</label>
                        <div class="col-md-7">
                            <form:input type="password" path="password" id="password" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="password" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="lastName">Last Name</label>
                        <div class="col-md-7">
                            <form:input type="text" path="lastname" id="lastname" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="lastname" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="firstname">First Name</label>
                        <div class="col-md-7">
                            <form:input type="text" path="firstname" id="firstname" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="firstname" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="gender">Gender</label>
                        <div class="col-md-7">
                            <form:input type="text" path="gender" id="gender" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="gender" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="age">Age</label>
                        <div class="col-md-7">
                            <form:input type="age" path="age" id="age" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="age" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="userProfiles">Roles</label>
                        <div class="col-md-7">
                            <form:select id="userProfiles" path="userProfiles" items="${roles}" multiple="true"
                                         itemValue="id" itemLabel="type" class="form-control input-sm"/>
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