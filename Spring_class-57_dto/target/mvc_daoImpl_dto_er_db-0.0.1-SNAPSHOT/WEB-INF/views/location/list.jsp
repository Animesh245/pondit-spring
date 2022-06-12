<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: warrior245
  Date: 6/5/22
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Location List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/51be22c3ae.js" crossorigin="anonymous"></script>
<%--    <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">--%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css">
</head>
<body>
<%@include file="../../resources/js/header.ejs" %>
<br>
<div class="container">
    <table class="table table-bordered">
        <thead class="thead-dark">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Location Name</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>
<%--        <h4>Locations(${locationList.size()})</h4>--%>
        <c:forEach var="location" items="${locationList}">
            <tr>
                <th scope="row" class="td">${location.getId()}</th>
                <td class="td">${location.getLocationName()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
