<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="defaultTemplate">

    <tiles:putAttribute name="title" value="Добавить продукт"/>

    <tiles:putAttribute name="addToHead">
        <script>
            $(document).ready(function () {
                //add more file components if Add is clicked
                $('#addFile').click(function () {
                    $('.imgInner').append(
                        '<div>' +
                        ' <input type="file" size="50" name="files" class="form-control" accept="image/*" onchange="readURL(this);"/>' +
                        '<img src="#"/>' +
                        '</div>'
                    )
                    ;
                });
            });
            function readURL(input) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        $(input).next()
                            .attr('src', e.target.result)
                            .width(50)
                            .height(50);
                    };

                    reader.readAsDataURL(input.files[0]);
                }
            }
        </script>
    </tiles:putAttribute>

    <tiles:putAttribute name="body">

        <div class="form-container">
            <form:form method="POST" modelAttribute="product" class="form-horizontal" enctype="multipart/form-data">

                <form:input type="hidden" path="id"/>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="name">Name product</label>
                        <div class="col-md-7">
                            <form:input type="text" path="name" id="name" class="form-control input-sm"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="description">Description</label>
                        <div class="col-md-7">
                            <form:textarea type="text" path="description" id="description" class="form-control"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="producer">Producer</label>
                        <div class="col-md-7">
                            <form:input type="text" path="producer" id="producer" class="form-control"/>
                        </div>
                    </div>
                </div>

                <div class="images">
                    <div class="row">
                        <div class="form-group col-md-12">
                            <input id="addFile" type="button" value="Добавить файл"/>
                            <label class="col-md-3">Image</label>
                            <div class="col-md-7 imgInner">
                                <small class="form-text text-muted">Загрузить картинку продукта</small>
                                <div>
                                    <input type="file" size="50" name="files" class="form-control" accept="image/*"
                                           onchange="readURL(this);"/>
                                    <img src="#"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="type">Type</label>
                        <div class="col-md-7">
                            <form:input type="text" path="type" id="type" class="form-control"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="price">Price</label>
                        <div class="col-md-7">
                            <form:input type="text" path="price" id="price" class="form-control"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group">
                        <div class="form-actions floatRight">
                            <input type="submit" value="Добавить" class="btn btn-primary btn-sm"> or <a
                                href="<c:url value='/' />">Cancel</a>
                        </div>
                    </div>
                </div>
            </form:form>

        </div>

    </tiles:putAttribute>

</tiles:insertDefinition>