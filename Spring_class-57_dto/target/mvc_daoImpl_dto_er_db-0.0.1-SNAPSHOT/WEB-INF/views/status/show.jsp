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
    <title>Status</title>
</head>
<body>
<%@include file="../../resources/js/header.ejs" %>
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Title</th>
            <th scope="col">Description</th>
            <th scope="col">Privacy</th>
            <th scope="col">Location</th>
            <th scope="col">Attachment</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row">${status.getId()}</th>
            <td>${status.getStatusTitle()}</td>
            <td>${status.getStatusDescription()}</td>
            <td>${status.getStatusPrivacy()}</td>
            <td>${status.getLocation().getLocationName()}</td>
            <td><c:forEach var="image" items="${status.getStatusAttachmentList()}">
                <img src="/images/${image.getAttachmentPath()}" height="100px" width="100px" style="object-fit: cover" class="img-thumbnail"/>
            </c:forEach></td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
