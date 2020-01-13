<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Most Read Book</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2> Most Read Book </h2>
		</div>
	</div>
	<button onclick="window.location.href='home'" class="button">Back to HomePage</button>
	<br></br>
	<div id="container">
		<div id="content">
			<table>
				<tr>
					<th>Title</th>
					<th>Date of creation</th>
					<th>Pages</th>
					<th>Genre</th>
					<th>Author</th>
					<th>Readers</th>
				</tr>			
				
				<!-- Loop over and print books -->
				<c:forEach var="Book" items="${mostReadBook}">
					
				<tr>
					<td>${Book.title}</td>
					<td>${Book.doc}</td>
					<td>${Book.pages}</td>
					<td>${Book.genre.name}</td>
					<td>${Book.author.firstName} ${Book.author.lastName}</td>
					<td>${Book.users.size()}</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>