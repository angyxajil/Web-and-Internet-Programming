<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Listing Page</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

</head>

<body>

	<nav aria-label="breadcrumb" class="mx-5">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="Home">Home</a></li>
			<li class="breadcrumb-item active" aria-current="page">Student
				List</li>
		</ol>
	</nav>

	<a href='NewStudent' class='btn btn-outline-primary'>New Student</a>

	<form method='post'>
		<table class='table'>
			<thead>
				<tr>
					<th>Student</th>
					<th>Age</th>
					<th>Parent</th>
					<th>Email</th>
					<th>Group</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${studentEntries}" var="currentStudent">
					<tr>
						<td>${currentStudent.name}</td>
						<td>${currentYear - currentStudent.birthYear }</td>
						<td>${currentStudent.parentName}</td>
						<td>${currentStudent.parentEmail}</td>

						<c:if test="${currentStudent.group.name=='No Group'}">
							<td></td>
						</c:if>

						<c:if test="${currentStudent.group.name !='No Group'}">
							<td>${currentStudent.groupName}</td>
						</c:if>

						<td><a class='btn btn-outline-secondary'
							href="EditStudent?studentId=${currentStudent.studentId}">Edit</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>
</html>