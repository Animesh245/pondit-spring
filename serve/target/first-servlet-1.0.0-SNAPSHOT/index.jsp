<%--
  Created by IntelliJ IDEA.
  User: Reborn
  Date: 4/12/2022
  Time: 6:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="<%= request.getContextPath()%>/list">User Management Application</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
<%--                    <li class="nav-item">--%>
<%--                        <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>--%>
<%--                    </li>--%>
                    <li class="nav-item">
                        <a class="nav-link" href="<%= request.getContextPath()%>/new">Add User</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>

<br>

    <%

    %>

<table class="table">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Email</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${listUser}">
    <tr>
        <td><c:out value="${user.id}"/></td>
        <td><c:out value="${user.name}"/></td>
        <td><c:out value="${user.email}"/></td>
        <td><c:out value="${user.password}"/></td>
        <td><a href="edit?id=<c:out value="${user.id}"/>"> Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;<a href="delete?id=<c:out value ="${user.id}"/>">Delete</a></td>

    </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

<%--<i class="fa-solid fa-pen-to-square"></i>--%>
<%--<i class="fa-solid fa-trash-can"></i>--%>