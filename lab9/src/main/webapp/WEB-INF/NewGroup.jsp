<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Group</title>
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
			<li class="breadcrumb-item"><a href="ListGroups9">Group
					Listing</a></li>
			<li class="breadcrumb-item active" aria-current="page">New Group</li>
		</ol>
	</nav>

	<form method='post'>
		<table class='table'>
			<tr class="input-group mx-3 my-2">
				<th class='input-group-text'>Name</th>
				<td><input name='groupNameInput' class='form-control'></td>
			</tr>
			<tr>
				<td colspan='2'><button class='btn btn-primary'
						name='addButton'>Add</button></td>
			</tr>
		</table>
	</form>
</body>
</html>