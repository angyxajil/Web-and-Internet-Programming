<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Poll</title>
</head>
<body>

	<p>${poll.question }</p>

	<c:forEach items="${poll.answers }" var="answer">

		<div>
			<c:if test="${poll.singleChoice}">
				<input type="radio">
			</c:if>
			
			<c:if test="${! poll.singleChoice}">
				<input type="checkbox">
			</c:if>
			${answer}
		</div>

	</c:forEach>

</body>
</html>