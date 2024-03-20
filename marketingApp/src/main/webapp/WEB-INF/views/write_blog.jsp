<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Write Your Blog</title>
    <a href="getAllBlogs">View Blog Posts</a>
</head>
<body>
<div><a href="showLoginForm">Sign Out</a></div>
    <h2>Write Blog</h2>
    <form action="/saveBlog" method="post">
        Title: <input type="text" name="title"><br>
        Content: <textarea name="content"></textarea><br>
        Author: <input type="text" name="author"><br>
        <button type="submit">Save Blog</button>
        
        
    </form>
</body>
</html>
