<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Group Listing Page</title>
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
			<li class="breadcrumb-item active" aria-current="page">Group
				Listing</li>
		</ol>
	</nav>

	<a class='btn btn-primary' href='NewGroup'>New Group</a>
	<form method='post'>
		<table class='table'>
			<thead>
				<tr>
					<th>Group</th>
					<th>Members</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${groupEntries}" var="currentGroup">
					<tr>
						<td>${currentGroup.name}</td>
						<td><c:forEach items="${studentEntries}" var="currentStudent">
								<c:if test="${currentStudent.group.name==currentGroup.name}">
										${currentStudent.name}  
									</c:if>
							</c:forEach></td>
						<td><a class='btn btn-info'
							href="EditGroup?groupId=${currentGroup.id}">Edit</a></td>
					</tr>
				</c:forEach>

				<tr>
					<td>No Group</td>
					<td><c:forEach items="${studentEntries}" var="currentStudent">
							<c:if test="${currentStudent.group.name=='No Group'}">
									${currentStudent.name}, 
								</c:if>
						</c:forEach></td>
				</tr>

				<tr>

				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>