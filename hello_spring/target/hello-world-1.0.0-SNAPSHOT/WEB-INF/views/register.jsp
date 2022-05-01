<%--
  Created by IntelliJ IDEA.
  User: warrior245
  Date: 5/1/22
  Time: 10:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<form method="post" action="/confirm">
    <div class="form-group">
        <label for="exampleInputName1">Name</label>
        <input type="text" name="Name" class="form-control" id="exampleInputName1"  placeholder="Enter name">
    </div>
    <br>
    <div class="form-group">
        <label for="exampleInputEmail1">Email address</label>
        <input type="email" name="Email" class="form-control" id="exampleInputEmail1"  placeholder="Enter email">
    </div>
    <br>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" name="Password" class="form-control" id="exampleInputPassword1" placeholder="Password">
    </div>
    <br>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
