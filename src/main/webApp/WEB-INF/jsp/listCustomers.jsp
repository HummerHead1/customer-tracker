<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<head>

    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/static/style.css">
    <title>List Customers</title>

</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relations Manager</h2>
    </div>
    <form action="addCustomerForm">
        <input type="button" value="Add Customer" onclick="location.href='addCustomerForm'" class="add-button" />
    </form>
</div>
<div id="content">
    <table>
        <tr>
            <th>First name</th>
            <th>Last name</th>
            <th>Email</th>
            <th></th>
        </tr>

        <c:forEach var="customer" items="${customers}">
            <c:url value="/customer/deleteCustomer" var="deleteCustomer">
                <c:param name="customerId" value="${customer.id}"/>
            </c:url>
            <c:url value="/customer/updateCustomerForm" var="updateCustomer">
                <c:param name="customerId" value="${customer.id}"/>
            </c:url>
            <tr>
                <td>${customer.firstName}</td>
                <td>${customer.lastName}</td>
                <td>${customer.email}</td>
                <td> <a href="${updateCustomer}">Update Customer</a></td>
                <td> <a href="${deleteCustomer}">Delete Customer</a></td>
            </tr>
        </c:forEach>


    </table>
</div>
</body>

</html>









