<%--
  Created by IntelliJ IDEA.
  User: warrior245
  Date: 5/1/22
  Time: 10:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation</title>
</head>
<body>
<div>
    <h3 style="color:green">
        Thank you for joining us! <%= request.getParameter("Name")%>
    </h3>
    <h3>
        Your email id is : <%= request.getParameter("Email")%>
    </h3>
</div>

<br>
<a href="/">home</a>
</body>
</html>
