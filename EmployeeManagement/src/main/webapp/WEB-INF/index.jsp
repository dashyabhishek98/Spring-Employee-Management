<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Employees</title>
</head>
<body>
<table>
<tr>
<th>ID</th>
<th>First Name</th>
<th>Last Name</th>
<th>Email</th>
</tr>
<c:forEach var="tempEmployee" items="${employee}" >
<tr>
<td>${tempEmployee.id}</td>
<td>${tempEmployee.firstName}</td>
<td>${tempEmployee.lastName}</td>
<td>${tempEmployee.email}</td>
</c:forEach></table>
<input type="button" value="Search" onclick="window.location.href='showFormForSearch'"/>
</body>
</html>