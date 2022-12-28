<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Group</title>
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
			<li class="breadcrumb-item"><a href="GroupListing">Group
					Listing</a></li>
			<li class="breadcrumb-item active" aria-current="page">Edit
				Group</li>
		</ol>
	</nav>

	<form action='EditGroup' method='post'>
		<input type='hidden' name='groupId' value='${groupInfo.id}'>
		<table class='table table-hover'>
			<!-- row that shows the header/input  -->
			<tr class="input-group mx-3 my-2">
				<th>Name</th>
				<td><input class='form-control' name='groupNameInput'
					value='${groupInfo.name}'></td>
			</tr>
		</table>
		<!-- row that shows the students in current group -->
		<table class='table' style = "border-style: hidden">

			<c:forEach items="${studentEntries}" var="currentStudent">
				<c:if test="${currentStudent.groupName == groupInfo.name}">
					<tr class="input-group mx-3 my-2">
						<ul>
						<td style="width: 10%">
							<li class='pt-3'>${currentStudent.getName()}</li>
						</td>
						</ul>
						<td style="text-align: left;"><a class='btn btn-danger'
							href="RemoveStudent?studentId=${currentStudent.studentId}&groupId=${groupId}">
								remove</a></td>
				</c:if>
			</c:forEach>


			</tr>
			<!-- row that shows the button to save -->
			<tr class="input-group mx-3 my-2">
				<td><button class="btn btn-primary" name='saveButton'>Save</button></td>
			</tr>
		</table>

	</form>
</body>
</html>