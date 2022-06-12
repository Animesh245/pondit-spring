<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: warrior245
  Date: 6/5/22
  Time: 7:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Status List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/51be22c3ae.js" crossorigin="anonymous"></script>
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
            <th scope="col">Title</th>
            <th scope="col">Description</th>
            <th scope="col">Privacy</th>
            <th scope="col">Location</th>
            <th scope="col">Attachment</th>
            <th scope="col">Edit</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="status" items="${statusList}">
            <tr>
                <td class="td">${status.getId()}</td>
                <td class="td">${status.getStatusTitle()}</td>
                <td class="td">${status.getStatusDescription()}</td>
                <td class="td">${status.getStatusPrivacy()}</td>
                <td class="td">${status.getLocation().getLocationName()}</td>
                <td><c:forEach var="image" items="${status.getStatusAttachmentList()}">
                    <img src="/images/${image.getAttachmentPath()}"  height="100px" width="100px" style="object-fit: cover" class="img-thumbnail"/>
                </c:forEach></td>
                <td><i onclick="location='/status/update/${status.getId()}'" class="fa-solid fa-pen-to-square"></i></td>
                <td><i onclick="location='/status/delete/${status.getId()}'" class="fa-solid fa-trash-can"></i></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
