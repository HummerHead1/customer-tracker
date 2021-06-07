<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Add customer form</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/static/style.css">
</head>
<body>
<h2>Add customer form</h2>
<form:form modelAttribute="customer" action="addCustomer" method="POST">
    <p>First name</p>
    <form:input path="firstName"/>
    <br>
    <p>Last name</p>
    <form:input path="lastName"/>
    <br>
    <p>Email</p>
    <form:input path="email"/>
    <br>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>