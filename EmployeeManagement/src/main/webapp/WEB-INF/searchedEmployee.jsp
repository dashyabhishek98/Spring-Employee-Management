<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sesrched Employee</title>
</head>
<body>
<table>
<tr>
<th>ID</th>
<th>FirstName</th>
<th>LastName</th>
<th>Email</th></tr>
<tr>
<td>${employee.id}</td>
<td>${employee.firstName}</td>
<td>${employee.lastName}</td>
<td>${employee.email}</td></tr></table>
<!-- <input type="button" onclick="window.location.href='/employees'" value="All Employees"/> -->
</body>
</html>