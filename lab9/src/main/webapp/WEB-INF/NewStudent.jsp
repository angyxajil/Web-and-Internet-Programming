<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>
<!-- imports bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

</head>
<body>
	<!-- This is to control the breadcrumb header -->
	<nav aria-label="breadcrumb" class='mx-5'>
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="HomePage9">Home</a></li>
			<li class="breadcrumb-item"><a href="ListStudent9">Student
					Listing</a></li>
			<li class="breadcrumb-item active" aria-current="page">New
				Student</li>
		</ol>
	</nav>

	<form method='post'>
		<table class='table'>
			<!-- row that controls the name -->
			<tr class='input-group mt-3 mx-5'>
				<th class='input-group-text'>Name</th>
				<td><input class='form-control' type='text' name='nameInput'></td>
			</tr>
			<!-- row that controls the birth year -->
			<tr class='input-group mt-3 mx-5'>
				<th class='input-group-text'>Birth Year</th>
				<td><input class='form-control' name='birthYearInput'></td>
			</tr>
			<!-- row that controls the parent name -->
			<tr class='input-group mt-3 mx-5'>
				<th class='input-group-text'>Parent Name</th>
				<td><input class='form-control' type='text'
					name='parentNameInput'></td>
			</tr>
			<!-- row that controls the parent email -->
			<tr class='input-group mt-3 mx-5'>
				<th class='input-group-text'>Parent Email</th>
				<td><input class='form-control' type='text'
					name='parentEmailInput'></td>
			</tr>
			<!-- row that controls the group selected -->
			<tr class='input-group mt-3 mx-5'>
				<th class='input-group-text'>Group</th>
				<td><select class="form-select" name='groupDropdown'>
						<c:forEach items="${groupEntries}" var="currentGroup">
							<c:if
								test="${currentGroup.numOfStudents<5 && currentGroup.name!='No Group'}">
								<option value="${currentGroup.id}">${currentGroup.name}
								</option>
							</c:if>
						</c:forEach>
						<option value='0'></option>
				</select></td>aq
			</tr>
			<tr>
				<td colspan='2'><button name='addButton'
						class='btn btn-primary'>Add</button></td>
			</tr>
		</table>
	</form>
</body>
</html>