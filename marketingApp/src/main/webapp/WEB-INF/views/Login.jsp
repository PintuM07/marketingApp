<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<nav><a href="view">Register</a></nav>
    <h2>Login</h2>
<form action="/login" method="post">
    <input type="email" name="email" required>
    <input type="password" name="password" required>
    <!-- Your submit button -->
    <button type="submit">Login</button>
</form>
    ${msg}
</body>
</html>
