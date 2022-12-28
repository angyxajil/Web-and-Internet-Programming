<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Service Requests</title>
</head>
<body>

	<table border="1">

		<th><b>Request Time</b></th>
		<th><b>Requested By</b></th>
		<th><b>Service Type</b></th>
		<th><b>Status</b></th>

		<c:forEach items="${servs}" var="serv">
			<tr>
				<td>${serv.time}</a></td>
				<td>${serv.name}</a></td>
				<td>${serv.type}</a></td>
				<td>${serv.status}</a></td>
				<td>Details Update</td>
			</tr>
		</c:forEach>

	</table>
	
	<p> <a href = "CreateRequest"> Create Service Request </a> </p>

</body>
</html>