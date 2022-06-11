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
<%--    <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">--%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css">
</head>
<body>
<%@include file="../../resources/js/header.ejs" %>
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Location Name</th>
        </tr>
        </thead>
        <tbody>
        <h4>Locations(${locationList.size()})</h4>
        <c:forEach var="location" items="${locationList}">
            <tr>
                <th scope="row">${location.getId()}</th>
                <td>${location.getLocationName()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
