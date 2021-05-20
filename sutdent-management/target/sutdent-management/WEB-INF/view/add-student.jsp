<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
</head>
<body>
	
	<nav align="center" class="navbar navbar-dark bg-dark">
			<span class="navbar-text"> <h1>Student Management </h1></span>
	</nav>
	<div >
		<h1 align="center">Add Student</h1>
		<br/>
		<!-- create spring form -->
		<form:form action="save-student" modelAttribute="student" method="POST" class="container">
		
			<form:hidden path="id"/>
			<div class="mb-3">
				<label class="form-label">Name : </label>
				<form:input path="name" class="form-control"/>
			</div>
			
			<div class="mb-3">
				<label class="form-label">Mobile : </label>
				<form:input path="mobile" class="form-control"/>
			</div>
			
			<div class="mb-3">
				<label class="form-label">Country : </label>
				<form:input path="country" class="form-control"/>
			</div>
			
			<br/>
			<input class="btn btn-primary" type="submit"  value="submit" />
		</form:form>
	</div>
</html>