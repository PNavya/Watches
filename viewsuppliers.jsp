<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Categories</title>
</head>
<body>
<%-- ${msg}
<c:url var="addAction" value="add"></c:url>
<form:form action="${add}" commandName="category">
</form:form> --%>
 <c:if test="${!empty categoryList}">
<table>
<tr><th>Supplier ID</th>
<th>Supplier Name</th>
<th>Address</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<c:forEach items="${supplierList}" var="supplier">
<tr><td>${supplier.supid}</td>
<td>${supplier.name}</td>
<td>${supplier.address}</td>
<td><a href="<c:url value='updateSupplier/${supid}'/>">Edit</a></td>
<td><a href="<c:url value='deleteSupplier/${supplier.supid}'/>">Delete</a></td>
</tr>
</c:forEach>
</table>
</c:if>

</body>
</html> 