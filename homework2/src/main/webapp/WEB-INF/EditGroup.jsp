<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Group</title>

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
			<li class="breadcrumb-item"><a href="GroupListing">Group
					List</a></li>
			<li class="breadcrumb-item active" aria-current="page">Edit
				Group</li>
		</ol>
	</nav>

	<form action='EditGroup' method='post'>
		<input type='hidden' name='id' value='${groupInfo.id}'>
		<table class='table table-hover'>

			<tr class="input-group">
				<th>Name</th>
				<td><input class='form-control' name='groupNameInput'
					value='${groupInfo.name}'></td>
			</tr>

			<tr>
				<td><ul>
						<c:forEach items="${studentEntries}" var="currentStudent">
							<c:if test="${currentStudent.group.id == groupId}">
								<li class='pt-3'>${currentStudent.getName()}<a
									class='btn btn-outline-danger'
									href="RemoveStudent?studentId=${currentStudent.studentId}&groupId=${groupId}">
										remove</a>
								</li>
							</c:if>
						</c:forEach>
					</ul></td>
			</tr>

			<tr>
				<td><button class="btn btn-outline-primary" name='saveButton'>Save</button></td>
			</tr>
		</table>

	</form>
</body>
</html>