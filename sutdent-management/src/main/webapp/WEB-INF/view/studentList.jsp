<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Management</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
</head>
<body>
	<div>
		<nav align="center" class="navbar navbar-dark bg-dark">
			<span class="navbar-text"><h1> Student Management </h1></span>
		</nav>
		<br>
		<div align="left">
		<form action="/sutdent-management/showAddStudentPage">
			<input type="submit" value="Add Student" class="btn btn-success">
		</form>
		<br>
		</div>
		<div align="center">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<td>ID</td>
						<td>NAME</td>
						<td>MOBILE</td>
						<td>COUNTRY</td>
						<td>UPDATE</td>
						<td>DELETE</td>
					</tr>
				</thead>
				<c:forEach var="student" items= "${students }">
					<tr>
						<td>${student.id}</td>  <!-- calls student.getId() -->
						<td>${student.name}</td>
						<td>${student.mobile}</td>
						<td>${student.country}</td>
						<td> <a class="btn btn-primary" href="/sutdent-management/updateStudent?userId=${student.id}">Update</a></td>
						<td> <a class="btn btn-danger" href="/sutdent-management/deleteStudent?userId=${student.id}" onclick="if(!confirm('Are you sure to delete records of ${student.name}')) return false">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		<img alt="student photo" src="/sutdent-management/URLToReachResoursesFolder/images/students.jpg">
		</div>
	</div>	
</body>
</html>