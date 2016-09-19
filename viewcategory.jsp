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
${msg}
<c:url var="addAction" value="add"></c:url>
<form:form action="${add}" commandName="category">
</form:form>
 <c:if test="${!empty categoryList}">
<table>
<tr><th>Category ID</th>
<th>Category Name</th>
<th>Category Description</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<c:forEach items="${categoryList}" var="category">
<tr><td>${category.catid}</td>
<td>${category.name}</td>
<td>${category.description}</td>
<td><a href="<c:url value='update/${category.catid}'/>">Edit</a></td>
<td><a href="<c:url value='category/delete/${category.catid}'/>">Delete</a></td>
</tr>
</c:forEach>
</table>
</c:if>

</body>
</html> 