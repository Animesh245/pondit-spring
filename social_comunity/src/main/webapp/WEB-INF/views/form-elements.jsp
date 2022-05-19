<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
${pageTitle}
<br>
<%--@elvariable id="usr" type="com.pondit.b4.entity.User"--%>
<form:form action="${pageContext.request.contextPath}/save" method="post" modelAttribute="usr">
    <div class="form-group">
        <label for="exampleInputEmail1">Name</label>
        <form:input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter name" path="name"></form:input>
    </div>
    <div class="form-group">
        <label for="exampleInputEmail1">Email address</label>
        <form:input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" path="email"></form:input>
    </div>
    <div class="form-group">
        <label for="exampleFormControlSelect1">Location</label>
        <form:select class="form-control" id="exampleFormControlSelect1" path="location">
            <form:option selected="true" value="Please select a location" disabled="true"></form:option>
            <form:options items="${locationList}"></form:options>
        </form:select>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form:form>