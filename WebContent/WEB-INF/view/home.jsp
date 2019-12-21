<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/home.css"/>
	</head>
	<body>
		<h1>Welcome to BookStore</h1>
		<button onclick="window.location.href='authors'">Show me all Authors in the BookStore</button>
	</body>
</html>