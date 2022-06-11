<%--
  Created by IntelliJ IDEA.
  User: warrior245
  Date: 6/5/22
  Time: 5:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Saved</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css">
</head>
<body>
<%@include file="../../resources/js/header.ejs" %>
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
            <th scope="col">Password</th>
            <th scope="col">Location</th>
            <th scope="col">Attachment</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row">${user.getId()}</th>
            <td>${user.getUserName()}</td>
            <td>${user.getUserEmail()}</td>
            <td>${user.getUserPassword()}</td>
            <td>${user.getLocation().getLocationName()}</td>
            <td><img src="/images/${user.getAttachment().getAttachmentPath()}" height="100" width="100" class="img-thumbnail"/></td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
<%--Name: ${user.getName()}<br>--%>
<%--Email: ${user.getEmail()}<br>--%>
<%--Location: ${user.getLocation().getName()}<br>--%>
<%--Attachment Path: ${user.getAttachment().getAttachmentPath()}<br>--%>

