<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Request</title>
</head>
<body>

	<form method=post>
		<table border="1">

			<th><b>Your Name:</b></th>
			<th><input type="text" name="name"></th>

			<tr>
				<th><b> Service Type </b></th>
				<th><select name="type">

						<option value="Computer">Computer</option>
						<option value="Network">Network</option>
						<option value="Phone">Phone</option>
						<option value="Account">Account</option>

				</select></th>
			</tr>

			<tr>
				<th><b> Description: </b></th>
				<th><input type="text" name="description"></th>
			</tr>

			<tr>
				<th colspan='2'> <button>Create</button></th>
			</tr>

		</table>
	</form>

</body>
</html>