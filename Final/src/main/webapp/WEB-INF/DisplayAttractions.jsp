<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Attractions</title>

<!-- imports bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

</head>
<body>

	<h1>Attractions</h1>

	<a href = 'AddAttraction'> Add An Attraction </a>

	<table class='table'>

		<thead>
			<tr>
				<th>Name</th>

				<th>Phone</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${attEntries}" var="currentPark">
				<tr>
					<td> <a href = 'AddReview'> ${currentPark.name} </a> </td>
					<td>${currentPark.phone}</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

</body>
</html>