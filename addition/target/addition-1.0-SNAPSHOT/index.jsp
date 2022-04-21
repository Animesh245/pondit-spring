<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Input Data</title>
</head>
<body bgcolor="#add8e6">
<%= "This is the First Page of the servlet."%>
<br>

<form action="result" method="post">
    <%= "Enter 1st Number: "%> <input type="text" name="n1"><br>
    <%= "Enter 2nd Number: "%> <input type="text" name="n2"><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>