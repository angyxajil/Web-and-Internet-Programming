<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ECST Faculty</title>
</head>
<body>
	<h3>ECST Faculty</h3>
	<p>
		<a href="AddDepartment">Add Department</a> | <a href="AddFaculty">Add
			Faculty</a>
	</p>
	<table border="1">
		<tr>
			<th>Department</th>
			<th>Faculty</th>
		</tr>
		<c:forEach items="${departments}" var="department">
			<c:choose>
				<c:when test="${fn:length(department.faculty) == 0}">
					<tr>
						<td>${department.name}</td>
						<td></td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<td rowspan="${fn:length(department.faculty)}">${department.name}</td>
						<td>${department.faculty[0].name} <c:if
								test="${department.faculty[0].chair}">(Chair)</c:if>
						</td>
					</tr>
					<c:forEach items="${department.faculty}" var="faculty"
						varStatus="status">
						<c:if test="${not status.first}">
							<tr>
								<td>${faculty.name} <c:if test="${faculty.chair}">(Chair)</c:if>
								</td>
							</tr>
						</c:if>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</table>
</body>
</html>