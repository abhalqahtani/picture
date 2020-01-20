<%@ page import="sun.net.www.http.HttpClient" %>
<%@ page import="com.sun.deploy.net.HttpResponse" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Log in with your account</title>

      <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
  </head>

  <body>

    <div class="container">
        <form id="showpic" method="GET" action="${contextPath}/picture/show">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2><a onclick="document.forms['showpic'].submit()">show</a></h2>
<%--<%--%>
<%--    final HttpClient httpClient = new HttpClient();--%>
<%--    HttpConnectionParams.setConnectionTimeout(httpClient.getParams(), 10000);--%>
<%--    HttpGet httpget = new HttpGet(SERVER_URL + url);--%>
<%--    HttpResponse response = httpClient.execute(httpget);--%>
<%--%>--%>
        <h2 class="form-heading">Picture App</h2>
          <table class="table">
              <thead>
              <tr>
                  <th>Description</th>
                  <th>Category</th>
                  <th>URL</th>
                  <th style="width: 90px"></th>
              </tr>
              </thead>
              <tbody>
                  <td>{{booking.description}}</td>
                  <td>{{booking.category}}</td>
                  <td><a>{{booking.url}}</a> </td>

                  <td>
                      <!--                        <button class="btn btn-danger" ng-click="vm.deleteBooking(booking.id)">Delete</button>-->
                  </td>
              </tr>
              </tbody>
          </table>

      </form>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>
