<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<div><a href="showLoginForm">Sign Out</a></div>
    <meta charset="UTF-8">
    <title>All Blog Posts</title>
    
</head>
<body>
    <div><a href="getAllReg">See Users</a></div>

    <h2>All Blog Posts</h2>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Content</th>
                <th>Author</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="blogPost" items="${blogPosts}">
                <tr>
                    <td>${blogPost.id}</td>
                    <td>${blogPost.title}</td>
                    <td>${blogPost.content}</td>
                    <td>${blogPost.author}</td>
                    <td><a href="/updateBlog?id=${blogPost.id}">Edit</a></td>
                    <td>
                        <form action="/deleteBlog" method="post">
                            <input type="hidden" name="id" value="${blogPost.id}">
                            <button type="submit">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <div><a href="writeBlog">Create A New Blog</a></div>
</body>
</html>
