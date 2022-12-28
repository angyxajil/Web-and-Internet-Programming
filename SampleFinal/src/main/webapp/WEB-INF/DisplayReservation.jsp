<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Reservations</title>
<!-- imports bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

</head>
<body>
	<table class='table'>
		<thead>
			<tr>
				<th></th>
				<c:forEach items="${days}" var="currentDay">
					<th>${currentDay}</th>
				</c:forEach>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${timeSlots}" var="currentSlot">
				<tr>
					<td>${currentSlot}</td>

					<c:forEach items="${resEntries}" var="currentRes">

						<c:if test="${currentRes.time == currentSlot}">

							<c:if test="${currentRes.weekDay == 'MON'}">

								<td><a
									href="DeleteReservation?time=${currentRes.time}&weekDay=${currentRes.weekDay}">
										${currentRes.name} </a></td>
							</c:if>



							<c:if test="${currentRes.weekDay == 'TUE'}">

								<td><a
									href="DeleteReservation?time=${currentRes.time}&weekDay=${currentRes.weekDay}">
										${currentRes.name} </a></td>

							</c:if>

							<td></td>

							<c:if test="${currentRes.weekDay == 'WED'}">

								<td><a
									href="DeleteReservation?time=${currentRes.time}&weekDay=${currentRes.weekDay}">
										${currentRes.name} </a></td>

							</c:if>

							<td></td>

							<c:if test="${currentRes.weekDay == 'THR'}">

								<td><a
									href="DeleteReservation?time=${currentRes.time}&weekDay=${currentRes.weekDay}">
										${currentRes.name} </a></td>

							</c:if>

							<td></td>

							<c:if test="${currentRes.weekDay == 'FRI'}">

								<td><a
									href="DeleteReservation?time=${currentRes.time}&weekDay=${currentRes.weekDay}">
										${currentRes.name} </a></td>

							</c:if>

							<tr></tr>
						</c:if>


					</c:forEach>

				</tr>
			</c:forEach>
		</tbody>
	</table>

	<form action="MakeReservation" method='post'>

		<table class='table' style='width: 700px'>

			<tr>

				<td>
					<!-- DROPDOWN TO CHOOSE DAY  --> <select class="form-select"
					name="dayDropdown" style='width: 230px'>

						<c:forEach items="${days}" var="currentDay">

							<option value="${currentDay}">${currentDay}</option>

						</c:forEach>

				</select>
				</td>

				<td>
					<!-- DROPDOWN TO CHOOSE TIME  --> <select name="timeDropdown"
					class="form-select" style='width: 230px'>

						<c:forEach items="${timeSlots}" var="currentSlot">

							<option value="${currentSlot}">${currentSlot}</option>

						</c:forEach>

				</select>

				</td>

				<td><input name='nameInput' class='form-control'></td>

				<td><button name='addButton' class='btn btn-primary'>Reserve</button></td>
			</tr>

		</table>

	</form>
</body>
</html>