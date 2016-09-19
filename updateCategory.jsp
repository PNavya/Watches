<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adding</title>
</head>
<body>
	<center>
		<h2>Updating Category</h2>
		<form:form method="POST" action="edit/{category.catid}" commandName="category">
			<table>
				<tr>
					<td>Category Id:</td>
					<td><form:input type="text" path="catid" value="${cat.catid}"
							readonly="readonly" /></td>
				</tr>
				<tr>
					<td>Category Name:</td>
					<td><form:input type="text" path="name" value="${cat.name}" /></td>
				</tr>
				<tr>
					<td>Category Description:</td>
					<td><form:input type="text" path="description"
							value="${cat.description}" /></td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" value="Submit" /></td>
					<td><input type="reset" value="Reset" /></td>
				</tr>
			</table>
		</form:form>
		<h3>Category List</h3>
		<c:if test="${!empty categoryList}">
			<table class="tg">
				<tr>
					<th width="80">Category ID</th>
					<th width="120">Category Name</th>
					<th width="120">Category Description</th>
					<th width="60">Update</th>
					<th width="60">Delete</th>
				</tr>

				<c:forEach items="${categoryList}" var="category">
					<tr>
						<td>${category.catid}</td>
						<td>${category.name}</td>
						<td>${category.description}</td>
						<td><a href="<c:url value='update/${category.catid}'/>">Update</a></td>
						<td><a
							href="<c:url value='category/delete/${category.catid}'/>">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</center>
</body>
</html>