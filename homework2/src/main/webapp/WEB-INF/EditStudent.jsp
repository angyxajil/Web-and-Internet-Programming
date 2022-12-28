<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student</title>

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
			<li class="breadcrumb-item"><a href="StudentListing">Student
					List</a></li>
			<li class="breadcrumb-item active" aria-current="page">Edit
				Student</li>
		</ol>
	</nav>

	<form action='EditStudent' method='post'>

		<input type='hidden' name='studentId' value='${studentInfo.studentId}'>

		<table class='table table-hover ml-2'>

			<tr class="input-group mt-3">
				<th class="input-group-text">Name</th>
				<td><input class='form-control' type='text' name='nameInput'
					value='${studentInfo.name}'></td>
			</tr>

			<tr class="input-group mt-3">
				<th class="input-group-text">Birth Year</th>
				<td><input class='form-control' name='birthYearInput'
					value='${studentInfo.birthYear}'></td>
			</tr>

			<tr class="input-group mt-3">
				<th class="input-group-text">Parent Name</th>
				<td><input class='form-control' type='text'
					name='parentNameInput' value='${studentInfo.parentName}'></td>
			</tr>

			<tr class="input-group mt-3">
				<th class="input-group-text">Parent Email</th>
				<td><input class='form-control' type='text'
					name='parentEmailInput' value='${studentInfo.parentEmail}'></td>
			</tr>

			<tr class='input-group mt-3'>
				<th class="input-group-text">Group</th>
				<td><select name='groupDropdown' class="form-select">
						<option value='${studentInfo.group.id}'>
							${studentInfo.group.name}</option>

						<c:forEach items="${groupEntries}" var="currentGroup">
							<c:if
								test="${currentGroup.numOfStudents<5 && currentGroup.name!='No Group' && currentGroup.id!=studentInfo.group.id}">
								<option value="${currentGroup.id}">
									${currentGroup.name}</option>
							</c:if>
						</c:forEach>

						<option value='0'></option>
				</select></td>
			</tr>

			<tr>
				<td colspan='2'><button class="btn btn-outline-primary"
						name='saveButton'>save</button></td>
			</tr>
		</table>
	</form>
</body>
</html>