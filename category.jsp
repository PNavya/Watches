<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <link rel="stylesheet" href="<c:url value= "/resources/admin.css"/>">
 <html>
 <head>
 <title>Category Page</title>
 </head>
 
 <body>
 ${msg}
 <h1>Add a Category</h1>
 <c:url var="addAction" value="/category/add"> </c:url>
 <form:form action="${addAction}" commandName="category">
 <table>
 <tr>
 <td>Category Id:</td>
 <c:choose>
 <c:when test="${!empty category.catid}">
 <td><form:input path="catid" disabled="true" readonly="true"/></td>
 </c:when>
 <c:otherwise>
 <td><form:input path="catid" pattern="{4,7}" required="true" title="id should contain 4 to 7 characters"/></td>
 </c:otherwise>
 </c:choose>
 </tr>
 
 <tr>
 <td>Category Name:</td>
 <td><form:input path="name" required="true"/></td>
 </tr>
 
<tr>
<td>Category Description:</td>
 <td><form:input path="description" required="true"/></td>
 </tr>
 <tr>
 <%-- <td colspan="2"><c:if test="${!empty category.name}">
 <input type="submit" value="Update Category"/>
</c:if></td> --%>
<td>
 <input type="submit" value="Add Category"/></td>
</tr>
</table>
</form:form>
<br>
<h3>Category List</h3>
<c:if test="${!empty categoryList}">
<table class= "tg">
<tr>
<th width ="80">Category ID</th>
<th width ="120">Category Name</th>
<th width ="120">Category Description</th>
<th width ="60">Update</th>
<th width ="60">Delete</th>
</tr>

<c:forEach items="${categoryList}" var="category">
<tr>
<td>${category.catid}</td>
<td>${category.name}</td>
<td>${category.description}</td>
<td><a href="<c:url value='category/update/${category.catid}'/>">Update</a></td>
<td><a href="<c:url value='category/delete/${category.catid}'/>">Delete</a></td>
</tr>
</c:forEach>
</table>
</c:if>
</body>
 </html>