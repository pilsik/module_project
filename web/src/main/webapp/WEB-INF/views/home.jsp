<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<tiles:insertDefinition name="defaultTemplate">

    <tiles:putAttribute name="title" value="Домашняя"/>

    <tiles:putAttribute name="addToHead">
        <script src="//api-maps.yandex.ru/2.0/?load=package.standard&lang=ru-RU" type="text/javascript"></script>
        <script src="/js/geolocation_ip.js" type="text/javascript"></script>
        <script src="/js/userRegionCookies.js" type="text/javascript"></script>
    </tiles:putAttribute>

    <tiles:putAttribute name="body">
        <div class="row">
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <h2>
                    Welcome : ${pageContext.request.userPrincipal.name} | <a
                        href="javascript:formSubmit()"> Logout</a>
                </h2>
            </c:if>
            <sec:authorize access="isRememberMe()">
                <h2># This user is login by "Remember Me Cookies".</h2>
            </sec:authorize>
            <sec:authorize access="isFullyAuthenticated()">
                <h2># This user is login by username / password.</h2>
            </sec:authorize>
        </div>
        <div class="row">
            <div id="regionSelectDiv">
                <select id="regionSelect">
                    <option value="" disabled selected hidden>Выберите область</option>
                    <option value="mogilev">Могилёвская область</option>
                    <option value="vitebsk">Витебская область</option>
                    <option value="brest">Брестская область</option>
                    <option value="gomel">Гомельская область</option>
                    <option value="minsk">Минская область</option>
                    <option value="grodno">Гродненская область</option>
                </select>
                <button type="button" id="addRegionToCookies">Добавить регион в куки</button>
            </div>
        </div>
        <div id="showCookie" class="row">
            <p>У вас выбрана область:</p>
            <spans id="spanNameRegion">${cookie[userRegion].value}</spans>
            <button type="button" id="deleteRegionToCookies">Удалить регион в куки</button>
        </div>
        <div class="row">
            <div id="map" style="width:100%; height:800px;"></div>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>
