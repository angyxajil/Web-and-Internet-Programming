<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Listing Page</title>
<!-- imports bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

</head>
<body>

	<!-- This is to control the breadcrumb header -->
	<nav aria-label="breadcrumb" class="mx-5">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="Home">Home</a></li>
			<li class="breadcrumb-item active" aria-current="page">Student
				Listing</li>
		</ol>
	</nav>

	<a href='NewStudent' class='btn btn-primary'>New Student</a>
	<form method='post'>
		<table class='table'>
			<!-- header that holds all important imformation -->
			<thead>
				<tr>
					<th>Student</th>
					<th>Age</th>
					<th>Parent</th>
					<th>Email</th>
					<th>Group</th>
					<th></th>
				</tr>
			</thead>
			<!-- show the students that are saved -->
			<tbody>
				<c:forEach items="${studentEntries}" var="currentStudent">
					<tr>
						<td>${currentStudent.name}</td>
						<td>${currentYear - currentStudent.birthYear }</td>
						<td>${currentStudent.parentName}</td>
						<td>${currentStudent.parentEmail}</td>
						<td>${currentStudent.groupName}</td>
						<td><a class='btn btn-info'
							href="EditStudent?studentId=${currentStudent.studentId}">Edit</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>
</html>