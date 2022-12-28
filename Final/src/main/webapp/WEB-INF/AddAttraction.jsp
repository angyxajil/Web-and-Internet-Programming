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
	
	<form method='post'>
		<table class='table'>
			<tr class="input-group mx-3 my-2">
				<th>Attraction Name</th>
				<td><input name='name' class='form-control'></td>
			</tr>
			<tr class="input-group mx-3 my-2">
				<th>Phone Number</th>
				<td><input name='phone' class='form-control'></td>
			</tr>
			<tr class="input-group mx-3 my-2">
				<td colspan='2'><button class='btn btn-primary'
						name='addButton'>Add</button></td>
			</tr>
		</table>
	</form>

</body>
</html>