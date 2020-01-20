<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create an account</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <%--    <c:if test="${pageContext.request.userPrincipal.name != null}">--%>
    <form id="logoutForm" method="POST" action="${contextPath}/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
    <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>

    <form id="uploadForm" method="POST" enctype="multipart/form-data" action="/picture/upload">
        <table>
            <tr><td>File to upload:</td><td><input type="file" name="file" /></td></tr>
<%--            <tr><td></td><td><input type="submit" value="Upload" /></td></tr>--%>
        </table>
        <input name="description" type="text" class="form-control" placeholder="Description"
               autofocus="true"/>
        <input name="category" type="text" class="form-control" placeholder="Category"
               autofocus="true"/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <select name="sel">
                <option value="MACHINE">MACHINE</option>
                <option value="MACHINE">MACHINE</option>
                <option value="MACHINE">MACHINE</option>
            </select>
            <br>
            <input type="Submit" value="Submit">
        </form>

<%--        <%--%>
<%--            String something =  (String)request.getAttribute("sel");--%>
<%--            if(something!=null){--%>

<%--            }--%>
<%--            else {--%>
<%--                something = "hello";--%>
<%--            }--%>
<%--        %>--%>
<%--        <input type="text" name="someName" value="<%= something %>" />--%>

        </form>
<%--    <h2><a onclick="document.forms['uploadForm'].submit()">upload</a></h2>--%>
    <%--    </c:if>--%>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
