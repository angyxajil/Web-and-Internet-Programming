<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Answers</title>
</head>
<body>

<p> <a href = "ListPolls"> Back to Polls </a> </p>

	<p>${poll.question }</p>

	<c:forEach items="${poll.answers }" var="answer">

		<div>${answer}</div>

	</c:forEach>

	<form method="post">
		<input type="text" name="answer">
		<button>Add</button>
	</form>

</body>
</html>