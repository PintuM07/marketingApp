<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="Menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Lead</title>
<div><a href="showLoginForm">Sign Out</a></div>
</head>
<body>
	<h2>Update Lead</h2>
	<form action="updateReg" method="post">
		<pre>
		<input type="hidden" name="id" value="${registration.id }" />
		First Name <input type="text" name="firstName"value="${registration.firstName }" />
		First Name <input type="text" name="lastName"value="${registration.lastName }" />
		Email <input type="text" name="email" value="${registration.email }" />
		Mobile <input type="text" name="mobile" value="${registration.mobile }" />
	<input type="submit" value="Update" />
	</pre>

	</form>
	${msg }
</body>
</html>