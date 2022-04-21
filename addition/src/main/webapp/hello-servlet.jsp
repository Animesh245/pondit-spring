<%--
  Created by IntelliJ IDEA.
  User: Reborn
  Date: 4/17/2022
  Time: 8:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello-Servlet</title>
</head>
<body bgcolor="#7fffd4">
<h3><%= "This is the 2nd page. The result is shown in this page:" %></h3>

<h4>The Result is <%= request.getAttribute("k") %></h4>
</body>
</html>
