<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ECST Faculty - Add Faculty</title>
</head>
<body>
	<h3>
		<a href="DisplayFaculty">ECST Faculty</a> &gt; Add Faculty
	</h3>
	<form action="AddFaculty" method="post">
		<table border="1">
			<tr>
				<th>Department:</th>
				<td><select name="department">
						<c:forEach items="${departments}" var="department">
							<option>${department.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<th>Name:</th>
				<td><input type="text" name="faculty" /></td>
			</tr>
			<tr>
				<th>Chairperson:</th>
				<td><input type="checkbox" name="chair" /></td>
			<tr>
				<td colspan="2"><input type="submit" name="add" value="Add" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>