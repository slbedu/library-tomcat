<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log in</title>
<link rel="stylesheet" type="text/css" href="styles/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="styles/library.css" />
</head>
<body>

	<h1 align="center">
		<b>Log in</b>
	</h1>

	<form id="login_form" role="form" method="post" action="login">
		<div class="form-group">
			<label for="userName">Username:</label> <input type="text"
				class="form-control" name="userName" id="userName" value="">
		</div>
		<div class="form-group">
			<label for="pwd">Password:</label> <input type="password"
				class="form-control" name="password" id="pwd" value="">
		</div>

		<button type="reset" class="btn btn-default" id="reset_login">Reset</button>
		<button type="submit" class="btn btn-default">Log in</button>
	</form>
	
</body>
</html>