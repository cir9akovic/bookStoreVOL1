<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Book Store</title>
		<meta charset="UTF-8">
	    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/home.css"/>
	</head>
	<body>
		<h1>Welcome to BookStore</h1>
		<button onclick="window.location.href='authors'">Show me all Authors</button>
		<button onclick="window.location.href='geners'">Show me all Genres</button>
		<br></br>
		<button onclick="window.location.href='books'">Show me all Books</button>
		<button onclick="window.location.href='users'">Show me all Users and their jobs</button>
		<br></br>
		<button onclick="window.location.href='mostReadBook'">Most Read Book</button>
		<br></br>
		<button onclick="window.location.href='userReadBooks'">User Read Books</button>
	</body>
</html>