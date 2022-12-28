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

	<a href='DisplayAttractions'> Attractions </a> 

	<form action = 'AddReview' method = 'post'>

		<table class='table'>
			<thead>
				<tr>
					<th>Reviewer Name</th>
					<th>Review</th>

				</tr>
			</thead>


			<tbody>
				<c:forEach items="${revEntries}" var="currentRev">
					<tr>
						<td>${currentRev.name}</td>
						<td>${currentRev.review}</td>
						<td></td>

					</tr>

				</c:forEach>

				<tr>
					<td><input name='name' class='form-control'></td>

					<td><input name='review' class='form-control'></td>
					
					<td><input type = "hidden" name='park' class='form-control'></td>

					<td><button name='addButton' class='btn btn-primary'>Add</button></td>
				</tr>
			</tbody>

		</table>

	</form>


</body>
</html>