<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel="stylesheet" type="text/css" href="styles/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="styles/library.css" />
</head>
<body>

	<h1 align="center">
		<b>REGISTRATION FORM</b>
	</h1>

	<form id="register_form" role="form" method="post">
		<div class="form-group">
			<label for="userName">Username:</label> <input type="text"
				class="form-control" name="userName" id="userName" value="">
		</div>
		<div class="form-group">
			<label for="password">Password:</label> <input type="password"
				class="form-control" name="password" id="password" value="">
		</div>
		
		<div class="form-group">
			<label for="confirmPassword">Confirm password:</label> <input type="password"
				class="form-control" name="confirmPassword" id="confirmPassword" value="">
		</div>
		
		<div class="form-group">
			<label for="email">Email:</label> <input type="email"
				class="form-control" name="email" id="email" value="">
		</div>
		<button type="reset" class="btn btn-default">Reset</button>
		<button type="submit" class="btn btn-default">Register</button>
	</form>
	
</body>
</html>