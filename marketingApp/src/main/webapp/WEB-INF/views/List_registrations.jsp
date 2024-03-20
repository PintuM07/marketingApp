<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>All Registrations</title>
    <div><a href="showLoginForm">Sign Out</a></div>
</head>
<body>

    <table>

        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Mobile</th>
            <th>Delete</th>
            <th>Update</th>
        </tr>

        <c:forEach var="registration" items="${registrations}">
        <tr>
            <td>${registration.firstName}</td>
            <td>${registration.lastName}</td>
            <td>${registration.email}</td>
            <td>${registration.mobile}</td>
            <td><a href="delete?id=${registration.id}">Delete</a></td>
            <td><a href="update?id=${registration.id}">Update</a></td>
        </tr>
        </c:forEach>

    </table>

    <!-- Add buttons for viewing and creating blog posts -->
    <div>
        <a href="getAllBlogs">View Blog Posts</a>
        <a href="writeBlog">Create Blog Post</a>
    </div>

</body>
</html>
