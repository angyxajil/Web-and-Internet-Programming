<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Student List</title>
	</head>
	<body>
		<a href='NewStudent'>New Student</a>
		<form method='post'>
			<table border='1' cellpadding='2'>
				<tr>
					<th>Student</th>
					<th>Age</th>
					<th>Parent</th>
					<th>Email</th>
				</tr>
				<c:forEach items="${studentEntries}" var="currentStudent">
					<tr>
						<td>${currentStudent.name}</td>
						<td>${currentYear - currentStudent.birthYear }</td>
						<td>${currentStudent.parentName}</td>
						<td>${currentStudent.parentEmail}</td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</body>
</html>