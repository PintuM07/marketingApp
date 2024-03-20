<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Lead</title>
</head>
<body>
	<div><h2>Create Lead</h2>
	<div><nav><a href="view">Register</a></nav>
	<nav><a href="showLoginForm">Login</a></nav></div>
	</div>
	<form action="saveReg" method="post">
		<pre>
		First Name <input type="text" name="firstName" />
	First Name <input type="text" name="lastName" />
	Email <input type="text" name="email" />
	Mobile <input type="text" name="mobile" />
	Password <input type="password" name="password" />
	<input type="submit" value="save" />
	</pre>

	</form>
	${msg }
</body>
</html>