<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Group</title>

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
			<li class="breadcrumb-item"><a href="GroupListing">Group
					List</a></li>
			<li class="breadcrumb-item active" aria-current="page">New Group</li>
		</ol>
	</nav>

	<form method='post'>
		<table class='table'>
			<tr class="input-group mx-3 my-2">
				<th>Name</th>
				<td><input name='groupNameInput' class='form-control'></td>
			</tr>

			<tr class="input-group mx-3 my-2">
				<td colspan='2'><button class='btn btn-outline-primary'
						name='addButton'>Add</button></td>
			</tr>
		</table>
	</form>
</body>
</html>