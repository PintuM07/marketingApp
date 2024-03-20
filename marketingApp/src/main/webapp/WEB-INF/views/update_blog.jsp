<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Blog</title>
    <div><a href="showLoginForm">Sign Out</a></div>
</head>
<body>
    <h2>Update Blog</h2>
    <form action="/updateBlogPost" method="post">
        <input type="hidden" name="id" value="${blogPost.id}">
        Title: <input type="text" name="title" value="${blogPost.title}"><br>
        Content: <textarea name="content">${blogPost.content}</textarea><br>
        Author: <input type="text" name="author" value="${blogPost.author}"><br>
        <button type="submit">Update Blog</button>
    </form>
</body>
</html>
