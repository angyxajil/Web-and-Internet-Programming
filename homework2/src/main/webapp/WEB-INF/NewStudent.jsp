<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

</head>

<body>

	<nav aria-label="breadcrumb" class='mx-5'>
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="Home">Home</a></li>
			<li class="breadcrumb-item"><a href="StudentListing">Student
					List</a></li>
			<li class="breadcrumb-item active" aria-current="page">New
				Student</li>
		</ol>
	</nav>

	<form method='post'>
		<table class='table'>

			<tr class='input-group mt-3 mx-5'>
				<th>Name</th>
				<td><input class='form-control' type='text' name='nameInput'></td>
			</tr>

			<tr class='input-group mt-3 mx-5'>
				<th>Birth Year</th>
				<td><input class='form-control' name='birthYearInput'></td>
			</tr>

			<tr class='input-group mt-3 mx-5'>
				<th>Parent Name</th>
				<td><input class='form-control' type='text'
					name='parentNameInput'></td>
			</tr>

			<tr class='input-group mt-3 mx-5'>
				<th>Parent Email</th>
				<td><input class='form-control' type='text'
					name='parentEmailInput'></td>
			</tr>

			<tr class='input-group mt-3 mx-5'>
				<th>Group</th>
				<td><select class="form-select" name='groupDropdown'>
						<c:forEach items="${groupEntries}" var="currentGroup">
							<c:if
								test="${currentGroup.numOfStudents<5 && currentGroup.name!='No Group'}">
								<option value="${currentGroup.id}">
									${currentGroup.name}</option>
							</c:if>
						</c:forEach>

						<option value='0'></option>
				</select></td>
			</tr>

			<tr class='input-group mt-3 mx-5'>
				<td colspan='2'><button name='addButton'
						class='btn btn-outline-primary'>Add</button></td>
			</tr>
		</table>
	</form>
</body>
</html>